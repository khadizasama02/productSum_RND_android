package com.first.assignment2_productsum_rnd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Checkout_Activity extends AppCompatActivity {
    TextView tv1,tv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_);
        tv1=(TextView)findViewById(R.id.textView);
        tv2=(TextView)findViewById(R.id.textView2);
        String price = getIntent().getExtras().getString("sum");
        String discount = getIntent().getExtras().getString("discount");
        tv1.setText("Total Price: "+price );
        tv2.setText("Total Discounted Price: "+discount );
    }
}