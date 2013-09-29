package com.poorfellow.spellbookmanager.database;

import java.util.List;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.poorfellow.spellbookmanager.character.Character;

public interface SpellBookDatabaseManager {
	
	public final static String DB_NAME = "spellbook";
	public final static int DB_VERSION = 1;
	
	public final static String CHARACTER_TABLE_NAME = "characters";
	public final static String CHARACTER_TABLE_ROW_ID = "id";
	public final static String CHARACTER_TABLE_ROW_NAME = "name";
	public final static String CHARACTER_TABLE_ROW_DATA = "character_data";
	
	public final static String SPELL_TABLE_NAME = "spells";
	public final static String SPELL_TABLE_ROW_ID = "id";
	public final static String SPELL_TABLE_ROW_NAME = "spell_name";
	public final static String SPELL_TABLE_ROW_DATA = "spell_data";
	
	public final static String SPELL_BLOCK_TABLE_NAME = "spell_blocks";
	public final static String SPELL_BLOCK_ROW_ID = "id";
	public final static String SPELL_BLOCK_ROW_BLOCK_NAME = "spell_block_name";
	public final static String SPELL_BLOCK_ROW_CHARACTER_ID = "character_id";
	public final static String SPELL_BLOCK_ROW_DATA = "spell_block_data";
	
	public final static String DAILY_LIST_TABLE_NAME = "daily_lists";
	public final static String DAILY_LIST_ROW_ID = "id";
	public final static String DAILY_LIST_ROW_NAME = "daily_list_name";
	public final static String DAILY_LIST_ROW_CHARACTER_ID = "character_id";
	public final static String DAILY_LIST_ROW_TYPE = "type";
	public final static String DAILY_LIST_ROW_DATA = "blob";
		
	//don't do "add row, delete row" etc
	//do "Add Character, remove character, add spell
	//then maybe make generic methods underneath that like "addrow"
	
	long addRow(DatabaseObject DBObject);
	void removeRow(DatabaseObject DBObject);
	void removeRowByID(long id);
	void getRowByObject(DatabaseObject DBObject);
	List<DatabaseObject> getAllRows();
	void updateRow(long rowId, List<DatabaseObject> DBObject);
	
	
	
}
