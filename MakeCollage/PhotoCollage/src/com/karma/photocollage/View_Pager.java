package com.karma.photocollage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class View_Pager extends Activity {

    ViewPager viewPager;
    MyPagerAdapter myPagerAdapter;
    Button createCollage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getActionBar().hide();
        setContentView(R.layout.view_pager);
        viewPager = (ViewPager) findViewById(R.id.myviewpager);
        myPagerAdapter = new MyPagerAdapter();
        viewPager.setAdapter(myPagerAdapter);

        createCollage = (Button) findViewById(R.id.createCollage);



        createCollage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(i);
            }
        });

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            int item_count = 0
                    ,
                    max_count = 4;

            @Override
            public void run() {
                viewPager.setCurrentItem(item_count);
                if (item_count == max_count) {
                    item_count = 0;
                } else {
                    item_count++;
                }
                handler.postDelayed(this, 6000);
            }
        }, 1000);

    }


    private class MyPagerAdapter extends PagerAdapter {

        int NumberOfPages = 4;

        int[] res = {R.drawable.main1, R.drawable.main2, R.drawable.main3,
                R.drawable.main4, R.drawable.main5};

        @Override
        public int getCount() {
            return NumberOfPages;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            ImageView imageView = new ImageView(View_Pager.this);
            imageView.setImageResource(res[position]);
            LayoutParams imageParams = new LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(imageParams);

            LinearLayout layout = new LinearLayout(View_Pager.this);
            layout.setOrientation(LinearLayout.VERTICAL);
            LayoutParams layoutParams = new LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            layout.setLayoutParams(layoutParams);
            layout.addView(imageView);
            container.addView(layout);
            return layout;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout) object);
        }

    }
}
