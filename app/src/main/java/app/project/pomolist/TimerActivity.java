package app.project.pomolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

/**
 * Activity shows the graphical timer.
 */
public class TimerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        getSupportActionBar().setTitle("Timer");
        ChipNavigationBar menuBar = findViewById(R.id.navigation_bar_timer);

        if (savedInstanceState==null) {
            menuBar.setItemSelected(R.id.menu_timer, true);
        }
        menuBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                switch (i) {
                    case R.id.menu_timer:
                        break;
                    case R.id.menu_tasks:
                        Intent taskIntent = ToDoListActivity.launchIntent(TimerActivity.this);
                        startActivity(taskIntent);
                        break;
                    case R.id.menu_settings:
                        Intent settingIntent = SettingsActivity.launchIntent(TimerActivity.this);
                        startActivity(settingIntent);
                        break;
                }
            }
        });
    }

    public static Intent launchIntent(Context context) {
        return new Intent(context, TimerActivity.class);
    }
}