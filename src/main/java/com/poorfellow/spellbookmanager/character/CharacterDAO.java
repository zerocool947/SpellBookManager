package com.poorfellow.spellbookmanager.character;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.poorfellow.spellbookmanager.database.DatabaseObject;
import com.poorfellow.spellbookmanager.database.SpellBookDatabaseHelper;
import com.poorfellow.spellbookmanager.database.SpellBookDatabaseManager;

public class CharacterDAO implements SpellBookDatabaseManager {
	
	public static final String ROOT_ELEMENT = "character";
	public static final String NAME = "name";
	public static final String CHARACTER_LEVEL = "level";
	public static final String CHARACTER_CLASS = "class";
	public static final String RACE = "race";
	public static final String CASTER_LEVEL = "caster-level";
	public static final String INTELLIGENCE = "int";
	public static final String DEXTERITY = "dex";
	public static final String WISDOM = "wis";
	public static final String CHARISMA = "cha";
	public static final String CONSTITUTION = "con";
	public static final String STRENGTH = "str";
	public static final String STATS = "stats";
	public static final String TURN_ATTEMPTS = "turn-attempts";

	private SpellBookDatabaseHelper DBHelper;
	private SQLiteDatabase db;
	
	public CharacterDAO(Context context) {
		DBHelper = new SpellBookDatabaseHelper(context);
	}
	
	public Character CreateCharacter(String name, int level, String characterClass, String race, int casterLevel, 
			int dexterity, int intelligence, int strength, int charisma, int wisdom, int constitution,
			int turnAttempts) {
		
		Character newCharacter = new Character(name, level, characterClass, race, casterLevel, 
				dexterity, intelligence, strength, charisma, wisdom, constitution,
				turnAttempts);
		
		long rowId = addRow(newCharacter);
		newCharacter.setId(rowId);
		return newCharacter;
		
	}
	@Override
	public long addRow(DatabaseObject newCharacter) {
		long characterId = -1;
		Character character = (Character) newCharacter;
		String characterXML = "";
		
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			Document doc = docBuilder.newDocument();
			
			Element rootElement = doc.createElement(ROOT_ELEMENT);
			doc.appendChild(rootElement);
			
			Element nameElement = doc.createElement(NAME);
			nameElement.appendChild(doc.createTextNode(character.getName()));
			rootElement.appendChild(nameElement);
			
			Element levelElement = doc.createElement(CHARACTER_LEVEL);
			levelElement.appendChild(doc.createTextNode(Integer.toString(character.getLevel())));
			rootElement.appendChild(levelElement);
			
			Element casterElement = doc.createElement(CASTER_LEVEL);
			casterElement.appendChild(doc.createTextNode(Integer.toString(character.getCasterLevel())));
			rootElement.appendChild(casterElement);
			
			Element classElement = doc.createElement(CHARACTER_CLASS);
			casterElement.appendChild(doc.createTextNode(character.getCharacterClass()));
			rootElement.appendChild(classElement);
			
			Element turnElement = doc.createElement(TURN_ATTEMPTS);
			turnElement.appendChild(doc.createTextNode(Integer.toString(character.getTurnAttempts())));
			rootElement.appendChild(turnElement);
			
			Element raceElement = doc.createElement(RACE);
			raceElement.appendChild(doc.createTextNode(character.getRace()));
			rootElement.appendChild(raceElement);
			
			Element statsElement = doc.createElement(STATS);
			rootElement.appendChild(statsElement);
			
			Element intElement = doc.createElement(INTELLIGENCE);
			intElement.appendChild(doc.createTextNode(Integer.toString(character.getIntelligence())));
			statsElement.appendChild(intElement);
			
			Element strElement = doc.createElement(STRENGTH);
			strElement.appendChild(doc.createTextNode(Integer.toString(character.getStrength())));
			statsElement.appendChild(strElement);
			
			Element dexElement = doc.createElement(DEXTERITY);
			dexElement.appendChild(doc.createTextNode(Integer.toString(character.getDexterity())));
			statsElement.appendChild(dexElement);
			
			Element conElement = doc.createElement(CONSTITUTION);
			conElement.appendChild(doc.createTextNode(Integer.toString(character.getConstitution())));
			statsElement.appendChild(conElement);
			
			Element wisElement = doc.createElement(WISDOM);
			wisElement.appendChild(doc.createTextNode(Integer.toString(character.getWisdom())));
			statsElement.appendChild(wisElement);
			
			Element chaElement = doc.createElement(CHARISMA);
			chaElement.appendChild(doc.createTextNode(Integer.toString(character.getCharisma())));
			statsElement.appendChild(chaElement);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			
			StringWriter sw = new StringWriter();
			StreamResult result = new StreamResult(sw);
			DOMSource source = new DOMSource(doc.getDocumentElement());
			
			transformer.transform(source, result);
			characterXML = sw.toString();
			
			if (characterXML.equals("")) {
				throw new Exception("Error writing character xml");
			}
			
		} catch (ParserConfigurationException e) {
		    throw new RuntimeException(e);
		} catch (TransformerConfigurationException e) {
			//TODO something here
		} catch (TransformerException e) {
			//TODO something here
		} catch (Exception e) {
			//TODO something here
		}
		
		try {
			db = DBHelper.getWritableDatabase();

			ContentValues values = new ContentValues();
			values.put(CHARACTER_TABLE_ROW_NAME, character.getName());
			values.put(CHARACTER_TABLE_ROW_DATA, characterXML);
			characterId = db.insert(CHARACTER_TABLE_NAME, null, values);
		} catch(Exception e) {
			Log.e("DB ERROR", e.toString());
			e.printStackTrace();
		} finally {
			db.close();
		}
		
		return characterId;
	}

	@Override
	public void removeRow(DatabaseObject DBObject) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeRowByID(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getRowByObject(DatabaseObject DBObject) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DatabaseObject> getAllRows() {
		db = DBHelper.getWritableDatabase();
		List<DatabaseObject> characters = new ArrayList<DatabaseObject>();
		Cursor cursor = null;
		
		try {
			cursor = db.query(CHARACTER_TABLE_NAME,
					new String[] {CHARACTER_TABLE_ROW_ID, CHARACTER_TABLE_ROW_NAME, CHARACTER_TABLE_ROW_DATA},
					null, null, null, null, null);
			cursor.moveToFirst();
			if (!cursor.isAfterLast()) {
				do {
					long ID = cursor.getLong(cursor.getColumnIndex(CHARACTER_TABLE_ROW_ID));
					String name = cursor.getString(cursor.getColumnIndex(CHARACTER_TABLE_ROW_NAME));
					byte[] data = cursor.getBlob(cursor.getColumnIndex(CHARACTER_TABLE_ROW_DATA));
					Character character = new Character(ID, name, data);
					characters.add(character);
				}
				while (cursor.moveToNext());
			}
		} catch (SQLException e) {
			Log.e("DB Error", e.toString());
			e.printStackTrace();
		} finally {
			cursor.close();
			db.close();
		}
		
		return characters;
	}

	@Override
	public void updateRow(long rowId, List<DatabaseObject> DBObject) {
		// TODO Auto-generated method stub

	}
	
	public String getCharacterDataAsString(long rowId) {
		db = DBHelper.getWritableDatabase();
		String characterData = null;
		Cursor cursor = null;
		
		try {
			cursor = db.query(CHARACTER_TABLE_NAME,
					new String[] {CHARACTER_TABLE_ROW_DATA}, CHARACTER_TABLE_ROW_ID + " = ?",
					new String[] {Long.toString(rowId)}, null, null, null);
			if (!cursor.moveToFirst()){
				throw new SQLException("No character for character_id " + rowId);
			}
			
			characterData = cursor.getString(0);
		} catch (SQLException e) {
			Log.e("DB Error", e.toString());
			e.printStackTrace();
		} finally {
			cursor.close();
			db.close();
		}
		return characterData;
	}

}
