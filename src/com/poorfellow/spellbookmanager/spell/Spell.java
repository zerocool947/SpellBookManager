package com.poorfellow.spellbookmanager.spell;

import java.io.Serializable;

import com.poorfellow.spellbookmanager.database.DatabaseObject;

public class Spell implements DatabaseObject, Serializable {

	private String name;
	private long id;
	private String school;
	private String subschool;
	private String level;
	private String components;
	private String castingTime;
	private String range;
	private String effect;
	private String duration;
	private String savingThrow;
	private String spellResistance;
	private String description;
	private String materialComponent;
	private String focus;
	
	@Override
	public long getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

}
