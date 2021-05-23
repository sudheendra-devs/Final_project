package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class myAdapter extends  RecyclerView.Adapter<myAdapter.viewHolder>
{
    ArrayList<model> dataholder;

    public myAdapter(ArrayList<model> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @NotNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull viewHolder holder, int position) {
        holder.dhead.setText(dataholder.get(position).getView1());
        holder.dnotif.setText(dataholder.get(position).getView2());
        holder.dimage.setImageResource(dataholder.get(position).getImageId());

    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class viewHolder extends RecyclerView.ViewHolder{
        TextView dhead,dnotif;
        ImageView dimage;
        public viewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            dimage = itemView.findViewById(R.id.imagen);
            dhead = (TextView)itemView.findViewById(R.id.heading);
            dnotif = (TextView)itemView.findViewById(R.id.notify);
        }
    }
}
