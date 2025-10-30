package com.example.p1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.example.p1.room.student;
import com.example.p1.room.AppDatabase;

import java.util.ArrayList;
import java.util.List;

public class Activity_2 extends AppCompatActivity {

    ListView listView;
    AppDatabase db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);


        //  Enable the back (up) button on the ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Student Information");
        }

        listView = findViewById(R.id.listview);
        db = AppDatabase.getInstance(this);

        List<student> students = db.studentDao().getAllStudents();
        List<String> displayList = new ArrayList<>();

        for (student s : students) {
            displayList.add(s.name + " - " + s.studentId);
        }
        // Use ArrayAdapter to show list items
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                displayList
        );

        listView.setAdapter(adapter);

    } // Handle click on back button in the ActionBar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // Go back to MainActivity
            finish(); // closes SecondActivity and returns to MainActivity
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}