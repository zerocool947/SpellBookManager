package com.poorfellow.spellbookmanager.spell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.CompoundButton;

import com.poorfellow.spellbookmanager.R;

public class SpellListAdapter extends BaseExpandableListAdapter {
	
	private List<String> mSpellNames;
	private Context mContext;
	private Map<Integer, List<Integer>> mSpellLevelMap;
	private List<Integer> mLevelGroupList;
	private SpellDAO mSpellDAO;
	private Map<Integer, List<Integer>> mCheckedStates;

	public SpellListAdapter(Context context, Map<Integer, List<Integer>> spellLevelMap, List<Integer> levelGroupList) {
		this.mContext = context;
		this.mSpellLevelMap = spellLevelMap;
		this.mLevelGroupList = levelGroupList;
		this.mSpellDAO = new SpellDAO(context);
		this.mCheckedStates = new HashMap<Integer, List<Integer>>();
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
	public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView,
			ViewGroup parent) {
		final int mGroupPosition = groupPosition;
		final int mChildPosition = childPosition;
		View v = convertView;
		
		if (v == null) {
			LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = inflater.inflate(R.layout.list_adapter_spell, null);
		}
		
		final String childText = (String) getChild(groupPosition, childPosition);
		TextView spellNameView = (TextView) v.findViewById(R.id.spellName);
		spellNameView.setText(childText);

		CheckBox childCheck = (CheckBox)v.findViewById(R.id.addSpellCheckbox);
		childCheck.setOnCheckedChangeListener(null);
		if (mCheckedStates.containsKey(groupPosition)) {
			List<Integer> checkedChildrenPositions = mCheckedStates.get(groupPosition);
			if (checkedChildrenPositions.contains(childPosition)) {
				Log.d("CHECK", "I am checked " + childText);
				childCheck.setChecked(true);
			}
			else {
				Log.d("CHECK", "I am not checked " + childText);
				childCheck.setChecked(false);
			}
		}
		else {
			mCheckedStates.put(groupPosition, new ArrayList<Integer>());
		}

		childCheck.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
			   @Override
			   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				   if (isChecked) {
						if (mCheckedStates.containsKey(mGroupPosition)) {
							mCheckedStates.get(mGroupPosition).add(Integer.valueOf(mChildPosition));
						}
					   else {
							List<Integer> childList = new ArrayList<Integer>();
							childList.add(mChildPosition);
							mCheckedStates.put(mGroupPosition, childList);
						}
				   }
				   else {
					   if (mCheckedStates.containsKey(mGroupPosition)) {
						   mCheckedStates.get(mGroupPosition).remove(Integer.valueOf(mChildPosition));
					   }
					   else {
						   mCheckedStates.put(mGroupPosition, new ArrayList<Integer>());
					   }

				   }
			   }
		   }
		);
		
		return v;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		int level = mLevelGroupList.get(groupPosition);
		List<Integer> spellList = mSpellLevelMap.get(level);

		
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
