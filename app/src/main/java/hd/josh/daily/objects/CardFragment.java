package hd.josh.daily.objects;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hd.josh.daily.R;
import hd.josh.daily.adapters.CardAdapter;
import hd.josh.daily.adapters.EntryAdapter;

public class CardFragment extends Fragment {

    public static final String EXTRA_DAY = "extra_string";

    private CardView mCardView;
    private TextView mDayDate;
    private TextView mDayYear;
    private RecyclerView mDayEntryRecycler;

    private EntryAdapter mEntryAdapter;
    private Day mDay;

    public static CardFragment newInstance(Day day) {
        CardFragment fragment = new CardFragment();
        Bundle bundle = new Bundle(1);
        bundle.putParcelable(EXTRA_DAY, day);
        fragment.setArguments(bundle);
        return fragment ;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDay = getArguments().getParcelable(EXTRA_DAY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.card_page, container, false);
        mCardView = (CardView) view.findViewById(R.id.card_view);
        mDayDate = (TextView) view.findViewById(R.id.day_date);
        mDayYear = (TextView) view.findViewById(R.id.day_year);
        mDayEntryRecycler = (RecyclerView) view.findViewById(R.id.day_entry_recycler);

        mCardView.setMaxCardElevation(mCardView.getCardElevation() * CardAdapter.MAX_ELEVATION_FACTOR);
        mDayDate.setText(mDay.getDateDay());
        mDayYear.setText(mDay.getDateYear());

        mEntryAdapter = new EntryAdapter(getContext(), mDay.getEntries());
        mDayEntryRecycler.setAdapter(mEntryAdapter);
        mDayEntryRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    public CardView getCardView() {
        return mCardView;
    }
}
