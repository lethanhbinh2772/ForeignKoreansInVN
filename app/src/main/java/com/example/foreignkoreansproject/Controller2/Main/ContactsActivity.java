package com.example.foreignkoreansproject.Controller2.Main;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.foreignkoreansproject.Controller2.Main.Adapter.ContactsAdapter;
import com.example.foreignkoreansproject.Model.Contact;
import com.example.foreignkoreansproject.Model.ContactResult;
import com.example.foreignkoreansproject.R;
import com.example.foreignkoreansproject.Utils.Utils;
import com.google.gson.Gson;

public class ContactsActivity extends AppCompatActivity {
    RecyclerView rvContacts;
    Contact contact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        String strContacts = Utils.loadJSONFromAssetContact(this);
        Gson gson = new Gson();
        contact = gson.fromJson(strContacts, Contact.class);
        init();
        configRvContacts();
    }

    private void configRvContacts() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvContacts.setLayoutManager(linearLayoutManager);
        ContactsAdapter contactsAdapter = new ContactsAdapter();
        contactsAdapter.setData(contact.getContactResult());
        contactsAdapter.setContext(this);
        rvContacts.setAdapter(contactsAdapter);

    }
    private void init(){
        rvContacts = findViewById(R.id.rv_contacts);
    }

}
