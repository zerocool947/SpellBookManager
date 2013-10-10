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
				SpellBookDatabaseManager.CHARACTER_TABLE_ROW_ID + " integer primary key autoincrement not null," +
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
				SpellBookDatabaseManager.SPELL_TABLE_ROW_DESCRIPTOR + " text," +
				SpellBookDatabaseManager.SPELL_TABLE_ROW_LEVEL + " text," + 
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
		
		String AcidArrowQueryString = "insert into " +
                SpellBookDatabaseManager.SPELL_TABLE_NAME + 
                "(" + 
                SpellBookDatabaseManager.SPELL_TABLE_ROW_NAME + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_SCHOOL + ", " + 
                SpellBookDatabaseManager.SPELL_TABLE_ROW_SUBSCHOOL + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_DESCRIPTOR + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_LEVEL + ", " +
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
                "'Acid Arrow','Conjuration','Creation','Acid','Sor/Wiz 2','V, S, M, F'," +
                "'1 standard action',NULL,'Long (400 ft. + 40 ft./level)','One arrow of acid','1 round + 1 round per three levels','None'," +
                "'No','A magical arrow of acid springs from your hand and speeds to its target. You must succeed on a ranged touch attack to hit your target. The arrow deals 2d4 points of acid damage with no splash damage. For every three caster levels (to a maximum of 18th), the acid, unless somehow neutralized, lasts for another round, dealing another 2d4 points of damage in that round. ','Powdered rhubarb leaf and an adder’s stomach.','A dart.',NULL" +
                ");";
                db.execSQL(AcidArrowQueryString);

String AcidFogQueryString = "insert into " +
                SpellBookDatabaseManager.SPELL_TABLE_NAME + 
                "(" + 
                SpellBookDatabaseManager.SPELL_TABLE_ROW_NAME + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_SCHOOL + ", " + 
                SpellBookDatabaseManager.SPELL_TABLE_ROW_SUBSCHOOL + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_DESCRIPTOR + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_LEVEL + ", " +
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
                "'Acid Fog','Conjuration','Creation','Acid','Sor/Wiz 6, Water 7','V, S, M/DF'," +
                "'1 standard action',NULL,'Medium (100 ft. + 10 ft./level)','Fog spreads in 20-ft. radius, 20 ft. high','1 round/level','None'," +
                "'No','Acid fog creates a billowing mass of misty vapors similar to that produced by a solid fog spell. In addition to slowing creatures down and obscuring sight, this spell’s vapors are highly acidic. Each round on your turn, starting when you cast the spell, the fog deals 2d6 points of acid damage to each creature and object within it. A pinch of dried, powdered peas combined with powdered animal hoof. ',NULL,NULL,NULL" +
                ");";
                db.execSQL(AcidFogQueryString);

String AcidSplashQueryString = "insert into " +
                SpellBookDatabaseManager.SPELL_TABLE_NAME + 
                "(" + 
                SpellBookDatabaseManager.SPELL_TABLE_ROW_NAME + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_SCHOOL + ", " + 
                SpellBookDatabaseManager.SPELL_TABLE_ROW_SUBSCHOOL + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_DESCRIPTOR + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_LEVEL + ", " +
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
                "'Acid Splash','Conjuration','Creation','Acid','Sor/Wiz 0','V, S'," +
                "'1 standard action',NULL,'Close (25 ft. + 5 ft./2 levels)','One missile of acid','Instantaneous','None'," +
                "'No','You fire a small orb of acid at the target. You must succeed on a ranged touch attack to hit your target. The orb deals 1d3 points of acid damage. ',NULL,NULL,NULL" +
                ");";
                db.execSQL(AcidSplashQueryString);

String AidQueryString = "insert into " +
                SpellBookDatabaseManager.SPELL_TABLE_NAME + 
                "(" + 
                SpellBookDatabaseManager.SPELL_TABLE_ROW_NAME + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_SCHOOL + ", " + 
                SpellBookDatabaseManager.SPELL_TABLE_ROW_SUBSCHOOL + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_DESCRIPTOR + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_LEVEL + ", " +
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
                "'Aid','Enchantment','Compulsion','Mind-Affecting','Clr 2, Good 2, Luck 2','V, S, DF'," +
                "'1 standard action','Living creature touched','Touch',NULL,'1 min./level','None'," +
                "'Yes (harmless)','Aid grants the target a +1 morale bonus on attack rolls and saves against fear effects, plus temporary hit points equal to 1d8 + caster level (to a maximum of 1d8+10 temporary hit points at caster level 10th). ',NULL,NULL,NULL" +
                ");";
                db.execSQL(AidQueryString);

String AirWalkQueryString = "insert into " +
                SpellBookDatabaseManager.SPELL_TABLE_NAME + 
                "(" + 
                SpellBookDatabaseManager.SPELL_TABLE_ROW_NAME + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_SCHOOL + ", " + 
                SpellBookDatabaseManager.SPELL_TABLE_ROW_SUBSCHOOL + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_DESCRIPTOR + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_LEVEL + ", " +
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
                "'Air Walk','Transmutation','Air',NULL,'Air 4, Clr 4, Drd 4','V, S, DF'," +
                "'1 standard action','Creature (Gargantuan or smaller) touched','Touch',NULL,'10 min./level','None'," +
                "'Yes (harmless)','The subject can tread on air as if walking on solid ground. Moving upward is similar to walking up a hill. The maximum upward or downward angle possible is 45 degrees, at a rate equal to one-half the air walker’s normal speed. A strong wind (21+ mph) can push the subject along or hold it back. At the end of its turn each round, the wind blows the air walker 5 feet for each 5 miles per hour of wind speed. The creature may be subject to additional penalties in exceptionally strong or turbulent winds, such as loss of control over movement or physical damage from being buffeted about. Should the spell duration expire while the subject is still aloft, the magic fails slowly. The subject floats downward 60 feet per round for 1d6 rounds. If it reaches the ground in that amount of time, it lands safely. If not, it falls the rest of the distance, taking 1d6 points of damage per 10 feet of fall. Since dispelling a spell effectively ends it, the subject also descends in this way if the air walk spell is dispelled, but not if it is negated by an antimagic field. You can cast air walk on a specially trained mount so it can be ridden through the air. You can train a mount to move with the aid of air walk (counts as a trick; see Handle Animal skill) with one week of work and a DC 25 Handle Animal check. ',NULL,NULL,NULL" +
                ");";
                db.execSQL(AirWalkQueryString);

String AlarmQueryString = "insert into " +
                SpellBookDatabaseManager.SPELL_TABLE_NAME + 
                "(" + 
                SpellBookDatabaseManager.SPELL_TABLE_ROW_NAME + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_SCHOOL + ", " + 
                SpellBookDatabaseManager.SPELL_TABLE_ROW_SUBSCHOOL + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_DESCRIPTOR + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_LEVEL + ", " +
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
                "'Alarm','Abjuration',NULL,NULL,'Brd 1, Rgr 1, Sor/Wiz 1','V, S, F/DF'," +
                "'1 standard action',NULL,'Close (25 ft. + 5 ft./2 levels)',NULL,'2 hours/level (D)','None'," +
                "'No','Alarm sounds a mental or audible alarm each time a creature of Tiny or larger size enters the warded area or touches it. A creature that speaks the password (determined by you at the time of casting) does not set off the alarm. You decide at the time of casting whether the alarm will be mental or audible. A mental alarm alerts you (and only you) so long as you remain within 1 mile of the warded area. You note a single mental “ping” that awakens you from normal sleep but does not otherwise disturb concentration. A silence spell has no effect on a mental alarm. An audible alarm produces the sound of a hand bell, and anyone within 60 feet of the warded area can hear it clearly. Reduce the distance by 10 feet for each interposing closed door and by 20 feet for each substantial interposing wall. In quiet conditions, the ringing can be heard faintly as far as 180 feet away. The sound lasts for 1 round. Creatures within a silence spell cannot hear the ringing. Ethereal or astral creatures do not trigger the alarm. Alarm can be made permanent with a permanency spell. A tiny bell and a piece of very fine silver wire ',NULL,NULL,NULL" +
                ");";
                db.execSQL(AlarmQueryString);

String AlignWeaponQueryString = "insert into " +
                SpellBookDatabaseManager.SPELL_TABLE_NAME + 
                "(" + 
                SpellBookDatabaseManager.SPELL_TABLE_ROW_NAME + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_SCHOOL + ", " + 
                SpellBookDatabaseManager.SPELL_TABLE_ROW_SUBSCHOOL + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_DESCRIPTOR + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_LEVEL + ", " +
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
                "'Align Weapon','Transmutation','see text',NULL,'Clr 2','V, S, DF'," +
                "'1 standard action','Weapon touched or fifty projectiles (all of which must be in contact with each other at the time of casting)','Touch',NULL,'1 min./level','Will negates (harmless, object)'," +
                "'Yes (harmless, object)','Align weapon makes a weapon good, evil, lawful, or chaotic, as you choose. A weapon that is aligned can bypass the damage reduction of certain creatures. This spell has no effect on a weapon that already has an alignment. You can’t cast this spell on a natural weapon, such as an unarmed strike. When you make a weapon good, evil, lawful, or chaotic, align weapon is a good, evil, lawful, or chaotic spell, respectively. ',NULL,NULL,NULL" +
                ");";
                db.execSQL(AlignWeaponQueryString);

String AlterSelfQueryString = "insert into " +
                SpellBookDatabaseManager.SPELL_TABLE_NAME + 
                "(" + 
                SpellBookDatabaseManager.SPELL_TABLE_ROW_NAME + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_SCHOOL + ", " + 
                SpellBookDatabaseManager.SPELL_TABLE_ROW_SUBSCHOOL + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_DESCRIPTOR + ", " +
                SpellBookDatabaseManager.SPELL_TABLE_ROW_LEVEL + ", " +
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
                "'Alter Self','Transmutation',NULL,NULL,'Brd 2, Sor/Wiz 2','V, S'," +
                "'1 standard action','You','Personal',NULL,'10 min./level (D)',NULL," +
                "NULL,'You assume the form of a creature of the same type as your normal form. The new form must be within one size category of your normal size. The maximum HD of an assumed form is equal to your caster level, to a maximum of 5 HD at 5th level. You can change into a member of your own kind or even into yourself. You retain your own ability scores. Your class and level, hit points, alignment, base attack bonus, and base save bonuses all remain the same. You retain all supernatural and spell-like special attacks and qualities of your normal form, except for those requiring a body part that the new form does not have (such as a mouth for a breath weapon or eyes for a gaze attack). You keep all extraordinary special attacks and qualities derived from class levels, but you lose any from your normal form that are not derived from class levels. If the new form is capable of speech, you can communicate normally. You retain any spellcasting ability you had in your original form, but the new form must be able to speak intelligibly (that is, speak a language) to use verbal components and must have limbs capable of fine manipulation to use somatic or material components. You acquire the physical qualities of the new form while retaining your own mind. Physical qualities include natural size, mundane movement capabilities (such as burrowing, climbing, walking, swimming, and flight with wings, to a maximum speed of 120 feet for flying or 60 feet for nonflying movement), natural armor bonus, natural weapons (such as claws, bite, and so on), racial skill bonuses, racial bonus feats, and any gross physical qualities (presence or absence of wings, number of extremities, and so forth). A body with extra limbs does not allow you to make more attacks (or more advantageous two-weapon attacks) than normal. You do not gain any extraordinary special attacks or special qualities not noted above under physical qualities, such as darkvision, low-light vision, blindsense, blindsight, fast healing, regeneration, scent, and so forth. You do not gain any supernatural special attacks, special qualities, or spell-like abilities of the new form. Your creature type and subtype (if any) remain the same regardless of your new form. You cannot take the form of any creature with a template, even if that template doesn’t change the creature type or subtype. You can freely designate the new form’s minor physical qualities (such as hair color, hair texture, and skin color) within the normal ranges for a creature of that kind. The new form’s significant physical qualities (such as height, weight, and gender) are also under your control, but they must fall within the norms for the new form’s kind. You are effectively disguised as an average member of the new form’s race. If you use this spell to create a disguise, you get a +10 bonus on your Disguise check. When the change occurs, your equipment, if any, either remains worn or held by the new form (if it is capable of wearing or holding the item), or melds into the new form and becomes nonfunctional. When you revert to your true form, any objects previously melded into the new form reappear in the same location on your body they previously occupied and are once again functional. Any new items you wore in the assumed form and can’t wear in your normal form fall off and land at your feet; any that you could wear in either form or carry in a body part common to both forms at the time of reversion are still held in the same way. Any part of the body or piece of equipment that is separated from the whole reverts to its true form. ',NULL,NULL,NULL" +
                ");";
                db.execSQL(AlterSelfQueryString);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
