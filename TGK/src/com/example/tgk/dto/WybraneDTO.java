package com.example.tgk.dto;

/**
 * Klasa wybranych postaci dla Gracza.
 * @author Bitek
 *
 */
public class WybraneDTO {
	
	private String playerName;
	private int heroId,maruderId,tankId,rangerId,mageId;
	private int stage = 0;
	
	public WybraneDTO(String playerName, int heroId,int maruderId,int tankId,int rangerId,int mageId){
		this.playerName =playerName;
		this.heroId =heroId;
		this.maruderId =maruderId;
		this.tankId =tankId;
		this.rangerId =rangerId;
		this.mageId =mageId;
	}
	
	public WybraneDTO() {
		
	}

	public int getHeroId() {
		return heroId;
	}

	public void setHeroId(int heroId) {
		this.heroId = heroId;
	}

	public int getMaruderId() {
		return maruderId;
	}

	public void setMaruderId(int maruderId) {
		this.maruderId = maruderId;
	}

	public int getTankId() {
		return tankId;
	}

	public void setTankId(int tankId) {
		this.tankId = tankId;
	}

	public int getRangerId() {
		return rangerId;
	}

	public void setRangerId(int rangerId) {
		this.rangerId = rangerId;
	}

	public int getMageId() {
		return mageId;
	}

	public void setMageId(int mageId) {
		this.mageId = mageId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
		
	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}
}
