package com.example.foreignkoreansproject.Controller2.Main;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.foreignkoreansproject.Controller2.Main.Adapter.ContactsAdapter;
import com.example.foreignkoreansproject.Controller2.Main.Adapter.PromotionAdapter;
import com.example.foreignkoreansproject.Model.Contact;
import com.example.foreignkoreansproject.Model.Promotion;
import com.example.foreignkoreansproject.R;
import com.example.foreignkoreansproject.Utils.Utils;
import com.google.gson.Gson;

public class PromotionActivity extends AppCompatActivity {

    RecyclerView rvPromotion;
    Promotion promotion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        String strPromotion = Utils.loadJSONFromAssetPromotion(this);
        Gson gson = new Gson();
        promotion = gson.fromJson(strPromotion, Promotion.class);
        init();
        configRvPromotion();
    }

    private void configRvPromotion() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvPromotion.setLayoutManager(linearLayoutManager);
        PromotionAdapter promotionAdapter = new PromotionAdapter();
        promotionAdapter.setData(promotion.getResult());
        promotionAdapter.setContext(this);
        rvPromotion.setAdapter(promotionAdapter);
    }
    private void init(){
        rvPromotion = findViewById(R.id.rv_promotion);
    }
}

