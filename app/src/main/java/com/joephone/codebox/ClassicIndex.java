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

import com.joephone.codebox.act.classic.act.FriendCircleAct;
import com.joephone.codebox.act.classic.act.SanMainActivity;
import com.joephone.codebox.act.classic.act.SelectCitiesActivity;
import com.joephone.codebox.act.classic.act.CPAct;
import com.joephone.codebox.act.classic.rangeseek.act.NewRangeSeekBarAct;
import com.joephone.codebox.act.classic.rangeseek.act.RangeSeekBarAct;
import com.joephone.codebox.act.classic.weibo.act.SinaBottomAct;
import com.joephone.codebox.act.classic.weibo.act.WeiboPlusAct;
import com.joephone.codebox.act.classic.weibo.act.WeiboPlusPage;
import com.joephone.codebox.adapter.IndexAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

//import com.joephone.codebox.activity.scrollview.MeiTuanMainActivity;
//import com.joephone.codebox.activity.scrollview.ScrollRefreshActivity;

public class ClassicIndex extends Activity {
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
        sourceList.add("三级联");
        sourceList.add("SelectCities");
        sourceList.add("citypicker");
        sourceList.add("微信朋友圈点赞评论弹出框效果Popupwindow");
        sourceList.add("一个漂亮的范围拖动条");
        sourceList.add("一个漂亮的范围拖动条 new ");
        sourceList.add("仿微博加号动画 ");
        sourceList.add("仿微博加号动画2 ");
        sourceList.add("试图弹出动画：仿微博弹出icon ");
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
                    intent = new Intent(context, SanMainActivity.class);
                    startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(context, SelectCitiesActivity.class);
                    startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(context, CPAct.class);
                    startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(context, FriendCircleAct.class);
                    startActivity(intent);
                    break;
                case 4:
                    intent = new Intent(context, RangeSeekBarAct.class);
                    startActivity(intent);
                    break;
                case 5:
                    intent = new Intent(context, NewRangeSeekBarAct.class);
                    startActivity(intent);
                    break;
                case 6:
                    intent = new Intent(context, WeiboPlusAct.class);
                    startActivity(intent);
                    break;
                case 7:
                    intent = new Intent(context, WeiboPlusPage.class);
                    startActivity(intent);
                    break;
                case 8:
                    intent = new Intent(context, SinaBottomAct.class);
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
