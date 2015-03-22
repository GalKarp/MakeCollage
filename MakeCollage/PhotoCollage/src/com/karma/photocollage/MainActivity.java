package com.karma.photocollage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MainActivity extends Activity {

	GridView grid;
	Integer[] Frame_id,Frame_id1;
	Adapter_grid adapter;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
        // frames on the selection screen
		Frame_id = new Integer[] {
                R.drawable.t1_01, R.drawable.t1_02, R.drawable.t1_08,
				R.drawable.t1_22, R.drawable.t1_31, R.drawable.t1_32,
				R.drawable.t1_36, R.drawable.t1_37, R.drawable.t1_44,
				R.drawable.t1_53 };

		// actual picture frames
		Frame_id1 = new Integer[] {
                R.drawable.f1_01, R.drawable.f1_02, R.drawable.f1_08,
                R.drawable.f1_22, R.drawable.f1_31, R.drawable.f1_32,
                R.drawable.f1_36, R.drawable.f1_37, R.drawable.f1_44,
                R.drawable.f1_53 };

		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		getActionBar().hide();
		setContentView(R.layout.activity_main);

		// Gal check if this works properly i had problems with it
		grid = (GridView) findViewById(R.id.gridView1);
		adapter = new Adapter_grid(getApplicationContext(), Frame_id);
		grid.setAdapter(adapter);

		grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent i  = new Intent(MainActivity.this, SelectedImageActivity.class);
				i.putExtra("img_id", Frame_id1[arg2]);
				startActivity(i);

			}
		});
	}


}
