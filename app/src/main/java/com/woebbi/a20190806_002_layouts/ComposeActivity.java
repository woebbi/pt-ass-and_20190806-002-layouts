package com.woebbi.a20190806_002_layouts;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class ComposeActivity extends AppCompatActivity {
    private EditText cAFromInput, cAToInput, cASubjectInput, cATextContentInput;
    private Toolbar cAToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);
        cAFromInput = findViewById(R.id.composeActivityFromInput);
        cAToInput = findViewById(R.id.composeActivityToInput);
        cASubjectInput = findViewById(R.id.composeActivitySubjectInput);
        cATextContentInput = findViewById(R.id.composeActivityTextContentInput);
        cAToolbar =  findViewById(R.id.composeActivityToolbar);
        //Setzt toolbar
        setSupportActionBar(cAToolbar);


        SharedPreferences sp = getSharedPreferences("com.woebbi.a20190806_002_layouts", Context.MODE_PRIVATE);
        String username = sp.getString("user", "");
        cAFromInput.setText(username);
        cAFromInput.setEnabled(false);


    }
    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_compose, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuComposeSend:
                Toast.makeText(this, "ABC", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
