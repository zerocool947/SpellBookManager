package com.poorfellow.spellbookmanager.spell;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.poorfellow.spellbookmanager.database.DatabaseObject;
import com.poorfellow.spellbookmanager.database.SpellBookDatabaseHelper;
import com.poorfellow.spellbookmanager.database.SpellBookDatabaseManager;

public class SpellBlockDAO implements SpellBookDatabaseManager {

	private SpellBookDatabaseHelper DBHelper;
	private SQLiteDatabase db;
	
	public SpellBlockDAO(Context context) {
		DBHelper = new SpellBookDatabaseHelper(context);
	}
	
	public SpellBlock createSpellBlock(String name, long characterId, List<Integer> spells) {
		SpellBlock newSpellBlock = new SpellBlock(name, characterId, spells);
		long rowId = addRow(newSpellBlock);
		newSpellBlock.setId(rowId);
		return newSpellBlock;
	}
	@Override
	public long addRow(DatabaseObject DBObject) {
		SpellBlock spellBlock = (SpellBlock) DBObject;
		long spellBlockId = -1;
		try {
			db = DBHelper.getWritableDatabase();
			
			ContentValues spellBlockValues = new ContentValues();
			spellBlockValues.put(SPELL_BLOCK_ROW_NAME, spellBlock.getName());
			spellBlockValues.put(SPELL_BLOCK_ROW_CHARACTER_ID, spellBlock.getCharacterId());
			spellBlockId = db.insert(SPELL_BLOCK_TABLE_NAME, null, spellBlockValues);
			
			for (Integer spell : spellBlock.getSpells()) {
				ContentValues sheetValues = new ContentValues();
				sheetValues.put(SPELL_BLOCK_SHEET_ROW_SPELL_BLOCK_ID, spellBlockId);
				sheetValues.put(SPELL_BLOCK_SHEET_ROW_SPELL_ID, spell);
				db.insert(SPELL_BLOCK_SHEET_TABLE_NAME, null, sheetValues);
			}
			
		} catch (Exception e) {
			Log.e("DB ERROR", e.toString());
			e.printStackTrace();
		}
		return spellBlockId;
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
		List<DatabaseObject> spellBlocks = new ArrayList<DatabaseObject>();
		Cursor spellBlockCursor = null;
		Cursor sheetCursor = null;
		
		try {
			spellBlockCursor = db.query(SPELL_BLOCK_TABLE_NAME,
					null, 
					null, null, null, null, null); 
			spellBlockCursor.moveToFirst();
			
			if (!spellBlockCursor.isAfterLast()) {
				do {
					long spellBlockId = spellBlockCursor.getLong(spellBlockCursor.
							getColumnIndex(SPELL_BLOCK_ROW_ID));
					String name = spellBlockCursor.getString(spellBlockCursor.
							getColumnIndex(SPELL_BLOCK_ROW_NAME));
					long characterId = spellBlockCursor.getLong(spellBlockCursor.
							getColumnIndex(SPELL_BLOCK_ROW_CHARACTER_ID));
					List<Integer> spellIds = new ArrayList<Integer>();
					
					sheetCursor = db.query(SPELL_BLOCK_SHEET_TABLE_NAME,
							null, SPELL_BLOCK_SHEET_ROW_SPELL_BLOCK_ID + " = ?",
							new String[] {Long.toString(spellBlockId)}, null, null, null);
					
					sheetCursor.moveToFirst();
					
					if (!sheetCursor.isAfterLast()) {
						do {
							int spellId = sheetCursor.getInt(sheetCursor
									.getColumnIndex(SPELL_BLOCK_SHEET_ROW_SPELL_ID));
							spellIds.add(Integer.valueOf(spellId));
						} 
						while(sheetCursor.moveToNext());
					}
					
					SpellBlock spellBlock = new SpellBlock(name, characterId, spellIds);
					spellBlock.setId(spellBlockId);
					spellBlocks.add(spellBlock);
					
				}
				while (sheetCursor.moveToNext());
				
			}
		} catch (SQLException e) {
			Log.e("DB Error", e.toString());
			e.printStackTrace();
		}
		
		return spellBlocks;
	}

	@Override
	public void updateRow(long rowId, List<DatabaseObject> DBObject) {
		// TODO Auto-generated method stub

	}

}
