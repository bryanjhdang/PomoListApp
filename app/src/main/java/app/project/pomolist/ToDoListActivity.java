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

/**
 * Activity shows a list of tasks.
 * User is able to add and edit tasks.
 */
public class ToDoListActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        BottomNavigationView menuBar = findViewById(R.id.navigation_bar_tasks);
        menuBar.setOnNavigationItemSelectedListener(this);

        setActionBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_to_do_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_to_do_list) {
            Intent intent = ConfigureTaskActivity.launchIntent(ToDoListActivity.this);
            startActivity(intent);
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_timer:
                Intent timerIntent = TimerActivity.launchIntent(ToDoListActivity.this);
                startActivity(timerIntent);
                return true;
            case R.id.menu_tasks:
                return true;
            case R.id.menu_settings:
                Intent settingIntent = SettingsActivity.launchIntent(ToDoListActivity.this);
                startActivity(settingIntent);
                return true;
        }

        return false;
    }

    public static Intent launchIntent(Context context) {
        return new Intent(context, ToDoListActivity.class);
    }

    private void setActionBar() {
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.to_do_list_title);
    }
}