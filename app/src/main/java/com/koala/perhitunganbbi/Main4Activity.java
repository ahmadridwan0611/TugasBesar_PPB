package com.koala.perhitunganbbi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity {

    Button btn_kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //Cara manggil Fragment
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fl, new FragmentBMI())
                .commit();
        //Sampe Sini

        btn_kembali = (Button) findViewById(R.id.button1);
        btn_kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main4Activity.this, MainActivity.class);
                Main4Activity.this.startActivity(intent);
                Main4Activity.this.finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Main4Activity.this, MainActivity.class);
        Main4Activity.this.startActivity(intent);
        Main4Activity.this.finish();
    }
}
