package com.poorfellow.spellbookmanager.ui.activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.poorfellow.spellbookmanager.R;
import com.poorfellow.spellbookmanager.R.id;
import com.poorfellow.spellbookmanager.R.layout;
import com.poorfellow.spellbookmanager.R.menu;
import com.poorfellow.spellbookmanager.spell.SpellDAO;
import com.poorfellow.spellbookmanager.spell.SpellFilter;
import com.poorfellow.spellbookmanager.spell.SpellListAdapter;
import com.poorfellow.spellbookmanager.ui.fragment.SpellFilterFragment;
import com.poorfellow.spellbookmanager.ui.fragment.SpellFilterFragment.SpellFilterTunnel;

import android.os.Bundle;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.support.v4.app.NavUtils;

public class CreateSpellBlockActivity extends Activity
	implements SpellFilterTunnel{
	
	private SpellListAdapter mSpellListAdapter;
	private List<String> mSpellNamesList;
	private Map<String, Integer> mSpellsMap;
	private SpellFilter mSpellFilter;
	private Button mFilterButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_spell_block);
		// Show the Up button in the action bar.
		setupActionBar();
		
		SpellDAO spellDAO = new SpellDAO(this);
		mSpellsMap = spellDAO.getAllRowsAsMap();
		mSpellNamesList = (List<String>) (List<?>) Arrays.asList(mSpellsMap.keySet().toArray());

		Collections.sort(mSpellNamesList);		
		mSpellListAdapter = new SpellListAdapter(this, R.layout.list_adapter_spell, mSpellNamesList);
		
		ListView spellsList = (ListView) this.findViewById(R.id.selectSpellsList);
		spellsList.setAdapter(mSpellListAdapter);
		
		mFilterButton = (Button) this.findViewById(R.id.filterSpellsButton);
		mFilterButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FragmentTransaction ft = getFragmentManager().beginTransaction();
			    Fragment prev = getFragmentManager().findFragmentByTag("dialog");
			    if (prev != null) {
			        ft.remove(prev);
			    }
			    ft.addToBackStack(null);

			    // Create and show the dialog.
			    DialogFragment newFragment = SpellFilterFragment.newInstance(mSpellFilter);
			    newFragment.show(ft, "dialog");
			}
		});
		
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
		getMenuInflater().inflate(R.menu.create_spell_block, menu);
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

	@Override
	public void deliverSpellfilter(SpellFilter spellFilter) {
		this.mSpellFilter = spellFilter;
		System.out.println("I got a spell filter!");
	}

}
