package com.example.contactlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;

public class ContactsActivity extends AppCompatActivity {
    RecyclerView rv;
    ArrayList<Item> itemArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        rv = findViewById(R.id.rv);
        Intent intent = getIntent();
        ArrayList<Item> items = new ArrayList<>(intent.getParcelableArrayListExtra("item"));
        itemArrayList.addAll(items);
        Button btnPrev = findViewById(R.id.btn_prev);
        btnPrev.setOnClickListener(v -> goBack());
        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(ContactsActivity.this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), itemArrayList));

    }

    public void goBack() {
       onBackPressed();
     //   Intent intent = new Intent(ContactsActivity.this, MainActivity.class);
      //  startActivity(intent);
    }
}