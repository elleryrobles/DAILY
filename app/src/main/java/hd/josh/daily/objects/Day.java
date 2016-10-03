package hd.josh.daily.objects;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hd.josh.daily.utils.Tools;

public class Day implements Parcelable{
    private Date mDate;
    private String mDateDay;
    private String mDateYear;
    private int mSentiment; //-1, 0, +1
    private SimpleEmotionalState mCombinedState;
    private ArrayList<Entry> mEntries;

    public Day(Date date) {
        mDate = date;
        mDateDay = Tools.getDay(mDate);
        mDateYear = Tools.getDay(mDate);
        mSentiment = 0;
        mEntries = new ArrayList<>();
        mCombinedState = new SimpleEmotionalState();
    }

    public Day(Date date, ArrayList<Entry> entries, int sentiment) {
        mDate = date;
        mDateDay = Tools.getDay(mDate);
        mDateYear = Tools.getDay(mDate);
        mSentiment = sentiment;
        mEntries = entries;
        updateCombinedState();
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public String getDateDay() {
        return mDateDay;
    }

    public void setDateDay(String dateDay) {
        mDateDay = dateDay;
    }

    public String getDateYear() {
        return mDateYear;
    }

    public void setDateYear(String dateYear) {
        mDateYear = dateYear;
    }

    public int getSentiment() {
        return mSentiment;
    }

    public void setSentiment(int sentiment) {
        mSentiment = sentiment;
    }

    public List<Entry> getEntries() {
        return mEntries;
    }

    public void updateEntries(ArrayList<Entry> entries) {
        mEntries = entries;
        updateCombinedState();
    }

    public Entry getEntry(int position) {
        return mEntries.get(position);
    }

    public void updateEntry(Entry entry, int position) {
        mEntries.set(position, entry);
        updateCombinedState();
    }

    public void addEntry(Entry entry) {
        mEntries.add(entry);
        updateCombinedState();
    }


    public void updateCombinedState() {
        ArrayList<Double> anger = new ArrayList<>();
        ArrayList<Double> fear = new ArrayList<>();
        ArrayList<Double> happiness = new ArrayList<>();
        ArrayList<Double> surprise = new ArrayList<>();
        ArrayList<Double> sadness = new ArrayList<>();
        ArrayList<Double> disgust = new ArrayList<>();

        for (Entry entry : mEntries) {
            if (entry instanceof EntryText) {
                SimpleEmotionalState entryState = ((EntryText)entry).getEmotionalState();
                anger.add(entryState.getAnger());
                fear.add(entryState.getFear());
                happiness.add(entryState.getHappiness());
                surprise.add(entryState.getSurprise());
                sadness.add(entryState.getSadness());
                disgust.add(entryState.getDisgust());
            }
        }

        mCombinedState = new SimpleEmotionalState(
                Tools.avg(anger),
                Tools.avg(fear),
                Tools.avg(happiness),
                Tools.avg(surprise),
                Tools.avg(sadness),
                Tools.avg(disgust)
        );
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(mDate);
        dest.writeString(mDateDay);
        dest.writeString(mDateYear);
        dest.writeInt(mSentiment);
        dest.writeList(mEntries);
    }


    public static final Parcelable.Creator<Day> CREATOR = new Parcelable.Creator<Day>() {
        public Day createFromParcel(Parcel in)
        {
            return new Day(in);
        }
        public Day[] newArray(int size)
        {
            return new Day[size];
        }
    };


    public Day(Parcel in) {
        mDate = (Date)in.readSerializable();
        mDateDay = in.readString();
        mDateYear = in.readString();
        mSentiment = in.readInt();
        mEntries = new ArrayList<Entry>();
        in.readList(mEntries, Entry.class.getClassLoader());
    }
}
