package hd.josh.daily.objects;

import android.os.Parcel;
import android.os.Parcelable;


public class SimpleEmotionalState implements Parcelable {
    private double mAnger;
    private double mFear;
    private double mHappiness;
    private double mSurprise;
    private double mSadness;
    private double mDisgust;

    public SimpleEmotionalState() {
        mAnger = 0.0;
        mFear = 0.0;
        mHappiness = 0.0;
        mSurprise = 0.0;
        mSadness = 0.0;
        mDisgust = 0.0;
    }

    public SimpleEmotionalState(double anger, double fear, double happiness,
                                double surprise, double sadness, double disgust) {
        mAnger = anger;
        mFear = fear;
        mHappiness = happiness;
        mSurprise = surprise;
        mSadness = sadness;
        mDisgust = disgust;
    }

    public double getAnger() {
        return mAnger;
    }

    public void setAnger(double anger) {
        mAnger = anger;
    }

    public double getFear() {
        return mFear;
    }

    public void setFear(double fear) {
        mFear = fear;
    }

    public double getHappiness() {
        return mHappiness;
    }

    public void setHappiness(double happiness) {
        mHappiness = happiness;
    }

    public double getSurprise() {
        return mSurprise;
    }

    public void setSurprise(double surprise) {
        mSurprise = surprise;
    }

    public double getSadness() {
        return mSadness;
    }

    public void setSadness(double sadness) {
        mSadness = sadness;
    }

    public double getDisgust() {
        return mDisgust;
    }

    public void setDisgust(double disgust) {
        mDisgust = disgust;
    }

    public String toString() {
        return "Anger: " + mAnger +
                "\nFear: " + mFear +
                "\nHappiness: " + mHappiness +
                "\nSurprise: " + mSurprise +
                "\nSadness: " + mSadness +
                "\nDisgust: " + mDisgust;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(mAnger);
        dest.writeDouble(mFear);
        dest.writeDouble(mHappiness);
        dest.writeDouble(mSurprise);
        dest.writeDouble(mSadness);
        dest.writeDouble(mDisgust);
    }


    public static final Parcelable.Creator<SimpleEmotionalState> CREATOR = new Parcelable.Creator<SimpleEmotionalState>() {
        public SimpleEmotionalState createFromParcel(Parcel in) {
            return new SimpleEmotionalState(in);
        }
        public SimpleEmotionalState[] newArray(int size) {
            return new SimpleEmotionalState[size];
        }
    };


    public SimpleEmotionalState(Parcel in) {
        mAnger = in.readDouble();
        mFear = in.readDouble();
        mHappiness = in.readDouble();
        mSurprise = in.readDouble();
        mSadness = in.readDouble();
        mDisgust = in.readDouble();
    }
}
