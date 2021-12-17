package app.project.pomolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setAllNavigationButtons();
    }

    private void setAllNavigationButtons() {
        setTimerButton();
        setToDoListButton();
        setSettingsButton();
    }

    private void setTimerButton() {
        Button button = findViewById(R.id.timerBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchTimerActivity();
            }
        });
    }

    private void setToDoListButton() {
        Button button = findViewById(R.id.todolistBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchToDoListActivity();
            }
        });
    }

    private void setSettingsButton() {
        Button button = findViewById(R.id.settingsBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchSettingsActivity();
            }
        });
    }

    private void launchTimerActivity() {
        Intent intent = TimerActivity.launchIntent(MainActivity.this);
        startActivity(intent);
    }

    private void launchToDoListActivity() {
        Intent intent = ToDoListActivity.launchIntent(MainActivity.this);
        startActivity(intent);
    }

    private void launchSettingsActivity() {
        Intent intent = SettingsActivity.launchIntent(MainActivity.this);
        startActivity(intent);
    }
}