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

import com.joephone.codebox.act.list.act.DropBackAct;
import com.joephone.codebox.act.list.act.ListEditorAct;
import com.joephone.codebox.act.list.act.ListHeaderActivity;
import com.joephone.codebox.act.list.act.NahuanjinActivity;
import com.joephone.codebox.act.list.act.PinnedSectionListAct;
import com.joephone.codebox.act.list.act.RecycleLoadMoreAct;
import com.joephone.codebox.act.list.act.TimeLineAct;
import com.joephone.codebox.act.recycle.act.XiaoMIAct;
import com.joephone.codebox.adapter.IndexAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecyclerIndex extends Activity {
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
        sourceList.add("0 头锚定  xiaomiDIMICM");
        sourceList.add("1 RecyclerView实现底部加载更多功能");




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
                    intent = new Intent(context, XiaoMIAct.class);
                    startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(context, RecycleLoadMoreAct.class);
                    startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(context, DropBackAct.class);
                    startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(context, PinnedSectionListAct.class);
                    startActivity(intent);
                    break;
//                case 4:
//                    intent = new Intent(context, MapScrollAct.class);
//                    startActivity(intent);
//                    break;
//                case 5:
//                    intent = new Intent(context, MapScrollAct.class);
//                    startActivity(intent);
//                    break;
                case 6:
                    intent = new Intent(context, NahuanjinActivity.class);
                    startActivity(intent);
                    break;
                case 7:
                    intent = new Intent(context, ListHeaderActivity.class);
                    startActivity(intent);
                    break;
                case 8:
                    intent = new Intent(context, RecycleLoadMoreAct.class);
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
