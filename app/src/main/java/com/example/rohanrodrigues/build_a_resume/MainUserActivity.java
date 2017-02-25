package com.example.rohanrodrigues.build_a_resume;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainUserActivity extends AppCompatActivity {
    private ManageResumes mManageResumes;
    private Resume currentResumeViewFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user);

        mManageResumes = new ManageResumes();
        currentResumeViewFrag = null;
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("Add"));
        tabLayout.addTab(tabLayout.newTab().setText("View"));
        tabLayout.addTab(tabLayout.newTab().setText("Print"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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

    public ManageResumes getManageResumes() {
        return mManageResumes;
    }

    public void setCurrentResumeForViewFragment(Resume r) {
        this.currentResumeViewFrag = r;
    }

    public Resume getCurrentResumeForViewFragment() {
        return this.currentResumeViewFrag;
    }
}
