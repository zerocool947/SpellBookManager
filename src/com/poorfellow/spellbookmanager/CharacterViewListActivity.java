package com.poorfellow.spellbookmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.poorfellow.spellbookmanager.spell.SpellBlockDAO;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CharacterViewListActivity extends FragmentActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_character_view_list);

		Intent intent = getIntent();
		String characterData = intent.getStringExtra("characterData");
		//Log.d("CHARACTER_DATA", characterData);
		
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.character_view_list, menu);
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

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			/*Fragment fragment = new DummySectionFragment();
			Bundle args = new Bundle();
			args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
			fragment.setArguments(args);
			return fragment;*/
			Fragment returnFragment = null;
			
			switch (position) {
			case 0:
				//return spell block fragment
				Fragment spellBlockFragment = new SpellBlockListFragment();
				Bundle spellBlockArgs = new Bundle();
				spellBlockArgs.putInt(SpellBlockListFragment.ARG_SECTION_NUMBER, position + 1);
				spellBlockFragment.setArguments(spellBlockArgs);
				returnFragment = spellBlockFragment;
			case 1:
				Fragment fragment = new SpellBlockListFragment();
				Bundle args = new Bundle();
				args.putInt(SpellBlockListFragment.ARG_SECTION_NUMBER, position + 1);
				fragment.setArguments(args);
				returnFragment = fragment;			
			}
			
			return returnFragment;
			
		}

		@Override
		public int getCount() {
			// Show 2 total pages.
			return 2;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return "Spell Blocks";
			case 1:
				return "Spell Lists";
			}
			return null;
		}
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	//public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		/*public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.fragment_character_view_list_dummy, container,
					false);
			TextView dummyTextView = (TextView) rootView
					.findViewById(R.id.section_label);
			//dummyTextView.setText(Integer.toString(getArguments().getInt(
				//	ARG_SECTION_NUMBER)));
			dummyTextView.setText("LOLOLOLOLOLO");
			Button dummyButton = new Button(this.getActivity());
			dummyButton.setText("I'm a button!");
			((ViewGroup) rootView).addView(dummyButton);
			return rootView;
		}
	}*/
	
	public static class SpellBlockListFragment extends Fragment {
		public static  final String ARG_SECTION_NUMBER = "section_number";
		
		private List<String> arrayAdapterSpellBlocks;
		private Map<String, Integer> arrayAdapterSpellBlocksMap;
		
		public SpellBlockListFragment () {
			
		}
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, 
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_character_view_list_spell_block, container,
					false);
			Button createButton = (Button) rootView.findViewById(R.id.createSpellBlockButton);
			View divideContainer = rootView.findViewById(R.id.spellBlockDivideContainer);
			arrayAdapterSpellBlocks = new ArrayList<String>();
			arrayAdapterSpellBlocks.add("Utility Block");
			arrayAdapterSpellBlocks.add("Offensive Block");
			
			/*createButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent i = new Intent(this, SpellBlockDetailActivity.class);
					i.putExtra(SpellBlockDetailFragment.ARG_ITEM_ID, id);
					startActivity(i);
				}
			});*/
			
			//creating layout parameters
			ListView spellBlockListView = new ListView(this.getActivity());
			RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
			        RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.MATCH_PARENT);
			lp.addRule(RelativeLayout.BELOW, createButton.getId());
			
			//get all rows as map
			SpellBlockDAO spellBlockDAO = new SpellBlockDAO(this.getActivity());
			
			//create array adapter of spell block names
			final ArrayAdapter<String> spellBlocksAdapter = new ArrayAdapter<String>(getActivity(),
					android.R.layout.simple_list_item_1, android.R.id.text1, arrayAdapterSpellBlocks);
			spellBlockListView.setAdapter(spellBlocksAdapter);
			((ViewGroup) rootView).addView(spellBlockListView, lp);
			return rootView;
		}
	}
	
	public static class DailyListFragment extends Fragment {
		public static  final String ARG_SECTION_NUMBER = "section_number";
		
		private List<String> arrayAdapterDailyList;
		private Map<String, Integer> arrayAdapterDailyListMap;
		
		public DailyListFragment() {
			
		}
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, 
				Bundle savedInstanceState) {
			
			return null;
			
		}
	}

}