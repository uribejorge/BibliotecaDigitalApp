package com.example.bibliotecadigitalapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ListElement> elements;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();

    }

    public void init() {
        elements = new ArrayList<>();
        elements.add(new ListElement("#775447", "cien años de soledad", "grabriel garcia marquez", "Activo"));
        elements.add(new ListElement("#607d8b", "el empleo", "Santiago grasso", "Activo"));
        elements.add(new ListElement("#03a9f4", "la casa de la luz", "pedro berrocal", "Cancelado"));
        elements.add(new ListElement("#f44336", "la dama y la muerte", "javier recio", "Inactivo"));
        elements.add(new ListElement("#009688", "los girasoles", "alvaro carmona", "Activo"));

        ListAdapter listAdapter = new ListAdapter(elements, this);
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

    }
}

