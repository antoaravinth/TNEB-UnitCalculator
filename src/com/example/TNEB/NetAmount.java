package com.example.TNEB;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: antoaravinth
 * Date: 2/11/13
 * Time: 12:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class NetAmount extends Activity {

    private TextView displayNetAmount;
    private TextView goBack;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.net_amount);

        Bundle extras = getIntent().getExtras();
        String netAmount = (String) extras.get("netAmount");

        displayNetAmount = (TextView) findViewById(R.id.amount);
        displayNetAmount.setText(netAmount);

        goBack = (TextView) findViewById(R.id.goBack);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),TNEBActivity.class);
                startActivity(i);
            }
        });

    }
}