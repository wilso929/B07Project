package com.example.b07project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class DisplayOwnerOrdersActivity extends AppCompatActivity {

    Owner owner;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_owner_orders);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        Intent intent = getIntent();
        if(intent.getExtras() !=null){
            owner = (Owner) intent.getSerializableExtra(DisplayOwnerActivity.Owner_Key);
        }

        if (owner != null){
            listview = findViewById(R.id.listview_ownerproducts);
            if (owner.getOrders().isEmpty()){
                ArrayList<String> strings = new ArrayList<>();
                strings.add("No Orders");
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strings);
                listview.setAdapter(adapter);
            }else{
                ArrayAdapter<Order> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, owner.orders);
                listview.setAdapter(adapter);
            }
        }
    }

    public void backButton(View view){
        Intent intent = new Intent(this, DisplayOwnerActivity.class);
        intent.putExtra(DisplayOwnerActivity.Owner_Key, (Serializable) this.owner);
        startActivity(intent);
    }

}