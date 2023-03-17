package com.example.ktra1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CalculationActivity extends AppCompatActivity {
    private EditText number1, number2;
    private TextView result;
    private Button submitBtn;
    private Spinner operatorSp;
    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        initView();
    }

    private void initView() {
        this.number1 = findViewById(R.id.et1);
        this.number2 = findViewById(R.id.et2);
        this.result = findViewById(R.id.result);
        this.submitBtn = findViewById(R.id.submitBtn);
        this.operatorSp = findViewById(R.id.operatorSp);
        this.operator = "+";

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSubmit(view);
            }
        });

        operatorSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedOperator = operatorSp.getSelectedItem().toString();
                operator = selectedOperator;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void onSubmit(View view) {
        String text1 = number1.getText().toString();
        String text2 = number2.getText().toString();

        double n1, n2;

        try {
            n1 = Double.parseDouble(text1);
            n2 = Double.parseDouble(text2);
            String res = calculation(n1, n2);

            result.setText(res);
            Toast.makeText(this, res, Toast.LENGTH_LONG).show();
        } catch (Exception e) {

        }
    }

    private String calculation(double x, double y) {
        String res = "";

        switch (this.operator) {
            case "+":
                res = "" + (x + y);
                break;
            case "-":
                res = "" + (x - y);
                break;
            case "*":
                res = "" + (x * y);
                break;
            default:
                if (y == 0) res = "Cannot calculate, because y = 0";
                res = "" + (x / y);
        }

        return res;
    }
}