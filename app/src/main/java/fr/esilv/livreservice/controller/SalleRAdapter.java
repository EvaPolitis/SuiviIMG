package fr.esilv.livreservice.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.esilv.livreservice.R;

public class SalleRAdapter extends RecyclerView.Adapter<SalleRAdapter.MyViewHolder>{

    String data1[], data2[];
        int image[];
    Context context;

    public SalleRAdapter(String s1[], String s2[], int image[], Context context) {
        data1 = s1;
        data2 = s2;
        this.image = image;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtVille.setText(data1[position]);
        holder.txtNbSalle.setText(data2[position]);
        holder.imgVille.setImageResource(image[position]);
    }

    @Override
    public int getItemCount() {

        return data1.length ;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtVille, txtNbSalle;
        ImageView imgVille;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtVille = itemView.findViewById(R.id.txtVilleSport);
            txtNbSalle = itemView.findViewById(R.id.txtNbSalle);
            imgVille = itemView.findViewById(R.id.imgVille);
        }
    }
}
