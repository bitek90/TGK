package com.example.tgk;

import java.util.List;
import java.util.Random;

import com.example.tgk.dto.DataHolder;
import com.example.tgk.dto.PostacDTO;
import com.example.tgk.dto.WybraneDTO;
import com.example.tgk.utils.DataBaseUtils;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class NagrodaActivity extends Activity {

	private int stage;
	private List<Integer> nowa;
	private PostacDTO stara;
	private ImageButton btnStara, btnNowa;
	private TextView opis;
	private int random;
	protected WybraneDTO player;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nagroda);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		losujNagrode();
	}
	@Override
	protected void onResume() {
		super.onResume(); 
		losujNagrode();
	}
	
	private void losujNagrode(){
		stage = DataHolder.getPlayer().getStage();
		Random r1 = new Random();
		random = r1.nextInt(3);
		if(random==0){
			stara = DataBaseUtils.pobierzPostac(DataHolder.getPlayer().getTankId());
			nowa = DataBaseUtils.LostujPostacID("TAN",DataHolder.getPlayer().getTankId());
		}else if(random==1){
			stara = DataBaseUtils.pobierzPostac(DataHolder.getPlayer().getMageId());
			nowa = DataBaseUtils.LostujPostacID("MAG",DataHolder.getPlayer().getMageId());
		}else if(random==2){
			stara = DataBaseUtils.pobierzPostac(DataHolder.getPlayer().getMaruderId());
			nowa = DataBaseUtils.LostujPostacID("MAR",DataHolder.getPlayer().getMaruderId());
		}else {
			stara = DataBaseUtils.pobierzPostac(DataHolder.getPlayer().getRangerId());
			nowa = DataBaseUtils.LostujPostacID("RAN",DataHolder.getPlayer().getRangerId());
		}
		aktualizuj();
		dodajSluchaczy();
	}

	private void dodajSluchaczy() {
		btnStara.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		btnNowa.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(random==0){
					player = DataHolder.getPlayer();
					player.setTankId(nowa.get(0));
					DataHolder.setPlayer(player);
				}else if(random==1){
					player = DataHolder.getPlayer();
					player.setMageId(nowa.get(0));
					DataHolder.setPlayer(player);
				}else if(random==2){
					player = DataHolder.getPlayer();
					player.setMaruderId(nowa.get(0));
					DataHolder.setPlayer(player);
				}else {
					player = DataHolder.getPlayer();
					player.setRangerId(nowa.get(0));
					DataHolder.setPlayer(player);
				}
				DataBaseUtils.zapiszGracza(player);
				finish();
			}
		});	
	}

	private void aktualizuj() {
		btnStara = (ImageButton) findViewById(R.id.stara);
		btnStara.setImageResource(stara.getImg());
		btnNowa = (ImageButton) findViewById(R.id.nowa);
		btnNowa.setImageResource(nowa.get(1));
		opis = (TextView)findViewById(R.id.nagroda_opis);
		opis.setText(DataBaseUtils.pobierzOpis(stage));
	}
	
}
