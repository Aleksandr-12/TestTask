package com.test.testtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.test.testtask.database.ReponseRepository;
import com.test.testtask.database.model.Reponse;

import java.util.List;

public class ListUsersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        ReponseRepository reponseRepository = new ReponseRepository(getApplication());
        if (getIntent().getSerializableExtra("code") != null) {
            List<Reponse> reponses = (List<Reponse>) getIntent().getSerializableExtra("Reponse");
            for(Reponse reponse:reponses){
                reponseRepository.insert(reponse);
            }
            ReponseAdapter reponseAdapter = new ReponseAdapter(reponses);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(reponseAdapter);
        }
    }
}