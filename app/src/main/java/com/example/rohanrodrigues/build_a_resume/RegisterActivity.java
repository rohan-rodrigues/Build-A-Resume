package com.example.rohanrodrigues.build_a_resume;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    private TextView registertext;
    private EditText mNameField;
    private EditText mEmailField;
    private EditText mPasswordField;
    private Button mRegisterBtn;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private ProgressDialog mprogressdialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mNameField = (EditText)findViewById(R.id.etName);
        mEmailField = (EditText)findViewById(R.id.etemail);
        mPasswordField = (EditText)findViewById(R.id.etpasswrd);
        mRegisterBtn = (Button)findViewById(R.id.btnReg);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");
        mprogressdialog = new ProgressDialog(this);

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }
    private void register() {
        final String name = mNameField.getText().toString().trim();
        String Email = mEmailField.getText().toString().trim();
        final String Password = mPasswordField.getText().toString().trim();

        if (!TextUtils.isEmpty(name) || !TextUtils.isEmpty(Email) || !TextUtils.isEmpty(Password)) {
            mprogressdialog.setMessage("Registering...");
            mprogressdialog.show();

            mAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    String uid = mAuth.getCurrentUser().getUid();
                    DatabaseReference cu_db = mDatabase.child(uid);
                    cu_db.child("name").setValue(name);
                    cu_db.child("password").setValue(Password);
                    mprogressdialog.dismiss();
                    Intent goToLogin = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(goToLogin);
                }
            });
        }
    }
}
