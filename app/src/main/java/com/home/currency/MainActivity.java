package com.home.currency;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public EditText ed_ntd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviews();
    }

    private void findviews(){
        ed_ntd = findViewById(R.id.ed_ntd);
    }

    public void go(View view){
        String ntd = ed_ntd.getText().toString();
        String title = "";
        String message = "";

        if (ntd.equals("")){
            title = "Problem";
            message = "Please enter you NTD amount";
        }
        else{
            float ntdolles = Float.parseFloat(ntd);
            float usd = ntdolles/30.9f;
            title = "Result";
            message = "USD is "+String.valueOf(usd);
        }

        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ed_ntd.setText("");
                    }
                })
                .show();
    }
}
