package com.koala.perhitunganbbi;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    Button btn_kembali;
    RadioGroup rg_gender;
    RadioButton rb_gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btn_kembali = (Button) findViewById(R.id.b2);
        btn_kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this, MainActivity.class);
                Main3Activity.this.startActivity(intent);
                Main3Activity.this.finish();
            }
        });

        final EditText e2 = (EditText) findViewById(R.id.et2);
        final TextView tv4 = (TextView) findViewById(R.id.tv4);

        findViewById(R.id.b1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str2 = e2.getText().toString();
                if (TextUtils.isEmpty(str2)) {
                    e2.setError("Please Enter Your Height");
                    e2.requestFocus();
                    return;
                }

                rg_gender = (RadioGroup) findViewById(R.id.rg);

                if (rg_gender.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Pilih dulu kali bang GENDER nya!!!", Toast.LENGTH_LONG).show();
                } else {
                    int Selected = rg_gender.getCheckedRadioButtonId();
                    rb_gender = (RadioButton) findViewById(Selected);
                    float height, bmiValue;
                    height = Float.parseFloat(str2);
                    if (rb_gender.getText().equals("Pria")){
                        bmiValue = calculateBMI(0.1,height);
                    }
                    else {
                        bmiValue = calculateBMI(0.15, height);
                    }

                    tv4.setText(String.valueOf("Berat Badan Ideal = "+bmiValue+" Kg"));
                }

            }
        });
    }

    private float calculateBMI(double gender, float height) {
        return (float) ((height-100)-(gender*(height-100)));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Main3Activity.this, MainActivity.class);
        Main3Activity.this.startActivity(intent);
        Main3Activity.this.finish();    }
}