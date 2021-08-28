package com.example.labtask3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // get the reference of Toolbar
        setSupportActionBar(toolbar);

       EditText enteredNumber = findViewById(R.id.number); //Get input Number
        ImageView imageCall = findViewById(R.id.call); //Get id of the Call button

        imageCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = enteredNumber.getText().toString();
                if (number.trim().length() > 10) {
                    String dial = "tel:" + number;
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                } else {
                    Toast.makeText(MainActivity.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.home)
        {
            Toast.makeText(this, "Home Clicked", Toast.LENGTH_SHORT).show();
        }

        else if (itemId == R.id.about)
        {
            Toast.makeText(this, "About Clicked", Toast.LENGTH_SHORT).show();
        }
        else if (itemId == R.id.services)
        {
            Toast.makeText(this, "Service Clicked", Toast.LENGTH_SHORT).show();
        }
        else if (itemId == R.id.contact)
        {
            Toast.makeText(this, "Contact Clicked", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}