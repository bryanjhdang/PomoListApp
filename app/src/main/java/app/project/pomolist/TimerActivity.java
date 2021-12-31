package app.project.pomolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

/**
 * Activity shows the graphical timer and list view of tasks.
 */
public class TimerActivity extends AppCompatActivity {

    private ChipNavigationBar menuBar;
    private final long TIME_MILLI_SECS = 60000;
    private ProgressBar progressBar;
    private TextView timerText;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        getSupportActionBar().setTitle("Timer");
        menuBar = findViewById(R.id.navigation_bar_timer);
        if (savedInstanceState == null) {
            menuBar.setItemSelected(R.id.menu_timer, true);
        }
        setNavigationBar();

        initViews();
    }

    private void initViews() {
        progressBar = findViewById(R.id.progressBarTimer);
        timerText = findViewById(R.id.textViewTime);
    }

    public static Intent launchIntent(Context context) {
        return new Intent(context, TimerActivity.class);
    }

    private void setNavigationBar() {
        menuBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                switch (i) {
                    case R.id.menu_timer:
                        break;
                    case R.id.menu_tasks:
                        Intent taskIntent = ToDoListActivity.launchIntent(TimerActivity.this);
                        taskIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(taskIntent);
                        break;
                    case R.id.menu_settings:
                        Intent settingIntent = SettingsActivity.launchIntent(TimerActivity.this);
                        settingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(settingIntent);
                        break;
                }
            }
        });
    }
}