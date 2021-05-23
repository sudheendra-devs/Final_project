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

public class ChAdapter extends RecyclerView.Adapter<ChAdapter.clubheadholder>{
ArrayList<clubheadModel> arrayList;

    public ChAdapter(ArrayList<clubheadModel> arrayList) {
        this.arrayList = arrayList;
    }

    public clubheadholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.clubheads,parent,false);
        return  new clubheadholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull clubheadholder holder, int position) {
        holder.im.setImageResource(arrayList.get(position).getImageId());
        holder.name.setText(arrayList.get(position).getName());
        holder.role.setText(arrayList.get(position).getRole());
        holder.info.setText(arrayList.get(position).getInfo());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class clubheadholder extends RecyclerView.ViewHolder{
ImageView im;
TextView name,role,info;
        public clubheadholder(@NonNull @NotNull View itemView) {
            super(itemView);
            im = itemView.findViewById(R.id.headimage);
            name =itemView.findViewById(R.id.headname);
            role = itemView.findViewById(R.id.role);
            info = itemView.findViewById(R.id.headinfo);
        }
    }
}
