package com.poorfellow.spellbookmanager;

import com.poorfellow.spellbookmanager.character.CharacterDAO;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddCharacterActivity extends Activity {
	
	private Button mCreateCharacterButton;
	private EditText mCharacterNameEdit;
	private EditText mCharacterLevelEdit;
	private EditText mCasterLevelEdit;
	private EditText mCharacterClassEdit;
	private EditText mTurnAttemptsEdit;
	private EditText mRaceEdit;
	private EditText mIntelligenceEdit;
	private EditText mStrengthEdit;
	private EditText mDexterityEdit;
	private EditText mConstitutionEdit;
	private EditText mWisdomEdit;
	private EditText mCharismaEdit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_character);
		
		mCreateCharacterButton = (Button) findViewById(R.id.createCharacter);
		mCharacterNameEdit = (EditText) findViewById(R.id.characterName);
		mCharacterLevelEdit = (EditText) findViewById(R.id.characterLevel);
		mCasterLevelEdit = (EditText) findViewById(R.id.casterLevel);
		mCharacterClassEdit = (EditText) findViewById(R.id.characterClass);
		mTurnAttemptsEdit = (EditText) findViewById(R.id.turnAttempts);
		mRaceEdit = (EditText) findViewById(R.id.race);
		mIntelligenceEdit = (EditText) findViewById(R.id.intelligence);
		mStrengthEdit = (EditText) findViewById(R.id.strength);
		mDexterityEdit = (EditText) findViewById(R.id.dexterity);
		mConstitutionEdit = (EditText) findViewById(R.id.constitution);
		mWisdomEdit = (EditText) findViewById(R.id.wisdom);
		mCharismaEdit = (EditText) findViewById(R.id.charisma);
		
		mCreateCharacterButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onCreateCharacterClicked();
				finish();
			}

		});
	}
	
	private void onCreateCharacterClicked() {
		String name = mCharacterNameEdit.getText().toString();
		int level = Integer.parseInt(mCharacterLevelEdit.getText().toString());
		String characterClass = mCharacterClassEdit.getText().toString();
		String race = mRaceEdit.getText().toString();
		int casterLevel = Integer.parseInt(mCasterLevelEdit.getText().toString());
		int dexterity = Integer.parseInt(mDexterityEdit.getText().toString());
		int intelligence = Integer.parseInt(mIntelligenceEdit.getText().toString());
		int strength = Integer.parseInt(mStrengthEdit.getText().toString());
		int charisma = Integer.parseInt(mCharismaEdit.getText().toString());
		int wisdom = Integer.parseInt(mWisdomEdit.getText().toString());
		int constitution = Integer.parseInt(mConstitutionEdit.getText().toString());
		int turnAttempts = Integer.parseInt(mTurnAttemptsEdit.getText().toString());
		
		
		CharacterDAO charDAO = new CharacterDAO(getBaseContext());
		charDAO.CreateCharacter(name, level, characterClass, race, casterLevel, dexterity, intelligence, strength, 
				charisma, wisdom, constitution, turnAttempts);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_character, menu);
		return true;
	}

}
