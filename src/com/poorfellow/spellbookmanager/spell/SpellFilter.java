package com.poorfellow.spellbookmanager.spell;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;

@SuppressWarnings("serial")
public class SpellFilter implements Serializable {
	
	private Map<Integer, List<Integer>> filteredSpellsMap;
	private Map<String, String> filterClassLevelMap;
	private Map<Integer, String> filterSpellsMap;
	
	public SpellFilter(Map<Integer, String> spells, Map<String, String> classLevels) {
		this.filterSpellsMap = spells;
		this.filterClassLevelMap = classLevels;
	}
	
	public SpellFilter() {
		this(null, null);
	}
	
	/*
	 * First string is the class, second string is a comma separated list of levels
	 */
	public void setClassLevelMap(Map<String, String> classLevelMap) {
		this.filterClassLevelMap = classLevelMap;
	}
	
	/*
	 * First string is the class, second string is a comma separated list of levels
	 */
	public void addFilterClassLevel(String className, String level) {
		if (filterClassLevelMap == null) {
			filterClassLevelMap = new HashMap<String, String>();
		}
		
		if (filterClassLevelMap.containsKey(className)) {
			String levels = filterClassLevelMap.get(className);
			levels += "," + level;
			filterClassLevelMap.put(className, levels);
		}
		else {
			filterClassLevelMap.put(className, level);
		}
	}
	
	/*
	 * First string is the class, second string is a level
	 */
	public void addFilterClassLevel(String className, Integer level) {
		addFilterClassLevel(className, String.valueOf(level));
	}
	
	public void setFilterSpellMap(Map<Integer, String> spellMap) {
		this.filterSpellsMap = spellMap;
	}
	
	public Map<Integer, List<Integer>> filterRawSpells(Context context) {
		SpellDAO spellDAO = new SpellDAO(context); 
		
		for(Integer id : filterSpellsMap.keySet()) {
			//Make a retriever for just the class/level map
			//or better yet, do the whole logic with a DB query
			Spell spell = spellDAO.getSpellById(id);
			Map<String, Integer> spellClassLevels = spell.getLevel();
			
			for (String filterClass : filterClassLevelMap.keySet()) {
				if(spellClassLevels.containsKey(filterClass.toLowerCase())) {
					addToFilteredSpellsMap(id, filterClass, (int) spell.getId());
				}
			}
		}
		
		return filteredSpellsMap;
	}

	public void addToFilteredSpellsMap(Integer id, String filterClass, Integer spellId) {
		if (!filteredSpellsMap.containsKey(id)) {
			filteredSpellsMap.put(id, new ArrayList<Integer>());
		}

		filteredSpellsMap.get(id).add(spellId);
	}
}
