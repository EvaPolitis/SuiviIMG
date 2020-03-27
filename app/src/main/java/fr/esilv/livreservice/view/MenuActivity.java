package fr.esilv.livreservice.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import fr.esilv.livreservice.R;

public class MenuActivity extends AppCompatActivity {

    private Button mBtnIMG;
    private Button mBtnAccesSalles;
    private Button mQuizz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mBtnIMG=findViewById(R.id.btnAccesIMG);
        mBtnAccesSalles=findViewById(R.id.btnAccesSalles);
        mQuizz=findViewById(R.id.btnQuizz);
        listenAcces(mBtnIMG,CalculActivity.class);
        listenAcces(mBtnAccesSalles,RecycleSalleActivity.class);
        listenAcces(mQuizz,GameActivity.class);
    }

    /**
     * Ouvrir l'activity correspondante
     * @param btn
     * @param classe
     */
    private void listenAcces(Button btn, final Class classe){
        btn.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,classe);
                startActivity(intent);
            }
        });
    }
}
