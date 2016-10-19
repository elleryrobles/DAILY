package hd.josh.daily.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import hd.josh.daily.R;
import hd.josh.daily.objects.Entry;
import hd.josh.daily.objects.EntryText;


public class EntryAdapter extends RecyclerView.Adapter<EntryAdapter.EntryViewHolder>
{
    private Context mContext;
    private List<Entry> mEntries;

    public EntryAdapter(Context context, List<Entry> entries) {
        super();
        mContext = context;
        mEntries = entries;
    }

    @Override
    public void onBindViewHolder(EntryViewHolder holder, final int position) {
        switch (getItemViewType(position)) {
            case 0:
                initEntryText(holder, position);
                break;
        }
    }


    private void initEntryText(EntryViewHolder holder, final int position) {
        final EntryText entry = (EntryText)mEntries.get(position);

        holder.entryWeatherImage.setImageResource(entry.getWeather().getIconRes());
        holder.entryTimestamp.setText(entry.getDateTime());
        holder.entryText.setText(entry.getText());

        holder.entryLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, entry.getState().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        Entry entry = mEntries.get(position);

        if (entry instanceof EntryText) {
            return 0;
        }

        return 0;
    }

    @Override
    public int getItemCount() {
        return mEntries.size();
    }

    public void updateEntries(List<Entry> entries) {
        mEntries = entries;
        notifyDataSetChanged();
    }

    class EntryViewHolder extends RecyclerView.ViewHolder
    {
        public LinearLayout entryLayout;
        public ImageView entryWeatherImage;
        public TextView entryTimestamp;
        public TextView entryText;

        public EntryViewHolder(View itemView)
        {
            super(itemView);
            entryLayout = (LinearLayout) itemView.findViewById(R.id.entry_layout);
            entryWeatherImage = (ImageView) itemView.findViewById(R.id.entry_weather_icon);
            entryTimestamp = (TextView) itemView.findViewById(R.id.entry_timestamp);
            entryText = (TextView) itemView.findViewById(R.id.entry_text);
        }
    }

    @Override
    public EntryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_entry, parent, false);
        return new EntryViewHolder(v);
    }
}