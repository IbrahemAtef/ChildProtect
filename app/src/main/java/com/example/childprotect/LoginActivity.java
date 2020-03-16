package com.example.childprotect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    EditText et_email, et_password;
    TextView tv_toReg;
    Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inflate();
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject postparams = new JSONObject();
                try {
                    postparams.put("email", et_email.getText().toString());
                    postparams.put("password", et_password.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                // Suppose the Requset return true
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void inflate() {
        et_email = findViewById(R.id.login_et_email);
        et_password = findViewById(R.id.login_et_password);
        tv_toReg = findViewById(R.id.login_tv_toReg);
        btn_login = findViewById(R.id.login_btn);
    }

    public void registerScreen(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }

}
