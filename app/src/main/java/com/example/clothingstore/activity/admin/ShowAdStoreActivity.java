package com.example.clothingstore.activity.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.clothingstore.adapter.StoreAdapter;
import com.example.clothingstore.dbhelper.StoreDbHelper;
import com.example.clothingstore.R;
import com.example.clothingstore.adapter.StoreAdapter;
import com.example.clothingstore.dbhelper.StoreDbHelper;
import com.example.clothingstore.entity.Store;

import java.util.ArrayList;

public class ShowAdStoreActivity extends AppCompatActivity {

    ListView listView;
    ImageView back;
    Button crud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_ad_store);

        StoreDbHelper storeDbHelper = new StoreDbHelper(this);
        ArrayList<Store> stores = storeDbHelper.getAllStores();
        StoreAdapter adapter = new StoreAdapter(this, R.layout.admin_store_listview, stores);
        listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);

        back = findViewById(R.id.btnBackToDashboard);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowAdStoreActivity.this, DashBoard.class);
                startActivity(intent);
            }
        });

        crud = findViewById(R.id.btnCRUDStore);
        crud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowAdStoreActivity.this, AdminStoreActivity.class);
                startActivity(intent);
            }
        });
    }
}