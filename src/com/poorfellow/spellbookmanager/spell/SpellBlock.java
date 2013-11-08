package com.poorfellow.spellbookmanager.spell;

import java.io.Serializable;
import java.util.List;

import com.poorfellow.spellbookmanager.database.DatabaseObject;

@SuppressWarnings("serial")
public class SpellBlock implements DatabaseObject, Serializable {

	private long id;
	private String name;
	private long characterId;
	private List<Integer> spells;
	
	public SpellBlock(String name, long characterId, List<Integer> spells) {
		this.name = name;
		this.setCharacterId(characterId);
		this.setSpells(spells);
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
		this.name = name;
	}

	@Override
	public void setId(long objectId) {
		this.id = objectId;
	}
	
	public String toString() {
		return null;
	}

	public long getCharacterId() {
		return characterId;
	}

	public void setCharacterId(long characterId) {
		this.characterId = characterId;
	}

	public List<Integer> getSpells() {
		return spells;
	}

	public void setSpells(List<Integer> spells) {
		this.spells = spells;
	}

}
