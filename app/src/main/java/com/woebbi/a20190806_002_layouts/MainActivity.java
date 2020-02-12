package com.woebbi.a20190806_002_layouts;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    //alles für die dings erstelleren
    private Toolbar mAToolbar;
    private FrameLayout mAFrameLayout;
    private ListView mAListViewEmail;
    //private ListView mAListViewNav;//DEAC for Recycler
    private FloatingActionButton mAFAB;
    private TextView mATextViewNoEmail;
    private EmailAdapter emailAdapter;

    //Recycler view test
    private RecyclerView mARecyclerView;

    private SharedPreferences sp;

    //ArrayListen für die jeweiligen EmailPunkte deklariernenenenen
    private ArrayList<Email> aListSent,aListReceived,aListDraft,aListSpam,aListTrash;

    private DrawerLayout maDrawerLayout;

    private RecyclerView.Adapter mAAdapter;
    private RecyclerView.LayoutManager mAlayoutManager;



    /*
    wir brauchen ein adapter,
    "" einen layout manager

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    von der webseite und anpassen




        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new RecyclerAdapter(myDataset);
        recyclerView.setAdapter(mAdapter);




     */




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ohne RecyclerView
        //setContentView(R.layout.activity_main);//DEAC for Recycler
        //mit Recyclerview
        setContentView(R.layout.activity_main_with_a_recyclerview);
        //Recycler View Verbinden und so
        mARecyclerView = findViewById(R.id.mainActivityListViewNavRecycler);


        mAToolbar = findViewById(R.id.mainActivityToolbar);
        mAFrameLayout = findViewById(R.id.mainActivityFrameLayout);
        mAListViewEmail = findViewById(R.id.mainActivityListViewEmail);
        //mAListViewNav = findViewById(R.id.mainActivityListViewNav); //DEAC for Recycler
        mAFAB = findViewById(R.id.mainActivityFAB);
        mATextViewNoEmail = findViewById(R.id.mainActivityTextViewNoEmail);


        //Falls man niocht per XML (siehe activity main unter listviewlav) mache will kann man das so mit den adapter machen

        //mAListViewNav = findViewById(R.id.mainActivityListViewNav);//DEAC for Recycler
        //mAListViewNav.setAdapter(new ArrayAdapter<String>(this, R.layout.activity_drawer, getResources().getStringArray(R.array.menuMenu)));//DEAC for Recycler


        //recycler

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mARecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mAlayoutManager = new LinearLayoutManager(this);
        mARecyclerView.setLayoutManager(mAlayoutManager);

        // specify an adapter (see also next example)
        mAAdapter = new RecyclerAdapter(null);//TODO replace null
        mARecyclerView.setAdapter(mAAdapter);




        //Toggle
        maDrawerLayout = findViewById(R.id.mainActivityDrawerLayout);
        ActionBarDrawerToggle mAdrawerToggle = new ActionBarDrawerToggle(this, maDrawerLayout, mAToolbar, R.string.openDrawerContentDescRes, R.string.closeDrawerContentDescRes);
        mAdrawerToggle.syncState();
        maDrawerLayout.addDrawerListener(mAdrawerToggle);


        //ArrayList inizialisieren
        aListReceived = new ArrayList<>();
        aListSent = new ArrayList<>();
        aListDraft = new ArrayList<>();
        aListSpam = new ArrayList<>();
        aListTrash = new ArrayList<>();



        //DummyDaten für die Listen
        aListReceived = Utils.fillTheDummy(10, "Received");
        aListSent = Utils.fillTheDummy(9, "Sent");
        aListDraft = Utils.fillTheDummy(8, "Draft");
        aListSpam = Utils.fillTheDummy(7, "Spam");
        aListTrash = Utils.fillTheDummy(6, "Trash");


        //Emailliste und adapter verbinden
        emailAdapter = new EmailAdapter(aListReceived, this);
        mAListViewEmail.setAdapter(emailAdapter);

        //Listeners
        mAFAB.setOnClickListener(this);


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
        Email emailResult = null;
        if (data != null) {
            emailResult = (Email) data.getSerializableExtra("email");

        }
        switch (requestCode) {
            case 100: //kommt aus der COMPOSEACTIVITY
                if (resultCode == 1) { //BEI GESENDET
                    //Wird in sentListe gemacht
                    aListSent.add(emailResult);

                    Toast.makeText(this, resultCode + "Result <1sent1> Request" + requestCode, Toast.LENGTH_LONG).show();
                } else if (resultCode == 2) {//BEI BACK
                    //wird in entwurfliste gepackt
                    aListDraft.add(emailResult);

                    Toast.makeText(this, resultCode + "Result <2notSent2> Request" + requestCode, Toast.LENGTH_LONG).show();
                } else {//Bei kaputt
                    //meep
                    Toast.makeText(this, resultCode + "Result <?> Request" + requestCode, Toast.LENGTH_LONG).show();
                }
                return;
            default:
                Toast.makeText(this, resultCode + "Result <?default?> Request" + requestCode, Toast.LENGTH_LONG).show();
                return;

        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}


