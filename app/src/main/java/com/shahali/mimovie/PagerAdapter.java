package com.shahali.mimovie;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    private int numOfTab;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        numOfTab=behavior;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return new Popular();
            case 1:
                return new NowPlaying();
            default:
                return new Popular();
        }

    }

    @Override
    public int getCount() {
        return numOfTab;
    }
}


