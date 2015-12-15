package com.example.tgk.utils;

import java.util.ArrayList;
import java.util.List;

import com.example.tgk.dto.PostacDTO;
import com.example.tgk.dto.WybraneDTO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseUtils {
	static DataBaseOpenHelper dbhelper;
	static SQLiteDatabase db;
	static Context context;
    
	public Context getContext() {
		return context;
	}
	public static void setContext(Context context) {
		DataBaseUtils.context = context;
	}
	
	public static String dodajGracza(String name){
		Cursor cursor = null;
		try{
		dbhelper = new DataBaseOpenHelper(context);
		db = dbhelper.getWritableDatabase();
		String selectQuery = "SELECT ID FROM GRACZE where nazwaGracza = '"+name+"'";
		cursor = db.rawQuery(selectQuery, null);
		if (!cursor.moveToFirst()){
			ContentValues insertValues = new ContentValues();
			insertValues.put("nazwaGracza", name);
			db.insert("GRACZE", null, insertValues);
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		//	cursor.close();
			db.close();
		}
		return name;
	}
	
	public static String sprawdzGracza(String name) throws Exception{
		Cursor cursor = null;
		try{
		dbhelper = new DataBaseOpenHelper(context);
		db = dbhelper.getReadableDatabase();
		String selectQuery = "SELECT ID FROM GRACZE where nazwaGracza = '"+name+"'";
		cursor = db.rawQuery(selectQuery, null);
		if (!cursor.moveToFirst()){
		}
		else {
			throw new Exception();
		}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			db.close();
		}
		return name;		
	}
	
	public static void zapiszGracza(WybraneDTO wybrane){
		Cursor cursor = null;
		try{
			dbhelper = new DataBaseOpenHelper(context);
			db = dbhelper.getWritableDatabase();
			String selectQuery = "SELECT ID FROM GRACZE where nazwaGracza = '"+wybrane.getPlayerName()+"'";
			cursor = db.rawQuery(selectQuery, null);
			if (cursor.moveToFirst()){
				db.execSQL("UPDATE GRACZE SET heroID = "+wybrane.getHeroId()+"," +
					" maruderId = "+wybrane.getMaruderId()+"," +
					" tankId = "+wybrane.getTankId()+"," +
					" rangerID = "+wybrane.getRangerId()+"," +
					" mageID = "+wybrane.getMageId()+
					" WHERE nazwaGracza = '"+wybrane.getPlayerName()+"'");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//cursor.close();
			db.close();
		}
	}
	public static WybraneDTO wczytajGracza(String name){
		Cursor cursor = null;
		String selectQuery = "SELECT heroId, mageId, maruderId, rangerId, tankId, stage FROM GRACZE where nazwaGracza ='"+name+"'";
		WybraneDTO wybrane = new WybraneDTO();
		try{
		dbhelper = new DataBaseOpenHelper(context);
		db = dbhelper.getWritableDatabase();
		cursor = db.rawQuery(selectQuery, null);
		cursor.moveToFirst();
		wybrane.setPlayerName(name);
		wybrane.setHeroId(cursor.getInt(0));
		wybrane.setMageId(cursor.getInt(1));
		wybrane.setMaruderId(cursor.getInt(2));
		wybrane.setRangerId(cursor.getInt(3));
		wybrane.setTankId(cursor.getInt(4));
		wybrane.setStage(cursor.getInt(5));
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			cursor.close();
			db.close();
		}
		return wybrane;
	}
	
	public static List<String> pobierzGraczy(){
		dbhelper = new DataBaseOpenHelper(context);
		db = dbhelper.getWritableDatabase();
		List<String> gracze = new ArrayList<String>();
		Cursor cursor = null;
		String selectQuery = "SELECT * FROM Gracze";
		cursor = db.rawQuery(selectQuery, null);
		cursor.moveToFirst();
		while (cursor.moveToNext()){
			gracze.add(cursor.getString(1));
		}
		cursor.close();
		db.close();
		return gracze;
	}
	
	public static PostacDTO pobierzPostac(int idPostaci){ 
		dbhelper = new DataBaseOpenHelper(context);
		db = dbhelper.getWritableDatabase();
		PostacDTO postac = new PostacDTO();
		Cursor cursor = null;
		String hero;
		String selectQuery = "SELECT ID,hp,att,def,ranged,character,img,name,special,opis FROM POSTACI where ID ="+idPostaci;
		try{
			cursor = db.rawQuery(selectQuery, null);
			cursor.moveToFirst();
			postac.setId(cursor.getInt(0));
			postac.setHp(cursor.getInt(1));
			postac.setAtt(cursor.getInt(2));
			postac.setDef(cursor.getInt(3));
			postac.setRanged(cursor.getInt(4) == 1 ? true : false);
			hero = cursor.getString(5);
			postac.setCharacter(hero);
			postac.setHero(hero.equals("HERO")? true: false);
			postac.setImg(cursor.getInt(6));
			postac.setName(cursor.getString(7));
			postac.setSkill(cursor.getString(8));
			postac.setOpis(cursor.getString(9));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			cursor.close();
			db.close();
		}
		return postac;
	}
	
	public static List<PostacDTO> Losuj4Postaci(String typ){
		List<PostacDTO> postaci = new ArrayList<PostacDTO>();
		dbhelper = new DataBaseOpenHelper(context);
		db = dbhelper.getWritableDatabase();
		PostacDTO postac = new PostacDTO();
		Cursor cursor = null;
		String selectQuery = "SELECT p.* from (SELECT *, random() as rand FROM POSTACI where character LIKE '"+typ+"')as p order by rand limit 4 ";
		//String selectQuery = "SELECT * FROM POSTACI";
		try{
			cursor = db.rawQuery(selectQuery, null);
			cursor.moveToFirst();
			postac.setId(cursor.getInt(0));
  			postac.setHp(cursor.getInt(1));
  			postac.setAtt(cursor.getInt(2));
  			postac.setDef(cursor.getInt(3));
  			postac.setRanged(cursor.getInt(4) == 1 ? true : false);
  			postac.setCharacter(cursor.getString(5));
  			postac.setImg(cursor.getInt(6));
  			postac.setName(cursor.getString(7));
  			postac.setSkill(cursor.getString(8));
  			postac.setOpis(cursor.getString(9));
  			postaci.add(postac);
			while (cursor.moveToNext()){
				postac = new PostacDTO();
	            	postac.setId(cursor.getInt(0));
	      			postac.setHp(cursor.getInt(1));
	      			postac.setAtt(cursor.getInt(2));
	      			postac.setDef(cursor.getInt(3));
	      			postac.setRanged(cursor.getInt(4) == 1 ? true : false);
	      			postac.setCharacter(cursor.getString(5));
	      			postac.setImg(cursor.getInt(6));
	      			postac.setName(cursor.getString(7));
	      			postac.setSkill(cursor.getString(8));
	      			postac.setOpis(cursor.getString(9));
	      			postaci.add(postac);
	       }
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			cursor.close();
			db.close();
		}
		return postaci;
	}
	
	public static List<Integer> LostujPostacID(String typ,int obecna){
		List<Integer> list = new ArrayList<Integer>();
		dbhelper = new DataBaseOpenHelper(context);
		db = dbhelper.getWritableDatabase();
		Cursor cursor = null;
		String selectQuery = "SELECT p.* from (SELECT *, random() as rand FROM POSTACI where character LIKE '"+typ+"' and ID <> "+obecna+")as p order by rand limit 1 ";
		//String selectQuery = "SELECT * FROM POSTACI";
		try{
			cursor = db.rawQuery(selectQuery, null);
			cursor.moveToFirst();
			list.add(cursor.getInt(0));
			list.add(cursor.getInt(6));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			cursor.close();
			db.close();
		}
		return list;
	}
	
	public static void aktualizujGracza(WybraneDTO wybrane) {
		dbhelper = new DataBaseOpenHelper(context);
		db = dbhelper.getWritableDatabase();
		Cursor cursor = null;
		try{
			String selectQuery = "SELECT ID FROM GRACZE where nazwaGracza = '"+wybrane.getPlayerName()+"'";
			cursor = db.rawQuery(selectQuery, null);
			if (cursor.moveToFirst()){
				db.execSQL("UPDATE GRACZE SET stage = "+ wybrane.getStage()+
					" WHERE nazwaGracza = '"+wybrane.getPlayerName()+"'");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			cursor.close();
			db.close();
		}
	}
	public static WybraneDTO pobierzPrzeciwnika(int int1) {
		Cursor cursor = null;
		String selectQuery = "SELECT heroId, mageId, maruderId, rangerId, tankId FROM POZIOMY where ID ="+int1;
		WybraneDTO wybrane = new WybraneDTO();
		try{
		dbhelper = new DataBaseOpenHelper(context);
		db = dbhelper.getWritableDatabase();
		cursor = db.rawQuery(selectQuery, null);
		cursor.moveToFirst();
		wybrane.setHeroId(cursor.getInt(0));
		wybrane.setMageId(cursor.getInt(1));
		wybrane.setMaruderId(cursor.getInt(2));
		wybrane.setRangerId(cursor.getInt(3));
		wybrane.setTankId(cursor.getInt(4));
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			cursor.close();
			db.close();
		}
		return wybrane;
	}
	public static CharSequence pobierzOpis(int stage) {
		Cursor cursor = null;
		CharSequence opis = null;
		
		String selectQuery = "SELECT opis FROM POZIOMY where ID ="+stage;
		try{
		dbhelper = new DataBaseOpenHelper(context);
		db = dbhelper.getWritableDatabase();
		cursor = db.rawQuery(selectQuery, null);
		cursor.moveToFirst();
		opis= cursor.getString(0);
		
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			cursor.close();
			db.close();
		}
		return opis;
	}
}
