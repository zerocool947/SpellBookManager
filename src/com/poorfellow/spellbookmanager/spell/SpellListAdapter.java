package com.poorfellow.spellbookmanager.spell;

import java.util.ArrayList;
import java.util.List;

import com.poorfellow.spellbookmanager.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SpellListAdapter extends ArrayAdapter<String> {
	
	private List<String> spellNames;

	public SpellListAdapter(Context context, int textViewResourceId,
			List<String> spells) {
		super(context, textViewResourceId, spells);
		this.spellNames = spells;
		// TODO Auto-generated constructor stub
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		
		if (v == null) {
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = inflater.inflate(R.layout.list_adapter_spell, null);
		}
		
		String spellName = spellNames.get(position);
		
		TextView nameView = (TextView) v.findViewById(R.id.spellName);
		nameView.setText(spellName);
		
		return v;
		
	}
}
