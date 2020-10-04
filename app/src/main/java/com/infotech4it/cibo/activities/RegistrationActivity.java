package com.infotech4it.cibo.activities;

import android.os.Bundle;
import android.view.View;

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
import com.infotech4it.cibo.databinding.ActivityRegistrationBinding;
import com.infotech4it.cibo.helpers.UIHelper;
import com.infotech4it.cibo.models.UserModel;

public class RegistrationActivity extends AppCompatActivity {
    private ActivityRegistrationBinding binding;
    private UserModel userModel;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registration);

        init();
    }

    private void init() {
        binding.setOnRegisterClick(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = firebaseDatabase.getReference("User");

        binding.setOnUserModel(userModel);
        userModel = new UserModel();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnUpdate: {
                registerUser();
                break;
            }
        }
    }

    public void registerUser() {
        firebaseAuth.createUserWithEmailAndPassword(binding.edtEmail.getText().toString(),
                binding.edtPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    SaveDataToDb();
                    UIHelper.openActivity(RegistrationActivity.this, HomeActivity.class);
                    UIHelper.showLongToastInCenter(RegistrationActivity.this, "" + task.getException().getMessage());
                } else {
                    UIHelper.showLongToastInCenter(RegistrationActivity.this, "" + task.getException().getMessage());
                }
            }
        });
    }

    private void SaveDataToDb() {
        userModel = new UserModel(binding.edtName.getText().toString(), binding.edtEmail.getText().toString(),
                binding.edtNumber.getText().toString(), binding.edtAddress.getText().toString(),
                binding.edtPassword.getText().toString());
        databaseReference.child(FirebaseAuth.getInstance().getUid()).setValue(userModel);
    }

    public boolean validation() {
        boolean check = true;
        binding.edtName.setError(null);
        binding.edtEmail.setError(null);
        binding.edtNumber.setError(null);
        binding.edtAddress.setError(null);
        binding.edtPassword.setError(null);
        binding.edtConfirmPass.setError(null);

        if (binding.edtName.getText().toString().isEmpty()) {
            binding.edtName.setError("Name Field cannot be empty");
            check = false;
        } else if (binding.edtEmail.getText().toString().isEmpty()) {
            binding.edtEmail.setError("Email Field cannot be empty");
            check = false;
        } else if (binding.edtNumber.getText().toString().isEmpty()) {
            binding.edtNumber.setError("Number Field cannot be empty");
            check = false;
        } else if (binding.edtNumber.getText().toString().length() < 11) {
            binding.edtNumber.setError("Number format is not correct");
            check = false;
        } else if (binding.edtAddress.getText().toString().isEmpty()) {
            binding.edtAddress.setError("Address Field cannot be empty");
            check = false;
        } else if (binding.edtPassword.getText().toString().isEmpty()) {
            binding.edtPassword.setError("Password cannot be empty");
            check = false;
        } else if (binding.edtConfirmPass.getText().toString().isEmpty()) {
            binding.edtConfirmPass.setError("Password cannot be empty");
            check = false;
        } else if (binding.edtPassword.getText().length() < 6) {
            binding.edtPassword.setError("Password should be 6 digit maximum");
            check = false;
        } else if (binding.edtConfirmPass.getText().length() < 6) {
            binding.edtConfirmPass.setError("Password should be 6 digit maximum");
            check = false;
        } else if (!binding.edtPassword.getText().toString().equals(binding.edtConfirmPass.getText().toString())) {
            binding.edtConfirmPass.setError("Password Mismatch");
            check = false;
        }
        return check;
    }
}