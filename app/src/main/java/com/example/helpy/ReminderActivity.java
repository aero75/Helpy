package com.example.helpy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;

import com.example.helpy.logic.ReminderList;
import com.example.helpy.logic.Reminders;

public class ReminderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final ReminderList list = new ReminderList();
        ImageButton add = findViewById(R.id.addReminder);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.noReminder).setVisibility(View.INVISIBLE);
                final Reminders reminders = new Reminders();
                handleDate(reminders);
                AlertDialog.Builder builder = new AlertDialog.Builder(ReminderActivity.this);
                builder.setTitle("What do you wanna be reminded of?");

// Set up the input
                final EditText input = new EditText(ReminderActivity.this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);

// Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        reminders.setRemind(input.getText().toString());
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
                list.addReminder(reminders);
            }

        });
    }

    public void handleDate(final Reminders reminder) {
        Calendar calendar = Calendar.getInstance();

        int YEAR = calendar.get(Calendar.YEAR);
        int MONTH = calendar.get(Calendar.MONTH);
        int DAY = calendar.get(Calendar.DATE);

        DatePickerDialog picker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                reminder.setDate(dayOfMonth);
                reminder.setMonth(month + 1);
                reminder.setYear(year);
            }
        }, YEAR, MONTH, DAY);
        picker.show();
    }

    public void showReminders() {

    }
}
