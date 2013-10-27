package com.poorfellow.spellbookmanager.spell;

import java.io.Serializable;
import java.util.Map;

import com.poorfellow.spellbookmanager.database.DatabaseObject;

@SuppressWarnings("serial")
public class Spell implements DatabaseObject, Serializable {

	private String name;
	private long id;
	private String school;
	private String subschool;
	private String descriptor;
	private Map<String, Integer> level;
	private String components;
	private String castingTime;
	private String target;
	private String range;
	private String effect;
	private String duration;
	private String savingThrow;
	private String spellResistance;
	private String description;
	private String materialComponent;
	private String focus;
	private String xpCost;
	
	public Spell(String name, String school, String subschool, String descriptor, 
			Map<String, Integer> level, String components, String castingTime,
			String target, String range, String effect, String duration, String savingThrow,
			String spellResistance, String description, String materialComponent,
			String focus, String xpCost) {
		
		this.name = name;
		this.school = school;
		this.subschool = subschool;
		this.descriptor = descriptor;
		this.level = level;
		this.components = components;
		this.castingTime = castingTime;
		this.target = target;
		this.range = range;
		this.effect = effect;
		this.duration = duration;
		this.savingThrow = savingThrow;
		this.spellResistance = spellResistance;
		this.description = description;
		this.materialComponent = materialComponent;
		this.focus = focus;
		this.xpCost = xpCost;
	}
	
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

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getSubschool() {
		return subschool;
	}

	public void setSubschool(String subschool) {
		this.subschool = subschool;
	}

	public String getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(String descriptor) {
		this.descriptor = descriptor;
	}

	public Map<String, Integer> getLevel() {
		return level;
	}

	public void setLevel(Map<String, Integer> level) {
		this.level = level;
	}
	
	public void addLevel(String className, Integer level) {
		this.level.put(className, level);
	}

	public String getComponents() {
		return components;
	}

	public void setComponents(String components) {
		this.components = components;
	}

	public String getCastingTime() {
		return castingTime;
	}

	public void setCastingTime(String castingTime) {
		this.castingTime = castingTime;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getSavingThrow() {
		return savingThrow;
	}

	public void setSavingThrow(String savingThrow) {
		this.savingThrow = savingThrow;
	}

	public String getSpellResistance() {
		return spellResistance;
	}

	public void setSpellResistance(String spellResistance) {
		this.spellResistance = spellResistance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMaterialComponent() {
		return materialComponent;
	}

	public void setMaterialComponent(String materialComponent) {
		this.materialComponent = materialComponent;
	}

	public String getFocus() {
		return focus;
	}

	public void setFocus(String focus) {
		this.focus = focus;
	}

	public String getXpCost() {
		return xpCost;
	}

	public void setXpCost(String xpCost) {
		this.xpCost = xpCost;
	}

	public String toString() {
		return this.name;
	}
	
}
