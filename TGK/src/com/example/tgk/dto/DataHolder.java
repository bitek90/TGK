package com.example.tgk.dto;


public class DataHolder {
	
	private static WybraneDTO player;

	public static WybraneDTO getPlayer() {
		return player;
	}
	
	public static void setPlayer(WybraneDTO player) {
		DataHolder.player = player;
	}
}
