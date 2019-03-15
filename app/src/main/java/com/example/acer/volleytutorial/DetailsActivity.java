package com.example.acer.volleytutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity
{
    ImageView detimage;
    TextView t1,t2,t3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        detimage=findViewById(R.id.detailimage);
        t1=findViewById(R.id.detailtitle);
        t2=findViewById(R.id.detailauthor);
        t3=findViewById(R.id.detaildesc);
        Picasso.with(this).load(getIntent().getStringExtra("image")).into(detimage);
        t1.setText(getIntent().getStringExtra("title"));
        t2.setText(getIntent().getStringExtra("author"));
        t3.setText(getIntent().getStringExtra("description"));
    }
}
