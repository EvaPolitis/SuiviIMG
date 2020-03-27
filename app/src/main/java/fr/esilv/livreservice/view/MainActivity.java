package fr.esilv.livreservice.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import fr.esilv.livreservice.R;
import fr.esilv.livreservice.model.User;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    //Identifiant de l'activité jeu
    private static final int GAME_ACTIVITY_REQUEST_CODE = 42;
    //clé publique
    public static final String PREF_KEY_SCORE = "PREF_KEY_SCORE";
    public static final String PREF_KEY_FIRSTNAME = "PREF_KEY_FIRSTNAME";

    private TextView mGreetingText;
    private EditText mNameInput;
    private Button mPlayButton;

    private User mUser;
    private SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGreetingText= findViewById(R.id.greeting_txt);
        mNameInput = findViewById(R.id.name_input);
        mPlayButton=findViewById(R.id.play_btn);

        mUser=new User();

        mPreferences = getPreferences(MODE_PRIVATE);



        //Désactive le button si utilisateur n'a pas rempli infos
        mPlayButton.setEnabled(false);

        comebackUser();

        //Notifier EditText rempli
        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //si utilisateur saisi une lettre -> activation button
                mPlayButton.setEnabled(s.toString().length() !=0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mUser.setFirstName(mNameInput.getText().toString());

                mPreferences.edit().putString(PREF_KEY_FIRSTNAME, mUser.getFirstName()).apply();
                //New Activité
                Intent menuActivity = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(menuActivity);

            }
        });

    }
    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // résultat provient de la bonne activité
        //activité s'est correctement terminée
        if (GAME_ACTIVITY_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {

            // Fetch the score from the Intent
            int score = data.getIntExtra(GameActivity.BUNDLE_EXTRA_SCORE, 0);
            mPreferences.edit().putInt(PREF_KEY_SCORE, score).apply();

            comebackUser();
        }
    }*/

    protected void comebackUser()
    {
        //int lastscore= mPreferences.getInt(PREF_KEY_SCORE,0);
        String name = mPreferences.getString(PREF_KEY_FIRSTNAME,null);

        if (name!= null)
        {
            String comeback = "Welcome back " + name+" !";
            mGreetingText.setText(comeback);
            mNameInput.setText(name);

            //curseur à la fin
            mNameInput.setSelection(name.length());
            mPlayButton.setEnabled(true);
        }
    }


}
