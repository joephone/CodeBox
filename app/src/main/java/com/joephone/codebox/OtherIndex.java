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

import com.joephone.codebox.adapter.IndexAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class OtherIndex extends Activity {
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
        sourceList.add("设置，setting index");
//        sourceList.add("BMI健康顾问，health");
//        sourceList.add("指南针   compass");
//        sourceList.add("计时器   Timer");
//        sourceList.add("倒时器   TimerCountDown");
//        sourceList.add("投票   Vote");
//        sourceList.add("数字提醒   BadgeView");
//        sourceList.add("计算器   Calucator");
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
                    intent = new Intent(context, SettingIndex.class);
                    startActivity(intent);
                    break;
//                case 1:
//                    intent = new Intent(context, CompassActivity.class);
//                    startActivity(intent);
//                    break;
//                case 2:
//                    intent = new Intent(context, TimerActivity.class);
//                    startActivity(intent);
//                    break;
//                case 3:
//                    intent = new Intent(context, OtherTimerCountDownActivity.class);
//                    startActivity(intent);
//                    break;
//                case 4:
//                    intent = new Intent(context, OtherVoteActivity.class);
//                    startActivity(intent);
//                    break;
//                case 5:
//                    intent = new Intent(context, OtherBadgeViewActivity.class);
//                    startActivity(intent);
//                    break;
//                case 6:
//                    intent = new Intent(context, CalulatorActivity.class);
//                    startActivity(intent);
//                    break;
                default:
                    break;
            }
        }
    };
}
