package tablefixheaders.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import mainscreen.govt.maidi.com.maidi.Fragmentweek1;
import mainscreen.govt.maidi.com.maidi.Fragmentweek2;
import mainscreen.govt.maidi.com.maidi.Fragmentweek3;
import mainscreen.govt.maidi.com.maidi.Fragmentweek4;
import mainscreen.govt.maidi.com.maidi.Fragmentweek5;

/**
 * Created by Priyabrat on 21-08-2015.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new Fragmentweek1();
        }
        else if (position == 1)
        {
            fragment = new Fragmentweek2();
        }
        else if (position == 2)
        {
            fragment = new Fragmentweek3();
        }
        else if (position == 3)
        {
            fragment = new Fragmentweek4();
        }
        else if (position == 4)
        {
            fragment = new Fragmentweek5();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 5;

    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "Week 1";
        }
        else if (position == 1)
        {
            title = "Week 2";
        }
        else if (position == 2)
        {
            title = "Week 3";
        }
        else if (position == 3)
        {
            title = "Week 4";
        }
        else if (position == 4)
        {
            title = "Week 5";
        }
        return title;
    }
}
