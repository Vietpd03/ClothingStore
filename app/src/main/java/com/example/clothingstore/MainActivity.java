package com.example.clothingstore;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.clothingstore.activity.admin.DashBoard;
import com.example.clothingstore.fragment.CartFragment;
import com.example.clothingstore.fragment.DiscountFragment;
import com.example.clothingstore.fragment.HomeFragment;
import com.example.clothingstore.fragment.MenuFragment;
import com.example.clothingstore.fragment.NotificationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.clothingstore.activity.admin.DashBoard;
import com.example.clothingstore.fragment.CartFragment;
import com.example.clothingstore.fragment.DiscountFragment;
import com.example.clothingstore.fragment.HomeFragment;
import com.example.clothingstore.fragment.MenuFragment;
import com.example.clothingstore.fragment.NotificationFragment;
import com.example.clothingstore.utilities.AccountSessionManager;

public class MainActivity extends AppCompatActivity {
    public static Resources mainResources;
    public static final String NOTIFICATION_ACTION = "Notification Action";
    @SuppressLint("NonConstantResourceId")
    private final BottomNavigationView.OnNavigationItemSelectedListener
            onNavItemSelectedListener = item -> {
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.menuHome:
                fragment = new HomeFragment();
                loadFragment(fragment);
                return true;
            case R.id.menuCart:
                fragment = new CartFragment();
                loadFragment(fragment);
                return true;
            case R.id.menuAvatar:
                fragment = new MenuFragment();
                loadFragment(fragment);
                return true;
            case R.id.menuNotifications:
                fragment = new NotificationFragment();
                loadFragment(fragment);
                return true;
            case R.id.menuDiscount:
                fragment = new DiscountFragment();
                loadFragment(fragment);
                return true;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("admin", Context.MODE_PRIVATE);
        if (sharedPreferences.contains("Admin")) {
            if (!sharedPreferences.getString("Admin", "").equals("")) {
                Intent intent = new Intent(this, DashBoard.class);
                startActivity(intent);
            }
        }

        BottomNavigationView navigationView = this.findViewById(R.id.bottom_navbar);
        navigationView.setOnNavigationItemSelectedListener(onNavItemSelectedListener);

        if (savedInstanceState == null) {
            navigationView.setSelectedItemId(R.id.menuHome);
        }
        mainResources = getResources();
        AccountSessionManager.checkLogin(this);
        Intent intent = getIntent();
        String action = intent.getStringExtra("action");
        if (action != null && action.equals(NOTIFICATION_ACTION)) {
            navigationView.setSelectedItemId(R.id.menuNotifications);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.bottom_navbar, menu);
        return true;
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}