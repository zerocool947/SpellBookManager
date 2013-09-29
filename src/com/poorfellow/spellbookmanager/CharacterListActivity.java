package com.poorfellow.spellbookmanager;

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

import com.poorfellow.spellbookmanager.dummy.DummyContent;
import com.poorfellow.spellbookmanager.character.CharacterDAO;


public class CharacterListActivity extends Activity {

	private HorizontalScrollView mHorizontalCharacterContainer;
	private RelativeLayout mParentLayout;
	private LinearLayout mCharacterButtonContainer;
	
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
		
        Button addCharButton = new Button(this);
        addCharButton.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		Intent i = new Intent(CharacterListActivity.this, AddCharacterActivity.class);
        		startActivity(i);
        	}
        });
        mCharacterButtonContainer.addView(addCharButton);
		
		//Hook up database, get character list, for now lets just create dummy buttons
		/*Button char1 = new Button(this);
		Button char2 = new Button(this);
		Button char3 = new Button(this);
		
		
	
		char1.setText("Yousseff");
		char2.setText("Alton");
		char3.setText("Beznik");
		addChar.setText("Add New Character");
		
		mCharacterButtonContainer.addView(char1);
		mCharacterButtonContainer.addView(char2);
		mCharacterButtonContainer.addView(char3);
		*/

		
		

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
