package com.joephone.codebox.act.list.adapter;



import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.joephone.codebox.R;


/**
 * Created by Joephone on 2016/5/23.
 */

public class SimpleGroupAdapter extends BaseAdapter {

    private LayoutInflater mInflater;

    private List<Map<String, String>> listData;

    private List<Map<String, String>> splitData;

    public SimpleGroupAdapter(Context context,
                              List<Map<String, String>> listData,
                              List<Map<String, String>> splitData) {
        this.mInflater = LayoutInflater.from(context);
        this.listData = listData;
        this.splitData = splitData;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean isEnabled(int position) {
        if (splitData.contains(listData.get(position))) {
            return false;
        }
        return super.isEnabled(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (splitData.contains(listData.get(position))) {
            convertView = mInflater.inflate(R.layout.list_group_tag, null);
        } else {
            convertView = mInflater.inflate(R.layout.list_group_child, null);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.itemTitle);
        textView.setText(listData.get(position).get("itemTitle"));

        return convertView;
    }

}