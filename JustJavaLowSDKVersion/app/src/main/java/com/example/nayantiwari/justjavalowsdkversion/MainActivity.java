package com.example.nayantiwari.justjavalowsdkversion;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    private int numberOfCoffees = 0;
    boolean checkBoxValue1, checkBoxValue2;
    private TextView qty;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        qty = (TextView) findViewById(R.id.quantity_text_view);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrders(View view) {

//        displayMessage(createOrderSummary(calculatePrice()));
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, "nayan.tiwari@asu.edu");
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.orderSum));
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary(calculatePrice()));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private String createOrderSummary(int price) {
        String text = qty.getText().toString();
        if (numberOfCoffees > 0) {
            String name;
            EditText editText = (EditText) findViewById(R.id.editText);
            name = editText.getText().toString();
            return getString(R.string.name_s, name) +
                    getString(R.string.addWhippedCream) + checkBoxValue1 +
                    getString(R.string.addChocolate) + checkBoxValue2 +
                    getString(R.string.quan) + text +
                    getString(R.string.tot) + price + "\n" +
                    getString(R.string.thank_you);
        } else {
            Toast.makeText(this, R.string.cannotOrderZeroNumberOfCoffees, Toast.LENGTH_SHORT).show();
            return text;
        }

    }

    private int calculatePrice() {
        if (checkBoxValue1) {
            if (checkBoxValue2) {
                Log.i(TAG, "calculatePrice: Both");
                return numberOfCoffees * (5 + 3);
            } else {
                Log.i(TAG, "calculatePrice: Only 1");
                return numberOfCoffees * (5 + 1);
            }
        } else {
            if (checkBoxValue2) {
                Log.i(TAG, "calculatePrice: Only 2");
                return numberOfCoffees * (5 + 2);
            } else {
                Log.i(TAG, "calculatePrice: None");
                return numberOfCoffees * 5;
            }
        }

    }

    public void addNumberOfCoffees(View view) {
        if (numberOfCoffees <= 100) {
            numberOfCoffees++;
            displayQuantity(numberOfCoffees);
        } else {
            Toast.makeText(this, R.string.cupLimit100, Toast.LENGTH_SHORT).show();
        }
    }

    public void removeNumberOfCoffees(View view) {
        if (numberOfCoffees > 0) {
            numberOfCoffees--;
            displayQuantity(numberOfCoffees);
        } else {
            numberOfCoffees = 0;
            Toast.makeText(this, R.string.cupNumNoNeg, Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(number));
    }

    /**
     * This method displays the given text on the screen.
     */

    public void changeCheckedValue(View view) {
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBoxValue1 = checkBox1.isChecked();
        checkBoxValue2 = checkBox2.isChecked();
    }
}