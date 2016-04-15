package com.joephone.codebox.adapter;

/**
 * Created by joephone on 2016/4/14.
 */
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.joephone.codebox.R;

public class IndexAdapter  extends BaseAdapter {
    private Context context;
    private List<String> sourceList = new ArrayList<String>();


    public IndexAdapter(Context context, List<String> sourceList) {
        super();
        this.context = context;
        this.sourceList = sourceList;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return sourceList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return sourceList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        String str = sourceList.get(position);
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.main_index_item, null);
            holder = initHolder(convertView);
            convertView.setTag(holder);
        }
        initData(holder, position, str, convertView);
        return convertView;
    }


    private void initData(ViewHolder holder, int position, String str,
                          View convertView) {
        if (null != str) {
            holder.tvMainIndexTip.setText(str);
        }
    }

    private ViewHolder initHolder(View convertView) {
        ViewHolder holder = new ViewHolder();
        holder.tvMainIndexTip = (TextView) convertView.findViewById(R.id.tvMainIndexTip);
        return holder;
    }

    public class ViewHolder {
        private TextView tvMainIndexTip;
    }
}