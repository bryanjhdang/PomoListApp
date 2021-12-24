package app.project.pomolist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import app.project.pomolist.control.TaskManager;
import app.project.pomolist.model.Task;

/**
 * Activity allows the user to edit the fields of a task, save options, and remove a task.
 */
public class ConfigureTaskActivity extends AppCompatActivity {
    TaskManager taskManager = TaskManager.getInstance();

    private DatePickerDialog.OnDateSetListener dateDialog;
    private TimePickerDialog timeDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configure_task);

        hideActionBar();


        setDatePicker();
        setConfirmationButtons();
    }

    public static Intent launchIntent(Context context) {
        return new Intent(context, ConfigureTaskActivity.class);
    }

    private void hideActionBar() {
        getSupportActionBar().hide();
    }

    private void setDatePicker() {
        Button dateButton = findViewById(R.id.dateButton);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.YEAR);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ConfigureTaskActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dateDialog,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
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
        String taskName = getTaskNameFromInput();
        return TaskManager.isValidName(taskName);
    }

    private void addTask() {
        String taskName = getTaskNameFromInput();
        // TODO: Get date from datePicker and pass into list

        Task newTask = new Task(taskName, null);
        taskManager.addTask(newTask);
    }

    private void showToastWarning() {
        String warning = "Information is invalid!";
        Toast.makeText(getApplicationContext(), warning, Toast.LENGTH_SHORT)
                .show();
    }

    private String getTaskNameFromInput() {
        EditText taskName = findViewById(R.id.taskName);
        return taskName.getText().toString();
    }


}