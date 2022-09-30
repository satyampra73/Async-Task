package com.db.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class UploadTask extends AsyncTask<String,Integer,String> {

    Context context;
    TextView textView;
    ProgressBar progressIndicator;
    Button button;

    public UploadTask(Context context, TextView textView, ProgressBar progressIndicator, Button button) {
        this.context=context;
        this.textView=textView;
        this.progressIndicator=progressIndicator;
        this.button=button;
    }

    @Override
    protected void onPreExecute() {
        progressIndicator.setVisibility(View.VISIBLE);
        button.setEnabled(false);
        textView.setText("File Uploading");
        Log.d("Tag","on Pre Execute"+Thread.currentThread().getName());
    }


    @Override
    protected void onProgressUpdate(Integer... values) {
        progressIndicator.setProgress(values[0]+1);

    }

    @Override
    protected String doInBackground(String... strings) {
        Log.d("Tag","do in background:"+strings[0]);
        Log.d("Tag","do in background:"+Thread.currentThread().getName());
        for (int i=0;i<10;i++){
            Log.d("Tag",String.valueOf(i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);
        }
        return "Finally the task is Complete";
    }

    @Override
    protected void onPostExecute(String string) {
        progressIndicator.setVisibility(View.VISIBLE);
        textView.setText(string);
        button.setEnabled(true);
        Log.d("Tag","on Post Execute"+Thread.currentThread().getName());
    }

}
