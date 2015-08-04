package com.demo.myapplication;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MaterialButtonFragment extends Fragment {

	public static final String MB_FRAGMENT_COLOR = "mb_fragment_color";
	private ImageView mImageView;

	public static MaterialButtonFragment newInstance(int color) {
		MaterialButtonFragment fragment = new MaterialButtonFragment();
		Bundle bundle = new Bundle();
		bundle.putInt(MB_FRAGMENT_COLOR, color);
		fragment.setArguments(bundle);
		return fragment;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_material_button, null);
		mImageView = (ImageView) rootView.findViewById(R.id.image_fragment);
		Bundle bundle = getArguments();
		int color = bundle.getInt(MB_FRAGMENT_COLOR);
		mImageView.setImageResource(color);
		return rootView;
	}

	public Bitmap getFragmentBitmap() {
		return ((BitmapDrawable) mImageView.getDrawable()).getBitmap();
	}
}
