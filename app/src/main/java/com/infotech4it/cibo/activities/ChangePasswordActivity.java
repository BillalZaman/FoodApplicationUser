package com.infotech4it.cibo.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.infotech4it.cibo.R;
import com.infotech4it.cibo.databinding.ActivityChangePasswordBinding;
import com.infotech4it.cibo.helpers.UIHelper;

public class ChangePasswordActivity extends AppCompatActivity {
    private ActivityChangePasswordBinding binding;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_change_password);

        init();
    }

    private void init() {
        firebaseAuth = FirebaseAuth.getInstance();
        binding.setOnClick(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBack: {
                finish();
                break;
            }
            case R.id.textView4: {
                if (validation()) {
                    sendForgotPasswordEmail();
                }
                break;
            }
        }
    }

    private void sendForgotPasswordEmail() {
        firebaseAuth.sendPasswordResetEmail(binding.edtForgotPassword.getText().toString()).addOnCompleteListener(
                new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(ChangePasswordActivity.this,
                                    "The Reset Password Link has been sent to the Register Email",
                                    Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            UIHelper.showLongToastInCenter(ChangePasswordActivity.this, task.getException().getMessage());
                        }
                    }
                }
        );
    }

    private boolean validation() {
        boolean check = true;
        binding.edtForgotPassword.setError(null);
        if (binding.edtForgotPassword.getText().toString().isEmpty()) {
            binding.edtForgotPassword.setError("Email field is required");
            check = false;
        }
        return check;
    }
}