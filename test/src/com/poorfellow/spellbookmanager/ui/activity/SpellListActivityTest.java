package com.poorfellow.spellbookmanager.ui.activity;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.poorfellow.spellbookmanager.database.DatabaseObject;
import com.poorfellow.spellbookmanager.spell.Spell;
import com.poorfellow.spellbookmanager.spell.SpellDAO;
import com.poorfellow.spellbookmanager.ui.activity.SpellListActivity;
import com.poorfellow.spellbookmanager.ui.fragment.SpellListFragment;

import java.util.List;

/**
 * Created by David on 10/25/2014.
 */
public class SpellListActivityTest extends ActivityInstrumentationTestCase2<SpellListActivity> {

    SpellListActivity mActivity;
    ListView mListView;
    SpellDAO mSpellDAO;
    SpellListFragment mListFragment;

    public SpellListActivityTest() {
        super(SpellListActivity.class);
    }

    public SpellListActivityTest(Class<SpellListActivity> activityClass) {
        super(activityClass);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mActivity = getActivity();
        mListFragment = (SpellListFragment) mActivity.getSupportFragmentManager().findFragmentById(com.poorfellow.spellbookmanager.R.id.master_spell_list);
        mListView = (ListView) mListFragment.getListView();
        mSpellDAO = new SpellDAO(mActivity);

    }

    public void testListOrder() throws Exception {

        for (DatabaseObject spell : mSpellDAO.getAllRows()) {
            assertEquals(mListView.getItemAtPosition(((int) spell.getId())), spell.getName());
        }

        assertEquals(mSpellDAO.getAllRows().size(), mListView.getCount());


    }
}
