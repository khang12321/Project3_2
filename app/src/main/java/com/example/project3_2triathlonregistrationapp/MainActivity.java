package com.example.project3_2triathlonregistrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double costPerAthletes = 725;
    int number;
    double totalCost;
    String locationChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // indicating final variable
        final EditText athletes = (EditText)findViewById(R.id.txtnumberOfAthletes);
        final Spinner location = (Spinner)findViewById(R.id.location);

        // create button object and generate action
        Button cost = (Button)findViewById(R.id.btnCost);
        cost.setOnClickListener(new View.OnClickListener() {
            final TextView result = ((TextView)findViewById(R.id.txtResult));
            @Override
            public void onClick(View view) {

                number= Integer.parseInt(athletes.getText().toString());
                totalCost = costPerAthletes*number;
                DecimalFormat currency = new DecimalFormat("S###,###.##");
                locationChoice = location.getSelectedItem().toString();
                result.setText(locationChoice + " race team fee is " + currency.format(totalCost));
            }
        });
    }
}
