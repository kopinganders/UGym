package org.example.anders.eazy.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import org.example.anders.eazy.Views.ArmsExercises.ArmTab;
import org.example.anders.eazy.Views.BackExercises.BackTab;
import org.example.anders.eazy.Views.ChestExercises.ChestTab;
import org.example.anders.eazy.Views.LegExercises.LegTab;

public class TabPagerAdapter extends FragmentStatePagerAdapter {
    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                //Fragement for Armtab Tab
                return new ArmTab();
            case 1:
                //Fragment for Leg Tab
                return new LegTab();
            case 2:
                //Fragment for Back Tab
                return new BackTab();
            case 3:
                return  new ChestTab();
        }
        return null;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 4; //No of Tabs
    }

}