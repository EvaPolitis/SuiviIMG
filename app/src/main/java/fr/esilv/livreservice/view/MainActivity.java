package fr.esilv.livreservice.view;

import androidx.appcompat.app.AppCompatActivity;
import fr.esilv.livreservice.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listenAcces((ImageButton)findViewById(R.id.btnAccesIMG),CalculActivity.class);
        listenAcces((ImageButton)findViewById(R.id.btnAccesSalles),RecycleSalleActivity.class);
    }

    /**
     * Ouvrir l'activity correspondante
     * @param btn
     * @param classe
     */
    private void listenAcces(ImageButton btn, final Class classe){
        btn.setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,classe);
                startActivity(intent);
            }
        });
    }
}
