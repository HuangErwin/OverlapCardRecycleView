package com.bfmehuang.overlapcardrecycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private OverlapCardRecycleView mRecyclerView;
    private CustomAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(String.valueOf(i));
        }

        mRecyclerView = (OverlapCardRecycleView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new CustomLayoutManager());
        mAdapter = new CustomAdapter(this,list);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setRemovedListener(new OverlapCardRemovedListener() {
            @Override
            public void onRightRemoved() {
                Toast.makeText(MainActivity.this, list.get(list.size() - 1) + " was right removed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLeftRemoved() {
                Toast.makeText(MainActivity.this, list.get(list.size() - 1) + " was left removed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
