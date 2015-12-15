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
					""+R.drawable.barbarian+",'JON BARBA¯YÑCA','freeze','')");
			db.execSQL("INSERT INTO POZIOMY VALUES(1,1,13,31,23,7,1,'Po wyczerpuj¹cej bitwie" +
					" spotka³eœ przechadzaj¹cego siê po cmentarzu nekromantê! Zachwycony Twoj¹" +
					" walecznoœci¹ oferuje swoje us³ugi. Wybierz czy chesz ¿eby odebra³ duszê" +
					" Twojemu wojownikowi i przekaza³ j¹ o¿ywieñcowi. " +
					"Wybor Twojej postaci(z lewej) zostawi j¹ przy ¿yciu, wybór " +
					"o¿ywieñca(z prawej) w³aczy go do Twoich szeregów w miejsce wojownika.')");
			db.execSQL("INSERT INTO POSTACI VALUES(2,15,3,5,0,'HERO',"+R.drawable.drzewo+",'PANI NATURY','healall','')");
			db.execSQL("INSERT INTO POSTACI VALUES(3,9,7,2,0,'HERO',"+R.drawable.bridge+",'SIEWCA ZAG£ADY','attall','')");
			//zrobic jeszcze 3 herosów
			//Postaci
			//magowie
			db.execSQL("INSERT INTO POSTACI VALUES(7,12,5,2,1,'MAG',"+R.drawable.blist+",'BLIST','N','Blist jest magiem, do atakow wykorzystuje energiê elektryczn¹. Posiada 12 P¯.')");
			db.execSQL("INSERT INTO POSTACI VALUES(8,11,6,2,1,'MAG',"+R.drawable.elsa+",'ELSA','N','Elsa dorasta³a w szkole magii, z tamt¹d posiada swoj¹ potê¿n¹ magiczn¹ laskê. Posiada 11 P¯.')");
			db.execSQL("INSERT INTO POSTACI VALUES(9,9,7,3,1,'MAG',"+R.drawable.octopus+",'OKTOPUS','N','Oktopus pochodzi z atlantydy, swoj¹ moc czerpie z serca oceanu, pomimo to potrafi lewitowaæ w powietrzu. Posiada 9 P¯.')");
			db.execSQL("INSERT INTO POSTACI VALUES(10,10,8,1,1,'MAG',"+R.drawable.priestess+",'PRIESTESS','N','Priestess to czarodziejka ognia, p³omienie szalej¹ w jej umyœle i nie tylko. Posiada 10 P¯.')");
			db.execSQL("INSERT INTO POSTACI VALUES(11,11,5,3,1,'MAG',"+R.drawable.shyma+",'SHYMA','N','Shyma to oddana kap³anka œwi¹tyni trzech ksiê¿yców, pos³uguje siê zaklêt¹ bu³aw¹. Posiada 11 P¯.')");
			db.execSQL("INSERT INTO POSTACI VALUES(12,10,7,2,1,'MAG',"+R.drawable.siren+",'SIREN','N','Siren przyp³ynê³a z podbitych przez piratów wód oceanu po³udniowego. Potrafi zamieniæ ogon na nogi kiedy chce chcodziæ po l¹dzie. Posiada 10 P¯.')");
			//maruderzy
			db.execSQL("INSERT INTO POSTACI VALUES(13,16,4,4,0,'MAR',"+R.drawable.medusa+",'MEDUSA','N','Medusa zosta³a wy³owiona przez rybaków na morzu czarnego or³a. Zosta³a zaklêta by wykonywaæ rozkazy. Posiada 16 P¯.')");
			db.execSQL("INSERT INTO POSTACI VALUES(14,17,4,4,0,'MAR',"+R.drawable.pumpkin+",'PUMPKIN','N','Pumpkin jest przebraniem na hallowen o¿ywionym przez nekromantê. Posiada 17 P¯.')");
			db.execSQL("INSERT INTO POSTACI VALUES(15,16,5,3,0,'MAR',"+R.drawable.reaper+",'REAPER','N','Reaper to bies z najodleglejszych czeluœci tartaru, zosta³ przywo³any przez akolitów w œwi¹tyni bia³ego bzu. Zabi³ ich wszystkich. Posiada 16 P¯.')");
			db.execSQL("INSERT INTO POSTACI VALUES(16,15,5,4,0,'MAR',"+R.drawable.silla+",'SILLA','N','Silla jest p³atnym morderc¹. Szkolona by³a przez asasynów z imperium. Uciek³a ciemn¹ noc¹. Posiada 15 P¯.')");
			db.execSQL("INSERT INTO POSTACI VALUES(17,15,6,3,0,'MAR',"+R.drawable.soulstealer+",'SOULSTEALER','N','Soulstealer to dusza nekromanty umieszczona w potwornym ciele. Posiada 15 P¯.')");
			db.execSQL("INSERT INTO POSTACI VALUES(18,16,3,4,0,'MAR',"+R.drawable.yarrak+",'YARRAK','N','Yarrak to centaur z pasma gór Yarre. Ma brata Aesmira. Posiada 16 P¯.')");
			db.execSQL("INSERT INTO POSTACI VALUES(19,17,5,3,0,'MAR',"+R.drawable.zybra+",'ZYBRA','N', 'Zybra to robot zbudowany do ³apania przestêpców i zwyrodnialców. Posiada 17 P¯.')");
			//£ucznicy
			db.execSQL("INSERT INTO POSTACI VALUES(20,10,8,1,1,'RAN',"+R.drawable.aeshali+",'AESHALI','N','Aeshali to córka króla Legolula. Ojciec wys³a³ j¹ na szkolenie w strzelectwie. Posiada 10 P¯.')");
			db.execSQL("INSERT INTO POSTACI VALUES(21,10,7,2,1,'RAN',"+R.drawable.aesmir+",'AESMIR','N','To m³odszy brak Yarraka, centaur z gór Yarre, jest bardzo dobrym ³ucznikiem. Posiada 10 P¯.')");
			db.execSQL("INSERT INTO POSTACI VALUES(22,10,6,3,1,'RAN',"+R.drawable.cargrana+",'CARGRANA','N','Cargrana to kuszniczka wiatru. Zawsze dok³adnie wie gdzie wyl¹duje jej be³t. Posiada 10 P¯.')");
			db.execSQL("INSERT INTO POSTACI VALUES(23,11,7,2,1,'RAN',"+R.drawable.endrillana+",'ENDRILLANA','N','Endrillana jest m³od¹ elfk¹, od dziecka potrafi³a pos³ugiwaæ siê ³ukiem. Posiada 11 P¯. ')");
			db.execSQL("INSERT INTO POSTACI VALUES(24,9,7,3,1,'RAN',"+R.drawable.iris+",'IRIS','N','Iris to d¿in po utracie zdolnoœci spe³niania ¿yczeñ zaczê³a paraæ siê trudn¹ sztuk¹ trafiania w cel z dalekiej odleg³oœci. Posiada 9 P¯.')");
			
			db.execSQL("INSERT INTO POSTACI VALUES(25,16,4,5,0,'TAN',"+R.drawable.brutus+",'BRUTUS','N','Brutus to barbarzyñca. Rozwala wszystko co spotka na swojej drodze. Posiada 16 P¯.')");
			db.execSQL("INSERT INTO POSTACI VALUES(26,18,1,6,0,'TAN',"+R.drawable.ezhid+",'EZHID','N','Ezhid to skalny cz³ekokszta³tny golem. Potrafi wytrzymaæ ogromny nacisk. Posiada 18 P¯.')");
			db.execSQL("INSERT INTO POSTACI VALUES(27,15,1,8,0,'TAN',"+R.drawable.gronicht+",'GRONICHT','N','Gronicht uwielbia banany dlatego jest taki du¿y i wytrzyma³y. Posiada 15 P¯.')");
			db.execSQL("INSERT INTO POSTACI VALUES(28,16,1,7,0,'TAN',"+R.drawable.ormar+",'ORMAR','N','Ormar jest legendarym ¿elaznym golemem, by³ obroñc¹ krasnoludzkich twierdz. Posiada 16 P¯.')");
			db.execSQL("INSERT INTO POSTACI VALUES(29,15,2,7,0,'TAN',"+R.drawable.ozouz+",'OZOUZ','N','Ozouz to stwór z laboratorium szalonego naukowca który chcia³ stworzyæ bestiê przepotê¿n¹. Posiada 15 P¯.')");
			db.execSQL("INSERT INTO POSTACI VALUES(30,15,3,5,0,'TAN',"+R.drawable.xerex+",'XEREX','N','Xerex to robot wytworzony z najtwardszego metalu na œwiecie. Posiada 15 P¯.')");
			db.execSQL("INSERT INTO POSTACI VALUES(31,14,2,7,0,'TAN',"+R.drawable.zhothum+",'ZHOTHUM','N','Zhothum to owoc pracy ³¹czenia gatunków w laboratorium imperium. Jest to po³¹czenie kraba z raf¹ koralow¹. Posiada 14 P¯.')");

			
			//Poziomy
			
			db.execSQL("INSERT INTO POZIOMY VALUES(2,3,17,29,24,33,2,'Po walce jeden z Twoich ¿o³nierzy znajduje kamnieñ filozoficzny, niestety zostaje œmiertelnie raniony przez pu³apkê. Nadbiega nieznajomy i b³aga byœ od³o¿y³ kamieñ na miejsce, oferujac w zamian swoje us³ugi do kresu ¿ycia. Wyczuwasz ¿ê potrafisz uratowaæ ¿ycie wojownika dziêki nowej b³yskotce. Wybór nale¿y do Ciebie.')");
			db.execSQL("INSERT INTO POZIOMY VALUES(3,2,18,30,22,8,3,'Spotykasz mieszkañca tych szalonych krain, kiedy podchodzi do Ciebie okazuje sie ¿e OSZALA£ jeden z Twoich pobratymców. Wybierz czy chcesz uratowaæ go (klikaj¹c na jego wizerunek) i zabiæ nieznajomego, czy wyruszyæ w podró¿ razem z nim (postaæ z prawej).')");
			db.execSQL("INSERT INTO POZIOMY VALUES(4,3,19,26,20,12,4,'Przybysz ze œwietego Ÿród³a wyzywa jednego z Twoich towarzyszy na pojedynek pod wod¹. Po wyczerpuj¹cej walce mo¿esz oszczêdziæ tylko jednego z nich ')");
			db.execSQL("INSERT INTO POZIOMY VALUES(5,1,14,27,21,9,5,'Wchodz¹c do jaskini zawala siê za Tob¹ przejœcie. Po drugiej stronie zostaje jeden z Twoich ¿o³nierzy. Po drugiej stronie s³yszysz ¿e ktoœ Ciebie wo³a. Podchodzisz do krat w skale i widzisz za nimi nieznajomego. Obiecuje, ¿e jeœli go uwolnisz wyprowadzi Ciebie z tej jaskini i bêdzie Tobie towarzyszy³ do œmierci. Chcesz wróciæ do ¿o³nie¿a czy uratowaæ uwiêzionego?')");
			db.execSQL("INSERT INTO POZIOMY VALUES(6,2,15,28,21,11,6,'Przechodz¹c przez przesmyk górski widzisz nadbiegaj¹c¹ postaæ. Wpada ona na ¿o³nie¿a stoj¹cego obok Ciebie i spadaj¹ w przepaœæ. W ostatniej chwili ³apiesz obu ale nie starcza Tobie si³ by ich utrzymaæ. Zdecyduj kogo ocalisz.')");
			
			// Postaci cd.
			db.execSQL("INSERT INTO POSTACI VALUES(32,11,6,2,1,'RAN',"+R.drawable.khroder+",'KHRODER','N','Khroder to niesamowity rewolwerowiec. Uczy³ siê od samego Lucky Luke`a. Posiada 11 P¯.')");
			db.execSQL("INSERT INTO POSTACI VALUES(33,12,6,2,1,'MAG',"+R.drawable.terlor+",'TERLOR','N','Terlor jest czarnoksiê¿nikiem uwiezionym niegdyœ w puszce pandory. Dziêki swojej mocy uda³o mu siê uwolniæ. Posiada 12 P¯.')");
	  
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