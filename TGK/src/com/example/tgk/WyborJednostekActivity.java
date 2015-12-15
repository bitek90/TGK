package com.example.tgk;

import java.util.List;

import com.example.tgk.dto.DataHolder;
import com.example.tgk.dto.PostacDTO;
import com.example.tgk.dto.WybraneDTO;
import com.example.tgk.utils.DataBaseUtils;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewAnimator;
/**
 * Klasa aktywnoœci wyboru jednostek.
 * @author Bitek
 */
public class WyborJednostekActivity extends Activity {
	
	private Intent goToMap;
	private Button btnMage1,btnMage2,btnMage3,btnMage4,btnRngr1,btnRngr2,btnRngr3,btnRngr4;
	private Button btnMar1,btnMar2,btnMar3,btnMar4,btnTank1,btnTank2,btnTank3,btnTank4;
	private int idMage1,idMage2,idMage3,idMage4,idTank1,idTank2,idTank3,idTank4;
	private int idMar1, idMar2, idMar3, idMar4, idRngr1, idRngr2, idRngr3, idRngr4; 
	private TextView twMage1,twMage2,twMage3,twMage4,twRngr1,twRngr2,twRngr3,twRngr4;
	private TextView twMar1,twMar2,twMar3,twMar4,twTank1,twTank2,twTank3,twTank4;
	private WybraneDTO wybrane = DataHolder.getPlayer();

	ViewAnimator viewFlipper1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wybor_jednostek);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		inicjujKontrolki();
		ustawPostaci();
		dodajSluchaczy();	
		goToMap = new Intent(WyborJednostekActivity.this, MapaActivity.class);
	}

	private void ustawPostaci() {
		List<PostacDTO> postaci = DataBaseUtils.Losuj4Postaci("MAG");
		btnMage1.setBackgroundResource(postaci.get(0).getImg());
		btnMage2.setBackgroundResource(postaci.get(1).getImg());
		btnMage3.setBackgroundResource(postaci.get(2).getImg());
		btnMage4.setBackgroundResource(postaci.get(3).getImg());
		idMage1 = postaci.get(0).getId();
		idMage2 = postaci.get(1).getId();
		idMage3 = postaci.get(2).getId();
		idMage4 = postaci.get(3).getId();
		twMage1.setText(postaci.get(0).getOpis());
		twMage2.setText(postaci.get(1).getOpis());
		twMage3.setText(postaci.get(2).getOpis());
		twMage4.setText(postaci.get(3).getOpis());
		postaci = DataBaseUtils.Losuj4Postaci("TAN");
		btnTank1.setBackgroundResource(postaci.get(0).getImg());
		btnTank2.setBackgroundResource(postaci.get(1).getImg());
		btnTank3.setBackgroundResource(postaci.get(2).getImg());
		btnTank4.setBackgroundResource(postaci.get(3).getImg());
		idTank1 = postaci.get(0).getId();
		idTank2 = postaci.get(1).getId();
		idTank3 = postaci.get(2).getId();
		idTank4 = postaci.get(3).getId();
		twTank1.setText(postaci.get(0).getOpis());
		twTank2.setText(postaci.get(1).getOpis());
		twTank3.setText(postaci.get(2).getOpis());
		twTank4.setText(postaci.get(3).getOpis());
		postaci = DataBaseUtils.Losuj4Postaci("MAR");
		btnMar1.setBackgroundResource(postaci.get(0).getImg());
		btnMar2.setBackgroundResource(postaci.get(1).getImg());
		btnMar3.setBackgroundResource(postaci.get(2).getImg());
		btnMar4.setBackgroundResource(postaci.get(3).getImg());
		idMar1 = postaci.get(0).getId();
		idMar2 = postaci.get(1).getId();
		idMar3 = postaci.get(2).getId();
		idMar4 = postaci.get(3).getId();
		twMar1.setText(postaci.get(0).getOpis());
		twMar2.setText(postaci.get(1).getOpis());
		twMar3.setText(postaci.get(2).getOpis());
		twMar4.setText(postaci.get(3).getOpis());
		postaci = DataBaseUtils.Losuj4Postaci("RAN");
		btnRngr1.setBackgroundResource(postaci.get(0).getImg());
		btnRngr2.setBackgroundResource(postaci.get(1).getImg());
		btnRngr3.setBackgroundResource(postaci.get(2).getImg());
		btnRngr4.setBackgroundResource(postaci.get(3).getImg());
		idRngr1 = postaci.get(0).getId();
		idRngr2 = postaci.get(1).getId();
		idRngr3 = postaci.get(2).getId();
		idRngr4 = postaci.get(3).getId();
		twRngr1.setText(postaci.get(0).getOpis());
		twRngr2.setText(postaci.get(1).getOpis());
		twRngr3.setText(postaci.get(2).getOpis());
		twRngr4.setText(postaci.get(3).getOpis());
	}


	public void inicjujKontrolki(){
		viewFlipper1 = (ViewAnimator)findViewById(R.id.viewFlipper1);
		btnMage1 = (Button)findViewById(R.id.btnMage1);
		btnMage2 = (Button)findViewById(R.id.btnMage2);
		btnMage3 = (Button)findViewById(R.id.btnMage3);
		btnMage4 = (Button)findViewById(R.id.btnMage4);
		btnMar1 = (Button)findViewById(R.id.btnMar1);
		btnMar2 = (Button)findViewById(R.id.btnMar2);
		btnMar3 = (Button)findViewById(R.id.btnMar3);
		btnMar4 = (Button)findViewById(R.id.btnMar4);
		btnTank1 = (Button)findViewById(R.id.btnTank1);
		btnTank2 = (Button)findViewById(R.id.btnTank2);
		btnTank3 = (Button)findViewById(R.id.btnTank3);
		btnTank4 = (Button)findViewById(R.id.btnTank4);
		btnRngr1 = (Button)findViewById(R.id.btnRngr1);
		btnRngr2 = (Button)findViewById(R.id.btnRngr2);
		btnRngr3 = (Button)findViewById(R.id.btnRngr3);
		btnRngr4 = (Button)findViewById(R.id.btnRngr4);
		twMage1 = (TextView)findViewById(R.id.opisMage1);
		twMage2 = (TextView)findViewById(R.id.opisMage2);
		twMage3 = (TextView)findViewById(R.id.opisMage3);
		twMage4 = (TextView)findViewById(R.id.opisMage4);
		twMar1 = (TextView)findViewById(R.id.opisMar1);
		twMar2 = (TextView)findViewById(R.id.opisMar2);
		twMar3 = (TextView)findViewById(R.id.opisMar3);
		twMar4 = (TextView)findViewById(R.id.opisMar4);
		twTank1 = (TextView)findViewById(R.id.opisTank1);
		twTank2 = (TextView)findViewById(R.id.opisTank2);
		twTank3 = (TextView)findViewById(R.id.opisTank3);
		twTank4 = (TextView)findViewById(R.id.opisTank4);
		twRngr1 = (TextView)findViewById(R.id.opisRngr1);
		twRngr2 = (TextView)findViewById(R.id.opisRngr2);
		twRngr3 = (TextView)findViewById(R.id.opisRngr3);
		twRngr4 = (TextView)findViewById(R.id.opisRngr4);
	}

	public void dodajSluchaczy(){
		btnMage1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				wybrane.setMageId(idMage1);
				DataBaseUtils.dodajGracza(wybrane.getPlayerName());
				DataBaseUtils.zapiszGracza(wybrane);
				startActivity(goToMap);		
			}
		});
		btnMage2.setOnClickListener(new OnClickListener() {
					
			@Override
			public void onClick(View v) {
				wybrane.setMageId(idMage2);
				DataBaseUtils.dodajGracza(wybrane.getPlayerName());
				DataBaseUtils.zapiszGracza(wybrane);
				//DataBaseUtils.zapiszGracza(wybrane);
				startActivity(goToMap);
				//finish();
				
			}
		});
		btnMage3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				wybrane.setMageId(idMage3);
				DataBaseUtils.dodajGracza(wybrane.getPlayerName());
				DataBaseUtils.zapiszGracza(wybrane);
				//DataBaseUtils.zapiszGracza(wybrane);
				startActivity(goToMap);
				//finish();
				
			}
		});
		btnMage4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				wybrane.setMageId(idMage4);
				DataBaseUtils.dodajGracza(wybrane.getPlayerName());
				DataBaseUtils.zapiszGracza(wybrane);
				//DataBaseUtils.zapiszGracza(wybrane);
				startActivity(goToMap);
				//finish();
				
			}
		});
		btnMar1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				wybrane.setMaruderId(idMar1);
				viewFlipper1.showNext();
			}
		});
		btnMar2.setOnClickListener(new OnClickListener() {
					
			@Override
			public void onClick(View v) {
				wybrane.setMaruderId(idMar2);
				viewFlipper1.showNext();
			}
		});
		btnMar3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				wybrane.setMaruderId(idMar3);
				viewFlipper1.showNext();
			}
		});
		btnMar4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				wybrane.setMaruderId(idMar4);
				viewFlipper1.showNext();
			}
		});
		btnTank1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				wybrane.setTankId(idTank1);
				viewFlipper1.showNext();
							
			}
		});
		btnTank2.setOnClickListener(new OnClickListener() {
					
			@Override
			public void onClick(View v) {
				wybrane.setTankId(idTank2);
				viewFlipper1.showNext();
				
			}
		});
		btnTank3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				wybrane.setTankId(idTank3);
				viewFlipper1.showNext();
				
			}
		});
		btnTank4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				wybrane.setTankId(idTank4);
				viewFlipper1.showNext();
				
			}
		});
		btnRngr1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				wybrane.setRangerId(idRngr1);
				viewFlipper1.showNext();
				
			}
		});
		btnRngr2.setOnClickListener(new OnClickListener() {
					
			@Override
			public void onClick(View v) {
				wybrane.setRangerId(idRngr2);
				viewFlipper1.showNext();
				
			}
		});
		btnRngr3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				wybrane.setRangerId(idRngr3);
				viewFlipper1.showNext();
				
			}
		});
		btnRngr4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				wybrane.setRangerId(idRngr4);
				viewFlipper1.showNext();
				
			}
		});
	}
	@Override
	protected void onStop(){
		super.onStop();
	}
}
