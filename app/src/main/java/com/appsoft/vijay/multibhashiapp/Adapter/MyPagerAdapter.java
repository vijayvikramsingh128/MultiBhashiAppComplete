package com.appsoft.vijay.multibhashiapp.Adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.appsoft.vijay.multibhashiapp.Fragments.LearnFragment;
import com.appsoft.vijay.multibhashiapp.Fragments.QuestioFragment;
import com.appsoft.vijay.multibhashiapp.Model.Lesson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vijay on 21-Apr-18.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {

    List<Lesson> total_lessonData = new ArrayList<>();
    Fragment fm;

    public MyPagerAdapter(FragmentManager fm, List<Lesson> lessons) {

         super(fm);
        total_lessonData=lessons;

    }

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
     Lesson lesson=total_lessonData.get(position);


        if (lesson.getType().equals("learn"))
        {
         return   fm= LearnFragment.newInstance(lesson);

        }

        else if (lesson.getType().equals("question")) { return fm= QuestioFragment.newInstance(lesson);}

        else return  null;


    }

    @Override
    public int getCount() {
        return  total_lessonData.size();
    }
}
