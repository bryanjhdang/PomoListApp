package app.project.pomolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * Activity shows a list of tasks.
 * User is able to add and edit tasks.
 */
public class ToDoListActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private final String ADD_TASK = "Add";
    private final String EDIT_TASK = "Edit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        setActionBar();

        BottomNavigationView menuBar = findViewById(R.id.navigation_bar_tasks);
        menuBar.setOnNavigationItemSelectedListener(this);

        addTaskButton();
    }

    public static Intent launchIntent(Context context) {
        return new Intent(context, ToDoListActivity.class);
    }

    private void setActionBar() {
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.to_do_list_title);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_timer:
                Intent timerIntent = TimerActivity.launchIntent(ToDoListActivity.this);
                timerIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(timerIntent);
                return true;
            case R.id.menu_tasks:
                return true;
            case R.id.menu_settings:
                Intent settingIntent = SettingsActivity.launchIntent(ToDoListActivity.this);
                settingIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(settingIntent);
                return true;
        }

        return false;
    }

    private final void addTaskButton() {
        FloatingActionButton addTaskButton = findViewById(R.id.addTaskButton);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = ConfigureTaskActivity.launchIntent(ToDoListActivity.this, ADD_TASK);
                startActivity(intent);
            }
        });
    }


}