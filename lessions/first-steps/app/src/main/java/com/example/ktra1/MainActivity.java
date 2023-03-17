package com.example.ktra1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CheckBox cb1, cb2, cb3;
    private RadioButton rFemale, rMale;
    private RatingBar rating;
    private Spinner sp;
    private Button submitBtn;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.some_widgets);
        this.init();
        this.setOnClick();
    }

    private void setOnClick() {
        this.submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = "Checkbox: ";
                if (cb1.isChecked()) {
                    res += cb1.getText() + ", ";
                }
                if (cb2.isChecked()) {
                    res += cb2.getText() + ", ";
                }
                if (cb3.isChecked()) {
                    res += cb3.getText() + ", ";
                }

                res += "\nGender: ";
                if (rFemale.isChecked()) {
                    res += rFemale.getText() + ", ";
                }
                if (rMale.isChecked()) {
                    res += rMale.getText() + ", ";
                }

                res+= "\nRating: " + rating.getRating();

                res += "\nUniversity: " + sp.getSelectedItem().toString();

                result.setText(res);
            }
        });
    }

    private void init() {
        this.cb1 = findViewById(R.id.cb1);
        this.cb2 = findViewById(R.id.cb2);
        this.cb3 = findViewById(R.id.cb3);
        this.rFemale = findViewById(R.id.rFemale);
        this.rMale = findViewById(R.id.rMale);
        this.rating = findViewById(R.id.rating);
        this.initSpinner();
        this.submitBtn = findViewById(R.id.submitBtn);
        this.result = findViewById(R.id.result);
    }

    private void initSpinner() {
        sp = findViewById(R.id.sp2);
        String[] universities = {"PTIT", "HNU", "FTU", "HUST"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item, universities);
        sp.setAdapter(adapter);
    }
}