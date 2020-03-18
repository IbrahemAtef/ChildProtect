package com.example.childprotect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    EditText et_email, et_pass, et_rePass, et_userName;
    TextView tv_toLogin;
    Button btn_create;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        inflate();
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_userName.getText().toString();
                String email = et_email.getText().toString();
                String pass = et_pass.getText().toString();
                String rePass = et_rePass.getText().toString();
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("userName", name);
                    jsonObject.put("email", email);
                    jsonObject.put("pass", pass);
                    jsonObject.put("rePass", rePass);
                    Toast.makeText(RegisterActivity.this, "Done", Toast.LENGTH_SHORT).show();
                    //login
                    loginScreen(v);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void inflate() {
        et_email = findViewById(R.id.Reg_et_email);
        et_pass = findViewById(R.id.Reg_et_password);
        et_rePass = findViewById(R.id.Reg_et_rePass);
        et_userName = findViewById(R.id.Reg_et_userName);
        tv_toLogin = findViewById(R.id.Reg_tv_toLogin);
        btn_create = findViewById(R.id.Create_btn);
    }

    public void loginScreen(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
