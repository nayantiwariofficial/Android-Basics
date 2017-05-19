package com.example.nayantiwari.justjava2;

import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int numberOfCoffees = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrders(View view) {
        display(numberOfCoffees);
        displayPrice( numberOfCoffees * 5);
        numberOfCoffees = 0;
    }

    public void addNumberOfCoffees(View view){
        numberOfCoffees++;
        display(numberOfCoffees);
    }
    public void removeNumberOfCoffees(View view){
        if(numberOfCoffees > 0) {
            numberOfCoffees--;
            display(numberOfCoffees);
        }
        else{
            numberOfCoffees = 0;
        }
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
        private void displayPrice(int number) {
            TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
            priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
        }
}