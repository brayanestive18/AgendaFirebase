package com.brayadiaz.agendafirebase;

import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AgendaSQLite extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    EditText eID, eName, eEmail, ePhone;
    Button bCreate, bUpdate, bRead, bDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eID = (EditText) findViewById(R.id.eID);
        eName = (EditText) findViewById(R.id.eName);
        eEmail = (EditText) findViewById(R.id.eEmail);
        ePhone = (EditText) findViewById(R.id.ePhone);
        bCreate = (Button) findViewById(R.id.bCreate);
        bUpdate = (Button) findViewById(R.id.bUpdate);
        bRead = (Button) findViewById(R.id.bRead);
        bDelete = (Button) findViewById(R.id.bDelete);

    }

    public void onClick(View view) {
        int id = view.getId();
        final String name, email, phone, uuid;

        name = eName.getText().toString();
        email = eEmail.getText().toString();
        phone = ePhone.getText().toString();

        switch (id){
            case R.id.bCreate:

                break;
            case R.id.bUpdate:

                break;
            case R.id.bRead:

                break;
            case R.id.bDelete:

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
