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
				SpellBookDatabaseManager.CHARACTER_TABLE_ROW_ID + "integer primary key autoincrement not null," +
				SpellBookDatabaseManager.CHARACTER_TABLE_ROW_NAME + " text," +
				SpellBookDatabaseManager.CHARACTER_TABLE_ROW_DATA + "blob" +
				");";
		
		db.execSQL(characterTableQueryString);
		
		String spellTableQueryString = "create_table " +
				SpellBookDatabaseManager.SPELL_TABLE_NAME + 
				" (" + 
				SpellBookDatabaseManager.SPELL_TABLE_ROW_ID + "integer primary key autoincrement not null," +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_NAME + "text," +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_DATA + "blob" + //Not sure about this blob creation
				");";
		db.execSQL(spellTableQueryString);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
