package com.poorfellow.spellbookmanager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class ManagerHome extends Activity {
	
	private Button mCharactersButton;
	private Button mMasterSpellButton;
	private Button mSettingsButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manager_home);
		
		//hook up handles to buttons
		mCharactersButton = (Button) findViewById(R.id.charactersButton);
		mMasterSpellButton = (Button) findViewById(R.id.masterListButton);
		mSettingsButton = (Button) findViewById(R.id.settingButton);
		
		//register handles to buttons
		mCharactersButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(ManagerHome.this, CharacterListActivity.class);
				startActivity(i);
			}
		});
		
		mMasterSpellButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(ManagerHome.this, SpellListActivity.class);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_page, menu);
		return true;
	}

}
