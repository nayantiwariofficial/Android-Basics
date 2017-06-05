package com.example.android.miwok;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by nayantiwari on 6/1/17.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    public CategoryAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return GeneralFragment.newInstance("Numbers");
            case 1:
                return GeneralFragment.newInstance("Family Members");
            case 2:
                return GeneralFragment.newInstance("Colors");
            default:
                return GeneralFragment.newInstance("Phrases");
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Numbers";
            case 1:
                return "Family";
            case 2:
                return "Colors";
            default:
                return "Phrases";
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
