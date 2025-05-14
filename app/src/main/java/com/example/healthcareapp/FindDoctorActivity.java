package com.example.healthcareapp;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FindDoctorActivity extends AppCompatActivity {

    CardView familyPhysician, dietician, dentist, surgeon, cardiologist, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        familyPhysician = findViewById(R.id.cardFDFamilyPhysician);
        dietician = findViewById(R.id.cardFDDietician);
        dentist = findViewById(R.id.cardFDDentist);
        surgeon = findViewById(R.id.cardFDSurgeon);
        cardiologist = findViewById(R.id.cardFDCardiologist);
        back = findViewById(R.id.cardFDBack);

        familyPhysician.setOnClickListener(view -> openDoctorDetails("Family Physician"));
        dietician.setOnClickListener(view -> openDoctorDetails("Dietician"));
        dentist.setOnClickListener(view -> openDoctorDetails("Dentist"));
        surgeon.setOnClickListener(view -> openDoctorDetails("Surgeon"));
        cardiologist.setOnClickListener(view -> openDoctorDetails("Cardiologist"));

        back.setOnClickListener(view ->
                startActivity(new Intent(FindDoctorActivity.this, HomeActivity.class))
        );
    }

    private void openDoctorDetails(String title) {
        Log.d(TAG, "openDoctorDetails: ");
        Intent intent = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
        intent.putExtra("title", title);
        startActivity(intent);
    }
}