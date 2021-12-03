package com.weeworld.gogodriver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity{

    Button btnSignIn;
    Button btnSignUp;
    TextInputEditText txtLoginUser , txtPassLoginUser;

    FirebaseAuth auth;
    FirebaseUser firebaseUser;
    ProgressBar progressBarSignUp;
    FirebaseDatabase db;

    DatabaseReference databaseReference ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Firebase
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();

        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        // id input
        txtLoginUser = (TextInputEditText) findViewById(R.id.txt_LoginUsername);
        txtPassLoginUser = (TextInputEditText) findViewById(R.id.txt_PassLoginUser);
        progressBarSignUp = (ProgressBar) findViewById(R.id.Progress_bar_login);
        progressBarSignUp.setVisibility(View.GONE);

        /*Click chuyển qua trang đăng kí*/
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginUser();
                progressBarSignUp.setVisibility(View.VISIBLE);
            }
        });

        if (firebaseUser != null){
            Intent intent = new Intent(LoginActivity.this , MainPageActivity.class);
            startActivity(intent);
        }
    }

    // đăng nhập
    private void LoginUser() {
        String Username , PassLoginUser;

        Username = txtLoginUser.getText().toString();
        PassLoginUser = txtPassLoginUser.getText().toString();

        if(TextUtils.isEmpty(Username)){
            Toast.makeText(this , "Tên tài khoản không được để trống" , Toast.LENGTH_SHORT).show();
            return;
        }
        //kiểm tra mật khẩu
        if (TextUtils.isEmpty(PassLoginUser)){
            Toast.makeText(this , "Mật khẩu không được để trống" , Toast.LENGTH_SHORT).show();
            return;
        }

        //Check tài khoản mật khẩu
        auth.signInWithEmailAndPassword(Username , PassLoginUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    //FirebaseUser user = auth.getCurrentUser();
                    progressBarSignUp.setVisibility(View.GONE);
                    Intent intent = new Intent(LoginActivity.this , MainPageActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginActivity.this , "Sai tên tài khoản hoặc mật khẩụ" , Toast.LENGTH_SHORT).show();
                }
            }
        });

        //String userID = firebaseUser.getUid();

        //databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(userID).child("FullnameUser");


    }
}