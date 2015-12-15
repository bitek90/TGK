package com.example.tgk;

import java.util.ArrayList;

import com.example.tgk.dto.DataHolder;
import com.example.tgk.dto.WybraneDTO;
import com.example.tgk.utils.DataBaseUtils;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Klasa aktywnoœci menu g³ównego.
 * @author Bitek
 */
public class MenuGlowneActivity extends Activity {
	
	private Button btnGraj;
	private Button btnKontynuuj;
	private Button btnWyjdz;
	private EditText tfNazwaGracza;
	private static String nazwaGracza;
	private Spinner spinnerGracze;
	
    @Override
    protected void onRestart() {
        super.onRestart(); 
        spinnerGracze = (Spinner)findViewById(R.id.spinner1);
        ArrayList<String> listaGraczy =(ArrayList<String>) DataBaseUtils.pobierzGraczy();
        ArrayAdapter<String> adapterSpinnera = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,listaGraczy);
        adapterSpinnera.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGracze.setPrompt("Wybierz Gracza!");
        spinnerGracze.setAdapter(adapterSpinnera);
       
    }
    @Override
    protected void onResume() {
        super.onResume(); 
        spinnerGracze = (Spinner)findViewById(R.id.spinner1);
        ArrayList<String> listaGraczy =(ArrayList<String>) DataBaseUtils.pobierzGraczy();
        ArrayAdapter<String> adapterSpinnera = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,listaGraczy);
        adapterSpinnera.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGracze.setPrompt("Wybierz Gracza!");
        spinnerGracze.setAdapter(adapterSpinnera);
       
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_glowne);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        DataBaseUtils.setContext(getApplicationContext());
        btnKontynuuj = (Button)findViewById(R.id.btnKontynuuj);
        btnKontynuuj.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MenuGlowneActivity.this, MapaActivity.class);
				spinnerGracze.getSelectedItemId();
				if(spinnerGracze.getSelectedItemId()<0){
						Toast.makeText(getBaseContext(), "Nie wybrano gracza!", Toast.LENGTH_SHORT).show();				
				}else{
				setName(spinnerGracze.getSelectedItem().toString());
				WybraneDTO wybrane = new WybraneDTO();
				wybrane = DataBaseUtils.wczytajGracza(getName());
				DataHolder.setPlayer(wybrane);
		    	startActivity(i);
				}
			}
		});
        
        tfNazwaGracza   = (EditText)findViewById(R.id.tgName);
        btnGraj = (Button)findViewById(R.id.btnGraj);
        btnGraj.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MenuGlowneActivity.this, WyborBohateraActivity.class);
				if(tfNazwaGracza.getText().toString().equals("") || tfNazwaGracza.getText() == null){
					Toast.makeText(getBaseContext(), "Nie wybrano gracza!", Toast.LENGTH_SHORT).show();				
				}else{
					setName(tfNazwaGracza.getText().toString());
					try{
						DataBaseUtils.sprawdzGracza(getName());			
						WybraneDTO wybrane = new WybraneDTO();
						wybrane.setPlayerName(getName());
						DataHolder.setPlayer(wybrane);
				    	startActivity(i);
				    }catch(Exception e){
						Toast.makeText(getBaseContext(), "Istnieje ju¿ gracz o takiej nazwie. Wpisz inn¹ nazwê gracza.", Toast.LENGTH_SHORT).show();	
					}
				}
			}
		});
        btnWyjdz = (Button)findViewById(R.id.btnWyjdz);
        btnWyjdz.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
				}
        });
        spinnerGracze = (Spinner)findViewById(R.id.spinner1);
        ArrayList<String> listaGraczy =(ArrayList<String>) DataBaseUtils.pobierzGraczy();
        ArrayAdapter<String> adapterSpinnera = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,listaGraczy);
        adapterSpinnera.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGracze.setPrompt("Wybierz Gracza!");
        spinnerGracze.setAdapter(adapterSpinnera);
        //spinnerGracze.setAdapter((SpinnerAdapter) new NothingSelectedSpinnerAdapter(adapterSpinnera,R.layout.contact_spinner_row_nothing_selected,this));
        
        
    }

	public static String getName() {
		return nazwaGracza;
	}

	public void setName(String name) {
		MenuGlowneActivity.nazwaGracza = name;
	}
	
//	@Override
//	protected void onStop(){
//		finish();
//	}
    
}