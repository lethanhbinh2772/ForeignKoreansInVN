package com.example.foreignkoreansproject.Controller2.Main;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.foreignkoreansproject.R;

public class MainActivity extends AppCompatActivity {
    LinearLayout lnToContactsActivity;
    LinearLayout lnToPlacesActivity;
    LinearLayout lnToPromotionActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        init();
        toContactsActivity();
        toPlacesActivity();
        toPromotionActivity();
    }
    private void init() {
        lnToContactsActivity = findViewById(R.id.ln_contact);
        lnToPlacesActivity = findViewById(R.id.ln_places);
        lnToPromotionActivity = findViewById(R.id.ln_promotion);
    }

    private void toContactsActivity() {
        lnToContactsActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ContactsActivity.class);
                startActivity(intent);
            }
        });

    }
    private void toPromotionActivity(){
        lnToPlacesActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PlacesActivity.class);
                startActivity(intent);
            }
        });


    }
    private void toPlacesActivity(){
        lnToPromotionActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PromotionActivity.class);
                startActivity(intent);
            }
        });


    }
}
