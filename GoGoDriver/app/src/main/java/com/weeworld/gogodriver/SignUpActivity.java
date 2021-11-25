package com.weeworld.gogodriver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.weeworld.gogodriver.Model.UserModel;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity {

    TextView txt_SignIn;
    TextInputEditText txt_FullnameUser, txt_PassUser , txt_PhoneUser , txt_EmailUser;
    Button btnSignUp;
    FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressBar progressBarSignUp;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // chuyển trang qua đăng nhập
        txt_SignIn = (TextView) findViewById(R.id.txt_SignIn);
        txt_SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
            }
        });

        //khai báo báo firebase
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        txt_FullnameUser = (TextInputEditText) findViewById(R.id.txt_FullnameUser);
        txt_PassUser = (TextInputEditText) findViewById(R.id.txt_PassUser);
        txt_PhoneUser = (TextInputEditText) findViewById(R.id.txt_PhoneUser);
        txt_EmailUser = (TextInputEditText) findViewById(R.id.txt_EmailUser);
        progressBarSignUp = (ProgressBar) findViewById(R.id.Progress_bar_signup);
        progressBarSignUp.setVisibility(View.GONE);

        //chức năng đăng kí tài khảon
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateUser();
                progressBarSignUp.setVisibility(View.VISIBLE);
            }
        });
    }

    private void CreateUser() {
        final String[] UserID = new String[1];
        String FullnameUser;
        String PassUser;
        String PhoneUser;
        String EmailUser;

        FullnameUser = txt_FullnameUser.getText().toString();
        PassUser = txt_PassUser.getText().toString();
        PhoneUser = txt_PhoneUser.getText().toString();
        EmailUser = txt_EmailUser.getText().toString();

        //kiểm tra họ tên
        if (TextUtils.isEmpty(FullnameUser)){
            Toast.makeText(this , "Họ tên không được để trống" , Toast.LENGTH_SHORT).show();
            return;
        }

        //kiểm tra mật khẩu
        if (TextUtils.isEmpty(PassUser)){
            Toast.makeText(this , "Mật khẩu không được để trống" , Toast.LENGTH_SHORT).show();
            return;
        }

        if(PassUser.length() < 8 ){
            Toast.makeText(this , "Mật khẩu phải nhiều hơn 8 kí tự" , Toast.LENGTH_SHORT).show();
            return;
        }

        //kiểm tra số điện thoại
        if (TextUtils.isEmpty(PhoneUser)){
            Toast.makeText(this , "Số điện thoại không được để trống" , Toast.LENGTH_SHORT).show();
            return;
        }

        //kiểm tra Email
        if (TextUtils.isEmpty(EmailUser)){
            Toast.makeText(this , "Tài khoản email không được để trống" , Toast.LENGTH_SHORT).show();
            return;
        }

        // check từng input nếu đủ điều kiện sẽ đăng kí thành công và ngược lại
        auth.createUserWithEmailAndPassword(EmailUser , PassUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    FirebaseUser firebaseUser = auth.getCurrentUser();
                    String UserID = firebaseUser.getUid();

                    assert firebaseUser != null;
                    String userid = firebaseUser.getUid();

                    reference = FirebaseDatabase.getInstance().getReference("Users").child(userid);

                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("UserID", userid);
                    hashMap.put("FullnameUser", FullnameUser);
                    hashMap.put("picUser", "default");
                    hashMap.put("status", "offline");
                    hashMap.put("search", FullnameUser.toLowerCase());

                    reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(SignUpActivity.this , "Đăng kí thành công" , Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(SignUpActivity.this , "Không được để trống thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}