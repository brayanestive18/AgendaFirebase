package com.brayadiaz.agendafirebase;

import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    EditText eID, eName, eEmail, ePhone;
    Button bCreate, bUpdate, bRead, bDelete;

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


    }
}
