package com.example.helpy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;

import com.example.helpy.logic.ReminderList;
import com.example.helpy.logic.Reminders;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class ReminderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final ReminderList list = new ReminderList();
        ImageButton add = findViewById(R.id.addReminder);
        final ChipGroup remGroup = findViewById(R.id.reminderChips);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.noReminder).setVisibility(View.INVISIBLE);
                Reminders reminders = new Reminders();
                handleDate(reminders);

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

}
