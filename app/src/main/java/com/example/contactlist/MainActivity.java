package com.example.contactlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText textName, textPhone;
    Button btn;
    ImageButton btn_next_activity;
    List<Item> items = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this, ContactsActivity.class);


        btn = findViewById(R.id.button);
        textName = (EditText) findViewById(R.id.EditName);
        textPhone = (EditText) findViewById(R.id.EditPhone);
        btn_next_activity = findViewById(R.id.btn_next_activity);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = textName.getText().toString();
                String phone = textPhone.getText().toString();
                if (name != null && phone != null){
                items.add(new Item(name, phone, R.drawable.icon));
                }
            }
        });


        btn_next_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putParcelableArrayListExtra("item",(ArrayList) items);
                startActivity(intent);

            }
        });
    }
}
