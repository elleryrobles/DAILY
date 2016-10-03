package hd.josh.daily.objects;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

import synesketch.emotion.EmotionalState;

public class EntryText extends Entry {
    private String mText;
    private SimpleEmotionalState mState;

    public EntryText() {
        // empty constructor
    }

    public EntryText(String entryText, EmotionalState state) {
        mText = entryText;
        mState = state.getSimpleState();
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public SimpleEmotionalState getEmotionalState() {
        return mState;
    }

    public void setEmotionalState(EmotionalState state) {
        mState = state.getSimpleState();
    }

    public void setEmotionalState(SimpleEmotionalState state) {
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
