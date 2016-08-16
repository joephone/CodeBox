package com.joephone.codebox.act.list.act;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.joephone.codebox.R;
import com.joephone.codebox.act.list.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joephone on 2016/8/14.
 */
public class RecycleLoadMoreAct extends Activity {
    private RecyclerView mRecyclerView;
    private TextView tv_empty;
    private List<String> list = new ArrayList<>();
    private List<String> moreData = new ArrayList<>();
    private List<String> refreshData = new ArrayList<>();
    private MyAdapter myAdapter;
    private Handler handler = new Handler();
//    private SwipeRefreshLayout sfl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_loadmore);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //// TODO: 点击FAB后的操作
//            }
//        });

        init();
    }

    private void init() {
        initData();
        initRefreshData();
        initMoreData();
        initView();
        initListener();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        tv_empty = (TextView) findViewById(R.id.tv_empty);
//        sfl = (SwipeRefreshLayout) findViewById(R.id.sfl);
//        sfl.setColorSchemeColors(Color.parseColor("#FF4081"));
        //创建一个LinearLayoutManager对象
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //创建adapter对象
        myAdapter = new MyAdapter(this, mRecyclerView);
        mRecyclerView.setAdapter(myAdapter);
        myAdapter.setData(list);//设置数据


        if (list.isEmpty()) {
            mRecyclerView.setVisibility(View.GONE);
            tv_empty.setVisibility(View.VISIBLE);
        } else {
            mRecyclerView.setVisibility(View.VISIBLE);
            tv_empty.setVisibility(View.GONE);
        }

    }

    //初始化数据
    private void initData() {
        for (int i = 0; i < 20; i++) {
            list.add("handsome is wrong?" + i);
        }
    }

    //初始化加载更多数据
    private void initMoreData() {
        for (int i = 0; i < 10; i++) {
            moreData.add("life is good" + i);
        }
    }

    private void initRefreshData() {
        for (int i = 0; i < 2; i++) {
            refreshData.add("refreshData" + i);
        }
    }


    //初始化监听
    private void initListener() {
//        sfl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                //模拟下拉刷新数据操作
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        list.addAll(0, refreshData);
//                        myAdapter.notifyDataSetChanged();
//                        sfl.setRefreshing(false);
//                    }
//                }, 1000);
//            }
//        });

        //加载更多回调监听
        myAdapter.setOnMoreDataLoadListener(new MyAdapter.LoadMoreDataListener() {
            @Override
            public void loadMoreData() {
                //加入null值此时adapter会判断item的type
                list.add(null);
                myAdapter.notifyDataSetChanged();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //移除刷新的progressBar
                        list.remove(list.size() - 1);
                        myAdapter.notifyDataSetChanged();
                        list.addAll(moreData);
                        myAdapter.notifyDataSetChanged();
                        myAdapter.setLoaded();
                    }
                }, 2000);

            }
        });

        myAdapter.setOnItemClickListener(new MyAdapter.RecyclerOnItemClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RecycleLoadMoreAct.this, "能不能不要这么帅", Toast.LENGTH_SHORT).show();
//                Snackbar.make(view, "Iam BadGuy_Leo", Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
