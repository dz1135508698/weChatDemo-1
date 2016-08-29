package com.emmanuel.wechatdemo.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.emmanuel.wechatdemo.R;
import com.emmanuel.wechatdemo.util.DensityUtil;
import com.emmanuel.wechatdemo.view.TabLayout;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2016/8/23.
 */
public class MainActivity extends BaseActivity {

    private String[] mTitle = {"微信", "通讯录", "发现", "我"};
    private int[] mIconSelect = {R.mipmap.icon_chat_green, R.mipmap.icon_contacts_green, R.mipmap.icon_find_green, R.mipmap.icon_me_green};
    private int[] mIconNormal = {R.mipmap.icon_chat_white, R.mipmap.icon_contacts_white, R.mipmap.icon_find_white, R.mipmap.icon_me_white};
    private ViewPager mViewPager ;
    private TabLayout mTabView ;
    private Map<Integer, Fragment> mFragmentMap ;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        mFragmentMap = new HashMap<>() ;
        mViewPager = (ViewPager)findViewById(R.id.activity_main_viewpager) ;
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setAdapter(new PageAdapter(getSupportFragmentManager()));
        mTabView = (TabLayout) findViewById(R.id.activity_main_tablayout) ;
        mTabView.setViewPager(mViewPager);
    }

    private Fragment getFragment(int position){
        Fragment fragment = mFragmentMap.get(position) ;
        if(fragment == null){
            switch (position){
                case 0:
                    fragment = new FriendsFragment() ;
                    break ;
                case 1:
                    fragment = new FriendsFragment();
                    break ;
                case 2:
                    fragment = new FriendsFragment();
                    break;
                case 3:
                    fragment = new FriendsFragment() ;
                    break;
            }
            mFragmentMap.put(position,fragment) ;
        }
        return fragment ;
    }

    class PageAdapter extends FragmentPagerAdapter implements TabLayout.OnItemIconTextSelectListener{

        public PageAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return getFragment(position);
        }
        @Override
        public int[] onIconSelect(int position) {
            int icon[] = new int[2] ;
            icon[0] = mIconSelect[position] ;
            icon[1] = mIconNormal[position] ;
            return icon;
        }
        @Override
        public String onTextSelect(int position) {
            return mTitle[position];
        }

        @Override
        public int getCount() {
            return mTitle.length;
        }
    }

}