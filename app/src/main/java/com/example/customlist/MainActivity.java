package com.example.customlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button imageDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(navListener);

        imageDisplay = (Button)findViewById(R.id.btnImageDisplay);

        onImageDisplayButtonClick();
    }

    public void onImageDisplayButtonClick(){
        imageDisplay.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, ImageDisplayActivity.class));
                    }
                }
        );
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    Fragment selectedFragment = null;

//                    switch (item.getItemId()) {
//                        case R.id.navigation_home:
//                            selectedFragment = new HomePage();
//                            break;
//                        case R.id.navigation_maps:
//                            selectedFragment = new Profile();
//                            break;
//                        case R.id.navigation_camera:
//                            selectedFragment = new fitnessAssessment();
//                            break;
//                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };
}
