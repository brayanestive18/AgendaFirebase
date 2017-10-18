package com.brayadiaz.agendafirebase;

import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class ListaActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_lista);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.frame);
        getLayoutInflater().inflate(R.layout.activity_lista, contentFrameLayout);
    }
}
