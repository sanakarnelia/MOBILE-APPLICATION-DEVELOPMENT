package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public static final String TAG ="Activity_Lifecycle";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        Log.d(TAG, "onCreate: Activity 1");


        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            //navigate from activity 1 to activity 2
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("name", "app demo2");
            startActivity(intent);


            Toast.makeText(this, "button clicked", Toast.LENGTH_LONG).show();




           });

        }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart: Activity 1");
    }


    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume: Activity 1");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause: Activity 1");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: Activity 1");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy: Activity 1");
    }
}



