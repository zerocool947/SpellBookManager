package com.poorfellow.spellbookmanager;

import java.util.Vector;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class CharacterViewListPagerAdapter extends PagerAdapter {
	
	private Context mContext;
	private Vector<View> pages;
	private Vector<View> buttons;
	
	public CharacterViewListPagerAdapter(Context context, Vector<View> pages, Vector<View> buttons) {
		this.mContext = context;
		this.pages = pages;
		this.buttons = buttons;
	}
	
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View button = buttons.get(position);
		View page = pages.get(position);
		container.addView(button);
		container.addView(page);
		
		return container;
	}
	
	@Override
	public void destroyItem (ViewGroup container, int position, Object object) {
		container.removeView(buttons.get(position));
		container.removeView(pages.get(position));
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return pages.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return false;
	}

}
