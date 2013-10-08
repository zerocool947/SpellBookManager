package com.poorfellow.spellbookmanager.spell;

import java.io.Serializable;

import com.poorfellow.spellbookmanager.database.DatabaseObject;

@SuppressWarnings("serial")
public class Spell implements DatabaseObject, Serializable {

	private String name;
	private long id;
	private String school;
	private String subschool;
	private String level;
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

	private String getSubschool() {
		return subschool;
	}

	private void setSubschool(String subschool) {
		this.subschool = subschool;
	}

	private String getLevel() {
		return level;
	}

	private void setLevel(String level) {
		this.level = level;
	}

	private String getComponents() {
		return components;
	}

	private void setComponents(String components) {
		this.components = components;
	}

	private String getCastingTime() {
		return castingTime;
	}

	private void setCastingTime(String castingTime) {
		this.castingTime = castingTime;
	}

	private String getTarget() {
		return target;
	}

	private void setTarget(String target) {
		this.target = target;
	}

	private String getRange() {
		return range;
	}

	private void setRange(String range) {
		this.range = range;
	}

	private String getEffect() {
		return effect;
	}

	private void setEffect(String effect) {
		this.effect = effect;
	}

	private String getDuration() {
		return duration;
	}

	private void setDuration(String duration) {
		this.duration = duration;
	}

	private String getSavingThrow() {
		return savingThrow;
	}

	private void setSavingThrow(String savingThrow) {
		this.savingThrow = savingThrow;
	}

	private String getSpellResistance() {
		return spellResistance;
	}

	private void setSpellResistance(String spellResistance) {
		this.spellResistance = spellResistance;
	}

	private String getDescription() {
		return description;
	}

	private void setDescription(String description) {
		this.description = description;
	}

	private String getMaterialComponent() {
		return materialComponent;
	}

	private void setMaterialComponent(String materialComponent) {
		this.materialComponent = materialComponent;
	}

	private String getFocus() {
		return focus;
	}

	private void setFocus(String focus) {
		this.focus = focus;
	}

}
