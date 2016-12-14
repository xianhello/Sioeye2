package com.ckt.ued.sioeye;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.ckt.ued.sioeye.fragment.FindFragment;
import com.ckt.ued.sioeye.fragment.FocusFragment;
import com.ckt.ued.sioeye.fragment.MeFragment;
import com.gigamole.navigationtabbar.ntb.NavigationTabBar;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    ViewPager viewPager;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initNavigationTabBar();
    }

    private void initUI() {
        viewPager = (ViewPager) findViewById(R.id.vp_horizontal_ntb);
        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = new FindFragment();
                        break;
                    case 1:
                        fragment = new FocusFragment();
                        break;
                    case 2:
                        fragment = new MeFragment();
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return 3;
            }
        };
        viewPager.setAdapter(fragmentPagerAdapter);
    }

    private void initNavigationTabBar() {
        final int colorBottom = getResources().getColor(R.color.colorBottom);
        final NavigationTabBar navigationTabBar = (NavigationTabBar) findViewById(R.id.ntb_horizontal);
        navigationTabBar.setBgColor(getResources().getColor(R.color.colorBg));
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.find_normal),
                        colorBottom)
                        .title(getResources().getString(R.string.find))
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_second),
                        colorBottom)
                        .title(getResources().getString(R.string.focus))
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.profile_normal),
                        colorBottom)
                        .title(getResources().getString(R.string.me))
                        .build()
        );

        navigationTabBar.setModels(models);
        navigationTabBar.setViewPager(viewPager);
        navigationTabBar.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
            }

            @Override
            public void onPageScrollStateChanged(final int state) {

            }
        });

    }
}
