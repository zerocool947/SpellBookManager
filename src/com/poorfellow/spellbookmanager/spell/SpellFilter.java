package com.poorfellow.spellbookmanager.spell;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import android.content.Context;
import android.util.Log;

@SuppressWarnings("serial")
public class SpellFilter implements Serializable {
	
	//Key is the level, value is the spell ID
	private Map<Integer, List<Integer>> filteredSpellsMap;
	
	//Key is absolute position (sequential), value is the level
	private Set<Integer> filteredGroupsList; 
	private Map<String, String> filterClassLevelMap;
	
	//Key is the Id, string is the name
	private List<Integer> preFilterSpellsList;
			
	public SpellFilter(List<Integer> spells, Map<String, String> classLevels) {
		Log.d("STATUS", "Instantiating SpellFilter");
		this.preFilterSpellsList = spells;
		this.filterClassLevelMap = classLevels;
		this.filteredSpellsMap = new HashMap<Integer, List<Integer>>();
		this.filteredGroupsList = new TreeSet<Integer>();
		
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
	public void addPreFilterClassLevel(String className, String level) {
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
	public void addPreFilterClassLevel(String className, Integer level) {
		addPreFilterClassLevel(className, String.valueOf(level));
	}
	
	public void setFilterSpellMap(List<Integer> spellMap) {
		this.preFilterSpellsList = spellMap;
	}
	
	public void filterRawSpells(Context context) {
		SpellDAO spellDAO = new SpellDAO(context); 
		
		for(String className : filterClassLevelMap.keySet()) {
			String classLevels = filterClassLevelMap.get(className);
			
			for (String level : classLevels.split(",")) {
				filteredGroupsList.add(Integer.valueOf(level));
			}
		}
		
				
		for(Integer spellId : preFilterSpellsList) {
			//Make a retriever for just the class/level map
			//or better yet, do the whole logic with a DB query
			Spell spell = spellDAO.getSpellById(spellId);
			Map<String, Integer> spellClassLevels = spell.getLevel();
			
			for (String filterClass : filterClassLevelMap.keySet()) {
				if(spellClassLevels.containsKey(filterClass.toLowerCase())) {
					Integer filterLevel = spellClassLevels.get(filterClass);
					if (filterClassLevelMap.get(filterClass).contains(Integer.toString(filterLevel))) {
						addToFilteredSpellsMap(spellId, filterClass, filterLevel);
					}
				}
			}
		}
	}

	public void addToFilteredSpellsMap(Integer spellId, String filterClass, Integer filterLevel) {
		if (!filteredSpellsMap.containsKey(filterLevel)) {
			filteredSpellsMap.put(filterLevel, new ArrayList<Integer>());
		}

		filteredSpellsMap.get(filterLevel).add(spellId);
				
	}
	
	public Map<String, String> getFilterClassLevelMap() {
		return filterClassLevelMap;
	}

	public Map<Integer, List<Integer>> getFilteredSpells() {
		// TODO Auto-generated method stub
		return filteredSpellsMap;
	}
	
	public Set<Integer> getFilteredGroups() {
		
		return filteredGroupsList;
	}
}
