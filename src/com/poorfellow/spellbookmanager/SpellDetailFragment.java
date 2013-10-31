package com.poorfellow.spellbookmanager;

import java.util.Map;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.poorfellow.spellbookmanager.spell.Spell;
import com.poorfellow.spellbookmanager.spell.SpellDAO;

/**
 * A fragment representing a single Spell detail screen. This fragment is either
 * contained in a {@link SpellListActivity} in two-pane mode (on tablets) or a
 * {@link SpellDetailActivity} on handsets.
 */
public class SpellDetailFragment extends Fragment {
	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";

	/**
	 * The dummy content this fragment is presenting.
	 */
	private Spell mSpell;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public SpellDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_ITEM_ID)) {
			// Load the dummy content specified by the fragment
			// arguments. In a real-world scenario, use a Loader
			// to load content from a content provider.

			SpellDAO spellDAO = new SpellDAO(this.getActivity());
			mSpell = spellDAO.getSpellById(getArguments().getString(ARG_ITEM_ID));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_spell_detail,
				container, false);

		// Show the dummy content as text in a TextView.
		/*if (mItem != null) {
			((TextView) rootView.findViewById(R.id.spell_detail))
					.setText(mItem.content);
		}*/
		if (mSpell != null) {
			TextView spellDetail = ((TextView) rootView.findViewById(R.id.spell_detail));
			spellDetail.setText(mSpell.getName() + "\n");
			spellDetail.append(Html.fromHtml("<i>" + mSpell.getSchool() + " </i>"));
			
			if (mSpell.getSubschool() != null){
				spellDetail.append(Html.fromHtml("<i>" + mSpell.getSubschool() + " </i>"));
			}
			if (mSpell.getDescriptor() != null) {
				spellDetail.append(Html.fromHtml("<i>" + mSpell.getDescriptor() + " </i>"));
			}
			spellDetail.append("\n");
			
			spellDetail.append(Html.fromHtml("<br /><b>Level: </b>"));
			Map<String, Integer> levelMap = mSpell.getLevel();
			String[] levelMapKeyStrings = (String[]) levelMap.keySet().toArray(new String[0]);
			for (int i = 0; i < levelMapKeyStrings.length; i++) {
				spellDetail.append(levelMapKeyStrings[i] + " " + levelMap.get(levelMapKeyStrings[i]));
				if (i < (levelMapKeyStrings.length - 1)) {
					spellDetail.append(", ");
				}
			}
			
			if (mSpell.getComponents() != null) {
				spellDetail.append(Html.fromHtml("<br /><b>Components: </b>" + mSpell.getComponents()));
			}
			if (mSpell.getCastingTime() != null) {
				spellDetail.append(Html.fromHtml("<br /><b>Casting Time: </b>" + mSpell.getCastingTime()));
			}
			if (mSpell.getTarget() != null) {
				spellDetail.append(Html.fromHtml("<br /><b>Target: </b>" + mSpell.getTarget()));
			}
			if (mSpell.getRange() != null) {
				spellDetail.append(Html.fromHtml("<br /><b>Range: </b>" + mSpell.getRange()));
			}
			if (mSpell.getEffect() != null) {
				spellDetail.append(Html.fromHtml("<br /><b>Effect: </b>" + mSpell.getEffect()));
			}
			if (mSpell.getDuration() != null) {
				spellDetail.append(Html.fromHtml("<br /><b>Duration: </b>" + mSpell.getDuration()));
			}
			if (mSpell.getSavingThrow() != null) {
				spellDetail.append(Html.fromHtml("<br /><b>Saving Throw: </b>" + mSpell.getSavingThrow()));
			}
			if (mSpell.getSpellResistance() != null) {
				spellDetail.append(Html.fromHtml("<br /><b>Spell Resistance: </b>" + mSpell.getSpellResistance()));
			}
			
			spellDetail.append("\n");
			
			if (mSpell.getDescription() != null) {
				spellDetail.append(Html.fromHtml("<br /><b>Description: </b>" + mSpell.getDescription()));
			}
			if (mSpell.getMaterialComponent() != null) {
				spellDetail.append(Html.fromHtml("<br /><b>Material Component: </b>" + mSpell.getMaterialComponent()));
			}
			if (mSpell.getArcMaterialComponent() != null) {
				spellDetail.append(Html.fromHtml("<br /><b>Arcane Material Component: </b>" + mSpell.getArcMaterialComponent()));
			}
			if (mSpell.getFocus() != null) {
				spellDetail.append(Html.fromHtml("<br /><b>Focus: </b>" + mSpell.getFocus()));
			}
			if (mSpell.getArcFocus() != null) {
				spellDetail.append(Html.fromHtml("<br /><b>Arcane Focus: </b>" + mSpell.getArcFocus()));
			}
			if (mSpell.getXpCost() != null) {
				spellDetail.append(Html.fromHtml("<br /><b>XP Cost</b>" + mSpell.getXpCost()));
			}
		}

		return rootView;
	}
}
