package hd.josh.daily.utils;

import android.app.Application;

import java.util.ArrayList;

import hd.josh.daily.objects.Day;

public class AppController extends Application {

    private static AppController mInstance;
    private ArrayList<Day> mDays;

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
}
