package app.project.pomolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.Objects;

/**
 * Activity allows the user to edit the fields of a task, save options, and remove a task.
 */
public class ConfigureTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configure_task);

        setActionBar();
    }

    public static Intent launchIntent(Context context) {
        return new Intent(context, ConfigureTaskActivity.class);
    }

    private void setActionBar() {
        // TODO: detect if editing or adding task
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.add_task_title);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }
}