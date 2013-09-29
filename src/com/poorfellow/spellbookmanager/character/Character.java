package com.poorfellow.spellbookmanager.character;

import com.poorfellow.spellbookmanager.database.DatabaseObject;

public class Character implements DatabaseObject{
	
	private String name;
	private long id;
	private int level;
	private String characterClass;
	private String race;
	private int casterLevel;
	private int dexterity;
	private int intelligence;
	private int strength;
	private int charisma;
	private int wisdom;
	private int constitution;
	private int turnAttempts;
	
	Character(String name, int level, String characterClass, String race, int casterLevel, 
			int dexterity, int intelligence, int strength, int charisma, int wisdom, int constitution,
			int turnAttempts) {
		
		this.name = name;
		this.level = level;
		this.characterClass = characterClass;
		this.race = race;
		this.casterLevel = casterLevel;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
		this.strength = strength;
		this.charisma = charisma;
		this.wisdom = wisdom;
		this.constitution = constitution;
		this.turnAttempts = turnAttempts;
				 
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}
	
	@Override
	public void setId(long id) {
		this.id = id;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getCasterLevel() {
		return casterLevel;
	}
	
	public String getCharacterClass() {
		return characterClass;
	}
	
	public int getTurnAttempts() {
		return turnAttempts;
	}
	
	public String getRace() {
		return race;
	}
	
	public int getIntelligence() {
		return intelligence;
	}
	
	public int getStrength() {
		return strength;
	}
	
	public int getDexterity() {
		return dexterity;
	}
	
	public int getConstitution() {
		return constitution;
	}
	
	public int getWisdom() {
		return wisdom;
	}
	
	public int getCharisma() {
		return charisma;
	}
}
