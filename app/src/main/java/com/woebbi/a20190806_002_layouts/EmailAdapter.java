package com.woebbi.a20190806_002_layouts;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
/* use for lists and the listview */

public class EmailAdapter extends ArrayAdapter<Email> {
    private ArrayList<Email> emails;
    private Context context;

    public EmailAdapter(ArrayList<Email> emails, Context context) {
        super(context, R.layout.activity_emaillist, emails);
        this.context = context;
        this.emails = emails;
    }

    @Override
    public int getCount() {
        return emails.size();
    }

    @Override
    public Email getItem(int position) {
        return emails.get(position);
    }

    @Override
    public long getItemId(int position) {
        //TODO
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //TODO fertig?
        Email mail = emails.get(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.activity_emaillist, parent, false);

        }

        //Connect/assosciate
        TextView emailListActivityDate = convertView.findViewById(R.id.emailListActivityDate);
        TextView emailListActivityFrom = convertView.findViewById(R.id.emailListActivityFrom);
        TextView emailListActivitySubject = convertView.findViewById(R.id.emailListActivitySubject);
        TextView emailListActivityText = convertView.findViewById(R.id.emailListActivityText);
        TextView emailListActivityTime = convertView.findViewById(R.id.emailListActivityTime);


        emailListActivityFrom.setText(mail.getFrom());
        emailListActivitySubject.setText(mail.getSubject());
        emailListActivityText.setText(mail.getMessage());


        //convert the CALENDAR OBJECT to the specific Time format
        CharSequence theTime = new SimpleDateFormat("HH:mm:ss").format(mail.getCalendar().getTime());
        CharSequence theDate = new SimpleDateFormat("yyyy.MM.dd").format(mail.getCalendar().getTime());
        emailListActivityDate.setText(theDate); //mail.getCalendar().get(Calendar.YEAR) + "." + (mail.getCalendar().get(Calendar.MONTH) + 1) + "." + mail.getCalendar().get(Calendar.DAY_OF_MONTH));
        emailListActivityTime.setText(theTime); //mail.getCalendar().get(Calendar.HOUR_OF_DAY) + ":" + (mail.getCalendar().get(Calendar.MINUTE) + 1) + ":" + mail.getCalendar().get(Calendar.SECOND));
//        emailListActivityDate.setText("");
//        emailListActivityTime.setText("");


        return convertView;
    }
}
