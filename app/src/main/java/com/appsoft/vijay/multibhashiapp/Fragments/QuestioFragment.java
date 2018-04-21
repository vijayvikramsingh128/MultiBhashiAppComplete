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

public class QuestioFragment extends Fragment{

    TextView tv;
    public QuestioFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_question, container, false);

         tv = (TextView) v.findViewById(R.id.tvFragSecond);

        Lesson lesson = (Lesson) getArguments().getSerializable("question");
        tv.setText(lesson.getAudioUrl());
        return v;

    }


    public static QuestioFragment newInstance(Lesson lesson) {

        QuestioFragment f = new QuestioFragment();
        Bundle b = new Bundle();
        b.putSerializable("question",lesson);
        f.setArguments(b);

        return f;
    }
    @Override public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    }
}
