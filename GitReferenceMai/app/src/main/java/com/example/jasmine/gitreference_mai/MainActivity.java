package com.example.jasmine.gitreference_mai;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private InputStream is;
    private String jsonString;
    ArrayList<GitReference> arrayList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.gitList);
        try {
            is = getApplicationContext().getAssets().open("gitReference.json");
            jsonString = JsonUtils.parseJsonToString(is);
            arrayList = JsonUtils.populateGitReferences(jsonString);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        adapter = new Adapter(this, arrayList);
        listView.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (MainActivity.this, Addition.class);
                startActivity(i);
            }
        });
    }
}
