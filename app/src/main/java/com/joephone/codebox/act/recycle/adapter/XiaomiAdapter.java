package com.joephone.codebox.act.recycle.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.joephone.codebox.R;

/**
 * Created by LZL on 16/5/3.
 */
public class XiaomiAdapter extends RecyclerView.Adapter<XiaomiAdapter.MyHolder> {

    private Context context;

    public XiaomiAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyHolder holder = new MyHolder(LayoutInflater.from(context).inflate(R.layout.xiaomi_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.tv.setText("标题" + (position + 1));
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView tv;
        ImageView img;

        public MyHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.item_text);
            img = (ImageView) itemView.findViewById(R.id.img);
        }
    }
}
