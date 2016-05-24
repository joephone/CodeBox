package com.joephone.codebox.act.sliding.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import com.joephone.codebox.R;
/**
 * Created by chenpei on 2016/4/18.
 * 我的钓点 adapter
 */
public class MyFishSpotAdapter extends RecyclerView.Adapter {
    private String tag ="MyFishSpotAdapter";
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private MyItemClickListener mItemClickListener;

    List<String> array_list = Arrays.asList(
            "This",
            "Is",
            "An",

            "Example",
            "ListView",
            "That",
            "You",
            "Can",
            "Scroll",
            ".",
            "It",
            "Shows",
            "How",
            "Any",
            "Scrollable",
            "View",
            "Can",
            "Be",
            "Included",
            "As",
            "A",
            "Child",
            "Of",
            "SlidingUpPanelLayout"
    );

    /**
     * 设置Item点击监听
     * @param listener
     */
    public void setOnItemClickListener(MyItemClickListener listener){
        this.mItemClickListener = listener;
    }


    public MyFishSpotAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.mine_frag_myfishspot_item, parent, false),mItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).tvName.setText(array_list.get(position));
        //暂以position 作判断

//        String imageUrl = DisPlayImageOption.getInstance().getImageWH(array_list.get(position), ((ViewHolder) holder).ivEvent.getWidth(), ((ViewHolder) holder).ivEvent.getHeight(), false);
//        Log.i(tag, "imageUrl:" + imageUrl);
//        Uri imageUri = Uri.parse(imageUrl);
        //开始下载
//        userHeadIv.setImageURI(imageUri);
//        DisplayImage.getInstance().setCircle(userHeadIv);
//        DisplayImage.getInstance().displayNetworkImage(((ViewHolder) holder).ivEvent, imageUrl);
    }

    @Override
    public int getItemCount() {
        return array_list.size() > 0 ? array_list.size() : 0;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

        @Bind(R.id.tvName)
        TextView tvName;


        private MyItemClickListener mListener;

        public ViewHolder(View itemView,MyItemClickListener listener) {
            super(itemView);
//            R.layout.gofishing_event_item;
            ButterKnife.bind(this, itemView);
            this.mListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mListener != null){
                mListener.onItemClick(v,getPosition());
            }
        }
    }

    public interface MyItemClickListener {
        public void onItemClick(View view, int position);
    }
}
