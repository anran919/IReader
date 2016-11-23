package com.anakin.ireader.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.anakin.ireader.constants.PagerConfig;
import com.anakin.ireader.ui.fragment.ArticleFragment;
import com.anakin.ireader.ui.fragment.PictureFragment;
import com.anakin.ireader.ui.fragment.QuestionsFragment;
import com.anakin.ireader.ui.fragment.ThingsFragment;
import com.anakin.ireader.ui.fragment.MoviesFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建者     demo
 * 创建时间   2016/11/21 0021 15:15
 */
public class ContenPagetAdapter  extends FragmentPagerAdapter{

    private List<Fragment> fragmentList;

    public ContenPagetAdapter(FragmentManager fm) {
        super(fm);
        createFragment();
    }

    private void createFragment() {
        fragmentList = new ArrayList<>(5);
        fragmentList.add(ArticleFragment.getInstance());
        fragmentList.add(PictureFragment.getInstance());
        fragmentList.add(ThingsFragment.getInstance());
        fragmentList.add(QuestionsFragment.getInstance());
        fragmentList.add(MoviesFragment.getInstance());
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return PagerConfig.titles[position];
    }
}
