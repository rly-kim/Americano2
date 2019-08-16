package com.example.americano;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StoreActivity extends AppCompatActivity {
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("홍대 스타벅스");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF87CEFA));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.store_layout);
        textview = (TextView) findViewById(R.id.textview);
        Intent intent = getIntent();
        textview.setText(intent.getStringExtra("nameText").toString());

        ImageButton callBut = (ImageButton) findViewById(R.id.callBut);
        callBut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent calling = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01012341234"));
                startActivity(calling);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home){
            super.onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}