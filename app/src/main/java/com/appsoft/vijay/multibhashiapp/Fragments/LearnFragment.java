package com.appsoft.vijay.multibhashiapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appsoft.vijay.multibhashiapp.Model.Lesson;
import com.appsoft.vijay.multibhashiapp.R;

/**
 * Created by Vijay on 21-Apr-18.
 */

public class LearnFragment extends Fragment {
    TextView tv;
    public LearnFragment() {
                super();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_learn, container, false);

       tv = (TextView) v.findViewById(R.id.text_Pronountiation);
        Lesson lesson = (Lesson) getArguments().getSerializable("learn");
        tv.setText(lesson.getAudioUrl());
        return v;

    }
    public static LearnFragment newInstance(Lesson lesson) {

        LearnFragment f = new LearnFragment();
        Bundle b = new Bundle();
        b.putSerializable("learn",lesson);
        f.setArguments(b);
        return f;
    }
    @Override public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


    }
}
