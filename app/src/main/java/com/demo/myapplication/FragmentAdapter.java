package com.demo.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class FragmentAdapter extends FragmentStatePagerAdapter {

	private List<Integer> mImageResource;
	private Map<Integer, MaterialButtonFragment> mFragments;

	public FragmentAdapter(FragmentManager fragmentManager, List<Integer> imageResource) {
		super(fragmentManager);
		mImageResource = imageResource;
		mFragments = new HashMap<>();
	}
	@Override
	public int getCount() {
		return mImageResource.size();
	}

	@Override
	public Fragment getItem(int position) {
		MaterialButtonFragment fragment = MaterialButtonFragment.newInstance(mImageResource.get(position));
		mFragments.put(position, fragment);
		return fragment;
	}

	public MaterialButtonFragment getFragment(int position) {
		return mFragments.get(position);
	}
}
