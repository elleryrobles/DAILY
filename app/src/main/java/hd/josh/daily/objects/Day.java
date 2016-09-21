package hd.josh.daily.objects;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hd.josh.daily.tools.Tools;

/**
 * Created by Josh HD on 9/20/2016.
 */

public class Day {
    private Date mDate;
    private String mDateDay;
    private String mDateYear;
    private List<Entry> mEntries;
    private int mSentiment; //-1, 0, +1

    public Day(Date date) {
        mDate = date;
        mDateDay = Tools.getDay(mDate);
        mDateYear = Tools.getDay(mDate);
        mEntries = new ArrayList<>();
        mSentiment = 0;
    }

    public Day(Date date, List<Entry> entries, int sentiment) {
        mDate = date;
        mDateDay = Tools.getDay(mDate);
        mDateYear = Tools.getDay(mDate);
        mEntries = entries;
        mSentiment = sentiment;
    }
}
