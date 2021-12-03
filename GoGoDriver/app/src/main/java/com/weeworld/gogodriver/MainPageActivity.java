package com.weeworld.gogodriver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.weeworld.gogodriver.Fragment.AccountFragment;
import com.weeworld.gogodriver.Fragment.ChatFragment;
import com.weeworld.gogodriver.Fragment.CheckListOrderFragment;
import com.weeworld.gogodriver.Fragment.ListOrderFragment;
import com.weeworld.gogodriver.Fragment.WalletFragment;

public class MainPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomMenu_Page);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new CheckListOrderFragment());

        bottomNavigationView.setSelectedItemId(R.id.list_order_check);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.list_order_check:
                        selectedFragment = new CheckListOrderFragment();
                        break;
                    case R.id.show_list_order:
                        selectedFragment = new ListOrderFragment();
                        break;
                    case R.id.chat_helper:
                        selectedFragment = new ChatFragment();
                        break;
                    case R.id.wallet_helper:
                        selectedFragment = new WalletFragment();
                        break;
                    case R.id.profile_helper:
                        selectedFragment = new AccountFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,
                        selectedFragment).commit();
                return true;
            }

        });

    }
}