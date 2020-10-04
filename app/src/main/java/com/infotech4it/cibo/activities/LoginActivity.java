package com.infotech4it.cibo.activities;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.infotech4it.cibo.R;
import com.infotech4it.cibo.databinding.ActivityLoginBinding;
import com.infotech4it.cibo.helpers.UIHelper;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        init();
    }

    private void init() {
        binding.setOnClick(this);
        firebaseAuth = FirebaseAuth.getInstance();
        if (FirebaseAuth.getInstance().getCurrentUser()!=null) {
            UIHelper.openActivity(LoginActivity.this, HomeActivity.class);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txtForgotPassword: {
                UIHelper.openActivity(this, ForgotActivity.class);
                break;
            }
            case R.id.btnLogin: {
                if (validation()){
                    LoggedIn();
                }
                break;
            }
            case R.id.txtRegisterAccount: {
                UIHelper.openActivity(this, RegistrationActivity.class);
                break;
            }
        }
    }

    private void LoggedIn() {
        firebaseAuth.signInWithEmailAndPassword(binding.edtEmail.getText().toString(),
                binding.edtPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            UIHelper.openActivity(LoginActivity.this, HomeActivity.class);
                        }
                    }, 3000);
                } else {

                    Toast.makeText(LoginActivity.this, "" + task.getException().getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean validation(){
        boolean check = true;
        binding.edtEmail.setError(null);
        binding.edtPassword.setError(null);
        if (binding.edtEmail.getText().toString().isEmpty()){
            binding.edtEmail.setError("Email cannot be empty");
            check = false;
        } else if (binding.edtPassword.getText().toString().isEmpty()){
            binding.edtPassword.setError("Password cannot be empty");
            check = false;
        }
        return check;
    }
}