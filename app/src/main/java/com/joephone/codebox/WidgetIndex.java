package com.joephone.codebox;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.joephone.codebox.act.widget.act.PhoneViewAct;
import com.joephone.codebox.act.widget.act.StarViewAct;
import com.joephone.codebox.adapter.IndexAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WidgetIndex extends Activity {
    @Bind(R.id.lvIndex)
    ListView lvIndex;

    private String tag = this.getClass().getName();
    private Context context;
    private IndexAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_index);
        ButterKnife.bind(this);
        initView();
        initListView();
    }

    private void initView() {
        context = this;
    }

    private void initListView() {
        List<String> sourceList = new ArrayList<String>();
        lvIndex.setOnItemClickListener(lvPicIndexOnItemClickListner);
        sourceList.add("号码分隔  PhoneViewAct");
        sourceList.add("星星评分控件，ratingbar，自定义大小，形状");


//        sourceList.add("左右滑动效果   ViewFipper");
//        sourceList.add("带动画的Gallary   GallarySwitcher");
//        sourceList.add("头像，拍照，获取本地图片，裁剪，显示圆形头像");
        adapter = new IndexAdapter(this, sourceList);
        lvIndex.setAdapter(adapter);
    }

    OnItemClickListener lvPicIndexOnItemClickListner = new OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                long arg3) {
            Intent intent;
            Log.i(tag, "position:" + position);
            switch (position) {
                case 0:
                    intent = new Intent(context, PhoneViewAct.class);
                    startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(context, StarViewAct.class);
                    startActivity(intent);
                    break;
//                case 1:
//                    intent = new Intent(context, ViewFipperActivity.class);
//                    startActivity(intent);
//                    break;
//                case 2:
//                    intent = new Intent(context, GallarySwitcherActitvity.class);
//                    startActivity(intent);
//                    break;
//                case 3:
//                    intent = new Intent(context, PicHeadSelectActivity.class);
//                    startActivity(intent);
//                    break;
                default:
                    break;
            }
        }
    };
}
