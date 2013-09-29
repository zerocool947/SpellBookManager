package com.poorfellow.spellbookmanager.character;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.Serializable;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import android.util.Log;

import com.poorfellow.spellbookmanager.database.DatabaseObject;

@SuppressWarnings("serial")
public class Character implements DatabaseObject, Serializable {
	
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

	public Character(long id, String name, byte[] data) {
		this.id = id;
		this.name = name;
		DocumentBuilder docBuilder;
		try {
			docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = docBuilder.parse(new ByteArrayInputStream(data));
			XPath xPath = XPathFactory.newInstance().newXPath();
			
			this.level = Integer.parseInt(xPath.compile("/"+CharacterDAO.CHARACTER+"/"+CharacterDAO.CHARACTER_LEVEL).evaluate(doc));
			this.characterClass = xPath.compile("/"+CharacterDAO.CHARACTER+"/"+CharacterDAO.CHARACTER_CLASS).evaluate(doc);
			this.race = xPath.compile("/"+CharacterDAO.CHARACTER+"/"+CharacterDAO.CHARACTER_CLASS).evaluate(doc);
			this.casterLevel = Integer.parseInt(xPath.compile("/"+CharacterDAO.CHARACTER+"/"+CharacterDAO.CASTER_LEVEL).evaluate(doc));
			this.turnAttempts = Integer.parseInt(xPath.compile("/"+CharacterDAO.CHARACTER+"/"+CharacterDAO.TURN_ATTEMPTS).evaluate(doc));
			this.dexterity = Integer.parseInt(xPath.compile("/"+CharacterDAO.CHARACTER+"/"+CharacterDAO.STATS+"/"+CharacterDAO.DEXTERITY).evaluate(doc));
			this.intelligence = Integer.parseInt(xPath.compile("/"+CharacterDAO.CHARACTER+"/"+CharacterDAO.STATS+"/"+CharacterDAO.INTELLIGENCE).evaluate(doc));
			this.strength = Integer.parseInt(xPath.compile("/"+CharacterDAO.CHARACTER+"/"+CharacterDAO.STATS+"/"+CharacterDAO.STRENGTH).evaluate(doc));
			this.charisma = Integer.parseInt(xPath.compile("/"+CharacterDAO.CHARACTER+"/"+CharacterDAO.STATS+"/"+CharacterDAO.CHARISMA).evaluate(doc));
			this.wisdom = Integer.parseInt(xPath.compile("/"+CharacterDAO.CHARACTER+"/"+CharacterDAO.STATS+"/"+CharacterDAO.WISDOM).evaluate(doc));
			this.constitution = Integer.parseInt(xPath.compile("/"+CharacterDAO.CHARACTER+"/"+CharacterDAO.STATS+"/"+CharacterDAO.CONSTITUTION).evaluate(doc));
			
		} catch (ParserConfigurationException e) {
			Log.e("Error Instantiating Document Builder", e.getMessage());
			e.printStackTrace();
		} catch (SAXException e) {
			Log.e("Error Instantiating Document Builder", e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			Log.e("Error Instantiating Document Builder", e.getMessage());
			e.printStackTrace();
		} catch (NumberFormatException e) {
			Log.e("Error parsing blob", e.getMessage());
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			Log.e("Error parsing blob", e.getMessage());
			e.printStackTrace();
		}
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
