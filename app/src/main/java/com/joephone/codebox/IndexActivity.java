package com.joephone.codebox;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;

//import com.joephone.codebox.act.appstart.act.MyLauncherGuideAct;
import com.joephone.codebox.adapter.IndexAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class IndexActivity extends Activity {
    @Bind(R.id.back)
    ImageView back;
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
        lvIndex.setOnItemClickListener(lvIndexOnItemClickListner);
        sourceList.add("手机 AndroidSoftIndex");
        sourceList.add("控件 Widget");
        sourceList.add("ScrollView 效果集合");
        sourceList.add("ListView 效果集合");
        sourceList.add("Pic 图像处理");
        sourceList.add("vPager 广告轮播");
		sourceList.add("窗口添加机制");
		sourceList.add("动画 Animation");
		sourceList.add("通知 Notification");
		sourceList.add("sliding集合");
		sourceList.add("经典事例 classic");
		sourceList.add("其他");
        sourceList.add("app start");
        adapter = new IndexAdapter(this, sourceList);
        lvIndex.setAdapter(adapter);
    }

    OnItemClickListener lvIndexOnItemClickListner = new OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                long arg3) {
            Intent intent;
            Log.i(tag, "position:" + position);


            switch (position) {
//			case 0:
//				intent = new Intent(context, AndroidSoftIndex.class);
//				startActivity(intent);
//				break;
//			case 1:
//				intent = new Intent(context, WidgetIndex.class);
//				startActivity(intent);
//				break;
			case 2:
				intent = new Intent(context, ScrollIndex.class);
				startActivity(intent);
				break;
			case 3:
				intent = new Intent(context, ListIndex.class);
				startActivity(intent);
				break;
//			case 4:
//				intent = new Intent(context, PicIndex.class);
//				startActivity(intent);
//				break;
//			case 5:
//				intent = new Intent(context, VPagerIndex.class);
//				startActivity(intent);
//				break;
//			case 6:
//				intent = new Intent(context, WindowIndex.class);
//				startActivity(intent);
//				break;
//			case 7:
//				intent = new Intent(context, AnimIndex.class);
//				startActivity(intent);
//				break;
//			case 8:
//				intent = new Intent(context, NotificationIndex.class);
//				startActivity(intent);
//				break;
			case 9:
				intent = new Intent(context, SlideIndex.class);
				startActivity(intent);
				break;
//			case 10:
//				intent = new Intent(context, ClassicIndex.class);
//				startActivity(intent);
//				break;
//			case 11:
//				intent = new Intent(context, OtherIndex.class);
//				startActivity(intent);
//				break;
//			case 12:
//				intent = new Intent(context, MyLauncherGuideAct.class);
//				startActivity(intent);
//				break;


//			default:
//				break;
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		Intent intent;
//		switch (id) {
//		case R.id.about:
//			intent = new Intent(context, AboutActivity.class);
//			startActivity(intent);
//			break;
////			return true;
//		case R.id.connet:
//			intent = new Intent(context, EmailSenderActivity.class);
//			startActivity(intent);
//			break;
//		case R.id.exit:
//			System.exit(0);
//			break;
//		}

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

//        	if(SaveRun.getisdaojishi() || SaveRun.getisjishi()){
            new AlertDialog.Builder(this)
                    .setTitle("提示")
                    .setMessage("正在计算中，确定要退出吗？")
                    .setNegativeButton("取消",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    dialog.cancel();
                                }
                            })
                    .setPositiveButton("确定",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int whichButton) {
                                    finish();
                                }
                            }).setNeutralButton("后台",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,
                                            int whichButton) {
                            Intent i = new Intent(Intent.ACTION_MAIN);
                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            i.addCategory(Intent.CATEGORY_HOME);
                            startActivity(i);
                        }
                    }).create().show();
//        	}else{
//        		finish();
//        	}
            return true;

        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

}
