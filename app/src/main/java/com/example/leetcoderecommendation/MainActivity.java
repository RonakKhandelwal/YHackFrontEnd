package com.example.leetcoderecommendation;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import io.kommunicate.Kommunicate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    final String APP_ID = BuildConfig.APP_ID;
    final String API_KEY = "lkNbH2bwdOGvD8fTVPqlTWfcYbs6Afff";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        //
        Kommunicate.init(this, APP_ID);

        //Usage Instance
        /*
        NetworkTask.getRecommendations(new Callback<List<Recommendation>>() {
            @Override
            public void returnResult(List<Recommendation> recommendations) {
                //Do something with the result. Remember this is the main thread
            }

            @Override
            public void returnError(String message) {
                //DO something with the error
            }
        });
         */
    }

}
