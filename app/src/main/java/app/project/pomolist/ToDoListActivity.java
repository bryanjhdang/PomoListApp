package app.project.pomolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ToDoListActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        getSupportActionBar().setTitle("To do list");
        BottomNavigationView menuBar = findViewById(R.id.navigation_bar_tasks);
        menuBar.setOnNavigationItemSelectedListener(this);
    }

    public static Intent launchIntent(Context context) {
        return new Intent(context, ToDoListActivity.class);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_timer:
                Intent timerIntent = TimerActivity.launchIntent(ToDoListActivity.this);
                finish();
                startActivity(timerIntent);
                return true;
            case R.id.menu_tasks:
                return true;
            case R.id.menu_settings:
                Intent settingIntent = SettingsActivity.launchIntent(ToDoListActivity.this);
                finish();
                startActivity(settingIntent);
                return true;
        }

        return false;
    }
}