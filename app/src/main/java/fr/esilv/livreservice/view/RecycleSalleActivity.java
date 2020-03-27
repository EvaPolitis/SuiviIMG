package fr.esilv.livreservice.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageButton;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import fr.esilv.livreservice.R;
import fr.esilv.livreservice.controller.SalleRAdapter;
import fr.esilv.livreservice.model.Salle;

public class RecycleSalleActivity extends AppCompatActivity {

    /*private SalleRAdapter adapter;
    private List<Salle> exampleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillExampleList();
        setUpRecyclerView();
    }

    private void fillExampleList() {
        exampleList = new ArrayList<>();
        exampleList.add(new Salle(getResources().getStringArray(R.array.ville_sport)[0], getResources().getStringArray(R.array.nb_salle)[0],R.drawable.montesson));
        exampleList.add(new Salle(getResources().getStringArray(R.array.ville_sport)[1],getResources().getStringArray(R.array.nb_salle)[1],R.drawable.pecq));
        exampleList.add(new Salle(getResources().getStringArray(R.array.ville_sport)[2],getResources().getStringArray(R.array.nb_salle)[2],R.drawable.vesinet));
        exampleList.add(new Salle(getResources().getStringArray(R.array.ville_sport)[3],getResources().getStringArray(R.array.nb_salle)[3],R.drawable.sartrouville));
        exampleList.add(new Salle(getResources().getStringArray(R.array.ville_sport)[4],getResources().getStringArray(R.array.nb_salle)[4],R.drawable.chatou));
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new SalleRAdapter(exampleList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_bar, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }*/
    RecyclerView recyclerView;
    SalleRAdapter salleRAdapter;
    String s1[],s2[];
    int images[]={R.drawable.montesson,R.drawable.pecq,R.drawable.vesinet,R.drawable.sartrouville,R.drawable.chatou};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_salle);

        recyclerView= findViewById(R.id.recyclerView);

        s1=getResources().getStringArray(R.array.ville_sport);
        s2=getResources().getStringArray(R.array.nb_salle);

        salleRAdapter=new SalleRAdapter(s1,s2,images,this);

        salleRAdapter.setOnItemClickListener(new SalleRAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(int position){
                Intent intent=new Intent(RecycleSalleActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });


        recyclerView.setAdapter(salleRAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
