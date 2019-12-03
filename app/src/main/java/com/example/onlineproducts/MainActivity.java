package com.example.onlineproducts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private String[] userList = {"Dharam", "Jasspreet", "Jaswinder"};
    private String[] passwordList = {"Singh", "Canada", "India"};
    private String[] customerIdList = {"1", "2", "3"};

    EditText usernameEditTxt,passwordEditTxt;
    Button loginBtn;
    int customerId = -1;
    //String firstName = usernameEditTxt.getText().toString()

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < userList.length; i++) {


                    if (usernameEditTxt.getText().toString().equalsIgnoreCase(userList[i])) {
                        if (passwordEditTxt.getText().toString().equalsIgnoreCase(passwordList[i])) {
                            Toast.makeText(MainActivity.this,
                                    "Login Succesfully", Toast.LENGTH_LONG).show();

                            int indexOfFlower = Arrays.asList(userList).indexOf(usernameEditTxt.getText().toString()) + 1;
                            String tmpStr10 = String.valueOf(indexOfFlower);

                            Toast.makeText(MainActivity.this,
                                    tmpStr10, Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                            intent.putExtra("username",usernameEditTxt.getText().toString());
                           intent.putExtra("customerId",tmpStr10);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this,
                                    "Invalid Credentials", Toast.LENGTH_LONG).show();
                        }
                        return;

                    }else{
                        Toast.makeText(MainActivity.this,
                                "Invalid Credentials", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }

    private void initView() {
        usernameEditTxt = findViewById(R.id.username);
        passwordEditTxt = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginButton);

    }
}
