package com.example.customlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<String> {

    String[] names;
    int[] flags;
    String[] usernames;
    String[] timestamps;
    Context mContext;

    public MyAdapter(Context context, String[] countryNames, int[] countryFlags, String[] username, String[] timestamp) {
        super(context, R.layout.listview_item);
        this.names = countryNames;
        this.flags = countryFlags;
        this.mContext = context;
        this.usernames = username;
        this.timestamps = timestamp;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.listview_item, parent, false);
            mViewHolder.mFlag = (ImageView) convertView.findViewById(R.id.imageViewMap);
            mViewHolder.mName = (TextView) convertView.findViewById(R.id.textView);
            mViewHolder.mUsername = (TextView) convertView.findViewById(R.id.tvUsername);
            mViewHolder.mTimestamp = (TextView) convertView.findViewById(R.id.tvTimestamp);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.mFlag.setImageResource(flags[position]);
        mViewHolder.mName.setText(names[position]);
        mViewHolder.mUsername.setText(usernames[position]);
        mViewHolder.mTimestamp.setText(timestamps[position]);
        return convertView;
    }

    static class ViewHolder {
        ImageView mFlag;
        TextView mName;
        TextView mUsername;
        TextView mTimestamp;
    }
}
