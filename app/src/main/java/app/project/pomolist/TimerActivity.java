package app.project.pomolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * Activity shows the graphical timer.
 */
public class TimerActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        BottomNavigationView menuBar = findViewById(R.id.navigation_bar);
        menuBar.setOnNavigationItemSelectedListener(this);
    }

    public static Intent launchIntent(Context context) {
        return new Intent(context, TimerActivity.class);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.menu_timer:
                return true;
            case R.id.menu_tasks:
                ToDoListActivity.launchIntent(TimerActivity.this);
            case R.id.menu_settings:
                SettingsActivity.launchIntent(TimerActivity.this);
        }

        return false;
    }
}