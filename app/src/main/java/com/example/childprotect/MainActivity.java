package com.example.childprotect;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    TextView tv;
    String result = "{\n" +
            "  \"name\": \"Ahmed\",\n" +
            "  \"email\": \"Ahmed@gmail.com\",\n" +
            "  \"numOfChildren\": 2,\n" +
            "  \"children\": [\n" +
            "    {\n" +
            "        \"name\": \"Mohammed\",\n" +
            "        \"id\": 1\n" +
            "    },\n" +
            "    {\n" +
            "    \"name\": \"mustafa\",\n" +
            "    \"id\": 2\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    String name, email, numOfCh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "To add a new child", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = headerView.findViewById(R.id.mainAct_tv_name);
        TextView navUseremail = headerView.findViewById(R.id.mainAct_tv_email);
        TextView navUserch = headerView.findViewById(R.id.mainAct_tv_numOfChildren);
        try {
            JSONObject object = new JSONObject(result);
            name = object.getString("name");
            email = object.getString("email");
            numOfCh = object.getString("numOfChildren");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        navUsername.setText(name);
        navUseremail.setText(email);
        navUserch.setText("numOfChildren: " + numOfCh);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_children, R.id.nav_share)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
