package com.woebbi.a20190806_002_layouts;

import java.util.ArrayList;

public class Utils {
    public static ArrayList<Email> fillTheDummy(int anz, String name) {
        ArrayList<Email> foobar = new ArrayList<>();
        for (int i = 0; i < anz; i++) {
            Email mail = new Email("", "", "subject" + i, name + i, null, null);
            foobar.add(mail);
        }
        return foobar;
    }
}
