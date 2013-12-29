package com.poorfellow.spellbookmanager.ui.activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.poorfellow.spellbookmanager.R;
import com.poorfellow.spellbookmanager.spell.SpellDAO;
import com.poorfellow.spellbookmanager.spell.SpellFilter;
import com.poorfellow.spellbookmanager.spell.SpellListAdapter;
import com.poorfellow.spellbookmanager.ui.fragment.SpellFilterFragment;
import com.poorfellow.spellbookmanager.ui.fragment.SpellFilterFragment.SpellFilterTunnel;

public class CreateSpellBlockActivity extends Activity
	implements SpellFilterTunnel{
	
	private SpellListAdapter mSpellListAdapter;
	private List<String> mSpellNamesList;
	private Map<Integer, String> mSpellsMap;
	private SpellFilter mSpellFilter;
	private Button mFilterButton;
	private Map<Integer, List<Integer>> mFilteredSpellsMap;
	private Set<Integer> mFilteredGroupsList;
	private List<Integer> mSpellsIdsList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_spell_block);
		// Show the Up button in the action bar.
		setupActionBar();
		
		if (mSpellFilter != null) {
			Log.d("STATUS", "I'm filtering spells in on create!!!!");
			mSpellFilter.filterRawSpells(this);
		}

		Log.d("STATUS", "I'm Creating the activity!!!!");

		SpellDAO spellDAO = new SpellDAO(this);
		mSpellsMap = spellDAO.getAllRowsAsMap();
		mSpellsIdsList = spellDAO.getAlllRowsIds();
		
		//get this list as just a list of Ids, add the DB method
		//List<Integer> spellsList = spellDAO.getAlllRowsIds();
		mSpellNamesList = new ArrayList<String>(mSpellsMap.values());

		Collections.sort(mSpellNamesList);		
		/*mSpellListAdapter = new SpellListAdapter(this, R.layout.list_adapter_spell, mSpellNamesList);
		
		ListView spellsList = (ListView) this.findViewById(R.id.selectSpellsList);
		spellsList.setAdapter(mSpellListAdapter);*/
		
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
	public void deliverSpellFilter(SpellFilter spellFilter) {
		this.mSpellFilter = spellFilter;
		System.out.println("I got a spell filter!");
	}

	@Override
	public void updateSpellListView() {
		// TODO Auto-generated method stub
		mFilterButton.setText("HOLY SHIT IT WORKS!");
		
		//fix once you get a real DB lookup
		mSpellFilter.setFilterSpellMap(mSpellsIdsList);
		mSpellFilter.filterRawSpells(this.getApplicationContext());
		populateSpellListView();
		
	}
	
	public void populateSpellListView() {
		mFilteredSpellsMap = mSpellFilter.getFilteredSpells();
		mFilteredGroupsList = mSpellFilter.getFilteredGroups();
		
		for(Integer level : mFilteredGroupsList) {
			Log.d("STATUS", "My filtered group Set value is " + level);
		}
		
		List<Integer> test = new ArrayList<Integer>(mFilteredGroupsList);
		Log.d("STATUS", "Atfer conversion to array");
		for(Integer level : test) {
			Log.d("STATUS", "My Filtered Group List value is " + level + " and the index is " + test.indexOf(level));

		}
	}

}
