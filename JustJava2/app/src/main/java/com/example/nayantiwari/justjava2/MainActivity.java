package com.example.nayantiwari.justjava2;

import android.os.Bundle;
import android.support.annotation.BoolRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import static com.example.nayantiwari.justjava2.R.id.checkBox1;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    private int numberOfCoffees = 0;
    private CheckBox checkBox1, checkBox2;
    boolean checkBoxValue1, checkBoxValue2;
    private TextView qty;

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
        displayMessage(createOrderSummary(calculatePrice()));
    }

    private String createOrderSummary(int price) {
        String text = qty.getText().toString();
        return "Name: Nayan Tiwari" +
                "\nAdd Whipped Cream? " + checkBoxValue1 +
                "\nAdd Chocolate? " + checkBoxValue2 +
                "\nQuantity: " + text +
                "\nTotal: $" + price + "\n" +
                "Thank you!";
    }

    private int calculatePrice() {
        return numberOfCoffees * 5;
    }

    public void addNumberOfCoffees(View view) {
        numberOfCoffees++;
        displayQuantity(numberOfCoffees);
    }

    public void removeNumberOfCoffees(View view) {
        if (numberOfCoffees > 0) {
            numberOfCoffees--;
            displayQuantity(numberOfCoffees);
        } else {
            numberOfCoffees = 0;
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
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    public void changeCheckedValue(View view) {
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBoxValue1 = checkBox1.isChecked();
        checkBoxValue2 = checkBox2.isChecked();

    }
}