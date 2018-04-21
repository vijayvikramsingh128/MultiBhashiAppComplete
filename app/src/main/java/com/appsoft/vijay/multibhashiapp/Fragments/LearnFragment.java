package com.appsoft.vijay.multibhashiapp.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.appsoft.vijay.multibhashiapp.Model.Lesson;
import com.appsoft.vijay.multibhashiapp.R;

import java.io.IOException;

/**
 * Created by Vijay on 21-Apr-18.
 */

public class LearnFragment extends Fragment {
    TextView tv_Pronountiation;
    TextView tv_Concept;
    Button sound_Button;
    String audioURL;

    MediaPlayer mediaplayer;

    public LearnFragment() {
                super();

    }

    public static LearnFragment newInstance(Lesson lesson) {

        LearnFragment f = new LearnFragment();
        Bundle b = new Bundle();
        b.putSerializable("learn", lesson);
        f.setArguments(b);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_learn, container, false);

        tv_Pronountiation = (TextView) v.findViewById(R.id.text_Pronountiation);
        tv_Concept = (TextView) v.findViewById(R.id.learn_concept);
        sound_Button = (Button) v.findViewById(R.id.button_Play);

        Lesson lesson = (Lesson) getArguments().getSerializable("learn");

        tv_Concept.setText(lesson.getConceptName());
        tv_Pronountiation.setText(lesson.getPronunciation());
        audioURL = lesson.getAudioUrl();
        sound_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    mediaplayer = new MediaPlayer();
                    mediaplayer.setDataSource(audioURL);
                    mediaplayer.prepare();


                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                mediaplayer.start();


            }
        });


        return v;

    }

    @Override public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


    }
}
