package com.labas.bozidar.foi.codebox.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.labas.bozidar.foi.codebox.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ScoreFragment extends Fragment implements View.OnClickListener{

    @InjectView(R.id.tvScore)
    TextView tvScore;

    @InjectView(R.id.tvTotalScore)
    TextView tvResult;

    @InjectView(R.id.ivConfirm)
    ImageView ivConfirm;

    private String score;
    private String totalScore;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private OnScoreInteractionListener listener;

    // TODO: Rename and change types and number of parameters
    public static ScoreFragment newInstance(String score, String totalScore) {
        ScoreFragment fragment = new ScoreFragment();


        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, score);
        args.putString(ARG_PARAM2, totalScore);
        fragment.setArguments(args);

        return fragment;
    }

    public ScoreFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            score = getArguments().getString(ARG_PARAM1);
            totalScore = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_score, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (listener != null) {
            listener.onSaveDataToBackend();
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity != null){
            try {
                listener = (OnScoreInteractionListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString()
                        + " must implement OnFragmentInteractionListener");
            }
        }

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.tvResult.setText(totalScore);
        this.tvScore.setText(score);
        ivConfirm.setOnClickListener(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public void setData(String score, String result){
        this.score = score;
        this.totalScore = result;
    }

    @Override
    public void onClick(View view) {
        listener.onSaveDataToSharedPrefs();
        listener.onSaveDataToBackend();
    }

    public interface OnScoreInteractionListener {
        public void onSaveDataToBackend();
        public void onSaveDataToSharedPrefs();
    }

}
