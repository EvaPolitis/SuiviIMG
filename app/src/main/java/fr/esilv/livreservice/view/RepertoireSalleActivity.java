package fr.esilv.livreservice.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import fr.esilv.livreservice.R;
import fr.esilv.livreservice.controller.SalleAdapter;
import fr.esilv.livreservice.model.Salle;

public class RepertoireSalleActivity extends AppCompatActivity {

    private ArrayList<Salle> lesSalles;
    private ListView listSalles;
    private SalleAdapter salleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repertoire_salle);

        listSalles= (ListView) findViewById(R.id.listSalle);

        salleAdapter=new SalleAdapter(getApplicationContext(),0);

        lesSalles=new ArrayList<>();

        lesSalles.add(new Salle("Montesson",1));
        lesSalles.add(new Salle("Montesson",2));
        lesSalles.add(new Salle("Montesson",3));
        lesSalles.add(new Salle("Vesinet",1));
        lesSalles.add(new Salle("Vesinet",2));
        lesSalles.add(new Salle("Chatou",1));
        lesSalles.add(new Salle("Chatou",2));

        listSalles.setAdapter(salleAdapter);
        salleAdapter.addAll(lesSalles);
    }
}
