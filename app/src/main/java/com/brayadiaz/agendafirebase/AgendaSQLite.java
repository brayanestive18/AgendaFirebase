package com.brayadiaz.agendafirebase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

public class AgendaSQLite extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    EditText eID, eName, eEmail, ePhone;
    Button bCreate, bUpdate, bRead, bDelete;

    ContactosSQLiteHelper contactosSQLiteHelper;
    SQLiteDatabase dbContactos;

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

        contactosSQLiteHelper = new ContactosSQLiteHelper(this, "AgendaDB", null, 1);
        dbContactos = contactosSQLiteHelper.getWritableDatabase();

    }

    public void onClick(View view) {
        int id = view.getId();
        final String name, email, phone, uuid;

        name = eName.getText().toString();
        email = eEmail.getText().toString();
        phone = ePhone.getText().toString();

        switch (id){
            case R.id.bCreate:

                ContentValues data = new ContentValues();
                data.put("name",name);
                data.put("phone",phone);
                data.put("email",email);

                dbContactos.insert("contactos", null,data);
                clean();

                break;
            case R.id.bUpdate:

                break;
            case R.id.bRead:

                Cursor c = dbContactos.rawQuery("SELECT * FROM contactos WHERE name='"+name+"'",null);
                if (c.moveToFirst()){
                    ePhone.setText(c.getString(2));
                    eEmail.setText(c.getString(3));
                } else {
                    Toast.makeText(this, "No Existe", Toast.LENGTH_SHORT).show();
                }

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
