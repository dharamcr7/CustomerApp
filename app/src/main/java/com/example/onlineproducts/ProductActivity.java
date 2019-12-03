package com.example.onlineproducts;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ProductActivity extends AppCompatActivity {


    private String[] productList = {"Product one", "Product Second", "Product Three"};
    private int[] priceList = {12,12,21};

    private int userValue =0;


    int [] images = {R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground,R.drawable.car};

    Spinner spinner;
    ImageView productImage;
    ArrayAdapter<CharSequence> adapter;
    TextView customerName,priceTxtView,totalPrice;
    EditText ed1;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);


        initView();
        spinnerOne();
        bundleData();

        ed1.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                convert();
            }
        });

    }

    private void bundleData(){
        Intent intent = getIntent();
        String userName = intent.getStringExtra("username");
        customerName.setText(userName);
        Toast.makeText(ProductActivity.this,
                userName, Toast.LENGTH_LONG).show();
    }

    private void initView() {
        spinner = findViewById(R.id.spinner);
        customerName = findViewById(R.id.customerName);
        productImage = findViewById(R.id.productImage);
        priceTxtView = findViewById(R.id.priceTxtView);
        ed1 = findViewById(R.id.quantity);
        totalPrice = findViewById(R.id.totalValue);

    }

    private void spinnerOne() {

        // Create an ArrayAdapter using the string array and a default spinner layout
        adapter = new ArrayAdapter<CharSequence>(this,
                android.R.layout.simple_spinner_dropdown_item, productList);

        // Specify the layout to use when the list of choices appears

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner


        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            productImage.setImageResource(images[position]);
            userValue = priceList[position];
                String str1 = Integer.toString(priceList[position]);


                priceTxtView.setText(str1);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }
    private void convert() {

        try{

                if (!ed1.getText().equals("") && ed1.getText() != null) {
                Double value1 = Double.parseDouble(ed1.getText().toString());
                Double calculatedValue = (userValue * (value1/0.3));
                totalPrice.setText(String.valueOf(calculatedValue));
            }}catch (NumberFormatException e){
            e.printStackTrace();
            alert(e.toString());
        }

        }
    public void alert(String msg) {
        AlertDialog alertDialog = new AlertDialog.Builder(ProductActivity.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage(msg);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();

    }

}
