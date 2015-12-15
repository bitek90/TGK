package com.example.tgk.dto;

public class Wynik implements Comparable<Wynik>{
	
	PostacDTO idAtt,idDeff;
	int dmg;
	boolean kill;

	public int getDmg() {
		return dmg;
	}
	public void setDmg(int dmg) {
		this.dmg = dmg;
	}
	public boolean isKill() {
		return kill;
	}
	public void setKill(boolean kill) {
		this.kill = kill;
	}
	public PostacDTO getIdAtt() {
		return idAtt;
	}
	public void setIdAtt(PostacDTO idAtt) {
		this.idAtt = idAtt;
	}
	public PostacDTO getIdDeff() {
		return idDeff;
	}
	public void setIdDeff(PostacDTO idDeff) {
		this.idDeff = idDeff;
	}
	@Override
	public int compareTo(Wynik another) {
		// TODO Auto-generated method stub
		return 0;
	}
	}