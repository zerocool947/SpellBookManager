package com.poorfellow.spellbookmanager.spell;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.poorfellow.spellbookmanager.R;

public class SpellListAdapter extends BaseExpandableListAdapter {
	
	private List<String> mSpellNames;
	private Context mContext;
	private Map<Integer, List<Integer>> mSpellLevelMap;
	private List<Integer> mLevelGroupList;
	private SpellDAO mSpellDAO;

	public SpellListAdapter(Context context, Map<Integer, List<Integer>> spellLevelMap, List<Integer> levelGroupList) {
		this.mContext = context;
		this.mSpellLevelMap = spellLevelMap;
		this.mLevelGroupList = levelGroupList;
		this.mSpellDAO = new SpellDAO(context);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		int level = mLevelGroupList.get(groupPosition);
		List<Integer> spellList = mSpellLevelMap.get(level);
		int spellId = spellList.get(childPosition);
		Spell spell =  mSpellDAO.getSpellById(spellId);
		return spell.getName();
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		//On suggestion, may revise in the future if I find a better explanation
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
			ViewGroup parent) {
		View v = convertView;
		
		if (v == null) {
			LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = inflater.inflate(R.layout.list_adapter_spell, null);
		}
		
		final String childText = (String) getChild(groupPosition, childPosition);
		TextView spellNameView = (TextView) v.findViewById(R.id.spellName);
		spellNameView.setText(childText);
		
		return v;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		int level = mLevelGroupList.get(groupPosition);
		List<Integer> spellList = mSpellLevelMap.get(level);
		Log.d("STATUS", "I'm trying to get something for level " + level);

		
		return spellList.size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return mLevelGroupList.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		return mLevelGroupList.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		//On suggestion, may revise in the future if I find a better explanation
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		Log.d("STATUS", "My Group Position is " + getGroupCount());
		Log.d("STATUS", "My Group Position is " + groupPosition);
		View v = convertView;
		
		if (v == null) {
			LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = inflater.inflate(R.layout.list_adapter_group, null);
		}
		
		TextView groupNameView = (TextView) v.findViewById(R.id.groupLevelName);
		Integer groupName = (Integer) getGroup(groupPosition);
		groupNameView.setTypeface(null, Typeface.BOLD);
		groupNameView.setText(groupName + "-Level Spells");
		
		return v;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		// when you do implement it, set it to check the box
		return false;
	}

}
