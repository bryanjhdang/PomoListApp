package app.project.pomolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

/**
 * Activity shows the graphical timer and list view of tasks.
 */
public class TimerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        getSupportActionBar().setTitle("Timer");
        setNavigationBar();
    }

    public static Intent launchIntent(Context context) {
        return new Intent(context, TimerActivity.class);
    }

    private void setNavigationBar() {
        ChipNavigationBar menuBar = findViewById(R.id.navigation_bar_timer);
        menuBar.setItemSelected(R.id.menu_timer, true);
        menuBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                switch (i) {
                    case R.id.menu_timer:
                        break;
                    case R.id.menu_tasks:
                        Intent taskIntent = ToDoListActivity.launchIntent(TimerActivity.this);
                        //taskIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        taskIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        menuBar.setItemSelected(R.id.menu_tasks, true);
                        startActivity(taskIntent);
                        break;
                    case R.id.menu_settings:
                        Intent settingIntent = SettingsActivity.launchIntent(TimerActivity.this);
                        //settingIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        settingIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        menuBar.setItemSelected(R.id.menu_settings, true);
                        startActivity(settingIntent);
                        break;
                }
            }
        });
    }
}