package com.neuroinnova.neuroinnovasampleapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMpesa;
    private Button btnAirtelMoney;
    private Button btnCash;
    private LinearLayout activity_payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        initView();
    }

    private void initView() {
        btnMpesa = (Button) findViewById(R.id.btnMpesa);
        btnAirtelMoney = (Button) findViewById(R.id.btnAirtelMoney);
        btnCash = (Button) findViewById(R.id.btnCash);
        activity_payment = (LinearLayout) findViewById(R.id.activity_payment);

        btnMpesa.setOnClickListener(this);
        btnAirtelMoney.setOnClickListener(this);
        btnCash.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMpesa:

                Toast.makeText(this, "M-Pesa Selected", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btnAirtelMoney:
                Toast.makeText(this, "Airtel Money Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnCash:

                Toast.makeText(this, "Cash Selected", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
