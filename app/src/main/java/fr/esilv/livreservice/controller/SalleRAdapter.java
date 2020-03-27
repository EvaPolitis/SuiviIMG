package fr.esilv.livreservice.controller;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fr.esilv.livreservice.R;
import fr.esilv.livreservice.model.Salle;
import fr.esilv.livreservice.view.MapsActivity;
import fr.esilv.livreservice.view.RecycleSalleActivity;

public class SalleRAdapter extends RecyclerView.Adapter<SalleRAdapter.MyViewHolder> {
    /*private List<Salle> exampleList;
    private List<Salle> exampleListFull;

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1;
        TextView textView2;

        MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.txtVilleSport);
            textView1 = itemView.findViewById(R.id.txtNbSalle);
            textView2 = itemView.findViewById(R.id.imgVille);
        }
    }

    public SalleRAdapter(List<Salle> exampleList) {
        this.exampleList = exampleList;
        exampleListFull = new ArrayList<>(exampleList);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Salle currentItem = exampleList.get(position);

        holder.imageView.setImageResource(currentItem.getImageResource());
        holder.textView1.setText(currentItem.getVille());
        holder.textView2.setText(currentItem.getNumSalle());
    }

    @Override
    public int getItemCount() {
        return exampleList.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Salle> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(exampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Salle item : exampleListFull) {
                    if (item.getVille().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            exampleList.clear();
            exampleList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };*/
    String data1[], data2[];
    int image[];
    Context context;

    private OnItemClickListener Listener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){Listener=listener;}

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
        return new MyViewHolder(view,Listener);
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

        public MyViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            txtVille = itemView.findViewById(R.id.txtVilleSport);
            txtNbSalle = itemView.findViewById(R.id.txtNbSalle);
            imgVille = itemView.findViewById(R.id.imgVille);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null){
                        int position =getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }

                }
            });
        }
    }
}
