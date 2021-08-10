package com.example.storemanager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.storemanager.menus.boletasFragment;
import com.example.storemanager.menus.comprasFragment;
import com.example.storemanager.menus.pedidosFragment;
import com.example.storemanager.menus.sunatFragment;

public class PagerViewAdapter extends FragmentPagerAdapter {


    public PagerViewAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        Fragment fragment=null;
        switch (position){
            case 0:
                fragment=new comprasFragment();
                break;
            case 1:
                fragment=new boletasFragment();
                break;
            case 2:
                fragment=new pedidosFragment();
                break;
            case 3:
                fragment=new sunatFragment();
                break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
