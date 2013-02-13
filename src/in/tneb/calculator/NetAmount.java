package in.tneb.calculator;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
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

    private TextView displayNetAmount, fixedCharges, consumption, units;
    private TextView goBack;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.net_amount);



        Bundle extras = getIntent().getExtras();
        String netAmount = (String) extras.get("netAmount");
        String unitsEntered = (String) extras.get("units");
        Integer charges = (Integer) extras.get("fixedCharges");

        double cosumptionCharges =  Double.parseDouble(netAmount) - charges.intValue() ;


        units = (TextView) findViewById(R.id.unitsEntered);
        units.setText(unitsEntered.replaceAll("\\.0*$", ""));

        fixedCharges = (TextView) findViewById(R.id.fixedCharge);
        fixedCharges.setText(String.valueOf(charges).replaceAll("\\.0*$", ""));


        consumption = (TextView) findViewById(R.id.consumption);
        consumption.setText(String.valueOf(cosumptionCharges).replaceAll("\\.0*$", ""));

        displayNetAmount = (TextView) findViewById(R.id.amount);
        displayNetAmount.setText(netAmount.replaceAll("\\.0*$", ""));


        goBack = (TextView) findViewById(R.id.goBack);
        goBack.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),TNEBActivity.class);
                startActivity(i);
            }
        });
    }
}