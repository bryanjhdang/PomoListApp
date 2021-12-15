package app.project.pomolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        launchTimerActivity();
    }

    private void launchTimerActivity() {
        Intent intent = TimerActivity.launchIntent(MainActivity.this);
        startActivity(intent);
    }
}