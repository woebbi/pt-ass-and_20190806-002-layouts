package com.woebbi.a20190806_002_layouts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //alles für die dings erstelleren
    private Toolbar mAToolbar;
    private FrameLayout mAFrameLayout;
    private ListView mAListViewEmail;
    private ListView mAListViewNav;
    private FloatingActionButton mAFAB;
    private TextView mATextViewNoEmail;

    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAToolbar = findViewById(R.id.mainActivityToolbar);
        mAFrameLayout = findViewById(R.id.mainActivityFrameLayout);
        mAListViewEmail = findViewById(R.id.mainActivityListViewEmail);
        mAListViewNav = findViewById(R.id.mainActivityListViewNav);
        mAFAB = findViewById(R.id.mainActivityFAB);
        mATextViewNoEmail = findViewById(R.id.mainActivityTextViewNoEmail);


        //Listeners
        mAFAB.setOnClickListener(this);

        //LAyout für diese activity setzten

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == mAFAB.getId()) {
            Intent i = new Intent(this, ComposeActivity.class);
            startActivity(i);
        }
    }
}

