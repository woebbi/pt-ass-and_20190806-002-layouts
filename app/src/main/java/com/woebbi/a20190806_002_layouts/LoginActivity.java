package com.woebbi.a20190806_002_layouts;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Loginactivity ist fürs activity_login zuständig
 *
 * @author woebbi
 * @license beerware
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText lAPasswordInput;
    private TextView lAPasswordText;
    private EditText lAUsernameInput;
    private TextView lAUsernameText;
    private Button lAButtonSend;
    private Button lAButtonAbort;
    private Spinner lAEmailProviderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //LAyout für diese activity setzten
        setContentView(R.layout.activity_login);

        //assosiate internal class variable with the loginActivity IDs
        lAUsernameInput = findViewById(R.id.loginActivityUsernameInput);
        lAUsernameText = findViewById(R.id.loginActivityUsernameText);
        lAPasswordInput = findViewById(R.id.loginActivityPasswordInput);
        lAPasswordText = findViewById(R.id.loginActivityPasswordText);
        lAButtonAbort = findViewById(R.id.loginActivityButtonAbort);
        lAButtonSend = findViewById(R.id.loginActivityButtonSend);
        lAEmailProviderList = findViewById(R.id.loginActivityEmailProviderList);

        //2 wege - der anonyme  - nur lokal für den einen button
        /*
        lAButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //anweisung
            }
        });
        */

        //2 wege - der andere weg - global
        // oben "implements..."-> onclicklistener -> auf die rote birne -> dann kommt unten @override publich void onclickviewview
        lAButtonSend.setOnClickListener(this); //nicht vergessen sonst doof
        lAButtonAbort.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        //R.id.loginActivityPasswordText
        if (view.getId() == lAButtonSend.getId()) {
            Toast.makeText(this, "Anmelden", Toast.LENGTH_LONG).show();
            lAUsernameText.setTextColor(getColor(R.color.colorPrimaryDark));
        } else if (view.getId() == lAButtonAbort.getId()) {
            lAUsernameText.setTextColor(getColor(R.color.colorAccent));
            Toast.makeText(this, "Abrechen", Toast.LENGTH_LONG).show();
        }
    }
}
