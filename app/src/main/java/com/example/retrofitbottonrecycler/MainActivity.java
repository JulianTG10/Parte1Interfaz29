package com.example.retrofitbottonrecycler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    PrincipalFragment homeFragment = new PrincipalFragment();
    SecondFragment secondFragment = new SecondFragment();
    OtroFragment otroFragment = new OtroFragment();

    private void loadFragment (Fragment fr){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container,fr);
        transaction.commit();




    }
private void selectionFr (BottomNavigationView navigation){
navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.first:
                loadFragment(homeFragment);
                return true;
            case R.id.second:
                loadFragment(secondFragment);
                return true;
            case R.id.third:
                loadFragment(otroFragment);
                return true;



        }
        return true;
    }
});

}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        selectionFr(navigationView);
        loadFragment(homeFragment);
    }
}