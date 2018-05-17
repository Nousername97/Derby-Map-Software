package com.example.customlist;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageDisplayActivity extends AppCompatActivity {

    Toolbar mToolbar;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_display);

        mImageView = (ImageView) findViewById(R.id.imageViewMap);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(mToolbar);
    }

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
