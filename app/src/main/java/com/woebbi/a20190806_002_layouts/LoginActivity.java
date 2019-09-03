package com.woebbi.a20190806_002_layouts;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Loginactivity ist fürs activity_login zuständig
 *
 * @author woebbi
 * @license beerware
 */

public class LoginActivity extends AppCompatActivity {
    private EditText lAPasswordInput;
    private EditText lAUsernameInput;
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
        lAPasswordInput = findViewById(R.id.loginActivityPasswordInput);
        lAButtonAbort = findViewById(R.id.loginActivityButtonAbort);
        lAButtonSend = findViewById(R.id.loginActivityButtonSend);
        lAEmailProviderList = findViewById(R.id.loginActivityEmailProviderList);

    }


}
