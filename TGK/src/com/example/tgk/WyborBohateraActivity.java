package com.example.tgk;

import com.example.tgk.dto.DataHolder;
import com.example.tgk.dto.WybraneDTO;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ViewAnimator;
/**
 * Klasa aktywnoœci wyboru bohatera.
 * @author Bitek
 *
 */
public class WyborBohateraActivity extends Activity {

	private ViewAnimator vAnimator;
	private Button btnNext,btnPrevious,btnChoose;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wybor_bohatera);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		inicjujKontrolki();
		dodajSluchaczy();
	}
	
	private void dodajSluchaczy(){
		btnNext.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				vAnimator.showNext();
				
			}
		});
		btnPrevious.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				vAnimator.showPrevious();
				
			}
		});
		btnChoose.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 //vAnimator.indexOfChild(child)
				int heroId= vAnimator.getDisplayedChild()+1;
				//Log.d("MEch", ""+heroId);
				WybraneDTO wybrane = DataHolder.getPlayer();
				wybrane.setHeroId(heroId);
				DataHolder.setPlayer(wybrane);
				try{
				startActivity(new Intent(WyborBohateraActivity.this, WyborJednostekActivity.class));
				finish();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}
	

	private void inicjujKontrolki() {
		vAnimator = (ViewAnimator)findViewById(R.id.viewAnimator);
		btnNext = (Button)findViewById(R.id.btnNastepny);
		btnPrevious = (Button)findViewById(R.id.btnPoprzedni);
		btnChoose = (Button)findViewById(R.id.btnWybierz);
		Animation inAnim = new AlphaAnimation(0, 1);
		inAnim.setDuration(1000);
		Animation outAnim = new AlphaAnimation(1, 0);
		outAnim.setDuration(1000);
	
		vAnimator.setInAnimation(inAnim);
		vAnimator.setOutAnimation(outAnim);
	}
}
	
