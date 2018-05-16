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



import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends Activity {

public class HomeActivity extends AppCompatActivity {


    Toolbar mToolbar;
    ListView mListView;

    String[] uploadName = {"Bridge", "water"};
    int[] pictureID = {
            R.drawable.bridge,
            R.drawable.waterfall};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        List<String> listContent = new ArrayList<String>();
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(mToolbar);

        mListView = (ListView) findViewById(R.id.listview);
        MyAdapter myAdapter = new MyAdapter(HomeActivity.this, uploadName, pictureID);
        mListView.setAdapter(myAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mIntent = new Intent(HomeActivity.this, DetailActivity.class);
                mIntent.putExtra("Uploader", uploadName[i]);
                mIntent.putExtra("Picture ID", pictureID[i]);
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
                return true;
            case R.id.navigation_camera:
                Toast.makeText(this, "Camera clicked",
                        Toast.LENGTH_SHORT).show();
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
