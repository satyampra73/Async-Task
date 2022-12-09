package com.db.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.UpdateLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    ProgressBar progressBar,progressIndicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);
        progressBar=findViewById(R.id.progressBar);
        progressIndicator=findViewById(R.id.progressIndicater);
        textView.setText("");
        progressIndicator.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.INVISIBLE);

    }

    public void uploadTask(View view) {
        UploadTask uploadTask=new UploadTask(MainActivity.this,textView,progressIndicator,button);
        uploadTask.execute("This is that String");
    }

    public void next(View view) {
        Intent intent=new Intent(MainActivity.this,TaskRescudleActivity.class);
        startActivity(intent);
    }
}