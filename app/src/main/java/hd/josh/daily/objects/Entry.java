package hd.josh.daily.objects;

import java.util.Date;

import hd.josh.daily.tools.Tools;

/**
 * Created by Josh HD on 9/20/2016.
 */

public class Entry {
    private Date mDate;
    private String mDateTime;
    private Weather mWeather;

    public Entry(Date date, Weather weather) {
        mDate = date;
        mDateTime = Tools.getTime(mDate);
        mWeather = weather;
    }
}
