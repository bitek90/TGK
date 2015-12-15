package com.example.tgk;

import com.example.tgk.dto.DataHolder;
import com.example.tgk.dto.WybraneDTO;
import com.example.tgk.utils.DataBaseUtils;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MapaActivity extends Activity {
	
	private Intent iPojedynek;
	private Button lokalizacja1,lokalizacja2,lokalizacja3,lokalizacja4,lokalizacja5,lokalizacja6;//lokalizacja7,lokalizacja8,lokalizacja9;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mapa);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		stworzMape();
		addListeners();
		iPojedynek = new Intent(MapaActivity.this, WalkaActivity.class);
		try {
			ustawLokalizacje();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		DataBaseUtils.zapiszGracza(DataHolder.getPlayer());
		if(lokalizacja1 != null)
			try {
				ustawLokalizacje();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	private void ustawLokalizacje() throws Exception {
		WybraneDTO wybrane = DataHolder.getPlayer();
		if(!(wybrane instanceof WybraneDTO)){
			throw new Exception("B³¹d pobierania gracza obiekt nie jest prawid³owy");
		}
		if(wybrane.getStage()>=0){

		}
		if (wybrane.getStage()>=1){
			lokalizacja2.setVisibility(View.VISIBLE);
			lokalizacja2.setEnabled(true);
		}
		if (wybrane.getStage()>=2){
			lokalizacja3.setVisibility(View.VISIBLE);
			lokalizacja3.setEnabled(true);
		}
		if (wybrane.getStage()>=3){
			lokalizacja4.setVisibility(View.VISIBLE);
			lokalizacja4.setEnabled(true);
		}
		if (wybrane.getStage()>=4){
			lokalizacja5.setVisibility(View.VISIBLE);
			lokalizacja5.setEnabled(true);
		}
		if (wybrane.getStage()>=5){
			lokalizacja6.setVisibility(View.VISIBLE);
			lokalizacja6.setEnabled(true);
		}
//		if (wybrane.getStage()>=6){
//			lokalizacja9.setVisibility(View.VISIBLE);
//			lokalizacja7.setEnabled(true);
//		}
//		if (wybrane.getStage()>=7){
//			//lokalizacja10.setVisibility(View.VISIBLE);
//			lokalizacja8.setEnabled(true);
//		}
//		if (wybrane.getStage()>=8){
//			//lokalizacja11.setVisibility(View.VISIBLE);
//			lokalizacja9.setEnabled(true);
//		}
	}

	private void rozpocznijPojedynek(int diffuculty) {
		iPojedynek.putExtra("difficulty", diffuculty);
		startActivity(iPojedynek);
	}
	
	private void stworzMape(){
		wczytajMapeZBazy();
		lokalizacja1 = (Button)findViewById(R.id.land1);	
		lokalizacja2 = (Button)findViewById(R.id.land2);		
		lokalizacja3 = (Button)findViewById(R.id.land3);
		lokalizacja4 = (Button)findViewById(R.id.land4);
		lokalizacja5 = (Button)findViewById(R.id.land5);
		lokalizacja6 = (Button)findViewById(R.id.land6);
		lokalizacja2.setEnabled(false);
		lokalizacja2.setVisibility(View.INVISIBLE);
		lokalizacja3.setEnabled(false);
		lokalizacja3.setVisibility(View.INVISIBLE);
		lokalizacja4.setEnabled(false);
		lokalizacja4.setVisibility(View.INVISIBLE);
		lokalizacja5.setEnabled(false);
		lokalizacja5.setVisibility(View.INVISIBLE);
		lokalizacja6.setEnabled(false);
		lokalizacja6.setVisibility(View.INVISIBLE);
		
//		lokalizacja7 = (Button)findViewById(R.id.land7);
//		lokalizacja8 = (Button)findViewById(R.id.land8);
//		lokalizacja9 = (Button)findViewById(R.id.land9);
		
	}
	private void wczytajMapeZBazy() {
		// TODO Auto-generated method stub
		
	}

	private void addListeners(){
		lokalizacja1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				rozpocznijPojedynek(1);
			
			}
		});
		lokalizacja2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				rozpocznijPojedynek(2);
				
			}
		});
		lokalizacja3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				rozpocznijPojedynek(3);
				
			}
		});
		lokalizacja4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				rozpocznijPojedynek(4);
				
			}
		});
		lokalizacja5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				rozpocznijPojedynek(5);
				
			}
		});
		lokalizacja6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				rozpocznijPojedynek(6);
				
			}
		});
//		lokalizacja7.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				rozpocznijPojedynek(4);
//				
//			}
//		});
//		lokalizacja8.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				rozpocznijPojedynek(4);
//				
//			}
//		});
//		lokalizacja9.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				rozpocznijPojedynek(5);
//				
//			}
//		});
	}
}
