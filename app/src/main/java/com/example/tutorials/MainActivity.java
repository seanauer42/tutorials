/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.tutorials;



import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * create variables 
     */
    int quantity = 0;
    double price = 4.50 * .07 + 4.5;

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        display(quantity);
        displayPrice(quantity * price);
    }

    /**
     * This method adds to the price of the coffee
     */
    public void displayPrice(double number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    //resets the orders
    public void reset(View view) {
        quantity = 0;
        display(quantity);
        displayPrice(quantity * price);
    }
    //increment quantity by 1
    public void increment(View view) {
        quantity ++;
        display(quantity);
        displayPrice(quantity * price);
    }

    public void decrement(View view) {
        if(quantity > 0) {
            quantity--;
            display(quantity);
            displayPrice(quantity * price);
        }
        else{
            quantity = 0;
            display(quantity);
            displayPrice(quantity * price);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(double number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}