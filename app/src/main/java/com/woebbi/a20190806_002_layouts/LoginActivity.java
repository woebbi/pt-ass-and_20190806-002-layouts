package com.woebbi.a20190806_002_layouts;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Loginactivity ist fürs activity_login zuständig
 *
 * @author woebbi
 * @
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //LAyout für diese activity setzten
        setContentView(R.layout.activity_login);
    }
}
