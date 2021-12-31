package app.project.pomolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class ToDoListActivity extends AppCompatActivity {

    private ChipNavigationBar menuBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        getSupportActionBar().setTitle("To do list");
        menuBar = findViewById(R.id.navigation_bar_tasks);
        if (savedInstanceState == null) {
            menuBar.setItemSelected(R.id.menu_tasks, true);
        }
        setNavigationBar();
    }

    public static Intent launchIntent(Context context) {
        return new Intent(context, ToDoListActivity.class);
    }

    private void setNavigationBar() {
        menuBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                switch (i) {
                    case R.id.menu_timer:
                        Intent timerIntent = TimerActivity.launchIntent(ToDoListActivity.this);
                        timerIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(timerIntent);
                        break;
                    case R.id.menu_tasks:
                        break;
                    case R.id.menu_settings:
                        Intent settingIntent = SettingsActivity.launchIntent(ToDoListActivity.this);
                        settingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(settingIntent);
                        break;
                }
            }
        });
    }
}