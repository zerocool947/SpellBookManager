package com.poorfellow.spellbookmanager.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SpellBookDatabaseHelper extends SQLiteOpenHelper {

	public SpellBookDatabaseHelper(Context context) {
		super(context, SpellBookDatabaseManager.DB_NAME, null, SpellBookDatabaseManager.DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String characterTableQueryString = "create table " +
				SpellBookDatabaseManager.CHARACTER_TABLE_NAME + 
				" (" +
				SpellBookDatabaseManager.CHARACTER_TABLE_ROW_ID + " integer primary key autoincrement not null," +
				SpellBookDatabaseManager.CHARACTER_TABLE_ROW_NAME + " text," +
				SpellBookDatabaseManager.CHARACTER_TABLE_ROW_DATA + " blob" +
				");";
		db.execSQL(characterTableQueryString);
		
		/*String YousseffQueryString = "insert into " +
				SpellBookDatabaseManager.CHARACTER_TABLE_NAME +
				"(" + 
				SpellBookDatabaseManager.CHARACTER_TABLE_ROW_ID +
				SpellBookDatabaseManager.CHARACTER_TABLE_ROW_NAME + 
				SpellBookDatabaseManager.CHARACTER_TABLE_ROW_DATA + 
				")" + 
				"VALUES(" +
				"1,'Yousseff','<>'" +
				");";
		db.execSQL(YousseffQueryString);*/
		
		String spellTableQueryString = "create table " +
				SpellBookDatabaseManager.SPELL_TABLE_NAME + 
				" (" + 
				SpellBookDatabaseManager.SPELL_TABLE_ROW_ID + " integer primary key autoincrement not null," +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_NAME + " text," +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_SCHOOL + " text," + 
				SpellBookDatabaseManager.SPELL_TABLE_ROW_SUBSCHOOL + " text," +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_DESCRIPTOR + " text," +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_COMPONENTS + " text," +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_CASTING_TIME + " text," +  
				SpellBookDatabaseManager.SPELL_TABLE_ROW_TARGET + " text," + 
				SpellBookDatabaseManager.SPELL_TABLE_ROW_RANGE + " text," +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_EFFECT + " text," + 
				SpellBookDatabaseManager.SPELL_TABLE_ROW_DURATION + " text," +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_SAVING_THROW + " text," +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_SPELL_RESISTANCE + " text," + 
				SpellBookDatabaseManager.SPELL_TABLE_ROW_DESCRIPTION + " text," + 
				SpellBookDatabaseManager.SPELL_TABLE_ROW_MATERIAL_COMPONENT + " text," + 
				SpellBookDatabaseManager.SPELL_TABLE_ROW_ARCANE_MATERIAL_COMPONENT + " text," +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_FOCUS + " text," +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_ARCANE_FOCUS + " text," +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_XP_COST + " text" + 
				");";
		db.execSQL(spellTableQueryString);
	
		String spellClassLevelTableQueryString = "create table " +
				SpellBookDatabaseManager.SPELL_CLASS_LEVEL_TABLE_NAME +
				" (" +
				SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_ID + " integer primary key autoincrement not null," +
				SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_SPELL_ID + " integer," + 
				SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_CLASS + " text," +
				SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_LEVEL + " integer," +
				"FOREIGN KEY(" + 
				SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_SPELL_ID + " ) REFERENCES " +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_NAME + "(" +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_ID + ")" +
				");";
		db.execSQL(spellClassLevelTableQueryString);
		
		/*db.execSQL("insert into " +
		SpellBookDatabaseManager.SPELL_CLASS_LEVEL_TABLE_NAME +
		"(" + 
		SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_SPELL_ID + ", " + 
		SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_CLASS + ", " + 
		SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_LEVEL + 
		")"+
		"VALUES(" + 
		"${id},${className},${level});");*/
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}