package com.poorfellow.spellbookmanager;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.support.v4.app.NavUtils;

import com.poorfellow.spellbookmanager.database.DatabaseObject;
import com.poorfellow.spellbookmanager.dummy.DummyContent;
import com.poorfellow.spellbookmanager.character.CharacterDAO;
import com.poorfellow.spellbookmanager.character.Character;


public class CharacterListActivity extends Activity {

	private HorizontalScrollView mHorizontalCharacterContainer;
	private RelativeLayout mParentLayout;
	private LinearLayout mCharacterButtonContainer;
	
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_character_list);
		// Show the Up button in the action bar.
		setupActionBar();
		
		//hook up handle to UI framework
		mHorizontalCharacterContainer = (HorizontalScrollView) findViewById(R.id.horizontalCharacterContainer);
		mCharacterButtonContainer = (LinearLayout) findViewById(R.id.characterButtonContainer);
		
        Log.d("CharacterListActivity", "My character button container is " + mCharacterButtonContainer);
        
        CharacterDAO charDAO = new CharacterDAO(this);         
        List<? extends DatabaseObject> characterObjects = charDAO.getAllRows();
        List<Character> characters = (List<Character>) (List<?>)characterObjects;
        
        for (final Character character : characters) {
        	Button characterButton = new Button(this);
        	characterButton.setText(character.getName());
        	characterButton.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent i = new Intent(CharacterListActivity.this, ViewCharacterActivity.class);
					i.putExtra("character", character);
					startActivity(i);
				}
			});
        	mCharacterButtonContainer.addView(characterButton);
        }
        
        Button addCharButton = new Button(this);
        addCharButton.setText("Create New Character");
        addCharButton.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		Intent i = new Intent(CharacterListActivity.this, AddCharacterActivity.class);
        		startActivity(i);
        	}
        });
        mCharacterButtonContainer.addView(addCharButton);
		
		
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.character_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
