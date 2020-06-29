package com.shahali.mimovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem popular;
    TabItem nowPlaying;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout=findViewById(R.id.Tablayout);
        popular=findViewById(R.id.PopularTab);
        nowPlaying=findViewById(R.id.NowPlayingTab);
        viewPager=findViewById(R.id.viewPager);
        PagerAdapter pagerAdapter=new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
