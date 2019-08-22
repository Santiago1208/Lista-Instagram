package com.mocte.listainstagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView postList;

    private PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postList = findViewById(R.id.posts_list);
        postAdapter = new PostAdapter();
        postList.setAdapter(postAdapter);
    }
}
