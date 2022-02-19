package com.example.bachelorhelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CustomerSignupActivity extends AppCompatActivity {
    TextView inputName;
    EditText inputEmail, inputPass;
    Button signupButton;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    DatabaseReference databaseReference;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_signup);
        Button customerSignupToLogin = (Button) findViewById(R.id.customerSignupPageLoginButton);
        customerSignupToLogin.setOnClickListener(v -> openLoginPageActivity());

        inputEmail = findViewById(R.id.customerSignupPageEmailInput);
        inputPass = findViewById(R.id.customerSignupPagePasswordInput);
        signupButton = findViewById(R.id.customerSignupPageSignupButton);
        inputName = findViewById(R.id.customerSignupPageCustomerNameInput);

        progressDialog = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        databaseReference = FirebaseDatabase.getInstance().getReference("Customers");

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAuthentication();
                sendName();
            }
        });

    }

    private void sendName() {
        String name = inputName.getText().toString();
        String email = inputEmail.getText().toString();
        String password = inputPass.getText().toString();

        databaseReference.child("name:").setValue(name);
        databaseReference.child("email:").setValue(email);
        databaseReference.child("password:").setValue(password);

    }

    private void performAuthentication() {
        String email = inputEmail.getText().toString();
        String password = inputPass.getText().toString();



        if(!email.matches(emailPattern)){
            inputEmail.setError("Invalid email address");
        }else if(password.isEmpty() || password.length()< 6){
            inputPass.setError("Password must not be empty or at least 6 characters long");
        }else{
            progressDialog.setMessage("Registering...");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUserToCustomerHomePageActivity();
                        Toast.makeText(CustomerSignupActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(CustomerSignupActivity.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void sendUserToCustomerHomePageActivity() {
        Intent intent = new Intent(CustomerSignupActivity.this, CustomerHomePageActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void openLoginPageActivity(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}