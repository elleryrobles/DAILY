package hd.josh.daily.objects;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.IOException;
import java.util.Date;

import hd.josh.daily.utils.Tools;
import synesketch.emotion.EmotionalState;
import synesketch.emotion.Empathyscope;

public class EntryText extends Entry {
    private String mText;
    private SimpleEmotionalState mState = new SimpleEmotionalState();

    public EntryText() {
        // empty constructor
    }

    public EntryText(Date date, Weather weather, String entryText) {
        mDate = date;
        mDateTime = Tools.getTime(mDate);
        mWeather = weather;
        mText = entryText;

//        mState = new SimpleEmotionalState();

        try {
            mState = Empathyscope.getInstance().feel(mText).getSimpleState();
        } catch(IOException e) {
            e.printStackTrace();
            mState = new SimpleEmotionalState();
        }
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public SimpleEmotionalState getState() {
        return mState;
    }

    public void setState(SimpleEmotionalState state) {
        mState = state;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(mDate);
        dest.writeString(mDateTime);
        dest.writeParcelable(mWeather, flags);
        dest.writeString(mText);
        dest.writeParcelable(mState, flags);
    }

    public static final Parcelable.Creator<EntryText> CREATOR = new Parcelable.Creator<EntryText>() {
        public EntryText createFromParcel(Parcel in)
        {
            return new EntryText(in);
        }
        public EntryText[] newArray(int size)
        {
            return new EntryText[size];
        }
    };


    public EntryText(Parcel in) {
        mDate = (Date)in.readSerializable();
        mDateTime = in.readString();
        mWeather = in.readParcelable(Weather.class.getClassLoader());
        mText = in.readString();
        mState = in.readParcelable(SimpleEmotionalState.class.getClassLoader());
    }
}
