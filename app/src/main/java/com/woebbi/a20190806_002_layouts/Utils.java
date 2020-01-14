package com.woebbi.a20190806_002_layouts;

import java.util.ArrayList;

public class Utils {
    private static ArrayList<Email> foobar;
    private static Email mail;

    public static ArrayList<Email> fillTheDummy(int anz, String name) {
        foobar = new ArrayList<>();
        for (int i = 0; i < anz; i++) {
            mail = new Email(name + i, "From" + i, "subject" + i, "message" + i, null, null);
            foobar.add(mail);
        }
        return foobar;
    }
}
