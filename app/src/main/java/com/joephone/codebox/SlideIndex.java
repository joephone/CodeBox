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

import com.joephone.codebox.act.scroll.act.MapScrollAct;
import com.joephone.codebox.act.scroll.act.PullToZoomAct;
import com.joephone.codebox.act.scroll.act.TopFloatActivity;
import com.joephone.codebox.act.sliding.act.SlidingCNAct;
import com.joephone.codebox.act.sliding.act.SlidingMapAct;
import com.joephone.codebox.act.sliding.act.SlidingUpPanelTestActivity;
import com.joephone.codebox.adapter.IndexAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;



public class SlideIndex extends Activity {
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
        sourceList.add("sliding_map  slidinguppanel_map");
        sourceList.add("SlidingUpPanelTestActivity");
        sourceList.add("SlidingUpPanel   中国eclipse版");
//        sourceList.add("下拉刷新   ScrollRefresh");
//        sourceList.add("地图锚定   MapViewScroll");

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
                    intent = new Intent(context, SlidingMapAct.class);
                    startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(context, SlidingUpPanelTestActivity.class);
                    startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(context, SlidingCNAct.class);
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
