package com.example.p1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.p1.room.student;
import com.example.p1.room.AppDatabase;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //declare valriable
    Button saveButton;
    EditText st_name,st_id;

    //for databse
    AppDatabase db;



    //temporary memory- array
    // Static list to hold data temporarily (in memory)
    public static ArrayList<String> studentList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        //take information from xml file
        st_name = findViewById(R.id.name);
        st_id = findViewById(R.id.id);
        saveButton = findViewById(R.id.save);


        //when button click call function
        //saveButton.setOnClickListener(v -> save());



        db = AppDatabase.getInstance(this);

        saveButton.setOnClickListener(v -> {
            String name = st_name.getText().toString();
            String studentId = st_id.getText().toString();

            if (name.isEmpty() || studentId.isEmpty()) {
                Toast.makeText(this, "Please enter name and ID", Toast.LENGTH_SHORT).show();
            } else {
                student student = new student(name, studentId);
                db.studentDao().insertStudent(student);
                Toast.makeText(this, "Student Saved!", Toast.LENGTH_SHORT).show();

                st_name.setText("");
                st_id.setText("");
            }
        });
    }

    //start new activity and pass the data into second
    //activity with intent
 /*   public void click(){
        String name = st_name.getText().toString().trim();
        String studentId = st_id.getText().toString().trim();

       Intent intent = new Intent(MainActivity.this,Activity_2.class);
       intent.putExtra("s_name",name);
       intent.putExtra("s_id",studentId);

       startActivity(intent);

    }
*/

    //start second activity
  /*  public void display(){
        Intent intent = new Intent(MainActivity.this,Activity_2.class);
            startActivity(intent);

    }*/

    //save student  information into array
    public void save(){

        String name = st_name.getText().toString().trim();
        String studentId = st_id.getText().toString().trim();

        if (!name.isEmpty() && !studentId.isEmpty()) {
            String entry = "Name: " + name + " | ID: " + studentId;
            studentList.add(entry);

            // clear input fields
            st_name.setText("");
            st_id.setText("");
        }

    }

    // Step 1: Inflate the menu
    //create manu
    // right click - res folder- android res direcotory-menu
    //click on menu - menu reso file
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    // Step 2: Handle menu item click
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_view_students) {
            Intent intent = new Intent(MainActivity.this, Activity_2.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
