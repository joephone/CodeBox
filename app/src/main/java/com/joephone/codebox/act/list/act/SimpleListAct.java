package com.joephone.codebox.act.list.act;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.joephone.codebox.R;
import com.joephone.codebox.act.list.adapter.SimpleGroupAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Joephone on 2016/5/23.
 */
public class SimpleListAct extends Activity {

    private List<Map<String, String>> mylist = new ArrayList<Map<String, String>>();
    private List<Map<String, String>> splitList = new ArrayList<Map<String, String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_group_main);

        ListView list = (ListView) findViewById(R.id.MyListView);

        setData(); // 设置数据

        // 配置适配器
        SimpleGroupAdapter adapter = new SimpleGroupAdapter(this, mylist, splitList); // 布局里的控件id
        // 添加并且显示
        list.setAdapter(adapter);
    }

    private void setData() {
        // 组织数据源
        Map<String, String> mp = new HashMap<String, String>();
        mp.put("itemTitle", "A");
        mylist.add(mp);
        splitList.add(mp);

        for (int i = 0; i < 3; i++) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("itemTitle", "文章1-" + i);
            mylist.add(map);
        }

        mp = new HashMap<String, String>();
        mp.put("itemTitle", "B");
        mylist.add(mp);
        splitList.add(mp);

        for (int i = 0; i < 6; i++) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("itemTitle", "文章2-" + i);
            mylist.add(map);
        }


        mp = new HashMap<String, String>();
        mp.put("itemTitle", "c");
        mylist.add(mp);
        splitList.add(mp);

        for (int i = 0; i < 6; i++) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("itemTitle", "文章2-" + i);
            mylist.add(map);
        }


        mp = new HashMap<String, String>();
        mp.put("itemTitle", "d");
        mylist.add(mp);
        splitList.add(mp);

        for (int i = 0; i < 6; i++) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("itemTitle", "文章2-" + i);
            mylist.add(map);
        }
    }

}