package com.example.TNEB;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.mobsandgeeks.saripaar.Rule;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Required;

public class TNEBActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    @Required(order = 1)
    private EditText editText;

    private Button calculate;
    private Validator validator;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        editText = (EditText) findViewById(R.id.editText);
        calculate = (Button) findViewById(R.id.button);

        validator = new Validator(TNEBActivity.this);
        validator.setValidationListener(new FormValidator());

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validator.validate();
            }
        });

    }

    private String calculateNetAmount(int units)
    {
        double netAmount = 0;

        if(units <= 100)
            netAmount = units + 20;
        else if(units >100 && units <=200 )
            netAmount = (units * 1.50) + 20;
        else if(units <=500)
        {
            double partial = 400;
            netAmount = ((units - 200) * 3) + 30 + partial;
        }
        else if(units >500)
        {
            double partial1 = 600;
            double partial2 = 1200;
            netAmount = ((units - 500) * 5.75) + 40 + partial1 + partial2;
        }

        //round the values
        netAmount = Math.round(netAmount);

        String amount = String.valueOf(netAmount);
        return amount;
    }

    private class FormValidator implements Validator.ValidationListener {

        public void onSuccess() {
            //
            int units = Integer.parseInt(editText.getText().toString());
            String netAmount =  calculateNetAmount(units);

            Intent i = new Intent(getApplicationContext(),NetAmount.class);
            i.putExtra("netAmount",netAmount);
            startActivity(i);
        }

        public void onFailure(View failedView, Rule<?> failedRule) {
            String message = failedRule.getFailureMessage();

            if (failedView instanceof EditText) {
                failedView.requestFocus();
                ((EditText) failedView).setError(message);
            } else {
                Toast.makeText(TNEBActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        }

        public void preValidation() {
            // Do nothing…
        }

        public void onValidationCancelled() {
            // Do nothing
        }
    }
}
