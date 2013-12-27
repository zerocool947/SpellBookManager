package com.poorfellow.spellbookmanager.spell;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class SpellFilter implements Serializable {
	
	private List<String> rawSpellList;
	private Map<String, String> classLevelMap;
	
	public SpellFilter(List<String> spells, Map<String, String> classLevels) {
		this.rawSpellList = spells;
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
	
	

}
