package com.first.assignment2_productsum_rnd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et1;

    EditText et2;
    EditText et3;

    TextView tv1;
    TextView tv2;
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.et_price);
        et2 = (EditText) findViewById(R.id.et_quantity);
        et3 = (EditText) findViewById(R.id.et_discount);
        tv1 = (TextView) findViewById(R.id.tv_totalPrice);
        tv2 = (TextView) findViewById(R.id.tv_totalDiscountedPrice);
        findViewById(R.id.bt_total).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum();

            }
        });
        findViewById(R.id.bt_discount).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                discountSum();

            }
        });
        findViewById(R.id.bt_checkOut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii = new Intent(getApplicationContext(),Checkout_Activity.class);
                ii.putExtra("sum",sum());
                ii.putExtra("discount",discountSum());
                startActivity(ii);

            }
        });

    }

    public String sum() {
        String price = et1.getText().toString();
        String quantity = et2.getText().toString();
        Double priceInt = Double.valueOf(price);
        Double quantityInt = Double.valueOf(quantity);
        Double total = priceInt * quantityInt;
        String totalString = String.valueOf(total);
        tv1.setText("Total price: "+totalString);
        Log.d(TAG, "sum: "+totalString);
        return totalString;
    }
    public String discountSum(){
        String discountValue = et3.getText().toString();
        Double discountInt = Double.valueOf(discountValue);
        Double discountAmount = (Double.valueOf(sum())*(discountInt/100));
        Double totalDiscount = Double.valueOf(sum())- discountAmount;
        String discountString = String.valueOf(totalDiscount);
        tv2.setText("Total discount price: "+discountString);
        return discountString;

    }
}