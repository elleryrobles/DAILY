package hd.josh.daily.objects;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

import hd.josh.daily.utils.Tools;

public class Entry implements Parcelable {
    protected Date mDate;
    protected String mDateTime;
    protected Weather mWeather;

    public Entry() {
        // empty constructor
    }

    public Entry(Date date, Weather weather) {
        mDate = date;
        mDateTime = Tools.getTime(mDate);
        mWeather = weather;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public String getDateTime() {
        return mDateTime;
    }

    public void setDateTime(String dateTime) {
        mDateTime = dateTime;
    }

    public Weather getWeather() {
        return mWeather;
    }

    public void setWeather(Weather weather) {
        mWeather = weather;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(mDate);
        dest.writeString(mDateTime);
        dest.writeParcelable(mWeather, flags);
    }


    public static final Parcelable.Creator<Entry> CREATOR = new Parcelable.Creator<Entry>() {
        public Entry createFromParcel(Parcel in)
        {
            return new Entry(in);
        }
        public Entry[] newArray(int size)
        {
            return new Entry[size];
        }
    };


    public Entry(Parcel in) {
        mDate = (Date)in.readSerializable();
        mDateTime = in.readString();
        mWeather = in.readParcelable(Weather.class.getClassLoader());
    }
}
