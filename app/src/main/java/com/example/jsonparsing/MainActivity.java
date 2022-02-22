package com.example.jsonparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    // Data initialize
    String JSON_STRING = "{employee:{" +
        "name:\"Huan Nguyen1\"," +
        "salary:65000" +
        "}}";
    String name, salary;
    TextView employeeName, employeeSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // View's initialize
        employeeName = findViewById(R.id.name);
        employeeSalary = findViewById(R.id.salary);

        try {
            // Get JSON from JSON file
            JSONObject obj = new JSONObject(JSON_STRING);

            // Fetching JSONObject named employee
            JSONObject employee = obj.getJSONObject("employee");

            // Get employee name and salary
            name = employee.getString("name");
            salary = employee.getString("salary");

            // Set employee name and salary in TextView's
            employeeName.setText("Name: " + name);
            employeeSalary.setText("Salary: " + salary);
        } catch (JSONException e) { e.printStackTrace(); }
    }
}