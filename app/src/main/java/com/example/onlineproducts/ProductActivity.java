package com.example.onlineproducts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ProductActivity extends AppCompatActivity {


    private String[] productList = {"Product one", "Product Second", "Product Three"};

    private ImageView[] imageList = {};
    int [] images = {R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground,R.drawable.car};

    Spinner spinner;
    ImageView productImage;
    ArrayAdapter<CharSequence> adapter;
    TextView customerName;
    int i = 0;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        initView();
        spinnerOne();
        bundleData();

    }

    private void bundleData(){
        Intent intent = getIntent();
        String userName = intent.getStringExtra("customerId");
        customerName.setText(userName);
        Toast.makeText(ProductActivity.this,
                userName, Toast.LENGTH_LONG).show();
    }

    private void initView() {
        spinner = findViewById(R.id.spinner);
        customerName = findViewById(R.id.customerName);
        productImage = findViewById(R.id.productImage);

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

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }
}
