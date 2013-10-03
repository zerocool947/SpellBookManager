package com.poorfellow.spellbookmanager.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
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
				SpellBookDatabaseManager.CHARACTER_TABLE_ROW_ID + " integer primary key autoincrement not null ," +
				SpellBookDatabaseManager.CHARACTER_TABLE_ROW_NAME + " text," +
				SpellBookDatabaseManager.CHARACTER_TABLE_ROW_DATA + " blob" +
				");";
		
		db.execSQL(characterTableQueryString);
		
		String spellTableQueryString = "create table " +
				SpellBookDatabaseManager.SPELL_TABLE_NAME + 
				" (" + 
				SpellBookDatabaseManager.SPELL_TABLE_ROW_ID + " integer primary key autoincrement not null," +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_NAME + " text," +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_SCHOOL + " text," + 
				SpellBookDatabaseManager.SPELL_TABLE_ROW_SUBSCHOOL + " text," +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_LEVEL + " text," + 
				SpellBookDatabaseManager.SPELL_TABLE_ROW_COMPONENTS + " text," +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_CASTING_TIME + " text," + 
				SpellBookDatabaseManager.SPELL_TABLE_ROW_RANGE + " text," +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_EFFECT + " text," + 
				SpellBookDatabaseManager.SPELL_TABLE_ROW_DURATION + " text," +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_SAVING_THROW + " text," +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_SPELL_RESISTANCE + " text," + 
				SpellBookDatabaseManager.SPELL_TABLE_ROW_DESCRIPTION + " text," + 
				SpellBookDatabaseManager.SPELL_TABLE_ROW_MATERIAL_COMPONENT + " text," + 
				SpellBookDatabaseManager.SPELL_TABLE_ROW_FOCUS + " text," +
				");";
		db.execSQL(spellTableQueryString);
		
		String acidArrowQueryString = "insert into " +
				SpellBookDatabaseManager.DB_NAME + 
				"." +
				SpellBookDatabaseManager.SPELL_TABLE_NAME + 
				"(" + 
				SpellBookDatabaseManager.SPELL_TABLE_ROW_ID + ", " + 
				SpellBookDatabaseManager.SPELL_TABLE_ROW_NAME + ", " +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_SCHOOL + ", " + 
				SpellBookDatabaseManager.SPELL_TABLE_ROW_SUBSCHOOL + ", " +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_LEVEL + ", " +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_COMPONENTS + ", " +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_CASTING_TIME + ", " +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_RANGE + ", " +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_EFFECT + ", " +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_DURATION + ", " +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_SAVING_THROW + ", " +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_SPELL_RESISTANCE + ", " +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_DESCRIPTION + ", " +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_MATERIAL_COMPONENT + ", " +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_FOCUS + ", " +
				")" +
				"\'${id}\',\'${name}\',\'${school)\',\'${subschool}\',\'${level}\',\'${components}\'," +
				"\'${castingTime}\',\'${range},\'${effect}\',\'${duration}\',\'${savingThrow}\'," +
				"\'${spellResistance}\',\'${description}\',\'${materialComponent}\',\'${focus}\'" +
				");";
		db.execSQL(acidArrowQueryString);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
