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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import hd.josh.daily.R;
import hd.josh.daily.adapters.CardAdapter;
import hd.josh.daily.adapters.EntryAdapter;

public class CardFragment extends Fragment {

    public static final String EXTRA_DAY = "extra_string";
    public static final String EXTRA_POS = "extra_position";

    private CardView mCardView;
    private LinearLayout mHeader;
    private TextView mDayDate;
    private TextView mDayYear;
    private RecyclerView mDayEntryRecycler;

    private EntryAdapter mEntryAdapter;
    private Day mDay;
    private int mPos;

    public static CardFragment newInstance(Day day, int pos) {
        CardFragment fragment = new CardFragment();
        Bundle bundle = new Bundle(2);
        bundle.putParcelable(EXTRA_DAY, day);
        bundle.putInt(EXTRA_POS, pos);
        fragment.setArguments(bundle);
        return fragment ;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDay = getArguments().getParcelable(EXTRA_DAY);
        mPos = getArguments().getInt(EXTRA_POS);

        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.card_page, container, false);
        mCardView = (CardView) view.findViewById(R.id.card_view);
        mHeader = (LinearLayout) view.findViewById(R.id.day_header);
        mDayDate = (TextView) view.findViewById(R.id.day_date);
        mDayYear = (TextView) view.findViewById(R.id.day_year);
        mDayEntryRecycler = (RecyclerView) view.findViewById(R.id.day_entry_recycler);

        mCardView.setMaxCardElevation(mCardView.getCardElevation() * CardAdapter.MAX_ELEVATION_FACTOR);
        // workaround for ShadowTransformer failing to animate the first card if it's the last in the adapter
        if (mPos == 0) {
            mCardView.animate().scaleY(1.1f);
            mCardView.animate().scaleX(1.1f);
        } else {
            mCardView.animate().scaleY(1.0f);
            mCardView.animate().scaleX(1.0f);
        }

        mHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), mDay.getCombinedState().toString(), Toast.LENGTH_LONG).show();
            }
        });

        mDayDate.setText(mDay.getDateDay());
//        mDayYear.setText(mDay.getDateYear());
        mDayYear.setText("Card: " + mPos);

        mEntryAdapter = new EntryAdapter(getContext(), mDay.getEntries());
        mDayEntryRecycler.setAdapter(mEntryAdapter);
        mDayEntryRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    public CardView getCardView() {
        return mCardView;
    }
}
