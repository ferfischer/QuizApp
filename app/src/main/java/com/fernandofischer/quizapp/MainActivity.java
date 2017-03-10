package com.fernandofischer.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void finishQuiz(View view){
        int numeroAcertos = 0;

        RadioButton rbCorrectAnswer1 = (RadioButton) findViewById(R.id.q1correctAnswer);
        if (rbCorrectAnswer1.isChecked()) {
            numeroAcertos++;
        }

        RadioButton rbCorrectAnswer2 = (RadioButton) findViewById(R.id.q2correctAnswer);
        if (rbCorrectAnswer2.isChecked()) {
            numeroAcertos++;
        }

        RadioButton rbCorrectAnswer3 = (RadioButton) findViewById(R.id.q3correctAnswer);
        if (rbCorrectAnswer3.isChecked()) {
            numeroAcertos++;
        }

        CheckBox cbCorrectAnswer4A = (CheckBox) findViewById(R.id.q4correctAnswerA);
        CheckBox cbCorrectAnswer4B = (CheckBox) findViewById(R.id.q4correctAnswerB);
        CheckBox cbCorrectAnswer4C = (CheckBox) findViewById(R.id.q4correctAnswerC);
        CheckBox cbWrongAnswer4 = (CheckBox) findViewById(R.id.q4wrongAnswer);

        if ( cbCorrectAnswer4A.isChecked() && cbCorrectAnswer4B.isChecked() && cbCorrectAnswer4C.isChecked() && !cbWrongAnswer4.isChecked() ) {
            numeroAcertos++;
        }

        TextView tvAnswer5 = (TextView) findViewById(R.id.q5answer);
        if ("Youtube".equalsIgnoreCase(tvAnswer5.getText().toString().trim())){
            numeroAcertos++;
        };

        if (numeroAcertos > 0) {
            Toast.makeText(this, "Você acertou " + numeroAcertos + " respostas!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Você não acertou nenhuma resposta! :(", Toast.LENGTH_SHORT).show();
        }
        RatingBar rbPontuacao = (RatingBar) findViewById(R.id.ratingBar);
        rbPontuacao.setRating(numeroAcertos);
        rbPontuacao.setVisibility(View.VISIBLE);


    }

}
