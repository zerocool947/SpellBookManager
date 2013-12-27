package com.poorfellow.spellbookmanager.ui.fragment;

import com.poorfellow.spellbookmanager.R;
import com.poorfellow.spellbookmanager.spell.SpellFilter;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpellFilterFragment extends DialogFragment {

	SpellFilter mSpellFilter;
	Spinner mClassSpinner;
	Spinner mLevelSpinner;
	TextView mLevelTextView;
	
    public interface spellFilterTunnel {
        public void deliverSpellfilter(SpellFilter spellFilter);
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
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	        View v = inflater.inflate(R.layout.fragment_spell_filter, container, false);
	        getDialog().setTitle("Spell Filter Options");
	        
	        mClassSpinner = (Spinner) v.findViewById(R.id.classDropDown);
	        mLevelSpinner = (Spinner) v.findViewById(R.id.levelDropDown);
	        mLevelTextView = (TextView) v.findViewById(R.id.levelText);
	        
	        final String[] classNames = {"Choose Class", "Cleric", "Paladin", "Wizard"};
	        final String[] levels = {"Choose Level", "All", "1", "2", "3"};
	        
	        ArrayAdapter<String> classSpinnerAdapter = new ArrayAdapter<String>(this.getActivity(),
	        		android.R.layout.simple_spinner_item, android.R.id.text1, classNames);
	        mClassSpinner.setAdapter(classSpinnerAdapter);
	        mClassSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> parent, View view,
						int position, long id) {
					if (classNames[(int) id] != "Choose Class") {
						mLevelTextView.setVisibility(View.VISIBLE);
						mLevelSpinner.setVisibility(View.VISIBLE);
					}
					else {
						mLevelTextView.setVisibility(View.GONE);
						mLevelSpinner.setVisibility(View.GONE);
					}
				}

				@Override
				public void onNothingSelected(AdapterView<?> parent) {
				}
	        	
	        });
	        
	        ArrayAdapter<String> levelAdapter = new ArrayAdapter<String>(this.getActivity(),
	        		android.R.layout.simple_spinner_item, android.R.id.text1, levels);
	        mLevelSpinner.setAdapter(levelAdapter);
	        
	        return v;
	        
	 }

}
