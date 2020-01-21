package com.woebbi.a20190806_002_layouts;

import android.content.Context;
import android.content.Intent;
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

import java.util.Date;

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
    public void onBackPressed() {
        sendMail(formEmail(),2);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuComposeSend:
                if (cAFromInput.length() > 0 && cAToInput.length() > 0 && cASubjectInput.length() > 0 /*&& !(cASubjectInput.getText().toString().equals(getText(R.string.composeActivitySubject))) */&& cATextContentInput.length() > 0){
                    Toast.makeText(this, "rein", Toast.LENGTH_LONG).show();
                    sendMail(formEmail(),1);
                }else{
                    Toast.makeText(this, "rausch", Toast.LENGTH_LONG).show();
                    if(cAToInput.length() == 0){
                        cAToInput.setText(R.string.composeActivityNeededTo);
                    }
                    if(cASubjectInput.length() == 0 /*||  cASubjectInput.getText().toString().equals(getText(R.string.composeActivitySubject))*/){
                        cASubjectInput.setText(R.string.composeActivityNeededSubject);
                    }
                    if(cATextContentInput.length() == 0){
                        cATextContentInput.setText(R.string.composeActivityNeededTextContent);
                    }
                }

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * is used to form a email object from the inputs and current date, receiveDate is null and is to be filled by other methodes
     * @return returns a "email" object
     */
    private Email formEmail(){
        String cAFrom = cAFromInput.getText().toString();
        String cATo = cAToInput.getText().toString();
        String cASubject = cASubjectInput.getText().toString();
        String cATextContent = cATextContentInput.getText().toString();
        Date dateNow = new Date();
        Email theMail = new Email(cATo,cAFrom,cASubject,cATextContent,dateNow,null);
        return theMail;
    }

    /**
     * is used to transfer object of type Email and the int sent to Intent MainActivity a
     * @param email expects a object of type "Email"
     * @param sent expects a int - 1 if sent, 2 if back/notsent
     */
    private void sendMail(Email email,int sent){
        Intent in = new Intent(this, MainActivity.class);
        in.putExtra("email",email);
        setResult(sent,in);
        finish();


    }
}
