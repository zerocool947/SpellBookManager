package com.poorfellow.spellbookmanager.spell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.poorfellow.spellbookmanager.database.DatabaseObject;
import com.poorfellow.spellbookmanager.database.SpellBookDatabaseHelper;
import com.poorfellow.spellbookmanager.database.SpellBookDatabaseManager;

public class SpellDAO implements SpellBookDatabaseManager {

	private SpellBookDatabaseHelper DBHelper;
	private SQLiteDatabase db;

	public SpellDAO(Context context) {
		DBHelper = new SpellBookDatabaseHelper(context);
	}
	
	public Spell createSpell(String name, String school, String subschool, String descriptor, 
			Map<String, Integer> level, String components, String castingTime,
			String target, String range, String effect, String duration, String savingThrow,
			String spellResistance, String description, String materialComponent,
			String arcMaterialComponent, String focus, String arcFocus, String xpCost) {
		
		
		Spell newSpell = new Spell(name, school, subschool, descriptor, level, components, castingTime, 
				target, range, effect, duration, savingThrow, spellResistance, description, 
				materialComponent, arcMaterialComponent, focus, arcFocus, xpCost);
		long rowId = addRow(newSpell);
		newSpell.setId(rowId);
		return newSpell;
	}
	
	@Override
	public long addRow(DatabaseObject newSpell) {
		Spell spell = (Spell) newSpell;

		try {
			db = DBHelper.getWritableDatabase();
			
			ContentValues values = new ContentValues();
			values.put(SPELL_TABLE_ROW_NAME, spell.getName());
			values.put(SPELL_TABLE_ROW_SCHOOL, spell.getSchool());
			//finish this off later, probably need to rewrite it anyway.
			//retrieving spells is more important than writing them at this point
			
		} catch (Exception e) {
			Log.e("DB ERROR", e.toString());
			e.printStackTrace();
		}
		return 0;
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
		List<DatabaseObject> spells = new ArrayList<DatabaseObject>();
		Cursor spellCursor = null;
		Cursor levelCursor = null;
		
		try {
			spellCursor = db.query(SPELL_TABLE_NAME, 
					null,
					null, null, null, null, null);
			spellCursor.moveToFirst();

			if (!spellCursor.isAfterLast()) {
				do {//maybe set with getColumnIndex later
					long spellId = spellCursor.getLong(0);
					String name = spellCursor.getString(1);
					String school = spellCursor.getString(2);
					String subschool = spellCursor.getString(3);
					String descriptor = spellCursor.getString(4);
					String components = spellCursor.getString(5);
					String castingTime = spellCursor.getString(6);
					String target = spellCursor.getString(7);
					String range = spellCursor.getString(8);
					String effect = spellCursor.getString(9);
					String duration = spellCursor.getString(10);
					String savingThrow = spellCursor.getString(11);
					String spellResistance = spellCursor.getString(12);
					String description = spellCursor.getString(13);
					String materialComponent = spellCursor.getString(14);
					String arcMaterialComponent = spellCursor.getString(15);
					String focus = spellCursor.getString(16);
					String arcFocus = spellCursor.getString(17);
					String xpCost = spellCursor.getString(18);
					Map<String, Integer> level = new HashMap<String, Integer>();
					
					levelCursor = db.query(SPELL_CLASS_LEVEL_TABLE_NAME,
							null, SPELL_CLASS_LEVEL_ROW_SPELL_ID + " = ?", 
							new String[] {Long.toString(spellId)}, null, null, null);
					
					levelCursor.moveToFirst();
					
					if (!levelCursor.isAfterLast()) {
						do {
							//long levelId = levelCursor.getLong(1);
							//If I ever make this a class I'll use this
							String className = levelCursor.getString(2);
							int levelValue = levelCursor.getInt(3);
							
							level.put(className, Integer.valueOf(levelValue));
						}
						while (levelCursor.moveToNext());
						
						levelCursor.close();
					}
					
					Spell spell = new Spell(name, school, subschool, descriptor, 
							level, components, castingTime, target, range, effect, 
							duration, savingThrow, spellResistance, description, 
							materialComponent, arcMaterialComponent, focus, arcFocus, xpCost);
					
					spell.setId(spellId);
					spells.add(spell);
				}
				while (spellCursor.moveToNext());
			}
		} catch (SQLException e) {
			Log.e("DB Error", e.toString());
			e.printStackTrace();
		} finally {
			spellCursor.close();
			levelCursor.close();
			db.close();
		}
		
		return spells;
	}
	
	public Map<String, Integer> getAllRowsAsMap() {
		db = DBHelper.getWritableDatabase();
		Map<String, Integer> spells = new HashMap<String, Integer>();
		Cursor spellCursor = null;
		
		try {
			spellCursor = db.query(SPELL_TABLE_NAME, new String[] {SPELL_TABLE_ROW_ID, SPELL_TABLE_ROW_NAME}, 
					null, null, null, null, null);
			
			spellCursor.moveToFirst();
			
			if (!spellCursor.isAfterLast()) {
				do {
					int id = spellCursor.getInt(0);
					String name = spellCursor.getString(1);
					
					spells.put(name, Integer.valueOf(id));
				} while(spellCursor.moveToNext());
			}
		} catch (SQLException e) {
			Log.e("DB Error", e.toString());
			e.printStackTrace();
		}  finally {
			spellCursor.close();
			db.close();
		}
		
		return spells;
	}

	@Override
	public void updateRow(long rowId, List<DatabaseObject> DBObject) {
		// TODO Auto-generated method stub

	}

	public Spell getSpellById(long spellId) {
		db = DBHelper.getWritableDatabase();
		Spell spell = null;
		Cursor spellCursor = null;
		Cursor levelCursor = null;
		
		try {
			spellCursor = db.query(SPELL_TABLE_NAME, 
					null,SPELL_TABLE_ROW_ID + " = ?", 
					new String[] {Long.toString(spellId)}, null, null, null);
			spellCursor.moveToFirst();

			if (!spellCursor.isAfterLast()) {
				do {//maybe set with getColumnIndex later
					String name = spellCursor.getString(spellCursor.getColumnIndex(SPELL_TABLE_ROW_NAME));
					String school = spellCursor.getString(spellCursor.getColumnIndex(SPELL_TABLE_ROW_SCHOOL));
					String subschool = spellCursor.getString(spellCursor.getColumnIndex(SPELL_TABLE_ROW_SUBSCHOOL));
					String descriptor = spellCursor.getString(spellCursor.getColumnIndex(SPELL_TABLE_ROW_DESCRIPTOR));
					String components = spellCursor.getString(spellCursor.getColumnIndex(SPELL_TABLE_ROW_COMPONENTS));
					String castingTime = spellCursor.getString(spellCursor.getColumnIndex(SPELL_TABLE_ROW_CASTING_TIME));
					String target = spellCursor.getString(spellCursor.getColumnIndex(SPELL_TABLE_ROW_TARGET));
					String range = spellCursor.getString(spellCursor.getColumnIndex(SPELL_TABLE_ROW_RANGE));
					String effect = spellCursor.getString(spellCursor.getColumnIndex(SPELL_TABLE_ROW_EFFECT));
					String duration = spellCursor.getString(spellCursor.getColumnIndex(SPELL_TABLE_ROW_DURATION));
					String savingThrow = spellCursor.getString(spellCursor.getColumnIndex(SPELL_TABLE_ROW_SAVING_THROW));
					String spellResistance = spellCursor.getString(spellCursor.getColumnIndex(SPELL_TABLE_ROW_SPELL_RESISTANCE));
					String description = spellCursor.getString(spellCursor.getColumnIndex(SPELL_TABLE_ROW_DESCRIPTION));
					String materialComponent = spellCursor.getString(spellCursor.getColumnIndex(SPELL_TABLE_ROW_MATERIAL_COMPONENT));
					String arcMaterialComponent = spellCursor.getString(spellCursor.getColumnIndex(SPELL_TABLE_ROW_ARCANE_MATERIAL_COMPONENT));
					String focus = spellCursor.getString(spellCursor.getColumnIndex(SPELL_TABLE_ROW_FOCUS));
					String arcFocus = spellCursor.getString(spellCursor.getColumnIndex(SPELL_TABLE_ROW_ARCANE_FOCUS));
					String xpCost = spellCursor.getString(spellCursor.getColumnIndex(SPELL_TABLE_ROW_XP_COST));
					Map<String, Integer> level = new HashMap<String, Integer>();
					
					levelCursor = db.query(SPELL_CLASS_LEVEL_TABLE_NAME,
							null, SPELL_CLASS_LEVEL_ROW_SPELL_ID + " = ?", 
							new String[] {Long.toString(spellId)}, null, null, null);
					
					levelCursor.moveToFirst();
					
					if (!levelCursor.isAfterLast()) {
						do {
							//long levelId = levelCursor.getLong(1);
							//If I ever make this a class I'll use this
							String className = levelCursor.getString(2);
							int levelValue = levelCursor.getInt(3);
							
							level.put(className, Integer.valueOf(levelValue));
						}
						while (levelCursor.moveToNext());
					}
					
					spell = new Spell(name, school, subschool, descriptor, 
							level, components, castingTime, target, range, effect, 
							duration, savingThrow, spellResistance, description, 
							materialComponent, arcMaterialComponent, focus, arcFocus, xpCost);
					
					spell.setId(spellId);
				}
				while (spellCursor.moveToNext());
			}
		} catch (SQLException e) {
			Log.e("DB Error", e.toString());
			e.printStackTrace();
		}  finally {
			spellCursor.close();
			levelCursor.close();
			db.close();
		}
		
		return spell;
	}

	public Spell getSpellById(String spellId) {
		// TODO Auto-generated method stub
		return getSpellById(Long.valueOf(spellId));
	}
	
	
}
