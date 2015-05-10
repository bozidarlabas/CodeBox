package com.labas.bozidar.foi.codebox.fragments.questions;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.labas.bozidar.foi.codebox.R;
import com.labas.bozidar.foi.codebox.mvp.models.Question;
import com.labas.bozidar.foi.codebox.mvp.views.QuestionView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.InjectViews;
import butterknife.OnClick;


public class QuestionTwo extends BaseQuestionFragment implements QuestionView {


    @InjectViews({R.id.btnAnswer1, R.id.btnAnswer2, R.id.btnAnswer3, R.id.btnAnswer4})
    List<Button> buttons;

    @InjectView(R.id.tvQuestion)
    TextView tvQuestion;

    private Button clickedButton;
    private String correctAnswer;

    private String question;
    private ArrayList<String> answers;

    public static QuestionTwo newInstance() {
        return new QuestionTwo();
    }

    public QuestionTwo() {
        answers = new ArrayList<>();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("kreiram", "kreiram");
        View view = inflater.inflate(R.layout.fragment_question_two, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    private void setViews() {
        tvQuestion.setText(question);
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).setText(answers.get(i));
        }
    }

    @Override
    public void onSetQuestion(List<Question> question) {
        this.question = question.get(1).getPitanje();
    }

    @Override
    public void onSetAnswers(List<Question> questions) {

        answers.add(questions.get(1).getOdgovor_a());
        answers.add(questions.get(1).getOdgovor_b());
        answers.add(questions.get(1).getOdgovor_c());
        answers.add(questions.get(1).getOdgovor_d());
        this.correctAnswer = questions.get(1).getTocan_odgovor();

    }

    @Override
    public void changeButtonText(String correctAnswer) {
        for (Button button : buttons) {
            if (!button.equals(clickedButton)) {
                button.setText("");
            } else {
                button.setText(correctAnswer);
            }
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setViews();
    }

    @OnClick({R.id.btnAnswer1, R.id.btnAnswer2, R.id.btnAnswer3, R.id.btnAnswer4})
    public void onClick(View v) {
        clickedButton = (Button) v;
        String answer = (String) clickedButton.getText();
        listener.answeredQuestion(answer, correctAnswer);
    }




}
