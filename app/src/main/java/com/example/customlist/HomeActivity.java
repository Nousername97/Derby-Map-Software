package com.example.customlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class HomeActivity extends Activity {

    Toolbar mToolbar;
    ListView mListView;

    String[] uploaderName = {"Bridge", "water"};
    int[] pictureID = {
            R.drawable.bridge,
            R.drawable.waterfall};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(getResources().getString(R.string.app_name));
        mListView = (ListView) findViewById(R.id.listview);
        MyAdapter myAdapter = new MyAdapter(HomeActivity.this, uploaderName, pictureID);
        mListView.setAdapter(myAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mIntent = new Intent(HomeActivity.this, DetailActivity.class);
                mIntent.putExtra("Uploader", uploaderName[i]);
                mIntent.putExtra("Picture ID", pictureID[i]);
                startActivity(mIntent);
            }
        });
    }
}
