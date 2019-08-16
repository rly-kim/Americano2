package com.example.americano;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class FavoriteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle) {
        super .onCreate(bundle);
        setContentView(R.layout.activity_favorite);
        Intent intent = getIntent();

    }
}
