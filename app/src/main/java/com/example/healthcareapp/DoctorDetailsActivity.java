package com.example.healthcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String [][] doctor_details1 =
            {
                    {"Doctor Name : Mootez aouinti", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:26414032", "600"},
                    {"Doctor Name : Molka Hamdi", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:26414032", "600"},
                    {"Doctor Name : Chayma Mhatli", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:26414032", "600"},
                    {"Doctor Name : Chayma Jleli", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:26414032", "600"},


            };
    private String [][] doctor_details2 =
            {
                    {"Doctor Name : Mootez aouinti", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:26414032", "600"},
                    {"Doctor Name : Molka Hamdi", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:26414032", "600"},
                    {"Doctor Name : Chayma Mhatli", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:26414032", "600"},
                    {"Doctor Name : Chayma Jleli", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:26414032", "600"},


            };
    private String [][] doctor_details3 =
            {
                    {"Doctor Name : Mootez aouinti", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:26414032", "600"},
                    {"Doctor Name : Molka Hamdi", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:26414032", "600"},
                    {"Doctor Name : Chayma Mhatli", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:26414032", "600"},
                    {"Doctor Name : Chayma Jleli", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:26414032", "600"},


            };
    private String [][] doctor_details4 =
            {
                    {"Doctor Name : Mootez aouinti", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:26414032", "600"},
                    {"Doctor Name : Molka Hamdi", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:26414032", "600"},
                    {"Doctor Name : Chayma Mhatli", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:26414032", "600"},
                    {"Doctor Name : Chayma Jleli", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:26414032", "600"},


            };
    private String [][] doctor_details5 =
            {
                    {"Doctor Name : Mootez aouinti", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:26414032", "600"},
                    {"Doctor Name : Molka Hamdi", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:26414032", "600"},
                    {"Doctor Name : Chayma Mhatli", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:26414032", "600"},
                    {"Doctor Name : Chayma Jleli", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:26414032", "600"},


            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonLTBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if ("Family Physician".equalsIgnoreCase(title)) {
            doctor_details = doctor_details1;
        } else if ("Dietician".equalsIgnoreCase(title)) {
            doctor_details = doctor_details2;
        } else if ("Dentist".equalsIgnoreCase(title)) {
            doctor_details = doctor_details3;
        } else if ("Surgeon".equalsIgnoreCase(title)) {
            doctor_details = doctor_details4;
        } else if ("Cardiologist".equalsIgnoreCase(title)) {
            doctor_details = doctor_details5;
        } else {
            // fallback
            doctor_details = new String[][] {{"No Data Found"}};
        }
        Log.d("DOCTOR_TITLE", "Received title: " + title);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for (int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees:"+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.listViewLT);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctor_details[i][0]);
                it.putExtra("text3", doctor_details[i][1]);
                it.putExtra("text4", doctor_details[i][3]);
                it.putExtra("text5", doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}
