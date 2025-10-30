package com.example.lab1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailsActivity extends AppCompatActivity  implements View.OnClickListener {


    @Override
    public void onClick(View v) {
        int id=v.getId();
        Intent intent =null;


        if(id == R.id.button1){
            //open yahoo website
            intent =new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("http://yahoo.com")
            );
            startActivity(intent);
            return;
        }


        if(id == R.id.button2){
            //phone call
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
               !=PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(
                        this,
                        new String[] {Manifest.permission.CALL_PHONE},
                        1

                );
            }else
            {
                callDummyNumber( );
            }
        }
    }

    private void callDummyNumber( ) {

        Intent intent = new Intent(
                Intent.ACTION_CALL,
                Uri.parse("tel:55555555")

        );
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                callDummyNumber();
            }
            else{
                Toast.makeText(this,"permision denied",Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Log.d(MainActivity.TAG, "onCreate: Activity 2");


        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        TextView textview = findViewById(R.id.name);
        textview.setText(name);


        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
    }


    @Override
    protected void onStart(){
        super.onStart();
        Log.d(MainActivity.TAG, "onStart: Activity 2");
    }


    @Override
    protected void onResume(){
        super.onResume();
        Log.d(MainActivity.TAG, "onResume: Activity 2");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(MainActivity.TAG, "onPause: Activity 2");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(MainActivity.TAG, "onStop: Activity 2");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(MainActivity.TAG,"onDestroy: Activity 2");
    }




}
