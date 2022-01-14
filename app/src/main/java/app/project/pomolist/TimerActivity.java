package app.project.pomolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

/**
 * Activity shows the graphical timer and list view of tasks.
 */
public class TimerActivity extends AppCompatActivity {

    private ChipNavigationBar menuBar;
    private final long STUDY_TIME_MILLI_SECS = 30000;
    private final long BREAK_TIME_MILLI_SECS = 5000;
    private long countDownTime;
    private ProgressBar progressBar;
    private TextView timerText;
    private CountDownTimer countDownTimer;
    private ToggleButton statusToggleBtn;
    private TextView statusTxt;
    private Switch statusAutoSwitch;
    private Button resetBtn;
    private Button startBtn;
    private ListView tasksList;

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
        setStatusToggleButton();
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

    private void initViews() {
        countDownTime = STUDY_TIME_MILLI_SECS;
        progressBar = findViewById(R.id.progressBarTimer);
        timerText = findViewById(R.id.textViewTime);
        statusToggleBtn = findViewById(R.id.toggleStatusButton);
        statusTxt = findViewById(R.id.statusTextView);
        statusAutoSwitch = findViewById(R.id.autoSwitch);
        resetBtn = findViewById(R.id.resetButton);
        startBtn = findViewById(R.id.startButton);
        tasksList = findViewById(R.id.tasksListView);
    }

    private void setStatusToggleButton() {
        statusToggleBtn.setText("Break");
        statusToggleBtn.setTextOff("Break");
        statusToggleBtn.setTextOn("Pomodoro");

        statusToggleBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    statusTxt.setText("BREAK");
                    timerText.setText("05:00");
                    countDownTime = BREAK_TIME_MILLI_SECS;
                } else {
                    statusTxt.setText("STUDY");
                    timerText.setText("30:00");
                    countDownTime = STUDY_TIME_MILLI_SECS;
                }
            }
        });
    }

    private void setButtonsListener() {
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPauseTimer();
            }
        });
    }

    private void resetTimer() {
        //stopCountDownTimer();
        //startCountDownTimer();
    }

    private void startPauseTimer() {
        setProgressBarValues();
        startCountDownTimer();
    }

    private void startCountDownTimer() {
        /*countDownTimer = new CountDownTimer(timeCountInMilliSeconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                textViewTime.setText(hmsTimeFormatter(millisUntilFinished));

                progressBarCircle.setProgress((int) (millisUntilFinished / 1000));

            }

            @Override
            public void onFinish() {

                textViewTime.setText(hmsTimeFormatter(timeCountInMilliSeconds));
                // call to initialize the progress bar values
                setProgressBarValues();
                // hiding the reset icon
                imageViewReset.setVisibility(View.GONE);
                // changing stop icon to start icon
                imageViewStartStop.setImageResource(R.drawable.icon_start);
                // making edit text editable
                editTextMinute.setEnabled(true);
                // changing the timer status to stopped
                timerStatus = TimerStatus.STOPPED;
            }

        }.start();
        countDownTimer.start();*/


        countDownTimer = new CountDownTimer(countDownTime, 1000) {
            @Override
            public void onTick(long millisTillFinishes) {
                progressBar.setProgress((int) (millisTillFinishes));
            }

            @Override
            public void onFinish() {
                setProgressBarValues();
            }
        }.start();
        countDownTimer.start();
    }

    private void setProgressBarValues() {

        progressBar.setMax((int) countDownTime / 1000);
        progressBar.setProgress((int) countDownTime / 1000);
    }
}