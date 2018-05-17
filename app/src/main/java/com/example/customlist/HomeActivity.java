package com.example.customlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;


public class HomeActivity extends AppCompatActivity {

    Toolbar mToolbar;
    ListView mListView;

    // hardcoded data
    String[] uploaderName = {"Ducks In Water", "Markeaton Park Lake", "Markeaton Campus Trees"};
    int[] pictureID = {
            R.drawable.ducks,
            R.drawable.lake,
            R.drawable.markeaton};
    String[] description = {"Ducks swimming at the Markeaton Park",
                            "Beautiful lake <3 :)", "River picture (with leaves aka trees)"};
    String[] username = {"d.voorhis", "BlackWidow7", "MrBradders"};
    String[] timestamp = {"16/05/2018", "14/05/2018", "13/05/2018"};
    int[] mapView = {R.drawable.map1, R.drawable.map2,R.drawable.map3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(mToolbar);

        mListView = (ListView) findViewById(R.id.listview);
        MyAdapter myAdapter = new MyAdapter(HomeActivity.this, uploaderName, pictureID, username, timestamp);
        mListView.setAdapter(myAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mIntent = new Intent(HomeActivity.this, DetailActivity.class);
                // pass the title, image, description, username, time
                mIntent.putExtra("Uploader", uploaderName[i]);
                mIntent.putExtra("Picture ID", pictureID[i]);
                mIntent.putExtra("Description", description[i]);
                mIntent.putExtra("mapID", mapView[i]);
                mIntent.putExtra("Username", username[i]);
                mIntent.putExtra("Timestamp", timestamp[i]);
                startActivity(mIntent);
            }
        });
    }

           @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Toast.makeText(this, "Home clicked",
                            Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, HomeActivity.class));
                    return true;
                case R.id.navigation_camera:
                    Toast.makeText(this, "Camera clicked",
                            Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, CameraActivity.class));
                    return true;
                case R.id.navigation_map_route:
                    Toast.makeText(this, "Route clicked",
                            Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, ImageDisplayActivity.class));
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.navigation, menu);

        return true;
    }
}
