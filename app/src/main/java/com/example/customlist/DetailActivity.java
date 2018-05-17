package com.example.customlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    Toolbar mToolbar;
    ImageView mImageView;
    TextView mDescription;
    TextView mTimestamp;
    TextView mUsername;
    ImageView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mToolbar = (Toolbar) findViewById(R.id.toolbar2);
        mImageView = (ImageView) findViewById(R.id.imageView2);
        mDescription = (TextView) findViewById(R.id.tvDescription);
//        mUsername = (TextView) findViewById(R.id.tvUsername);
//        mTimestamp = (TextView) findViewById(R.id.tvTimestamp);
        mapView = (ImageView) findViewById(R.id.imageViewMap);

        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            mToolbar.setTitle(mBundle.getString("Uploader"));
            mImageView.setImageResource(mBundle.getInt("Picture ID"));
            mDescription.setText(mBundle.getString("Description"));
//            mUsername.setText(mBundle.getString("Username"));
//            mTimestamp.setText(mBundle.getString("Timestamp"));
            mapView.setImageResource(mBundle.getInt("mapID"));
        }
    }
}
