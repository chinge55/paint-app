package com.lumen.mnsa_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    CustomView touchAppView;
    Button btnClearCanvas, samplebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        touchAppView =findViewById(R.id.customView);
        btnClearCanvas= findViewById(R.id.clearCanvas);
        samplebtn = findViewById(R.id.btn1);

        btnClearCanvas.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                touchAppView.clearCanvas();
            }
        });
        samplebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SampleActivity.class);
                startActivity(intent);
            }
        });
    }
}
