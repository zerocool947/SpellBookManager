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
				SpellBookDatabaseManager.SPELL_TABLE_ROW_FOCUS + " text," +
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
		String AcidArrowQueryString = "insert into " +
                SpellBookDatabaseManager.SPELL_TABLE_NAME + 
                "(" + 
                SpellBookDatabaseManager.SPELL_TABLE_ROW_ID + ", " + 
                SpellBookDatabaseManager.SPELL_TABLE_ROW_NAME + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_SCHOOL + ", " + 
                SpellBookDatabaseManager.SPELL_TABLE_ROW_SUBSCHOOL + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_DESCRIPTOR + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_COMPONENTS + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_CASTING_TIME + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_TARGET + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_RANGE + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_EFFECT + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_DURATION + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_SAVING_THROW + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_SPELL_RESISTANCE + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_DESCRIPTION + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_MATERIAL_COMPONENT + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_FOCUS + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_XP_COST +
                ")" +
                "VALUES(" + 
                "1,'Acid Arrow','Conjuration','(Creation)','[Acid]','V, S, M, F'," +
                "'1 standard action',NULL,'Long (400 ft. + 40 ft./level)','One arrow of acid','1 round + 1 round per three levels','None'," +
                "'No','A magical arrow of acid springs from your hand and speeds to its target. You must succeed on a ranged touch attack to hit your target. The arrow deals 2d4 points of acid damage with no splash damage. For every three caster levels (to a maximum of 18th), the acid, unless somehow neutralized, lasts for another round, dealing another 2d4 points of damage in that round.\n','Powdered rhubarb leaf and an adder’s stomach.','A dart.',NULL" +
                ");";
                db.execSQL(AcidArrowQueryString);

db.execSQL("insert into " +
                SpellBookDatabaseManager.SPELL_CLASS_LEVEL_TABLE_NAME +
                "(" + 
                SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_SPELL_ID + ", " + 
                SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_CLASS + ", " + 
                SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_LEVEL + 
                ")"+
                "VALUES(" + 
                "1,'Sor',2);");
db.execSQL("insert into " +
                SpellBookDatabaseManager.SPELL_CLASS_LEVEL_TABLE_NAME +
                "(" + 
                SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_SPELL_ID + ", " + 
                SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_CLASS + ", " + 
                SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_LEVEL + 
                ")"+
                "VALUES(" + 
                "1,'Wiz',2);");
String AcidFogQueryString = "insert into " +
                SpellBookDatabaseManager.SPELL_TABLE_NAME + 
                "(" + 
                SpellBookDatabaseManager.SPELL_TABLE_ROW_ID + ", " + 
                SpellBookDatabaseManager.SPELL_TABLE_ROW_NAME + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_SCHOOL + ", " + 
                SpellBookDatabaseManager.SPELL_TABLE_ROW_SUBSCHOOL + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_DESCRIPTOR + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_COMPONENTS + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_CASTING_TIME + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_TARGET + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_RANGE + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_EFFECT + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_DURATION + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_SAVING_THROW + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_SPELL_RESISTANCE + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_DESCRIPTION + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_MATERIAL_COMPONENT + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_FOCUS + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_XP_COST +
                ")" +
                "VALUES(" + 
                "2,'Acid Fog','Conjuration','(Creation)','[Acid]','V, S, M/DF'," +
                "'1 standard action',NULL,'Medium (100 ft. + 10 ft./level)','Fog spreads in 20-ft. radius, 20 ft. high','1 round/level','None'," +
                "'No','Acid fog creates a billowing mass of misty vapors similar to that produced by a solid fog spell. In addition to slowing creatures down and obscuring sight, this spell’s vapors are highly acidic. Each round on your turn, starting when you cast the spell, the fog deals 2d6 points of acid damage to each creature and object within it.\n\nArcane Material Component\nA pinch of dried, powdered peas combined with powdered animal hoof.\n',NULL,NULL,NULL" +
                ");";
                db.execSQL(AcidFogQueryString);

db.execSQL("insert into " +
                SpellBookDatabaseManager.SPELL_CLASS_LEVEL_TABLE_NAME +
                "(" + 
                SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_SPELL_ID + ", " + 
                SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_CLASS + ", " + 
                SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_LEVEL + 
                ")"+
                "VALUES(" + 
                "2,'Sor',6);");
db.execSQL("insert into " +
                SpellBookDatabaseManager.SPELL_CLASS_LEVEL_TABLE_NAME +
                "(" + 
                SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_SPELL_ID + ", " + 
                SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_CLASS + ", " + 
                SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_LEVEL + 
                ")"+
                "VALUES(" + 
                "2,'Wiz',6);");
db.execSQL("insert into " +
                SpellBookDatabaseManager.SPELL_CLASS_LEVEL_TABLE_NAME +
                "(" + 
                SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_SPELL_ID + ", " + 
                SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_CLASS + ", " + 
                SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_LEVEL + 
                ")"+
                "VALUES(" + 
                "2,'Water',7);");
String AcidSplashQueryString = "insert into " +
                SpellBookDatabaseManager.SPELL_TABLE_NAME + 
                "(" + 
                SpellBookDatabaseManager.SPELL_TABLE_ROW_ID + ", " + 
                SpellBookDatabaseManager.SPELL_TABLE_ROW_NAME + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_SCHOOL + ", " + 
                SpellBookDatabaseManager.SPELL_TABLE_ROW_SUBSCHOOL + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_DESCRIPTOR + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_COMPONENTS + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_CASTING_TIME + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_TARGET + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_RANGE + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_EFFECT + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_DURATION + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_SAVING_THROW + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_SPELL_RESISTANCE + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_DESCRIPTION + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_MATERIAL_COMPONENT + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_FOCUS + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_XP_COST +
                ")" +
                "VALUES(" + 
                "3,'Acid Splash','Conjuration','(Creation)','[Acid]','V, S'," +
                "'1 standard action',NULL,'Close (25 ft. + 5 ft./2 levels)','One missile of acid','Instantaneous','None'," +
                "'No','You fire a small orb of acid at the target. You must succeed on a ranged touch attack to hit your target. The orb deals 1d3 points of acid damage.\n',NULL,NULL,NULL" +
                ");";
                db.execSQL(AcidSplashQueryString);

db.execSQL("insert into " +
                SpellBookDatabaseManager.SPELL_CLASS_LEVEL_TABLE_NAME +
                "(" + 
                SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_SPELL_ID + ", " + 
                SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_CLASS + ", " + 
                SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_LEVEL + 
                ")"+
                "VALUES(" + 
                "3,'Sor',0);");
db.execSQL("insert into " +
                SpellBookDatabaseManager.SPELL_CLASS_LEVEL_TABLE_NAME +
                "(" + 
                SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_SPELL_ID + ", " + 
                SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_CLASS + ", " + 
                SpellBookDatabaseManager.SPELL_CLASS_LEVEL_ROW_LEVEL + 
                ")"+
                "VALUES(" + 
                "3,'Wiz',0);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
