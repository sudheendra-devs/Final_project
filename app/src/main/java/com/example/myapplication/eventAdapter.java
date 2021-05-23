package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class eventAdapter extends RecyclerView.Adapter<eventAdapter.viewHolder>{
    ArrayList<eventModel> arrayList;

    public eventAdapter(ArrayList<eventModel> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @NotNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.eventrow,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull viewHolder holder, int position) {
    holder.ehead.setText(arrayList.get(position).getHead());
    holder.event.setText(arrayList.get(position).getEvent());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class viewHolder extends RecyclerView.ViewHolder{
    TextView ehead,event;
        public viewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            ehead = itemView.findViewById(R.id.eventname);
            event = itemView.findViewById(R.id.event);
        }
    }
}
