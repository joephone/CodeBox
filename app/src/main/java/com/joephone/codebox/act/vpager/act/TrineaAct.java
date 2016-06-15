package com.joephone.codebox.act.vpager.act;

import android.app.Activity;
import android.os.Bundle;

import com.joephone.codebox.R;
import com.joephone.codebox.act.vpager.adapter.AdvertImagePagerAdapter;
import com.joephone.codebox.act.vpager.view.AutoScrollViewPager;
import com.joephone.codebox.act.vpager.view.CirclePageIndicatorB;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Joephone on 2016/6/15.
 */
public class TrineaAct extends Activity {

    @Bind(R.id.vpTrinae)
    AutoScrollViewPager vpTrinae;
    @Bind(R.id.indicator)
    CirclePageIndicatorB indicator;

    private List<Integer> imageIdList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trinaea);
        ButterKnife.bind(this);



        imageIdList = new ArrayList<Integer>();
        imageIdList.add(R.drawable.beauty01);
        imageIdList.add(R.drawable.beauty05);
        imageIdList.add(R.drawable.beauty06);
        imageIdList.add(R.drawable.beauty07);

        String [] imageUrls = this.getResources().getStringArray(R.array.image_url_test);

 //       vpTrinae.setAdapter(new AdvertImagePagerAdapter(this, imageIdList,false));      //本地图片
        vpTrinae.setAdapter(new AdvertImagePagerAdapter(this, imageUrls,true));      //网络图片
        indicator.setViewPager(vpTrinae);
        vpTrinae.setInterval(2000);
        vpTrinae.startAutoScroll();
        vpTrinae.setCurrentItem(Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2 % imageIdList.size());

    }

    @Override
    protected void onPause() {
        super.onPause();
        // stop auto scroll when onPause
        vpTrinae.stopAutoScroll();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // start auto scroll when onResume
        vpTrinae.startAutoScroll();
    }
}
