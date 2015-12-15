package com.example.tgk.utils;

import com.example.tgk.R;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseOpenHelper extends SQLiteOpenHelper {
	//private static String DB_PATH = "/data/data/com.example.tgk/databases/";
		private static String DB_NAME = "TGK";
		private static int DB_VERSION = 1;

	  public DataBaseOpenHelper(Context context) {
	    super(context, DB_NAME, null, DB_VERSION);
	  }

	  @Override
	  public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE IF NOT EXISTS POSTACI(ID Integer " +
					"PRIMARY KEY, hp Integer, att Integer, def Integer,ranged Boolean, " +
					"character String, img Integer, name String, special String, opis String);");
			db.execSQL("CREATE TABLE IF NOT EXISTS GRACZE(ID INTEGER PRIMARY KEY," +
					" nazwaGracza TEXT, heroId Integer, maruderId Integer, tankId Integer," +
					" rangerId Integer, mageId Integer, stage Integer);");
			db.execSQL("CREATE TABLE IF NOT EXISTS POZIOMY(ID INTEGER PRIMARY KEY," +
					" heroId Integer, maruderId Integer, tankId Integer, rangerId" +
					" Integer, mageId Integer, stage Integer, opis String);");
			db.execSQL("INSERT INTO POSTACI VALUES(1,11,4,3,0,'HERO'," +
					""+R.drawable.barbarian+",'JON BARBA�Y�CA','freeze','')");
			db.execSQL("INSERT INTO POZIOMY VALUES(1,1,13,31,23,7,1,'Po wyczerpuj�cej bitwie" +
					" spotka�e� przechadzaj�cego si� po cmentarzu nekromant�! Zachwycony Twoj�" +
					" waleczno�ci� oferuje swoje us�ugi. Wybierz czy chesz �eby odebra� dusz�" +
					" Twojemu wojownikowi i przekaza� j� o�ywie�cowi. " +
					"Wybor Twojej postaci(z lewej) zostawi j� przy �yciu, wyb�r " +
					"o�ywie�ca(z prawej) w�aczy go do Twoich szereg�w w miejsce wojownika.')");
			db.execSQL("INSERT INTO POSTACI VALUES(2,15,3,5,0,'HERO',"+R.drawable.drzewo+",'PANI NATURY','healall','')");
			db.execSQL("INSERT INTO POSTACI VALUES(3,9,7,2,0,'HERO',"+R.drawable.bridge+",'SIEWCA ZAG�ADY','attall','')");
			//zrobic jeszcze 3 heros�w
			//Postaci
			//magowie
			db.execSQL("INSERT INTO POSTACI VALUES(7,12,5,2,1,'MAG',"+R.drawable.blist+",'BLIST','N','Blist jest magiem, do atakow wykorzystuje energi� elektryczn�. Posiada 12 P�.')");
			db.execSQL("INSERT INTO POSTACI VALUES(8,11,6,2,1,'MAG',"+R.drawable.elsa+",'ELSA','N','Elsa dorasta�a w szkole magii, z tamt�d posiada swoj� pot�n� magiczn� lask�. Posiada 11 P�.')");
			db.execSQL("INSERT INTO POSTACI VALUES(9,9,7,3,1,'MAG',"+R.drawable.octopus+",'OKTOPUS','N','Oktopus pochodzi z atlantydy, swoj� moc czerpie z serca oceanu, pomimo to potrafi lewitowa� w powietrzu. Posiada 9 P�.')");
			db.execSQL("INSERT INTO POSTACI VALUES(10,10,8,1,1,'MAG',"+R.drawable.priestess+",'PRIESTESS','N','Priestess to czarodziejka ognia, p�omienie szalej� w jej umy�le i nie tylko. Posiada 10 P�.')");
			db.execSQL("INSERT INTO POSTACI VALUES(11,11,5,3,1,'MAG',"+R.drawable.shyma+",'SHYMA','N','Shyma to oddana kap�anka �wi�tyni trzech ksi�yc�w, pos�uguje si� zakl�t� bu�aw�. Posiada 11 P�.')");
			db.execSQL("INSERT INTO POSTACI VALUES(12,10,7,2,1,'MAG',"+R.drawable.siren+",'SIREN','N','Siren przyp�yn�a z podbitych przez pirat�w w�d oceanu po�udniowego. Potrafi zamieni� ogon na nogi kiedy chce chcodzi� po l�dzie. Posiada 10 P�.')");
			//maruderzy
			db.execSQL("INSERT INTO POSTACI VALUES(13,16,4,4,0,'MAR',"+R.drawable.medusa+",'MEDUSA','N','Medusa zosta�a wy�owiona przez rybak�w na morzu czarnego or�a. Zosta�a zakl�ta by wykonywa� rozkazy. Posiada 16 P�.')");
			db.execSQL("INSERT INTO POSTACI VALUES(14,17,4,4,0,'MAR',"+R.drawable.pumpkin+",'PUMPKIN','N','Pumpkin jest przebraniem na hallowen o�ywionym przez nekromant�. Posiada 17 P�.')");
			db.execSQL("INSERT INTO POSTACI VALUES(15,16,5,3,0,'MAR',"+R.drawable.reaper+",'REAPER','N','Reaper to bies z najodleglejszych czelu�ci tartaru, zosta� przywo�any przez akolit�w w �wi�tyni bia�ego bzu. Zabi� ich wszystkich. Posiada 16 P�.')");
			db.execSQL("INSERT INTO POSTACI VALUES(16,15,5,4,0,'MAR',"+R.drawable.silla+",'SILLA','N','Silla jest p�atnym morderc�. Szkolona by�a przez asasyn�w z imperium. Uciek�a ciemn� noc�. Posiada 15 P�.')");
			db.execSQL("INSERT INTO POSTACI VALUES(17,15,6,3,0,'MAR',"+R.drawable.soulstealer+",'SOULSTEALER','N','Soulstealer to dusza nekromanty umieszczona w potwornym ciele. Posiada 15 P�.')");
			db.execSQL("INSERT INTO POSTACI VALUES(18,16,3,4,0,'MAR',"+R.drawable.yarrak+",'YARRAK','N','Yarrak to centaur z pasma g�r Yarre. Ma brata Aesmira. Posiada 16 P�.')");
			db.execSQL("INSERT INTO POSTACI VALUES(19,17,5,3,0,'MAR',"+R.drawable.zybra+",'ZYBRA','N', 'Zybra to robot zbudowany do �apania przest�pc�w i zwyrodnialc�w. Posiada 17 P�.')");
			//�ucznicy
			db.execSQL("INSERT INTO POSTACI VALUES(20,10,8,1,1,'RAN',"+R.drawable.aeshali+",'AESHALI','N','Aeshali to c�rka kr�la Legolula. Ojciec wys�a� j� na szkolenie w strzelectwie. Posiada 10 P�.')");
			db.execSQL("INSERT INTO POSTACI VALUES(21,10,7,2,1,'RAN',"+R.drawable.aesmir+",'AESMIR','N','To m�odszy brak Yarraka, centaur z g�r Yarre, jest bardzo dobrym �ucznikiem. Posiada 10 P�.')");
			db.execSQL("INSERT INTO POSTACI VALUES(22,10,6,3,1,'RAN',"+R.drawable.cargrana+",'CARGRANA','N','Cargrana to kuszniczka wiatru. Zawsze dok�adnie wie gdzie wyl�duje jej be�t. Posiada 10 P�.')");
			db.execSQL("INSERT INTO POSTACI VALUES(23,11,7,2,1,'RAN',"+R.drawable.endrillana+",'ENDRILLANA','N','Endrillana jest m�od� elfk�, od dziecka potrafi�a pos�ugiwa� si� �ukiem. Posiada 11 P�. ')");
			db.execSQL("INSERT INTO POSTACI VALUES(24,9,7,3,1,'RAN',"+R.drawable.iris+",'IRIS','N','Iris to d�in po utracie zdolno�ci spe�niania �ycze� zacz�a para� si� trudn� sztuk� trafiania w cel z dalekiej odleg�o�ci. Posiada 9 P�.')");
			
			db.execSQL("INSERT INTO POSTACI VALUES(25,16,4,5,0,'TAN',"+R.drawable.brutus+",'BRUTUS','N','Brutus to barbarzy�ca. Rozwala wszystko co spotka na swojej drodze. Posiada 16 P�.')");
			db.execSQL("INSERT INTO POSTACI VALUES(26,18,1,6,0,'TAN',"+R.drawable.ezhid+",'EZHID','N','Ezhid to skalny cz�ekokszta�tny golem. Potrafi wytrzyma� ogromny nacisk. Posiada 18 P�.')");
			db.execSQL("INSERT INTO POSTACI VALUES(27,15,1,8,0,'TAN',"+R.drawable.gronicht+",'GRONICHT','N','Gronicht uwielbia banany dlatego jest taki du�y i wytrzyma�y. Posiada 15 P�.')");
			db.execSQL("INSERT INTO POSTACI VALUES(28,16,1,7,0,'TAN',"+R.drawable.ormar+",'ORMAR','N','Ormar jest legendarym �elaznym golemem, by� obro�c� krasnoludzkich twierdz. Posiada 16 P�.')");
			db.execSQL("INSERT INTO POSTACI VALUES(29,15,2,7,0,'TAN',"+R.drawable.ozouz+",'OZOUZ','N','Ozouz to stw�r z laboratorium szalonego naukowca kt�ry chcia� stworzy� besti� przepot�n�. Posiada 15 P�.')");
			db.execSQL("INSERT INTO POSTACI VALUES(30,15,3,5,0,'TAN',"+R.drawable.xerex+",'XEREX','N','Xerex to robot wytworzony z najtwardszego metalu na �wiecie. Posiada 15 P�.')");
			db.execSQL("INSERT INTO POSTACI VALUES(31,14,2,7,0,'TAN',"+R.drawable.zhothum+",'ZHOTHUM','N','Zhothum to owoc pracy ��czenia gatunk�w w laboratorium imperium. Jest to po��czenie kraba z raf� koralow�. Posiada 14 P�.')");

			
			//Poziomy
			
			db.execSQL("INSERT INTO POZIOMY VALUES(2,3,17,29,24,33,2,'Po walce jeden z Twoich �o�nierzy znajduje kamnie� filozoficzny, niestety zostaje �miertelnie raniony przez pu�apk�. Nadbiega nieznajomy i b�aga by� od�o�y� kamie� na miejsce, oferujac w zamian swoje us�ugi do kresu �ycia. Wyczuwasz �� potrafisz uratowa� �ycie wojownika dzi�ki nowej b�yskotce. Wyb�r nale�y do Ciebie.')");
			db.execSQL("INSERT INTO POZIOMY VALUES(3,2,18,30,22,8,3,'Spotykasz mieszka�ca tych szalonych krain, kiedy podchodzi do Ciebie okazuje sie �e OSZALA� jeden z Twoich pobratymc�w. Wybierz czy chcesz uratowa� go (klikaj�c na jego wizerunek) i zabi� nieznajomego, czy wyruszy� w podr� razem z nim (posta� z prawej).')");
			db.execSQL("INSERT INTO POZIOMY VALUES(4,3,19,26,20,12,4,'Przybysz ze �wietego �r�d�a wyzywa jednego z Twoich towarzyszy na pojedynek pod wod�. Po wyczerpuj�cej walce mo�esz oszcz�dzi� tylko jednego z nich ')");
			db.execSQL("INSERT INTO POZIOMY VALUES(5,1,14,27,21,9,5,'Wchodz�c do jaskini zawala si� za Tob� przej�cie. Po drugiej stronie zostaje jeden z Twoich �o�nierzy. Po drugiej stronie s�yszysz �e kto� Ciebie wo�a. Podchodzisz do krat w skale i widzisz za nimi nieznajomego. Obiecuje, �e je�li go uwolnisz wyprowadzi Ciebie z tej jaskini i b�dzie Tobie towarzyszy� do �mierci. Chcesz wr�ci� do �o�nie�a czy uratowa� uwi�zionego?')");
			db.execSQL("INSERT INTO POZIOMY VALUES(6,2,15,28,21,11,6,'Przechodz�c przez przesmyk g�rski widzisz nadbiegaj�c� posta�. Wpada ona na �o�nie�a stoj�cego obok Ciebie i spadaj� w przepa��. W ostatniej chwili �apiesz obu ale nie starcza Tobie si� by ich utrzyma�. Zdecyduj kogo ocalisz.')");
			
			// Postaci cd.
			db.execSQL("INSERT INTO POSTACI VALUES(32,11,6,2,1,'RAN',"+R.drawable.khroder+",'KHRODER','N','Khroder to niesamowity rewolwerowiec. Uczy� si� od samego Lucky Luke`a. Posiada 11 P�.')");
			db.execSQL("INSERT INTO POSTACI VALUES(33,12,6,2,1,'MAG',"+R.drawable.terlor+",'TERLOR','N','Terlor jest czarnoksi�nikiem uwiezionym niegdy� w puszce pandory. Dzi�ki swojej mocy uda�o mu si� uwolni�. Posiada 12 P�.')");
	  
	  } 

	  @Override
	  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//	    Log.w(DataBaseOpenHelper.class.getName(),
//	        "Upgrading database from version " + oldVersion + " to "
//	            + newVersion + ", which will destroy all old data");
//	    db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
	    onCreate(db);
	  }

	} 