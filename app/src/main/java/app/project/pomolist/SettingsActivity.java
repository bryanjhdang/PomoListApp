package app.project.pomolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SettingsActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        getSupportActionBar().setTitle("Settings");
        BottomNavigationView menuBar = findViewById(R.id.navigation_bar_settings);
        menuBar.setOnNavigationItemSelectedListener(this);
    }

    public static Intent launchIntent(Context context) {
        return new Intent(context, SettingsActivity.class);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_timer:
                Intent timerIntent = TimerActivity.launchIntent(SettingsActivity.this);
                startActivity(timerIntent);
                return true;
            case R.id.menu_tasks:
                Intent taskIntent = ToDoListActivity.launchIntent(SettingsActivity.this);
                startActivity(taskIntent);
                return true;
            case R.id.menu_settings:
                return true;
        }

        return false;
    }
}