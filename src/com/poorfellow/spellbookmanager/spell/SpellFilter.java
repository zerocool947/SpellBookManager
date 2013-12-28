package com.poorfellow.spellbookmanager.spell;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import android.content.Context;

@SuppressWarnings("serial")
public class SpellFilter implements Serializable {
	
	private Map<String, String> classLevelMap;
	private Map<String, Integer> rawSpellsMap;
	
	public SpellFilter(Map<String, Integer> spells, Map<String, String> classLevels) {
		this.rawSpellsMap = spells;
		this.classLevelMap = classLevels;
	}
	
	/*
	 * First string is the class, second string is a comma separated list of levels
	 */
	public void setClassLevelMap(Map<String, String> classLevelMap) {
		this.classLevelMap = classLevelMap;
	}
	
	/*
	 * First string is the class, second string is a comma separated list of levels
	 */
	public void addClassLevel(String className, String level) {
		if (classLevelMap == null) {
			classLevelMap = new HashMap<String, String>();
		}
		
		if (classLevelMap.containsKey(className)) {
			String levels = classLevelMap.get(className);
			levels += "," + level;
			classLevelMap.put(className, levels);
		}
		else {
			classLevelMap.put(className, level);
		}
	}
	
	/*
	 * First string is the class, second string is a level
	 */
	public void addClassLevel(String className, Integer level) {
		addClassLevel(className, String.valueOf(level));
	}
	
	public void setSpellMap(Map<String, Integer> spellMap) {
		this.rawSpellsMap = spellMap;
	}
	
	public Map<String, String> filterRawSpells(Context context) {
		SpellDAO spellDAO = new SpellDAO(context); 
		//making the map make sense, brb
		
		return null;
	}
}
