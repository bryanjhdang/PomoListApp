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

        getSupportActionBar().setTitle("Timer");
        BottomNavigationView menuBar = findViewById(R.id.navigation_bar_timer);
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
                Intent taskIntent = ToDoListActivity.launchIntent(TimerActivity.this);
                taskIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(taskIntent);
                return true;
            case R.id.menu_settings:
                Intent settingIntent = SettingsActivity.launchIntent(TimerActivity.this);
                settingIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(settingIntent);
                return true;
        }

        return false;
    }
}