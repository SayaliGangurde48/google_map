package com.example.google_map;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnGetDirection;
    private EditText etFromLocation;
    private EditText etToLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGetDirection = findViewById(R.id.btnGetDirection);
        etFromLocation = findViewById(R.id.etFromLocation);
        etToLocation = findViewById(R.id.etToLocation);

        btnGetDirection.setOnClickListener(view -> {
            String userLocation = etFromLocation.getText().toString();
            String userDestination = etToLocation.getText().toString();

            if (userLocation.equals(" ") || userDestination.equals(" ")) {
                Toast.makeText(this, "Please enter your location & destination", Toast.LENGTH_SHORT).show();
            } else {
                btnGetDirections(userLocation, userDestination);

            }
        });

    }

    private void btnGetDirections(String from, String to) {
        try {
            Uri uri = Uri.parse("https://www.google.com/maps/dir/" + from + "/" + to);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setPackage("com.google.android.apps.maps");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }catch (ActivityNotFoundException exception){
            Uri uri = Uri.parse("https://www.google.com/maps/@19.7542335,74.4923517,13.27z?authuser=0&entry=ttu&g_ep=EgoyMDI1MDIxNy4wIKXMDSoJLDEwMjExNDU1SAFQAw%3D%3D");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);



        }
    }
}









