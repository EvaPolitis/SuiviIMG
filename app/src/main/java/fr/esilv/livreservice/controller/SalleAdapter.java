package fr.esilv.livreservice.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import fr.esilv.livreservice.R;
import fr.esilv.livreservice.model.Salle;

public class SalleAdapter extends ArrayAdapter<Salle> {

    public SalleAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v;
        LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v=layoutInflater.inflate(R.layout.salle_cell, null);
        Salle curretnSalle = getItem(position);
        TextView txtVille = (TextView)v.findViewById(R.id.txtVille);
        TextView txtNumSalle = (TextView)v.findViewById(R.id.txtNumSalle);

        txtVille.setText(curretnSalle.getVille());
        txtNumSalle.setText(String.valueOf(curretnSalle.getNumSalle()));
        return v;
    }
}
