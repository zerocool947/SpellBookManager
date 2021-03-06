package com.poorfellow.spellbookmanager.database;

import java.util.List;


public interface SpellBookDatabaseManager {
	
	public final static String DB_NAME = "spellbook";
	public final static int DB_VERSION = 1;
	
	public final static String CHARACTER_TABLE_NAME = "characters";
	public final static String CHARACTER_TABLE_ROW_ID = "id";
	public final static String CHARACTER_TABLE_ROW_NAME = "name";
	public final static String CHARACTER_TABLE_ROW_DATA = "character_data";
	
	public final static String SPELL_TABLE_NAME = "spells";
	public final static String SPELL_TABLE_ROW_ID = "id";
	public final static String SPELL_TABLE_ROW_NAME = "name";
	public static final String SPELL_TABLE_ROW_SCHOOL = "school";
	public static final String SPELL_TABLE_ROW_SUBSCHOOL = "subschool";
	public static final String SPELL_TABLE_ROW_DESCRIPTOR = "descriptor";
	public static final String SPELL_TABLE_ROW_COMPONENTS = "components";
	public static final String SPELL_TABLE_ROW_CASTING_TIME = "casting_time";
	public static final String SPELL_TABLE_ROW_TARGET = "target";
	public static final String SPELL_TABLE_ROW_RANGE = "range";
    public static final String SPELL_TABLE_ROW_AREA = "area";
	public static final String SPELL_TABLE_ROW_EFFECT = "effect";
	public static final String SPELL_TABLE_ROW_DURATION = "duration";
	public static final String SPELL_TABLE_ROW_SAVING_THROW = "saving_throw";
	public static final String SPELL_TABLE_ROW_SPELL_RESISTANCE = "spell_resistance";
	public static final String SPELL_TABLE_ROW_DESCRIPTION = "description";
	public static final String SPELL_TABLE_ROW_MATERIAL_COMPONENT = "material_component";
	public static final String SPELL_TABLE_ROW_ARCANE_MATERIAL_COMPONENT = "arcane_material_component";
	public static final String SPELL_TABLE_ROW_FOCUS = "focus";
	public static final String SPELL_TABLE_ROW_ARCANE_FOCUS = "arcane_focus";
	public static final String SPELL_TABLE_ROW_XP_COST = "xp_cost";

	public final static String SPELL_BLOCK_TABLE_NAME = "spell_blocks";
	public final static String SPELL_BLOCK_ROW_ID = "id";
	public final static String SPELL_BLOCK_ROW_NAME = "name";
	public final static String SPELL_BLOCK_ROW_CHARACTER_ID = "character_id";
	
	public final static String SPELL_BLOCK_SHEET_TABLE_NAME = "spell_block_sheets";
	public final static String SPELL_BLOCK_SHEET_ROW_ID = "id";
	public final static String SPELL_BLOCK_SHEET_ROW_SPELL_BLOCK_ID = "spell_block_id";
	public final static String SPELL_BLOCK_SHEET_ROW_SPELL_ID = "spell_id";
	
	public final static String DAILY_LIST_TABLE_NAME = "daily_lists";
	public final static String DAILY_LIST_ROW_ID = "id";
	public final static String DAILY_LIST_ROW_NAME = "name";
	public final static String DAILY_LIST_ROW_CHARACTER_ID = "character_id";
	public final static String DAILY_LIST_ROW_TYPE = "type";

	public final static String DAILY_LIST_SHEET_TABLE_NAME = "daily_list_sheets";
	public final static String DAILY_LIST_SHEET_ROW_ID = "id";
	public final static String DAILY_LIST_SHEET_ROW_DAILY_LIST_ID = "daily_list_id";
	public final static String DAILY_LIST_SHEET_ROW_SPELL_BLOCK_ID = "spell_block_id";
	public final static String DAILY_LIST_SHEET_ROW_SPELL_ID = "spell_id";
	
	public final static String SPELL_CLASS_LEVEL_TABLE_NAME= "spell_class_level";
	public static final String SPELL_CLASS_LEVEL_ROW_ID = "id";
	public final static String SPELL_CLASS_LEVEL_ROW_SPELL_ID = "spell_id";
	public final static String SPELL_CLASS_LEVEL_ROW_CLASS = "class";
	public final static String SPELL_CLASS_LEVEL_ROW_LEVEL = "level";
	
	long addRow(DatabaseObject DBObject);
	void removeRow(DatabaseObject DBObject);
	void removeRowByID(long id);
	void getRowByObject(DatabaseObject DBObject);
	List<DatabaseObject> getAllRows();
	void updateRow(long rowId, List<DatabaseObject> DBObject);
	
	
	
}
