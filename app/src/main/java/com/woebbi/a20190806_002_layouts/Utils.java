package com.woebbi.a20190806_002_layouts;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Utils {
    public static ArrayList<Email> fillTheDummy(int anz, String name) {
        ArrayList<Email> foobar = new ArrayList<>();
        for (int i = 0; i < anz; i++) {
            Email mail = new Email(name + i, i + name, "subject" + i + " " + name, name + i, randCal(2000000000), randDate(2000000000));
            foobar.add(mail);
        }
        return foobar;
    }

    public static Date randDate(int blub) {
        final Calendar cal = Calendar.getInstance();
        Random rand = new Random();

        cal.setTimeInMillis(System.currentTimeMillis() - rand.nextInt(blub));
        Date date = cal.getTime();

        return date;
    }

    public static Calendar randCal(int blub) {
        final Calendar cal = Calendar.getInstance();
        Random rand = new Random();

        cal.setTimeInMillis(System.currentTimeMillis() - rand.nextInt(blub));
        Date date = cal.getTime();
        return cal;
    }
}
