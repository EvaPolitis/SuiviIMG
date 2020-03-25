package fr.esilv.livreservice.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import fr.esilv.livreservice.R;
import fr.esilv.livreservice.controller.Control;

public class CalculActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul);
        init();
        this.control= Control.getInstance();
    }

    //proprietes
    private EditText txtPoids;
    private EditText txtTaille;
    private EditText txtAge;
    private RadioButton rdHomme;
    private TextView labIMG;
    private ImageView imgEmoji;
    private Control control;

    /**
     * Initialisation des liens avec les objets graphique
     */
    private void init(){
        txtPoids=(EditText)findViewById(R.id.txtPoids);
        txtTaille=(EditText)findViewById(R.id.txtTaille);
        txtAge=(EditText)findViewById(R.id.txtAge);
        rdHomme=(RadioButton)findViewById(R.id.rdHomme);
        labIMG=(TextView)findViewById(R.id.labIMG);
        imgEmoji=(ImageView)findViewById(R.id.imgEmoji);
        listenCalcul();
        listenAccueil();
    }

    /**
     * Ecoute d'événment sur le bouton Calculer
     */
    private void listenCalcul(){
        ((Button)findViewById(R.id.btnCalcul)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                //Toast.makeText(CalculActivity.this,"test",Toast.LENGTH_SHORT).show();
                //Log.d("message","clic ok sur le outon Calcul*************************");

                Integer poids =0;
                Integer taille =0;
                Integer age =0;
                Integer sexe =0; //femme

                //recuperation des données saisies
                try {
                    poids = Integer.parseInt(txtPoids.getText().toString());
                    taille = Integer.parseInt(txtTaille.getText().toString());
                    age = Integer.parseInt(txtAge.getText().toString());
                }catch (Exception e){};

                if(rdHomme.isChecked()){
                    sexe=1;
                }

                //controle des données saisies
                if(poids==0 || taille==0 || age==0){
                    Toast.makeText(CalculActivity.this,"Veuillez renseigner tous les champs",Toast.LENGTH_SHORT).show();
                }else {
                    afficheResult(poids,taille,age,sexe);
                }
            }
        });
    }

    private void listenAccueil(){
        ((ImageButton)findViewById(R.id.btnAccueil)).setOnClickListener(new ImageButton.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(CalculActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Affichage de l'img, du message et de l'image
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     */
    private void afficheResult(Integer poids,Integer taille, Integer age, Integer sexe){
        //creation du profil et recuperation des informations
        this.control.creerProfil(poids,taille,age,sexe);
        float img=this.control.getImg();
        String message=this.control.getMessage();

        //affichage
        if(message=="normal"){
            imgEmoji.setImageResource(R.drawable.sunglasses);
            labIMG.setTextColor(Color.GREEN);
        }else {
            imgEmoji.setImageResource(R.drawable.hurt);
            labIMG.setTextColor(Color.RED);
        }
        labIMG.setText(String.format("%.01f",img)+" : IMG "+ message);
    }
}
