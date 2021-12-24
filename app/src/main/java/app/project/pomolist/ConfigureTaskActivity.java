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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import app.project.pomolist.control.TaskManager;
import app.project.pomolist.model.Task;

/**
 * Activity allows the user to edit the fields of a task, save options, and remove a task.
 */
public class ConfigureTaskActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    TaskManager taskManager = TaskManager.getInstance();
    private DatePicker datePicker;

    private final String NO_DATE = "No date";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configure_task);
        hideActionBar();

        setDatePicker();
        setNoDateOption();
        setConfirmationButtons();
    }

    public static Intent launchIntent(Context context) {
        return new Intent(context, ConfigureTaskActivity.class);
    }

    private void hideActionBar() {
        getSupportActionBar().hide();
    }

    // ***********************************************************
    // Let the user pick a date
    // ***********************************************************

    private void setDatePicker() {
        Button dateButton = findViewById(R.id.dateButton);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        ConfigureTaskActivity.this,
                        ConfigureTaskActivity.this,
                        Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MONTH),
                        Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
                );
                datePickerDialog.show();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = "month/day/year: " + month + "/" + dayOfMonth + "/" + year;

        TextView dateText = findViewById(R.id.dateText);
        dateText.setText(date);
    }

    private void setNoDateOption() {
        CheckBox noDueDateCheckBox = findViewById(R.id.noDueDate);
        noDueDateCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    TextView dateText = findViewById(R.id.dateText);
                    dateText.setText(NO_DATE);
                }
            }
        });
    }

    // ***********************************************************
    // Save and cancel button implementation
    // ***********************************************************

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

    private void addTask() {
        String taskName = getTaskNameFromInput();
        // TODO: Get date from datePicker and pass into list

        Task newTask = new Task(taskName, null);
        taskManager.addTask(newTask);
    }

    private boolean allInfoIsValid() {
        String taskName = getTaskNameFromInput();
        return TaskManager.isValidName(taskName);
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