package com.kelly.menuset.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


import com.dxtt.coolmenu.CoolMenuFrameLayout;
import com.kelly.menuset.R;
import com.kelly.menuset.fragment.CoolFragment1;
import com.kelly.menuset.fragment.CoolFragment2;
import com.kelly.menuset.fragment.CoolFragment3;
import com.kelly.menuset.fragment.CoolFragment4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoolActivity extends AppCompatActivity {

    Button bt;

    boolean open;

    CoolMenuFrameLayout coolMenuFrameLayout;

    List<Fragment> fragments = new ArrayList<>();

    List<String> titleList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cool);

//        coolMenuFrameLayout = (CoolMenuFrameLayout) findViewById(R.id.rl_main);
        coolMenuFrameLayout = $(R.id.rl_main);
        String[] titles = {"CONTACT", "ABOUT", "TEAM", "PROJECTS"};
        titleList = Arrays.asList(titles);
        coolMenuFrameLayout.setTitles(titleList);
//        coolMenuFrameLayout.setMenuIcon(R.drawable.menu2);

        fragments.add(new CoolFragment1());
        fragments.add(new CoolFragment2());
        fragments.add(new CoolFragment3());
        fragments.add(new CoolFragment4());

        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };
        coolMenuFrameLayout.setAdapter(adapter);
    }

    @SuppressWarnings("unchecked")
    private <T extends View> T $(@IdRes int id) {
        return (T) findViewById(id);
    }
}
