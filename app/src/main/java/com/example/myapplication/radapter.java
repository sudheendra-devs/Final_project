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

public class radapter extends RecyclerView.Adapter<radapter.viewholder> {
    ArrayList<modelregister> arrayList;

    public radapter(ArrayList<modelregister> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public viewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.registerrow,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull viewholder holder, int position) {
    holder.rimage.setImageResource(arrayList.get(position).getImageId());
    holder.ractivity.setText(arrayList.get(position).getActivity());
    holder.rlink.setText(arrayList.get(position).getLink());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class viewholder extends RecyclerView.ViewHolder{
        TextView  ractivity,rlink;
        ImageView rimage;
        public viewholder(@NonNull @NotNull View itemView) {
            super(itemView);
            ractivity = itemView.findViewById(R.id.headname);
            rlink = itemView.findViewById(R.id.role);
            rimage = itemView.findViewById(R.id.headimage);
        }
    }
}
