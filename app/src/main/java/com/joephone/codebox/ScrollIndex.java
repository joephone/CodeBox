package com.joephone.codebox;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

//import com.joephone.codebox.activity.scrollview.MeiTuanMainActivity;
import com.joephone.codebox.act.scroll.act.MapScrollAct;
import com.joephone.codebox.act.scroll.act.PullToZoomAct;
//import com.joephone.codebox.activity.scrollview.ScrollRefreshActivity;
import com.joephone.codebox.act.scroll.act.TopFloatActivity;
import com.joephone.codebox.adapter.IndexAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScrollIndex extends Activity {
    @Bind(R.id.back)
    ImageView back;
    @Bind(R.id.title)
    TextView title;
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
        lvIndex.setOnItemClickListener(lvScrollViewIndexOnItemClickListner);
        sourceList.add("下拉回弹   PullToZoomScrollView");
        sourceList.add("仿美团悬浮   MeiTuanScrollView");
        sourceList.add("仿美团悬浮2推荐   TopFloatScrollView");
        sourceList.add("下拉刷新   ScrollRefresh");
        sourceList.add("地图锚定   MapViewScroll");

        adapter = new IndexAdapter(this, sourceList);
        lvIndex.setAdapter(adapter);
    }

    OnItemClickListener lvScrollViewIndexOnItemClickListner = new OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                long arg3) {
            Intent intent;
            Log.i(tag, "position:" + position);

            switch (position) {
                case 0:
                    intent = new Intent(context, PullToZoomAct.class);
                    startActivity(intent);
                    break;
//                case 1:
//                    intent = new Intent(context, MeiTuanMainActivity.class);
//                    startActivity(intent);
//                    break;
                case 2:
                    intent = new Intent(context, TopFloatActivity.class);
                    startActivity(intent);
                    break;
//                case 3:
//                    intent = new Intent(context, ScrollRefreshActivity.class);
//                    startActivity(intent);
//                    break;
                case 4:
                    intent = new Intent(context, MapScrollAct.class);
                    startActivity(intent);
                    break;
                case 5:
                    intent = new Intent(context, MapScrollAct.class);
                    startActivity(intent);
                    break;
                default:
                    break;
            }
        }
    };

    @OnClick({R.id.back})
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
        }
    }
}
