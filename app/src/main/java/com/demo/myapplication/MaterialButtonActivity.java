package com.demo.myapplication;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;

import com.demo.myapplication.widget.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class MaterialButtonActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_material_button);
		final MaterialButton button = (MaterialButton) findViewById(R.id.material_button);
		ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
		List<Integer> list = new ArrayList<>();
		list.add(R.drawable.image_1);
		list.add(R.drawable.image_2);
		list.add(R.drawable.image_3);
		list.add(R.drawable.image_4);
		list.add(R.drawable.image_5);
		final FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), list);
		viewPager.setAdapter(fragmentAdapter);
		viewPager.setCurrentItem(0);
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageSelected(int position) {
				MaterialButtonFragment fragment = fragmentAdapter.getFragment(position);
				if (fragment != null) {
					Bitmap bitmap = fragment.getFragmentBitmap();
					Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {
						@Override
						public void onGenerated(Palette palette) {
							button.changeColor(palette.getVibrantColor().getRgb());
						}
					});
				}
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});
	}

}
