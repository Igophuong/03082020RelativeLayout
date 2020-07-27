package com.example.gameloto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText mEdtSomin, mEdtSomax;
    Button mBtnRandom;
    TextView mTvKetqua;
    String mValue = "";
    Random mRandom ;
    int mRandomValue = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnRandom = findViewById(R.id.buttonRandom);
        mEdtSomax = findViewById(R.id.edittextSomax);
        mEdtSomin = findViewById(R.id.edittextSomin);
        mTvKetqua = findViewById(R.id.textviewKetqua);

        mBtnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textSmin = mEdtSomin.getText().toString();
                String textSmax = mEdtSomax.getText().toString();
                if (textSmin.isEmpty() || textSmax.isEmpty()) {
                    Toast.makeText(
                            MainActivity.this,
                            "Bạn chưa nhập đủ thông tin",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                // Điều kiện 1 : Số min không lớn hơn số max
                // Điêu kiện 2 : Số max = 0 => min = 0 , max = 1

                int sMin = Integer.parseInt(textSmin);
                int sMax = Integer.parseInt(textSmax);
                if (sMin >= sMax) {
                    sMax = sMin + 1;
                }
                mEdtSomin.setText(sMin + "");
                mEdtSomax.setText(sMax + "");
                // Hien thi
                Random random = new Random();
                int value = random.nextInt(sMax - sMin + 1) + sMin;
                mValue = mValue + value + " - ";
                mTvKetqua.setText(mValue);
            }
        });
    }
}