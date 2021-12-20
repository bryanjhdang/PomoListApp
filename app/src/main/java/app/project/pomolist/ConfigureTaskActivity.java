package app.project.pomolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

/**
 * Activity allows the user to edit the fields of a task, save options, and remove a task.
 */
public class ConfigureTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configure_task);

        hideActionBar();

        setConfirmationButtons();
    }

    public static Intent launchIntent(Context context) {
        return new Intent(context, ConfigureTaskActivity.class);
    }

    private void hideActionBar() {
        getSupportActionBar().hide();
    }

    private void setConfirmationButtons() {
        setCancelButton();
        setSaveButton();
    }

    private void setCancelButton() {
        Button cancelButton = findViewById(R.id.cancelTaskButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setSaveButton() {
        Button saveButton = findViewById(R.id.saveTaskButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (allInfoIsValid()) {
                    addTask();
                    finish();
                } else {
                    showToastWarning();
                }
            }
        });
    }

    private boolean allInfoIsValid() {
        return true;
    }

    private void addTask() {

    }

    private void showToastWarning() {
        String warning = "Not all info is valid!";
        Toast.makeText(getApplicationContext(), warning, Toast.LENGTH_SHORT)
                .show();
    }



}