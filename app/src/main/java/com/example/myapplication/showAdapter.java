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

public class showAdapter extends RecyclerView.Adapter<showAdapter.showHolderClass> {
    ArrayList<modelclass> arrayList = new ArrayList<>();

    public showAdapter(ArrayList<modelclass> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @NotNull
    @Override
    public showHolderClass onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new showHolderClass(LayoutInflater.from(parent.getContext()).inflate(R.layout.imaged,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull showHolderClass holder, int position) {
        modelclass modelclass = arrayList.get(position);
        holder.tv.setText(arrayList.get(position).getImagename());
        holder.iv.setImageBitmap(arrayList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class showHolderClass extends RecyclerView.ViewHolder{
        TextView tv;
        ImageView iv;
        public showHolderClass(@NonNull @NotNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.imagedets);
            iv = itemView.findViewById(R.id.imagedisp);

        }
    }

}
