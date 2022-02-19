package com.example.bachelorhelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    EditText inputEmail, inputPass;
    Button loginButton;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginToSignupOption = (Button) findViewById(R.id.loginPageSignupButton);
        loginToSignupOption.setOnClickListener(v -> openSignupOptionActivity());

        inputEmail = findViewById(R.id.loginPageEmailInput);
        inputPass = findViewById(R.id.loginPagePasswordInput);
        loginButton = findViewById(R.id.loginPageLoginButton);

        progressDialog = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogin();
            }
        });

    }

    private void performLogin() {
        String email = inputEmail.getText().toString();
        String password = inputPass.getText().toString();

        if(!email.matches(emailPattern)){
            inputEmail.setError("Invalid email address");
        }else if(password.isEmpty() || password.length()< 6){
            inputPass.setError("Password must not be empty or at least 6 characters long");
        }else {
            progressDialog.setMessage("Logging...");
            progressDialog.setTitle("Login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                     if(task.isSuccessful()){
                         progressDialog.dismiss();
                         sendUserToCustomerHomePageActivity();
                         Toast.makeText(LoginActivity.this, "Login  successful", Toast.LENGTH_SHORT).show();
                     }else{
                         Toast.makeText(LoginActivity.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                     }
                }
            });
        }
    }

    private void sendUserToCustomerHomePageActivity() {
        Intent intent = new Intent(LoginActivity.this, CustomerHomePageActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void openSignupOptionActivity(){
        Intent intent = new Intent(this, SignupOptionActivity.class);
        startActivity(intent);
    }
}