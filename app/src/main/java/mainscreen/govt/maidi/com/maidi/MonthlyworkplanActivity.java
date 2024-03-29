package mainscreen.govt.maidi.com.maidi;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MonthlyworkplanActivity extends AppCompatActivity {

    private final String LOG_TAG = MainActivityTab.class.getSimpleName();

    // Titles of the individual pages (displayed in tabs)
    private final String[] PAGE_TITLES = new String[] {
            "Week 1",
            "Week 2",
            "Week 3",
            "Week 4"

    };

    // The fragments that are used as the individual pages
    private final Fragment[] PAGES = new Fragment[] {
            new MonthlyFragment1(),
            new MonthlyFragment2(),
            new MonthlyFragment3(),
            new MonthlyFragment4()

    };

    // The ViewPager is responsible for sliding pages (fragments) in and out upon user input
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_tab);

        // Set the Toolbar as the activity's app bar (instead of the default ActionBar)


        // Connect the ViewPager to our custom PagerAdapter. The PagerAdapter supplies the pages
        // (fragments) to the ViewPager, which the ViewPager needs to display.
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mViewPager.setAdapter(new MyPagerAdapter(getFragmentManager()));



        // Connect the tabs with the ViewPager (the setupWithViewPager method does this for us in
        // both directions, i.e. when a new tab is selected, the ViewPager switches to this page,
        // and when the ViewPager switches to a new page, the corresponding tab is selected)
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }


    /* PagerAdapter for supplying the ViewPager with the pages (fragments) to display. */
    public class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }


        public Fragment getItem(int position) {
            return PAGES[position];
        }


        public int getCount() {
            return PAGES.length;
        }


        public CharSequence getPageTitle(int position) {
            return PAGE_TITLES[position];
        }

    }
}
