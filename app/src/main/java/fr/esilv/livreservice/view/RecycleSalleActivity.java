package fr.esilv.livreservice.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import fr.esilv.livreservice.R;
import fr.esilv.livreservice.controller.SalleRAdapter;

public class RecycleSalleActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[],s2[];
    int images[]={R.drawable.montesson,R.drawable.pecq,R.drawable.vesinet,R.drawable.sartrouville,R.drawable.chatou};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_salle);

        recyclerView= findViewById(R.id.recyclerView);

        s1=getResources().getStringArray(R.array.ville_sport);
        s2=getResources().getStringArray(R.array.nb_salle);

        SalleRAdapter salleRAdapter=new SalleRAdapter(s1,s2,images,this);
        recyclerView.setAdapter(salleRAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
