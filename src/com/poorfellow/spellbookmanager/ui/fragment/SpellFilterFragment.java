package com.poorfellow.spellbookmanager.ui.fragment;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.poorfellow.spellbookmanager.R;
import com.poorfellow.spellbookmanager.spell.SpellFilter;

public class SpellFilterFragment extends DialogFragment {

	SpellFilterTunnel mCallback;
	SpellFilter mSpellFilter;
	Spinner mClassSpinner;
	Spinner mLevelSpinner;
	TextView mLevelTextView;
	Button mConfirmFilterButton;
	
    public interface SpellFilterTunnel {
        public void deliverSpellFilter(SpellFilter spellFilter);
        public void updateSpellListView();
    }
	
	public static SpellFilterFragment newInstance(SpellFilter spellFilter) {
		SpellFilterFragment f = new SpellFilterFragment();
		f.setSpellFilter(spellFilter);
		return f;
	}

	private void setSpellFilter(SpellFilter spellFilter) {
		this.mSpellFilter = spellFilter;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mCallback = (SpellFilterTunnel) activity;
	}
	
	 @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_spell_filter, container, false);
        getDialog().setTitle("Spell Filter Options");
        getDialog().setCanceledOnTouchOutside(false);
        
        
        mClassSpinner = (Spinner) v.findViewById(R.id.classDropDown);
        mLevelSpinner = (Spinner) v.findViewById(R.id.levelDropDown);
        mLevelTextView = (TextView) v.findViewById(R.id.levelText);
        mConfirmFilterButton = (Button) v.findViewById(R.id.confirmFilterButton);
        
        //move these to the spell filter itself mapbe?
        final String[] classNames = {"Choose Class", "Cleric", "Paladin", "Wizard"};
        final String[] levels = {"All", "0", "1", "2", "3"};
        
        ArrayAdapter<String> classSpinnerAdapter = new ArrayAdapter<String>(this.getActivity(),
        		android.R.layout.simple_spinner_item, android.R.id.text1, classNames);
        mClassSpinner.setAdapter(classSpinnerAdapter);
        mClassSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				if (classNames[(int) id] == "Choose Class") {
					mLevelTextView.setVisibility(View.GONE);
					mLevelSpinner.setVisibility(View.GONE);
					mLevelSpinner.setSelection(0);
				}
				else {
					mLevelTextView.setVisibility(View.VISIBLE);
					mLevelSpinner.setVisibility(View.VISIBLE);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        
        ArrayAdapter<String> levelAdapter = new ArrayAdapter<String>(this.getActivity(),
        		android.R.layout.simple_spinner_item, android.R.id.text1, levels);
        mLevelSpinner.setAdapter(levelAdapter);
        
        mConfirmFilterButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				if (mSpellFilter == null) {
					mSpellFilter = new SpellFilter();
				}
				//these calls need to stay here. consider the back button
				populateFilter();
				mCallback.deliverSpellFilter(mSpellFilter);
				dismiss();
			}
        });
	        
        return v;
	 }
	 
	 @Override
	 public void onDismiss(DialogInterface dialog) {
	 	super.onDismiss(dialog);

		mCallback.updateSpellListView();
		 
		
	 }
	 
	 public void populateFilter() {
		 String selectedClass = (String) mClassSpinner.getSelectedItem();
		 String selectedLevel = (String) mLevelSpinner.getSelectedItem();
		 String dbClass = "";
		 
		 if (selectedClass == "Cleric") {
			 dbClass = "clr";
		 }
		 if (selectedLevel == "All") {
			 selectedLevel = "0,1,7,3,4";
		 }
		 
		 mSpellFilter.addPreFilterClassLevel(selectedClass, selectedLevel);
		 
		 Log.d("STATUS", "The Selected class was " + selectedClass);
	 }

}
