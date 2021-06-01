package com.rawtalent.bitsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {
    EditText phonenumber;
    Button getotpbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


//        mauth.getFirebaseAuthSettings().setAppVerificationDisabledForTesting(true);

        phonenumber = findViewById(R.id.phoneNumber);
        getotpbtn = findViewById(R.id.getOTPBtn);
        getotpbtn.setOnClickListener(view -> {
                    if (!phonenumber.getText().toString().trim().isEmpty()) {
                        if (phonenumber.getText().toString().trim().length() == 10) {
                            PhoneAuthProvider.getInstance()
                                    .verifyPhoneNumber(
                                            "+91" + phonenumber.getText().toString(),
                                            60,
                                            TimeUnit.SECONDS,
                                            LoginActivity.this,
                                            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                                @Override
                                                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                                                }

                                                @Override
                                                public void onVerificationFailed(@NonNull FirebaseException e) {
                                                    Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                                }

                                                @Override
                                                public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                                    Intent intent = new Intent(getApplicationContext(), otpVerificationActivity.class);
                                                    intent.putExtra("mobile", phonenumber.getText().toString());
                                                intent.putExtra("backEndOTP", s);
                                                    startActivity(intent);
                                                }
                                            }
                                    );
                        } else {
                            Toast.makeText(LoginActivity.this, "Phone number must be of 10 digits", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "Enter the number", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}  