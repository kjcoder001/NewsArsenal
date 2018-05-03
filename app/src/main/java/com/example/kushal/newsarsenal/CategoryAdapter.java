package com.example.kushal.newsarsenal;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by kushal on 03-05-2018.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    Context context;

    public CategoryAdapter(Context context,FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {

        if(position == 0)
            return new HeadlinesFragment();
        else if(position == 1)
            return new SportsFragment();
        else if(position==2)
            return new IndiaFragment();
        else
            return new TechFragment();
    }

    @Override
    public int getCount() {
        return 4 ;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0)
            return "WORLD";
        else if(position == 1)
            return "SPORTS";
        else if (position==2)
            return "INDIA";
        else
            return "TECH";
    }
}
