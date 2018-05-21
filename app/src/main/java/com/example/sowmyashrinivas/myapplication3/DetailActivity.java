package com.example.sowmyashrinivas.myapplication3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by sowmyashrinivas on 21/05/18.
 */

public class DetailActivity extends AppCompatActivity {

    private Spinner mspinner = null;
    private Button returnbutton = null;
    //public static final int RESULT_OK = 1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();

        if(extras!=null)
        {
            String detailvalue = extras.getString("Keyforsending");
            if(detailvalue!=null)
            {
                Toast.makeText(this,detailvalue, Toast.LENGTH_SHORT).show();
            }
        }

        mspinner = findViewById(R.id.spinnerselection);
        returnbutton = (Button) findViewById(R.id.gotoreturn);
        returnbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                String myselection = mspinner.getSelectedItem().toString();
                i.putExtra("Keyforreturning",myselection);
                setResult(RESULT_OK,i);
                finish();

            }
        });

    }
}
