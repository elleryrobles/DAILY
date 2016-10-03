package hd.josh.daily.utils;

import android.app.Application;

import java.util.ArrayList;
import java.util.Date;

import hd.josh.daily.R;
import hd.josh.daily.objects.Day;
import hd.josh.daily.objects.Entry;
import hd.josh.daily.objects.EntryText;
import hd.josh.daily.objects.Weather;

public class AppController extends Application {

    private static AppController mInstance;
    private ArrayList<Day> mDays = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    public ArrayList<Day> getDays() {
        return mDays;
    }

    public void generateTestDays(int quantity) {
        mDays = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            Date date = Tools.today();
            ArrayList<Entry> entries = new ArrayList<>();

            entries.add(new EntryText(
                    date,
                    new Weather(800, "Clear"),
                    getString(R.string.pl_post_short)
            ));

            entries.add(new EntryText(
                    date,
                    new Weather(210, "Lightning"),
                    getString(R.string.pl_post_med)
            ));

            entries.add(new EntryText(
                    date,
                    new Weather(700, "Fog"),
                    getString(R.string.pl_post_long)
            ));

            mDays.add(new Day(date, entries, 0));
        }
    }
}
