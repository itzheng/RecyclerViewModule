package com.example.recyclerviewmodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.recyclerviewmodule.adapter.MyAdapter;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvContent = findViewById(R.id.rcvContent);
        setAdapter();
    }

    private void setAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvContent.setLayoutManager(linearLayoutManager);
        rcvContent.addItemDecoration(DividerManager.getDecoration(this));
        rcvContent.setAdapter(new MyAdapter());
    }
}
