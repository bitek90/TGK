package com.example.tgk.dto;

/**
 * Klasa postaci.
 * @author Bitek
 */
public class PostacDTO {
	
	private int id,hp,att,def,img;
	private boolean alive,ranged,used,hero,skillUsed;
	private String name, character,skill,opis;
	
	public PostacDTO() {
		
	}
	
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAtt() {
		return att;
	}
	public void setAtt(int att) {
		this.att = att;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public boolean isRanged() {
		return ranged;
	}
	public void setRanged(boolean ranged) {
		this.ranged = ranged;
	}
	public boolean isUsed() {
		return used;
	}
	public void setUsed(boolean used) {
		this.used = used;
	}
	public boolean isHero() {
		return hero;
	}
	public void setHero(boolean hero) {
		this.hero = hero;
	}
	public int getImg() {
		return img;
	}
	public void setImg(int img) {
		this.img = img;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public boolean isSkillUsed() {
		return skillUsed;
	}

	public void setSkillUsed(boolean skillUsed) {
		this.skillUsed = skillUsed;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
}
