package com.woebbi.a20190806_002_layouts;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class EmailAdapter extends BaseAdapter {
    private ArrayList<Email> emails;

    public EmailAdapter(ArrayList<Email> emails) {
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
        //TODO
        return null;
    }
}
