package com.shahali.themovieapp;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    private int numOfTab;
    public PagerAdapter (FragmentManager fm, int numOfTab){
        super(fm);
        this.numOfTab=numOfTab;
    }
    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return new PupularFragment();
            case 1:
                return new TopratedFragment();
            default:
                return new PupularFragment();
        }

    }

    @Override
    public int getCount() {
        return numOfTab;
    }
}


