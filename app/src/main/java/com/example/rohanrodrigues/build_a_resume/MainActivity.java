package com.example.rohanrodrigues.build_a_resume;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private TextView registerIntent;
    private TextView loginText;
    private EditText mEMField;
    private EditText mPSField;
    private Button mLoginBtn;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerIntent = (TextView)findViewById(R.id.tvReg);
        loginText = (TextView)findViewById(R.id.tvLogin);
        setContentView(R.layout.activity_main);
        mEMField = (EditText)findViewById(R.id.etEmail);
        mPSField = (EditText)findViewById(R.id.etPass);
        mLoginBtn = (Button)findViewById(R.id.btnLogin);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
    }
    private void Login() {
        String email = mEMField.getText().toString().trim();
        String password = mPSField.getText().toString().trim();

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (/*task.isSuccessful()*/true) {
                     //   CheckExistance();
                        Intent login = new Intent(MainActivity.this, MainUserActivity.class );
                        login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(login);
                    if (task.isSuccessful()) {
                        CheckExistance();
                    } else {
                        Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_LONG).show();
                    }
                }

            });
        }
    }
    private void CheckExistance() {
        final String userid = mAuth.getCurrentUser().getUid();

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild(userid)) {
                    Intent login = new Intent(MainActivity.this, MainUserActivity.class );
                    login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(login);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



}
