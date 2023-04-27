package com.example.contactlist;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView nameView, phoneView;



    public MyViewHolder( View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        nameView = itemView.findViewById(R.id.textViewName);
        phoneView = itemView.findViewById(R.id.textViewNumber);
    }
}
