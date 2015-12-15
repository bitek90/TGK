package com.example.tgk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import com.example.tgk.dto.Wynik;

import com.example.tgk.dto.DataHolder;
import com.example.tgk.dto.PostacDTO;
import com.example.tgk.dto.WybraneDTO;
import com.example.tgk.utils.DataBaseUtils;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class WalkaActivity extends Activity {
	private WybraneDTO player,enemy;
	private PostacDTO hero1, hero2, mage1, mage2, maruder1, maruder2;
	private PostacDTO tank1, tank2, ranger1, ranger2;
	private int tempBtn;
	private ImageButton btnHero1,btnHero2,btnMage1,btnMage2,btnTank1,btnTank2;
	private ImageButton btnMaruder1,btnMaruder2,btnRanger1,btnRanger2;
	private Button speccial;
	private Bundle extras;
	private TextView h1tW,h2tW,m1tW,m2tW,mar1tW,mar2tW,t1tW,t2tW,r1tW,r2tW;
	private Boolean turaGracza = true;
	private MediaPlayer mp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		setContentView(R.layout.activity_walka);
		//goToMap = new Intent(WalkaActivity.this, MapaActivity.class);
		extras = getIntent().getExtras();
		mp=MediaPlayer.create(this, R.raw.fight);
		wczytajGraczy();
		wczytajPostaci();
		dodajSluchaczy();
		losujTure();
		sprawdzPozostalePrzyciskiGracza();
		mp.start();
		
		
	}
	
	private void losujTure() {
		Random r1 = new Random();
		if(r1.nextInt(2)==1)
			turaGracza = true;
		else 
			turaGracza = false;
		//na sztywno do testow
		turaGracza =true;
		
	}

	private void wczytajGraczy() {		
		player = DataHolder.getPlayer();
		hero1 = DataBaseUtils.pobierzPostac(player.getHeroId());
		hero1.setUsed(false);
		hero1.setAlive(true);
		mage1 = DataBaseUtils.pobierzPostac(player.getMageId());
		mage1.setUsed(false);
		mage1.setAlive(true);
		maruder1 = DataBaseUtils.pobierzPostac(player.getMaruderId());
		maruder1.setUsed(false);
		maruder1.setAlive(true);
		tank1 = DataBaseUtils.pobierzPostac(player.getTankId());
		tank1.setUsed(false);
		tank1.setAlive(true);
		ranger1 = DataBaseUtils.pobierzPostac(player.getRangerId());		
		ranger1.setUsed(false);
		ranger1.setAlive(true);
		enemy = DataBaseUtils.pobierzPrzeciwnika(extras.getInt("difficulty"));
		hero2 = DataBaseUtils.pobierzPostac(enemy.getHeroId());
		hero2.setUsed(false);
		hero2.setAlive(true);
		mage2 = DataBaseUtils.pobierzPostac(enemy.getMageId());
		mage2.setUsed(false);
		mage2.setAlive(true);
		maruder2 = DataBaseUtils.pobierzPostac(enemy.getMaruderId());
		maruder2.setUsed(false);
		maruder2.setAlive(true);
		tank2 = DataBaseUtils.pobierzPostac(enemy.getTankId());
		tank2.setUsed(false);
		tank2.setAlive(true);
		ranger2 = DataBaseUtils.pobierzPostac(enemy.getRangerId());
		ranger2.setUsed(false);
		ranger2.setAlive(true);
	}

	private void wczytajPostaci() {		
		btnHero1 = (ImageButton) findViewById(R.id.hero1);
		btnHero1.setImageResource(hero1.getImg());
		btnHero2= (ImageButton) findViewById(R.id.hero2);
		btnHero2.setImageResource(hero2.getImg());
		btnMage1= (ImageButton) findViewById(R.id.mage1);
		btnMage1.setBackgroundResource(mage1.getImg());
		btnMage2= (ImageButton) findViewById(R.id.mage2);
		btnMage2.setBackgroundResource(mage2.getImg());
		btnTank1= (ImageButton) findViewById(R.id.tank1);
		btnTank1.setBackgroundResource(tank1.getImg());
		btnTank2= (ImageButton) findViewById(R.id.tank2);
		btnTank2.setBackgroundResource(tank2.getImg());
		btnMaruder1= (ImageButton) findViewById(R.id.maruder1);
		btnMaruder1.setBackgroundResource(maruder1.getImg());
		btnMaruder2= (ImageButton) findViewById(R.id.maruder2);
		btnMaruder2.setBackgroundResource(maruder2.getImg());
		btnRanger1= (ImageButton) findViewById(R.id.ranger1);
		btnRanger1.setBackgroundResource(ranger1.getImg());
		btnRanger2= (ImageButton) findViewById(R.id.ranger2);
		btnRanger2.setBackgroundResource(ranger2.getImg());
		h1tW = (TextView)findViewById(R.id.textView9);
		h2tW = (TextView)findViewById(R.id.textView10);
		m1tW = (TextView)findViewById(R.id.twName);
		m2tW = (TextView)findViewById(R.id.textView7);
		mar1tW = (TextView)findViewById(R.id.textView4);
		mar2tW = (TextView)findViewById(R.id.textView6);
		t1tW = (TextView)findViewById(R.id.textView3);
		t2tW = (TextView)findViewById(R.id.textView5);
		r1tW = (TextView)findViewById(R.id.textView2);
		r2tW = (TextView)findViewById(R.id.textView8);
		//btnEndOfTurn = (Button)findViewById(R.id.btnEndOfTurn);
		speccial = (Button)findViewById(R.id.speccial);
		aktualizujWidok();
	}
	
	private void aktualizujWidok(){
		aktualizujJednostke(hero1,h1tW);
		aktualizujJednostke(hero2,h2tW);
		aktualizujJednostke(mage1,m1tW);
		aktualizujJednostke(mage2,m2tW);
		aktualizujJednostke(maruder1,mar1tW);
		aktualizujJednostke(maruder2,mar2tW);
		aktualizujJednostke(tank1,t1tW);
		aktualizujJednostke(tank2,t2tW);
		aktualizujJednostke(ranger1,r1tW);
		aktualizujJednostke(ranger2,r2tW);
	}

	private void dodajSluchaczy(){
		
		btnHero1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (tempBtn == v.getId()){
					tempBtn = 0;
					sprawdzPozostalePrzyciskiGracza();
					speccial.setEnabled(false);
				}else if (tempBtn == btnHero2.getId()){
					hero2.setUsed(true);
					walka(hero2,hero1,h1tW);
				}else if(tempBtn == btnMage2.getId()){
					mage2.setUsed(true);
					walka(mage2,hero1,h1tW);
				}else if(tempBtn == btnTank2.getId()){
					tank2.setUsed(true);
					walka(tank2,hero1,h1tW);
				}else if(tempBtn == btnMaruder2.getId()){
					maruder2.setUsed(true);
					walka(maruder2,hero1,h1tW);
				}else if(tempBtn == btnRanger2.getId()){
					ranger2.setUsed(true);
					walka(ranger2,hero1,h1tW);
				}else if(tempBtn == 0){
					tempBtn = v.getId();
					sprawdzPrzyciskiMozliweDoAtakuPrzeciwnika(hero1, btnHero1);
					if(!hero1.isSkillUsed()){
						speccial.setEnabled(true);
						speccial.setAlpha(1F);
					}
				}else{
					tempBtn=0;
					sprawdzPozostalePrzyciskiGracza();
				}
				if(!hero1.isAlive()){
					try {
						mp.stop();
						Toast.makeText(getBaseContext(), "Pora¿ka!", Toast.LENGTH_SHORT).show();
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		btnHero2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (tempBtn == v.getId()){
					tempBtn = 0;
					sprawdzPozostalePrzyciskiPrzeciwnika();
					speccial.setEnabled(false);
				}else if (tempBtn == btnHero1.getId()){
					hero1.setUsed(true);
					walka(hero1,hero2,h2tW);
				}else if(tempBtn == btnMage1.getId()){
					mage1.setUsed(true);
					walka(mage1,hero2,h2tW);
				}else if(tempBtn == btnTank1.getId()){
					tank1.setUsed(true);
					walka(tank1,hero2,h2tW);
				}else if(tempBtn == btnMaruder1.getId()){
					maruder1.setUsed(true);
					walka(maruder1,hero2,h2tW);
				}else if(tempBtn == btnRanger1.getId()){
					ranger1.setUsed(true);
					walka(ranger1,hero2,h2tW);
				}else if(tempBtn == 0){
					tempBtn = v.getId();
					sprawdzPrzyciskiMozliweDoAtakuGracza(hero2,btnHero2);
					if(!hero2.isSkillUsed()){
						speccial.setEnabled(true);
					}
				}else{
					tempBtn=0;
					speccial.setEnabled(false);
					speccial.setAlpha(0.5F);
					sprawdzPozostalePrzyciskiPrzeciwnika();
				}
				if(!hero2.isAlive()){
					try {
						mp.stop();
						Toast.makeText(getBaseContext(), "Zwyciêstwo!", Toast.LENGTH_SHORT).show();
						player.setStage(player.getStage() +1);
						DataBaseUtils.aktualizujGracza(player);
						Thread.sleep(2000);						
						Intent i = new Intent(WalkaActivity.this, NagrodaActivity.class);
						startActivity(i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		btnMage1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (tempBtn == v.getId()){
					tempBtn = 0;
					sprawdzPozostalePrzyciskiGracza();
				}else if (tempBtn == btnHero2.getId()){
					hero2.setUsed(true);
					walka(hero2,mage1,m1tW);
				}else if(tempBtn == btnMage2.getId()){
					mage2.setUsed(true);
					walka(mage2,mage1,m1tW);
				}else if(tempBtn == btnTank2.getId()){
					tank2.setUsed(true);
					walka(tank2,mage1,m1tW);
				}else if(tempBtn == btnMaruder2.getId()){
					maruder2.setUsed(true);
					walka(maruder2,mage1,m1tW);
				}else if(tempBtn == btnRanger2.getId()){
					ranger2.setUsed(true);
					walka(ranger2,mage1,m1tW);
				}else if(tempBtn == 0){
					tempBtn = v.getId();
					sprawdzPrzyciskiMozliweDoAtakuPrzeciwnika(mage1, btnMage1);
				}else{
					tempBtn=0;
					sprawdzPozostalePrzyciskiGracza();
				}
			}
		});
		btnMage2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (tempBtn == v.getId()){
					tempBtn = 0;
					sprawdzPozostalePrzyciskiPrzeciwnika();
				}else if (tempBtn == btnHero1.getId()){
					hero1.setUsed(true);
					walka(hero1,mage2,m2tW);
				}else if(tempBtn == btnMage1.getId()){
					mage1.setUsed(true);
					walka(mage1,mage2,m2tW);
				}else if(tempBtn == btnTank1.getId()){
					tank1.setUsed(true);
					walka(tank1,mage2,m2tW);
				}else if(tempBtn == btnMaruder1.getId()){
					maruder1.setUsed(true);
					walka(maruder1,mage2,m2tW);
				}else if(tempBtn == btnRanger1.getId()){
					ranger1.setUsed(true);
					walka(ranger1,mage2,m2tW);
				}else if(tempBtn == 0){
					tempBtn = v.getId();
					sprawdzPrzyciskiMozliweDoAtakuGracza(mage2,btnMage2);
				}else{
					tempBtn=0;
					sprawdzPozostalePrzyciskiPrzeciwnika();
				}
			}
		});
		btnTank1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (tempBtn == v.getId()){
					tempBtn = 0;
					sprawdzPozostalePrzyciskiGracza();
				}else if (tempBtn == btnHero2.getId()){
					hero2.setUsed(true);
					walka(hero2,tank1,t1tW);
				}else if(tempBtn == btnMage2.getId()){
					mage2.setUsed(true);
					walka(mage2,tank1,t1tW);
				}else if(tempBtn == btnTank2.getId()){
					tank2.setUsed(true);
					walka(tank2,tank1,t1tW);
				}else if(tempBtn == btnMaruder2.getId()){
					maruder2.setUsed(true);
					walka(maruder2,tank1,t1tW);
				}else if(tempBtn == btnRanger2.getId()){
					ranger2.setUsed(true);
					walka(ranger2,tank1,t1tW);
				}else if(tempBtn == 0){
					tempBtn = v.getId();
					sprawdzPrzyciskiMozliweDoAtakuPrzeciwnika(tank1, btnTank1);
				}else{
					tempBtn=0;
					sprawdzPozostalePrzyciskiGracza();
				}
			}
		});
		btnTank2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (tempBtn == v.getId()){
					tempBtn = 0;
					sprawdzPozostalePrzyciskiPrzeciwnika();
				}else if (tempBtn == btnHero1.getId()){
					hero1.setUsed(true);
					walka(hero1,tank2,t2tW);
				}else if(tempBtn == btnMage1.getId()){
					mage1.setUsed(true);
					walka(mage1,tank2,t2tW);
				}else if(tempBtn == btnTank1.getId()){
					tank1.setUsed(true);
					walka(tank1,tank2,t2tW);
				}else if(tempBtn == btnMaruder1.getId()){
					maruder1.setUsed(true);
					walka(maruder1,tank2,t2tW);
				}else if(tempBtn == btnRanger1.getId()){
					ranger1.setUsed(true);
					walka(ranger1,tank2,t2tW);
				}else if(tempBtn == 0){
					tempBtn = v.getId();
					sprawdzPrzyciskiMozliweDoAtakuGracza(tank2,btnTank2);
				}else{
					tempBtn=0;
					sprawdzPozostalePrzyciskiPrzeciwnika();
				}
			}
		});
		btnMaruder1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (tempBtn == v.getId()){
					tempBtn = 0;
					sprawdzPozostalePrzyciskiGracza();
				}else if (tempBtn == btnHero2.getId()){
					hero2.setUsed(true);
					walka(hero2,maruder1,mar1tW);
				}else if(tempBtn == btnMage2.getId()){
					mage2.setUsed(true);
					walka(mage2,maruder1,mar1tW);
				}else if(tempBtn == btnTank2.getId()){
					tank2.setUsed(true);
					walka(tank2,maruder1,mar1tW);
				}else if(tempBtn == btnMaruder2.getId()){
					maruder2.setUsed(true);
					walka(maruder2,maruder1,mar1tW);
				}else if(tempBtn == btnRanger2.getId()){
					ranger2.setUsed(true);
					walka(ranger2,maruder1,mar1tW);
				}else if(tempBtn == 0){
					tempBtn = v.getId();
					sprawdzPrzyciskiMozliweDoAtakuPrzeciwnika(maruder1, btnMaruder1);
				}else{
					tempBtn=0;
					sprawdzPozostalePrzyciskiGracza();
				}
			}
		});
		btnMaruder2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (tempBtn == v.getId()){
					tempBtn = 0;
					sprawdzPozostalePrzyciskiPrzeciwnika();
				}else if (tempBtn == btnHero1.getId()){
					hero1.setUsed(true);
					walka(hero1,maruder2,mar2tW);
				}else if(tempBtn == btnMage1.getId()){
					mage1.setUsed(true);
					walka(mage1,maruder2,mar2tW);
				}else if(tempBtn == btnTank1.getId()){
					tank1.setUsed(true);
					walka(tank1,maruder2,mar2tW);
				}else if(tempBtn == btnMaruder1.getId()){
					maruder1.setUsed(true);
					walka(maruder1,maruder2,mar2tW);
				}else if(tempBtn == btnRanger1.getId()){
					ranger1.setUsed(true);
					walka(ranger1,maruder2,mar2tW);
				}else if(tempBtn == 0){
					tempBtn = v.getId();
					sprawdzPrzyciskiMozliweDoAtakuGracza(maruder2,btnMaruder2);
				}else{
					tempBtn=0;
					sprawdzPozostalePrzyciskiPrzeciwnika();
				}
			}
		});
		btnRanger1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (tempBtn == v.getId()){
					tempBtn = 0;
					sprawdzPozostalePrzyciskiGracza();
				}else if (tempBtn == btnHero2.getId()){
					hero2.setUsed(true);
					walka(hero2,ranger1,r1tW);
				}else if(tempBtn == btnMage2.getId()){
					mage2.setUsed(true);
					walka(mage2,ranger1,r1tW);
				}else if(tempBtn == btnTank2.getId()){
					tank2.setUsed(true);
					walka(tank2,ranger1,r1tW);
				}else if(tempBtn == btnMaruder2.getId()){
					maruder2.setUsed(true);
					walka(maruder2,ranger1,r1tW);
				}else if(tempBtn == btnRanger2.getId()){
					ranger2.setUsed(true);
					walka(ranger2,ranger1,r1tW);
				}else if(tempBtn == 0){
					tempBtn = v.getId();
					sprawdzPrzyciskiMozliweDoAtakuPrzeciwnika(ranger1, btnRanger1);
				}else{
					tempBtn=0;
					sprawdzPozostalePrzyciskiGracza();
				}
			}
		});
		btnRanger2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (tempBtn == v.getId()){
					tempBtn = 0;
					sprawdzPozostalePrzyciskiPrzeciwnika();
				}else if (tempBtn == btnHero1.getId()){
					hero1.setUsed(true);
					walka(hero1,ranger2,r2tW);
				}else if(tempBtn == btnMage1.getId()){
					mage1.setUsed(true);
					walka(mage1,ranger2,r2tW);
				}else if(tempBtn == btnTank1.getId()){
					tank1.setUsed(true);
					walka(tank1,ranger2,r2tW);
				}else if(tempBtn == btnMaruder1.getId()){
					maruder1.setUsed(true);
					walka(maruder1,ranger2,r2tW);
				}else if(tempBtn == btnRanger1.getId()){
					ranger1.setUsed(true);
					walka(ranger1,ranger2,r2tW);
				}else if(tempBtn == 0){
					tempBtn = v.getId();
					sprawdzPrzyciskiMozliweDoAtakuGracza(ranger2,btnRanger2);
				}else{
					tempBtn=0;
					sprawdzPozostalePrzyciskiPrzeciwnika();
				}
			}
		});
//		btnEndOfTurn.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				turaGracza= !turaGracza;
//				if(turaGracza){
//					allowPlayerLeftButtons();
//					
//					}
//				else{
//					uruchomSystemExpertowy();
//					
//				}
//				check();
//			}
//		});
		speccial.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				if(turaGracza){
					if (tempBtn == v.getId()){
						tempBtn = 0;
						sprawdzPozostalePrzyciskiGracza();
						}
					else if (tempBtn == btnHero1.getId()){
						if(hero1.getSkill().equals("healall")){
							if(hero1.isAlive())
							hero1.setHp(hero1.getHp()+2);
							if(mage1.isAlive())
							mage1.setHp(mage1.getHp()+2);
							if(ranger1.isAlive())
							ranger1.setHp(ranger1.getHp()+2);
							if(tank1.isAlive())
							tank1.setHp(tank1.getHp()+2);
							if(maruder1.isAlive())
							maruder1.setHp(maruder1.getHp()+2);
							aktualizujWidok();
						}else if(hero1.getSkill().equals("attall")){
							hero2.setHp(hero2.getHp()-2);
							mage2.setHp(mage2.getHp()-2);
							ranger2.setHp(ranger2.getHp()-2);
							tank2.setHp(tank2.getHp()-2);
							maruder2.setHp(maruder2.getHp()-2);
							aktualizujWidok();
						}else if(hero1.getSkill().equals("freeze")){
							
						}
						hero1.setSkillUsed(true);
						hero1.setUsed(true);
						tempBtn = 0;
						turaGracza = !turaGracza;
						//allowEnemyLeftButtons();
						uruchomSystemExpertowy();
						status();
					}
					
				}
//				else{
//					if (tempBtn == v.getId()){
//						tempBtn = 0;
//						allowPlayerLeftButtons();	
//					} else if (tempBtn == btnHero1.getId()){
//						doOnSkill();
//						tempBtn = 0;
//						turaGracza = !turaGracza;
//						allowEnemyLeftButtons();
//					}
//					
//				}
				
			}
			
		});

	}

	private void sprawdzPozostalePrzyciskiGracza(){
			if(hero1.isAlive()&&!hero1.isUsed()){
				btnHero1.setEnabled(true);
				speccial.setEnabled(true);
				btnHero1.setAlpha(1F);
				speccial.setAlpha(1F);
				}
			else {
				btnHero1.setEnabled(false);
				speccial.setEnabled(false);
				btnHero1.setAlpha(0.5F);
				speccial.setAlpha(0.5F);
			}
			if(mage1.isAlive()&&!mage1.isUsed()){
				btnMage1.setEnabled(true);
				btnMage1.setAlpha(1F);
				}
			else {
				btnMage1.setEnabled(false);
				btnMage1.setAlpha(0.5F);
			}
			if(tank1.isAlive()&&!tank1.isUsed()){
				btnTank1.setAlpha(1F);
				btnTank1.setEnabled(true);
				}
			else {
				btnTank1.setAlpha(0.5F);
				btnTank1.setEnabled(false);
			}
			if(maruder1.isAlive()&&!maruder1.isUsed()){
				btnMaruder1.setAlpha(1F);
				btnMaruder1.setEnabled(true);
				}
			else {
				btnMaruder1.setEnabled(false);
				btnMaruder1.setAlpha(0.5F);
			}
			if(ranger1.isAlive()&&!ranger1.isUsed()){
				btnRanger1.setEnabled(true);
				btnRanger1.setAlpha(1F);}
			else {
				btnRanger1.setEnabled(false);
				btnRanger1.setAlpha(0.5F);
			}
			btnHero2.setEnabled(false);
			btnHero2.setAlpha(0.5F);
			btnMage2.setEnabled(false);
			btnMage2.setAlpha(0.5F);
			btnTank2.setEnabled(false);
			btnTank2.setAlpha(0.5F);
			btnMaruder2.setEnabled(false);
			btnMaruder2.setAlpha(0.5F);
			btnRanger2.setEnabled(false);
			btnRanger2.setAlpha(0.5F);
			speccial.setEnabled(false);
			speccial.setAlpha(0.5F);
	}
	
	private void sprawdzPozostalePrzyciskiPrzeciwnika(){
			if(hero2.isAlive()&&!hero2.isUsed()){
				btnHero2.setEnabled(true);
				btnHero2.setAlpha(1F);
				speccial.setEnabled(true);
				speccial.setAlpha(1F);
			}
			else {
				btnHero2.setEnabled(false);
				btnHero2.setAlpha(0.5F);
				speccial.setEnabled(false);
				speccial.setAlpha(0.5F);
			}
			if(mage2.isAlive()&&!mage2.isUsed()){
				btnMage2.setEnabled(true);
				btnMage2.setAlpha(1F);
				}
			else {
				btnMage2.setEnabled(false);
				btnMage2.setAlpha(0.5F);
			}
			if(tank2.isAlive()&&!tank2.isUsed()){
				btnTank2.setEnabled(true);
				btnTank2.setAlpha(1F);
			}
			else {
				btnTank2.setEnabled(false);
				btnTank2.setAlpha(0.5F);
			}
			if(maruder2.isAlive()&&!maruder2.isUsed()){
				btnMaruder2.setEnabled(true);
				btnMaruder2.setAlpha(1F);
				}
			else {
				btnMaruder2.setEnabled(false);
				btnMaruder2.setAlpha(0.5F);
			}
			if(ranger2.isAlive()&&!ranger2.isUsed()){
				btnRanger2.setEnabled(true);
				btnRanger2.setAlpha(1F);
				}
			else {
				btnRanger2.setEnabled(false);
				btnRanger2.setAlpha(0.5F);
			}
			btnHero1.setEnabled(false);
			btnHero1.setAlpha(0.5F);
			btnMage1.setEnabled(false);
			btnMage1.setAlpha(0.5F);
			btnTank1.setEnabled(false);
			btnTank1.setAlpha(0.5F);
			btnMaruder1.setEnabled(false);
			btnMaruder1.setAlpha(0.5F);
			btnRanger1.setEnabled(false);
			btnRanger1.setAlpha(0.5F);
	}
	
	private void sprawdzPrzyciskiMozliweDoAtakuGracza(PostacDTO postac, ImageButton unit){
		btnHero2.setEnabled(false);
		btnHero2.setAlpha(0.5F);
		btnMage2.setEnabled(false);
		btnMage2.setAlpha(0.5F);
		btnTank2.setEnabled(false);
		btnTank2.setAlpha(0.5F);
		btnRanger2.setEnabled(false);
		btnRanger2.setAlpha(0.5F);
		btnMaruder2.setEnabled(false);
		btnMaruder2.setAlpha(0.5F);
		unit.setEnabled(true);
		unit.setAlpha(1F);
		if(hero1.isAlive()){
			btnHero1.setEnabled(true);
			btnHero1.setAlpha(1F);
			}
		if(mage1.isAlive()){
			btnMage1.setEnabled(true);
			btnMage1.setAlpha(1F);
		}
		if(tank1.isAlive()){
			btnTank1.setEnabled(true);
			btnTank1.setAlpha(1F);
		}
		if(maruder1.isAlive()){
			btnMaruder1.setEnabled(true);
			btnMaruder1.setAlpha(1F);
		}
		if(ranger1.isAlive()){
			btnRanger1.setEnabled(true);
			btnRanger1.setAlpha(1F);
		}
		if (tank1.isAlive()|| maruder1.isAlive()||mage1.isAlive()||ranger1.isAlive()){
			btnHero1.setEnabled(false);
			btnHero1.setAlpha(0.5F);
			
		}
		if(!postac.isRanged()){
			if(tank1.isAlive()|| maruder1.isAlive()){
				btnMage1.setEnabled(false);
				btnMage1.setAlpha(0.5F);
				btnRanger1.setEnabled(false);
				btnRanger1.setAlpha(0.5F);
				btnHero1.setEnabled(false);
				btnHero1.setAlpha(0.5F);
			}
		}
	}
	
	private void sprawdzPrzyciskiMozliweDoAtakuPrzeciwnika(PostacDTO postac, ImageButton btnHero12){
		btnHero1.setEnabled(false);
		btnHero1.setAlpha(0.5F);
		btnMage1.setEnabled(false);
		btnMage1.setAlpha(0.5F);
		btnTank1.setEnabled(false);
		btnTank1.setAlpha(0.5F);
		btnRanger1.setEnabled(false);
		btnRanger1.setAlpha(0.5F);
		btnMaruder1.setEnabled(false);
		btnMaruder1.setAlpha(0.5F);
		btnHero12.setEnabled(true);
		btnHero12.setAlpha(1F);
		if(hero2.isAlive()){
			btnHero2.setEnabled(true);
			btnHero2.setAlpha(1F);
			}
		if(mage2.isAlive()){
			btnMage2.setEnabled(true);
			btnMage2.setAlpha(1F);
		}
		if(tank2.isAlive()){
			btnTank2.setEnabled(true);
			btnTank2.setAlpha(1F);
		}
		if(maruder2.isAlive()){
			btnMaruder2.setEnabled(true);
			btnMaruder2.setAlpha(1F);
		}
		if(ranger2.isAlive()){
			btnRanger2.setEnabled(true);
			btnRanger2.setAlpha(1F);
		}
		if (tank2.isAlive()|| maruder2.isAlive()||mage2.isAlive()||ranger2.isAlive()){
			btnHero2.setEnabled(false);
			btnHero2.setAlpha(0.5F);
			
		}
		if(!postac.isRanged()){
			if(tank2.isAlive()|| maruder2.isAlive()){
				btnMage2.setEnabled(false);
				btnMage2.setAlpha(0.5F);
				btnRanger2.setEnabled(false);
				btnRanger2.setAlpha(0.5F);
				btnHero2.setEnabled(false);
				btnHero2.setAlpha(0.5F);
			}
		}
	}
	
	private void walka(PostacDTO attacker, PostacDTO deffender, TextView tvDeffender){
		starcie(attacker,deffender);
		aktualizujJednostke(deffender,tvDeffender);
		tempBtn = 0;
		turaGracza = !turaGracza;
		if(!turaGracza)
			uruchomSystemExpertowy();
		status();
	}
	
	private void starcie(PostacDTO attacker, PostacDTO deffender) {
		int dmg=0, a = attacker.getAtt(),dd = deffender.getDef(), dh = deffender.getHp();
		dmg = a-dd;
		if(dmg<=0)dmg=1;
		dh = dh-dmg;
		if(dh>0)
		{
			deffender.setHp(dh);
		}else{
			deffender.setHp(0);
			deffender.setAlive(false);
			deffender.setUsed(true);
		}
	}
	
	private void aktualizujJednostke(PostacDTO unitLogic, TextView unit){
		if(unitLogic.getHp()<=0){
			unitLogic.setHp(0);
			unitLogic.setAlive(false);
			unitLogic.setUsed(true);
			}
		String str = "";
		str += "¯: "+unitLogic.getHp()+" ";
		unit.setText(str);
	}
	
	private void status() {
		if(!hero1.isAlive()){
			try {
				Toast.makeText(getBaseContext(), "Pora¿ka!", Toast.LENGTH_SHORT).show();
				Thread.sleep(2000);
				finish();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(turaGracza){
			if(hero1.isUsed()&&mage1.isUsed()&&tank1.isUsed()&&ranger1.isUsed()&&maruder1.isUsed()){
				hero1.setUsed(false);
				if(mage1.isAlive())
				mage1.setUsed(false);
				if(tank1.isAlive())
				tank1.setUsed(false);
				if(ranger1.isAlive())
				ranger1.setUsed(false);
				if(maruder1.isAlive())
				maruder1.setUsed(false);
			}
			sprawdzPozostalePrzyciskiGracza();
			}
		else{
			if(hero2.isUsed()&&mage2.isUsed()&&tank2.isUsed()&&ranger2.isUsed()&&maruder2.isUsed()){
				hero2.setUsed(false);
				if(mage2.isAlive())
				mage2.setUsed(false);
				if(tank2.isAlive())
				tank2.setUsed(false);
				if(ranger2.isAlive())
				ranger2.setUsed(false);
				if(maruder2.isAlive())
				maruder2.setUsed(false);
			}
			sprawdzPozostalePrzyciskiPrzeciwnika();
		}
		if(!mp.isPlaying()){
			mp.start();
		}
	}
	
	private void uruchomSystemExpertowy() {
		List<Wynik> wyniki = new ArrayList<Wynik>();
		if(!hero2.isSkillUsed()){
			if(!hero2.isUsed()){		
				uzycieUmiejetnosci();
				Toast.makeText(getBaseContext(), 
						"Wrogi bohater u¿y³ umiejêtnoœci specjalnej.", Toast.LENGTH_SHORT).show();
				aktualizujWidok();		
			}
		}else{
			List<PostacDTO> enemyList = listaDostepnychDoAtaku();
			List<PostacDTO> aIplayerList = listaAtakujacych();
			if(aIplayerList.size()>0){
				if(enemyList.size()>0){
					for(int i =0; i < enemyList.size(); i++){
						for(int j=0; j < aIplayerList.size(); j++){
							Wynik w1 = symuluj(enemyList.get(i), aIplayerList.get(j));
							if (w1 != null)
							wyniki.add(w1);
						}
					}
					Collections.sort(wyniki,new Comparator<Wynik>(){
						
						public int compare(Wynik lhs, Wynik rhs) {
							int i = 0;
							if(lhs.isKill()){
								if(rhs.isKill()){
									 if (lhs.getDmg()==0 && rhs.getDmg()==0){
								         i= 0;
								     }
									 else if (lhs.getDmg() > rhs.getDmg()){
								         i= -1;
								     }
								     else if (lhs.getDmg() == rhs.getDmg()){    
								         i= 0;
								     }
								     else if (lhs.getDmg() < rhs.getDmg()){
								         i= 1;
								     }
								}
								else{
									i= -1;
								}
							}else {
								if(rhs.isKill()){
									 i= 1;
								}
								else{									
									 if (lhs.getDmg()==0 && rhs.getDmg()==0){
								         i= 0;
								     }
									 else if (lhs.getDmg() > rhs.getDmg()){
								         i= -1;
								     }
								     else if (lhs.getDmg() == rhs.getDmg()){    
								         i= 0;
								     }
								     else if (lhs.getDmg() < rhs.getDmg()){
								         i= 1;
								     }
								}							
							}
							return i;
						}
					});
					
					PostacDTO wybraniecAtt = wyniki.get(0).getIdAtt();
					PostacDTO wybraniecDef = wyniki.get(0).getIdDeff();
					starcie(wybraniecAtt,wybraniecDef);
					Toast.makeText(getBaseContext(), "Twoj "+wybraniecDef.getName()+" " +
							"zosta³ zaatakowany przez "+wybraniecAtt.getName(), Toast.LENGTH_SHORT).show();
					wyniki.get(0).getIdAtt().setUsed(true);
					aktualizujWidok();
				}
				else{
					 
				}
			}else{
				
			}
		}
		
		status();
		sprawdzPozostalePrzyciskiGracza();
		turaGracza = !turaGracza;
	}
	
	private void uzycieUmiejetnosci(){
		if(hero2.getSkill().equals("healall")){
			if(hero2.isAlive())
			hero2.setHp(hero2.getHp()+2);
			if(mage2.isAlive())
			mage2.setHp(mage2.getHp()+2);
			if(ranger2.isAlive())
			ranger2.setHp(ranger2.getHp()+2);
			if(tank2.isAlive())
			tank2.setHp(tank2.getHp()+2);
			if(maruder2.isAlive())
			maruder2.setHp(maruder2.getHp()+2);
			aktualizujWidok();
		}else if(hero2.getSkill().equals("attall")){
			hero1.setHp(hero1.getHp()-2);
			mage1.setHp(mage1.getHp()-2);
			ranger1.setHp(ranger1.getHp()-2);
			tank1.setHp(tank1.getHp()-2);
			maruder1.setHp(maruder1.getHp()-2);
			aktualizujWidok();
		}else if(hero1.getSkill().equals("freeze")){
			
		}
		hero2.setUsed(true);
		hero2.setSkillUsed(true);
		status();
	}

	private List<PostacDTO> listaDostepnychDoAtaku() {
		List<PostacDTO> unitDeffender = new ArrayList<PostacDTO>();
		if(hero1.isAlive())
			unitDeffender.add(hero1);
		if(mage1.isAlive())
			unitDeffender.add(mage1);
		if(ranger1.isAlive())
			unitDeffender.add(ranger1);
		if(maruder1.isAlive())
			unitDeffender.add(maruder1);
		if(tank1.isAlive())
			unitDeffender.add(tank1);
		return unitDeffender;
	}
	
	private List<PostacDTO> listaAtakujacych() {
		List<PostacDTO> unitAttacker = new ArrayList<PostacDTO>();
		if(hero2.isAlive() && !hero2.isUsed())
			unitAttacker.add(hero2);
		if(mage2.isAlive()&& !mage2.isUsed())
			unitAttacker.add(mage2);
		if(maruder2.isAlive()&& !maruder2.isUsed())
			unitAttacker.add(maruder2);
		if(ranger2.isAlive()&& !ranger2.isUsed())
			unitAttacker.add(ranger2);
		if(tank2.isAlive()&& !tank2.isUsed())
			unitAttacker.add(tank2);
		
		return unitAttacker;
	}
	
	private Wynik symuluj(PostacDTO enemy, PostacDTO aiPlayer){
		Wynik w1 = new Wynik();
		if(enemy.isHero()){	
			if(tank1.isAlive()||maruder1.isAlive()||mage1.isAlive()||ranger1.isAlive()){
				return null;
			}
			else{
				w1 = new Wynik();
				w1.setIdAtt(aiPlayer);
				w1.setIdDeff(enemy);
				w1.setDmg(aiPlayer.getAtt()-enemy.getDef() < 1 ? 1 : aiPlayer.getAtt()-enemy.getDef());
				w1.setKill(enemy.getHp()-w1.getDmg() < 1 ? true : false);
				return w1;
			}
		}
		else if(enemy.isRanged()&&(tank1.isAlive()||maruder1.isAlive())&& !aiPlayer.isRanged()){
			return null;
		}
		else {
			w1 = new Wynik();
			w1.setIdAtt(aiPlayer);
			w1.setIdDeff(enemy);
			w1.setDmg(aiPlayer.getAtt()-enemy.getDef() < 1 ? 1 : aiPlayer.getAtt()-enemy.getDef());
			w1.setKill(enemy.getHp()-w1.getDmg() < 1 ? true : false);
			return w1;
		}	
	}
	
	@Override
	protected void onStop(){
		mp.stop();
		super.onStop();
	}
	
	
}
