package com.example.apptonghop_giuaki;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignIn extends AppCompatActivity {

    Button btnLogin, btnSignUp, btnCreate;
    EditText edtUser, edtPassWord, edtUserSU, edtPassSU;
    String ten,mk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        AnhXa();;

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtUser.getText().length() != 0 && edtPassWord.getText().length() !=0){
                    if (edtUser.getText().toString().equals(ten) && edtPassWord.getText().toString().equals(mk)){
                        Toast.makeText(SignIn.this,"Bạn đã đăng nhập thành công",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignIn.this, MainActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(SignIn.this,"Sai mật khẩu",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(SignIn.this,"Vui lòng nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(SignIn.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.activity_sign_up);

                Window window = dialog.getWindow();
                if (window == null) {
                    return;
                }

                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable( new ColorDrawable(Color.TRANSPARENT));

                btnCreate = (Button) dialog.findViewById(R.id.buttonCreate);
                edtUserSU = (EditText) dialog.findViewById(R.id.editTextUserSU);
                edtPassSU = (EditText) dialog.findViewById(R.id.editTextPassSU);
                btnCreate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ten = edtUserSU.getText().toString().trim();
                        mk  = edtPassSU.getText().toString().trim();
                        Toast.makeText(SignIn.this, "", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
    }

    private void AnhXa() {
        btnLogin = (Button) findViewById(R.id.buttonLogin);
        btnSignUp = (Button) findViewById(R.id.buttonSignUp);
        edtUser = (EditText) findViewById(R.id.editTextUser);
        edtPassWord = (EditText) findViewById(R.id.editTextPass);

    }
}