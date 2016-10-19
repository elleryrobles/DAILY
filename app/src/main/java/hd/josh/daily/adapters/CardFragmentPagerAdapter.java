package hd.josh.daily.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hd.josh.daily.objects.CardFragment;
import hd.josh.daily.objects.Day;
import hd.josh.daily.utils.AppController;

public class CardFragmentPagerAdapter extends FragmentStatePagerAdapter implements CardAdapter {

    private ArrayList<CardFragment> mFragments;
    private float mBaseElevation;
    private ArrayList<Day> mDays;

    public CardFragmentPagerAdapter(FragmentManager fm, float baseElevation, ArrayList<Day> days) {
        super(fm);
        mFragments = new ArrayList<>();
        mBaseElevation = baseElevation;
        mDays = days;

        for (int i = mDays.size() - 1; i >= 0; --i) {
            addCardFragment(CardFragment.newInstance(mDays.get(i), i));
        }
    }

    @Override
    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mFragments.get(position).getCardView();
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CardFragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public CardFragment instantiateItem(ViewGroup container, int position) {
        CardFragment fragment = (CardFragment) super.instantiateItem(container, position);
        mFragments.set(position, fragment);
        return fragment;
    }

    public void addCardFragment(CardFragment fragment) {
        mFragments.add(fragment);
    }
}
