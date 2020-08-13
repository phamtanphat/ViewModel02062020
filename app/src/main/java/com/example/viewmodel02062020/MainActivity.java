package com.example.viewmodel02062020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;
    Button mBtn;
    TextView mTv;
    EditText mEdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        mBtn = findViewById(R.id.button);
        mTv = findViewById(R.id.textview);
        mEdt = findViewById(R.id.edittext);

        //observer
        mainViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mTv.setText(s);
            }
        });

        //event

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = mEdt.getText().toString();
                mainViewModel.setText(text);
            }
        });
    }
}