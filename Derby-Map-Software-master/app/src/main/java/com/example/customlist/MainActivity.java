package com.example.customlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button imageDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}
