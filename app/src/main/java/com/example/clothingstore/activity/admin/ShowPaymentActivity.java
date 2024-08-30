package com.example.clothingstore.activity.admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.clothingstore.R;
import com.example.clothingstore.adapter.AdminBillAdapter;
import com.example.clothingstore.dbhelper.BillDbHelper;
import com.example.clothingstore.entity.Bill;

import java.util.ArrayList;

public class ShowPaymentActivity extends AppCompatActivity {

    ListView listView;
    ImageView btnback;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_payment);
        
        BillDbHelper billDbHelper = new BillDbHelper(this);
        ArrayList<Bill> bills = billDbHelper.getAllUnpaidBills();
        AdminBillAdapter adapter = new AdminBillAdapter(this, R.layout.admin_payment_listview, bills);
        listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);

        btnback = findViewById(R.id.btnBack);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowPaymentActivity.this, DashBoard.class);
                startActivity(intent);
            }
        });
    }
}