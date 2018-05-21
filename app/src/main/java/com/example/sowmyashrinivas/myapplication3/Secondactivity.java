package com.example.sowmyashrinivas.myapplication3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by sowmyashrinivas on 21/05/18.
 */

public class Secondactivity extends AppCompatActivity {
    TextView mselectedview = null;
    public static final int DETAIL_REQUEST = 1;
    Button nbutton = null;
    Button dbutton = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        nbutton = findViewById(R.id.gotofirstactivity);
        nbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), MainActivity.class);
                startActivity(i);
            }
        });
        mselectedview =(TextView) findViewById(R.id.selecteditemnothing);
        dbutton = findViewById(R.id.gotodetailactivity);
        dbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), DetailActivity.class);
                i.putExtra("Keyforsending", "Some data for second activity");
                startActivityForResult(i, DETAIL_REQUEST);
            }
        });

    }
    protected void onActivityResult(int requestcode, int resultcode, Intent data) {
        if (resultcode == RESULT_OK && requestcode == DETAIL_REQUEST) {
            if (data.hasExtra("Keyforreturning")) {
                String selectedvalue = data.getExtras().getString("Keyforreturning");
                mselectedview.setText(selectedvalue);
            }
        }
    }


}

