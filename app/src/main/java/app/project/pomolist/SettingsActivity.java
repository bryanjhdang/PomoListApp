package app.project.pomolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class SettingsActivity extends AppCompatActivity {

    private ChipNavigationBar menuBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        getSupportActionBar().setTitle("Settings");
        menuBar = findViewById(R.id.navigation_bar_settings);
        if (savedInstanceState == null) {
            menuBar.setItemSelected(R.id.menu_settings, true);
        }
        setNavigationBar();
    }

    public static Intent launchIntent(Context context) {
        return new Intent(context, SettingsActivity.class);
    }

    private void setNavigationBar() {
        menuBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                switch (i) {
                    case R.id.menu_timer:
                        Intent timerIntent = TimerActivity.launchIntent(SettingsActivity.this);
                        timerIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(timerIntent);
                        break;
                    case R.id.menu_tasks:
                        Intent taskIntent = ToDoListActivity.launchIntent(SettingsActivity.this);
                        taskIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(taskIntent);
                        break;
                    case R.id.menu_settings:
                        break;
                }
            }
        });
    }
}