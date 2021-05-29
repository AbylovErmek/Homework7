package com.geektech.homework7;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<State> states = new ArrayList<>();
    private StateAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);

        initAdapter(recyclerView);
    }

    private void initAdapter(RecyclerView recyclerView) {
        adapter = new StateAdapter(this, states);
        recyclerView.setAdapter(adapter);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void setInitialData() {

        states.add(new State("Бразилия", "Бразилиа", getDrawable(R.drawable.ic_brazilia), getResources().getColor(R.color.black)));
        states.add(new State("Аргентина", "Буэнос-Айрес", getDrawable(R.drawable.ic_argentina), getResources().getColor(R.color.black)));
        states.add(new State("Колумбия", "Богота", getDrawable(R.drawable.ic_columbia2), getResources().getColor(R.color.black)));
        states.add(new State("Уругвай", "Монтевидео", getDrawable(R.drawable.ic_urugvai), getResources().getColor(R.color.black)));
        states.add(new State("Чили", "Сантьяго", getDrawable(R.drawable.ic_chile), getResources().getColor(R.color.black)));
    }
}