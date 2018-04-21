package com.appsoft.vijay.multibhashiapp.Fragments;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.appsoft.vijay.multibhashiapp.Model.Lesson;
import com.appsoft.vijay.multibhashiapp.R;
import com.appsoft.vijay.multibhashiapp.Utility.TextMatcher;

import java.util.ArrayList;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Vijay on 21-Apr-18.
 */

public class QuestioFragment extends Fragment{

    private final int REQ_CODE_SPEECH_INPUT = 100;
    TextView tv_Result;
    TextView tv_Pronountiation;
    TextView tv_Concept;
    TextMatcher matcher;
    private TextView txtSpeechInput;
    private ImageButton btnSpeak;

    public QuestioFragment() {
        super();
    }

    public static QuestioFragment newInstance(Lesson lesson) {

        QuestioFragment f = new QuestioFragment();
        Bundle b = new Bundle();
        b.putSerializable("question", lesson);
        f.setArguments(b);

        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_question, container, false);

        tv_Pronountiation = (TextView) v.findViewById(R.id.text_Pronountiation);
        txtSpeechInput = (TextView) v.findViewById(R.id.txtSpeechInput);
        tv_Concept = (TextView) v.findViewById(R.id.learn_concept);
        btnSpeak = (ImageButton) v.findViewById(R.id.btnSpeak);
        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                promptSpeechInput();
            }
        });
        Lesson lesson = (Lesson) getArguments().getSerializable("question");
        tv_Concept.setText(lesson.getConceptName());
        tv_Pronountiation.setText(lesson.getPronunciation());

        return v;

    }

    @Override public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        matcher = new TextMatcher();

    }

    /**
     * Showing google speech input dialog
     */
    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getActivity().getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Receiving speech input
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txtSpeechInput.setText(result.get(0));
                    int perc = TextMatcher.pecentageOfTextMatch(tv_Pronountiation.getText().toString(), result.get(0));


                    Toast.makeText(getActivity().getApplicationContext(),
                            Integer.toString(perc) + "\t" + "%" + "\t" + "Matched",
                            Toast.LENGTH_LONG).show();
                }
                break;
            }

        }
    }

}
