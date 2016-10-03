package hd.josh.daily.objects;

import android.os.Parcel;
import android.os.Parcelable;

import hd.josh.daily.utils.Tools;


public class Weather implements Parcelable {
    private int mCode;
    private int mIconRes;
    private String mText;

    public Weather(int weatherCode, String text) {
        mCode = weatherCode;
        mIconRes = Tools.getWeatherIcon(mCode);
        mText = text;
    }

    public int getCode() {
        return mCode;
    }

    public void setCode(int code) {
        mCode = code;
    }

    public int getIconRes() {
        return mIconRes;
    }

    public void setIconRes(int iconRes) {
        mIconRes = iconRes;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mCode);
        dest.writeInt(mIconRes);
        dest.writeString(mText);
    }


    public static final Parcelable.Creator<Weather> CREATOR = new Parcelable.Creator<Weather>() {
        public Weather createFromParcel(Parcel in)
        {
            return new Weather(in);
        }
        public Weather[] newArray(int size)
        {
            return new Weather[size];
        }
    };


    public Weather(Parcel in) {
        mCode = in.readInt();
        mIconRes = in.readInt();
        mText = in.readString();
    }
}
