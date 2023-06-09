package com.example.contactlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {
   private RecyclerView rv;
   private ArrayList<Item> itemArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        loadData();

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
        recyclerView.setAdapter(new ContactsAdapter(getApplicationContext(), itemArrayList));
    }


    public void goBack() {
        saveData();
        onBackPressed();
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(itemArrayList);
        editor.putString("task list", json);
        editor.apply();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<Item>>() {
        }.getType();
        itemArrayList = gson.fromJson(json, type);
        if (itemArrayList == null) {
            itemArrayList = new ArrayList<>();
        }
    }
}
