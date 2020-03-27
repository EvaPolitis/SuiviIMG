package fr.esilv.livreservice.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import fr.esilv.livreservice.R;
import fr.esilv.livreservice.model.Question;
import fr.esilv.livreservice.model.QuestionBank;


public class GameActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView mQuestion;
    private Button mAnswer1Btn;
    private Button mAnswer2Btn;
    private Button mAnswer3Btn;
    private Button mAnswer4Btn;

    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;

    private int mNumberOfQuestions;
    private int mScore;

    private boolean mEnableTouchEvents;

    //clé publique récupérable par main activité
    public static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE";
    //a sauvegarder
    public static final String BUNDLE_STATE_SCORE = "currentScore";
    public static final String BUNDLE_STATE_QUESTION = "currentQuestion";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        if (savedInstanceState != null) {
            mScore = savedInstanceState.getInt(BUNDLE_STATE_SCORE);
            mNumberOfQuestions = savedInstanceState.getInt(BUNDLE_STATE_QUESTION);
        } else {
            mScore = 0;
            mNumberOfQuestions = 4;
        }

        mQuestion=findViewById(R.id.question_text);
        mAnswer1Btn=findViewById(R.id.answer1);
        mAnswer2Btn=findViewById(R.id.answer2);
        mAnswer3Btn=findViewById(R.id.answer3);
        mAnswer4Btn=findViewById(R.id.answer4);

        mQuestionBank=this.generateQuestions();

        mNumberOfQuestions=4;
        // Use the tag property to 'name' the buttons
        mAnswer1Btn.setTag(0);
        mAnswer2Btn.setTag(1);
        mAnswer3Btn.setTag(2);
        mAnswer4Btn.setTag(3);

        mCurrentQuestion=mQuestionBank.getQuestion();
        displayQuestion(mCurrentQuestion);

        mEnableTouchEvents = true;

        // Use the same listener for the four buttons.
        // The tag value will be used to distinguish the button triggered
        mAnswer1Btn.setOnClickListener(this);
        mAnswer2Btn.setOnClickListener(this);
        mAnswer3Btn.setOnClickListener(this);
        mAnswer4Btn.setOnClickListener(this);


    }

    private QuestionBank generateQuestions() {
        Question question1 = new Question("Laquelle de ces huiles végétales est la plus riche en omega3 ?",
                Arrays.asList("Huile d'olive","Huile de pépins de raisin", "Huile de colza", "Huile de tournesol"),
                2);

        Question question2 = new Question("Laquelle des ces huiles végétales est la plus grasse ?",
                Arrays.asList("Huile d'arachide", "Huile d'olive", "Huile de sésame", "Aucune elles sont toutes 100% lipides"),
                3);

        Question question3 = new Question("Lequel des ces aliments constitue la meilleue source de vitamine C",
                Arrays.asList("L'orange", "Le kiwik", "Le poivron", "La clémentine"),
                2);

        Question question4 = new Question("Lequel de ces aliments apporte le plus de magnésium",
                Arrays.asList("La noisette", "L'épinard", "Le chocolat noi", "La pistache"),
                3);

        Question question5 = new Question("Quelle vitamine liposoluble possède un rôle fondamentale dans la fixation du calcium ?",
                Arrays.asList("Vitamine A", "Vitamine D", "Vitamine K", "Vitamine E"),
                1);

        Question question6 = new Question("Les protéines sont constituées d'acides",
                Arrays.asList("gras", "citriques", "ascorbiques", "aminés"),
                3);

        Question question7 = new Question("Combien de calories apporte 1g de glucides ? ",
                Arrays.asList("4 calories", "7 calories", "9 calories", "11 calories"),
                0);

        Question question8 = new Question("Dans lequel de ces végétaux, la quantité de fer est la plus importante ?",
                Arrays.asList("Le persil", "Les lentilles", "Les épinards", "Les haricots"),
                0);

        return new QuestionBank(Arrays.asList(question1,
                question2,
                question3,
                question4,
                question5,
                question6,
                question7,
                question8));
    }

    private void displayQuestion(final Question question) {
        // Set the text for the question text view and the four buttons
         mQuestion.setText(question.getQuestion());
         mAnswer1Btn.setText(question.getChoiceList().get(0));
         mAnswer2Btn.setText(question.getChoiceList().get(1));
         mAnswer3Btn.setText(question.getChoiceList().get(2));
         mAnswer4Btn.setText(question.getChoiceList().get(3));
    }

    @Override
    public void onClick(View v) {

        //int du button sur lequel utilisateur a cliqué
        int responseIndex = (int) v.getTag();
        mNumberOfQuestions--;


        if(mCurrentQuestion.getAnswerIndex()==responseIndex)
        {
            //good
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            mScore++;
        }
        else{
            //wrong
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }

        mEnableTouchEvents = false;

        //Temporisation : Delai entre chaque question
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mEnableTouchEvents = true;

                if (mNumberOfQuestions == 0) {
                    // No question left, end the game
                    endGame();
                } else {

                    mCurrentQuestion = mQuestionBank.getQuestion();
                    displayQuestion(mCurrentQuestion);
                }
            }
        }, 2000); // LENGTH_SHORT is usually 2 second long


    }

    private void endGame()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Well done!")
                .setMessage("Your score is " + mScore)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent();
                        finish();
                    }
                })
                .create()
                .show();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return mEnableTouchEvents && super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putInt(BUNDLE_STATE_SCORE, mScore);
        outState.putInt(BUNDLE_STATE_QUESTION, mNumberOfQuestions);

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
