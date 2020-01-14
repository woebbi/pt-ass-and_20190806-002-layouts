package com.woebbi.a20190806_002_layouts;
//package com.woebbi.a20190806_002_layouts;
import androidx.annotation.Nullable;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //alles für die dings erstelleren
    private Toolbar mAToolbar;
    private FrameLayout mAFrameLayout;
    private ListView mAListViewEmail;
    private ListView mAListViewNav;
    private FloatingActionButton mAFAB;
    private TextView mATextViewNoEmail;

    private SharedPreferences sp;

    //ArrayListen für die jeweiligen EmailPunkte deklariernenenenen
    private ArrayList<Email> aListSent,aListReceived,aListDraft,aListSpam,aListTrash;


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

        //ArrayList inizialisieren
        aListReceived = new ArrayList<>();
        aListSent = new ArrayList<>();
        aListDraft = new ArrayList<>();
        aListSpam = new ArrayList<>();
        aListTrash = new ArrayList<>();


        //Listeners
        mAFAB.setOnClickListener(this);

        //DummyDaten für die Listen
        aListReceived = Utils.fillTheDummy(10, "Received");
        aListSent = Utils.fillTheDummy(9, "Sent");
        aListDraft = Utils.fillTheDummy(8, "Draft");
        aListSpam = Utils.fillTheDummy(7, "Spamm");
        aListTrash = Utils.fillTheDummy(6, "Trash");


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == mAFAB.getId()) {
            Intent i = new Intent(this, ComposeActivity.class);
            //Starten der
            startActivityForResult(i, 100);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, aListReceived.size() + " " + aListSent.size() + " " + aListDraft.size() + " " + aListSpam.size() + " " + aListTrash.size() + " ", Toast.LENGTH_LONG).show();
        switch (requestCode) {
            case 100: //kommt aus der COMPOSEACTIVITY
                if (resultCode == 1) { //BEI GESENDET
                    //Wird in sentListe gemacht
                    Toast.makeText(this, resultCode + "Result <1sent1> Request" + requestCode, Toast.LENGTH_LONG).show();
                } else if (resultCode == 2) {//BEI BACK
                    //wird in entwurfliste gepackt
                    Toast.makeText(this, resultCode + "Result <2notSent2> Request" + requestCode, Toast.LENGTH_LONG).show();
                } else {//BEI ZURÜCK
                    //meep
                    Toast.makeText(this, resultCode + "Result <?> Request" + requestCode, Toast.LENGTH_LONG).show();
                }
                return;
            default:
                Toast.makeText(this, resultCode + "Result <???????> Request" + requestCode, Toast.LENGTH_LONG).show();
                return;

        }
    }
}


