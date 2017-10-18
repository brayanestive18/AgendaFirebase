package com.brayadiaz.agendafirebase;

import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    EditText eID, eName, eEmail, ePhone;
    Button bCreate, bUpdate, bRead, bDelete;

    int uid = 0;

    User user;

    DatabaseReference myRef;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.frame);
        getLayoutInflater().inflate(R.layout.activity_main, contentFrameLayout);

        eID = (EditText) findViewById(R.id.eID);
        eName = (EditText) findViewById(R.id.eName);
        eEmail = (EditText) findViewById(R.id.eEmail);
        ePhone = (EditText) findViewById(R.id.ePhone);
        bCreate = (Button) findViewById(R.id.bCreate);
        bUpdate = (Button) findViewById(R.id.bUpdate);
        bRead = (Button) findViewById(R.id.bRead);
        bDelete = (Button) findViewById(R.id.bDelete);

        // Write a message to the database
        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference myRef = database.getReference("message");

        //myRef.setValue("Hello, World!");

    }

    public void onClick(View view) {
        int id = view.getId();
        final String name, email, phone, uuid;


        database = FirebaseDatabase.getInstance();

        name = eName.getText().toString();
        email = eEmail.getText().toString();
        phone = ePhone.getText().toString();

        switch (id){
            case R.id.bCreate:
                myRef = database.getReference("Users").child("user"+uid);
                user = new User(name, email, phone, "user"+ uid);
                myRef.setValue(user);
                /*myRef = database.getReference("user"+uid).child("Name");
                myRef.setValue(name);
                myRef = database.getReference("user"+uid).child("Email");
                myRef.setValue(email);
                myRef = database.getReference("user"+uid).child("Phone");
                myRef.setValue(phone);*/

                uid++;
                clean();
                break;
            case R.id.bUpdate:

                uuid = eID.getText().toString();
                myRef = database.getReference("Users").child("user"+uuid);

                Map<String, Object> newData = new HashMap<>();
                newData.put("name", name);
                newData.put("email", email);
                newData.put("phone", phone);

                myRef.updateChildren(newData);
                break;
            case R.id.bRead:
                uuid = eID.getText().toString();
                myRef = database.getReference("Users");
                // Read from the database
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child("user"+uuid).exists()){

                            user = dataSnapshot.child("user"+uuid).getValue(User.class);
                            eName.setText(user.getName());
                            eEmail.setText(user.getEmail());
                            ePhone.setText(user.getPhone());

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                    }
                });

                break;
            case R.id.bDelete:
                uuid = eID.getText().toString();
                myRef = database.getReference("Users").child("user"+uuid);
                myRef.removeValue();
                break;
        }
    }

    private void clean() {
        eEmail.setText("");
        eName.setText("");
        ePhone.setText("");
        eID.setText("");
    }
}
