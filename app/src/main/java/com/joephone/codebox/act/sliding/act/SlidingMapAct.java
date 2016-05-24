package com.joephone.codebox.act.sliding.act;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.joephone.codebox.act.sliding.adapter.MyFishSpotAdapter;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener;
import com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState;


import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.joephone.codebox.R;


public class SlidingMapAct extends Activity {
    private static final String tag = "SlidingMapAct";
    @Bind(R.id.ivMul)

    ImageView ivMul;
    @Bind(R.id.ivCha)
    ImageView ivCha;
    @Bind(R.id.layPeekPanel)
    RelativeLayout layPeekPanel;
    @Bind(R.id.mLayout)
    SlidingUpPanelLayout mLayout;
    @Bind(R.id.lvFishSpot)
    ListView lvFishSpot;

//    @Bind(R.id.mRecyclerView)
//    XRecyclerView mRecyclerView;
    @Bind(R.id.layMyFishSpotDetail)
    LinearLayout layMyFishSpotDetail;
    @Bind(R.id.layNavi)
    LinearLayout layNavi;
    @Bind(R.id.layTide)
    LinearLayout layTide;
    @Bind(R.id.layEdit)
    LinearLayout layEdit;
    private MyFishSpotAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_map);
        ButterKnife.bind(this);


        Log.i(tag, "layPeekPanel:" + layPeekPanel.getHeight());
//        mLayout.setPanelHeight(layPeekPanel.getHeight());
        lvFishSpot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(SlidingMapAct.this, "onItemClick", Toast.LENGTH_SHORT).show();
                layMyFishSpotDetail.setVisibility(View.VISIBLE);
                lvFishSpot.setVisibility(View.GONE);
                ivCha.setVisibility(View.VISIBLE);
            }
        });

        List<String> your_array_list = Arrays.asList(
                "This",
                "Is",
                "An",
                "Example",
                "ListView",
                "That",
                "You",
                "Can",
                "Scroll",
                ".",
                "It",
                "Shows",
                "How",
                "Any",
                "Scrollable",
                "View",
                "Can",
                "Be",
                "Included",
                "As",
                "A",
                "Child",
                "Of",
                "SlidingUpPanelLayout"
        );

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                your_array_list);

        lvFishSpot.setAdapter(arrayAdapter);


//        mLayout.addPanelSlideListener(new PanelSlideListener() {
//            @Override
//            public void onPanelSlide(View panel, float slideOffset) {
////                Log.i(tag, "onPanelSlide, offset " + slideOffset);
//            }
//
//            @Override
//            public void onPanelStateChanged(View panel, PanelState previousState, PanelState newState) {
////                Log.i(tag, "onPanelStateChanged " + newState);
//            }
//        });
//        mLayout.setFadeOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                mLayout.setPanelState(PanelState.COLLAPSED);
//            }
//        });


    }


    @Override
    public void onBackPressed() {
        if (mLayout != null &&
                (mLayout.getPanelState() == PanelState.EXPANDED || mLayout.getPanelState() == PanelState.ANCHORED)) {
            mLayout.setPanelState(PanelState.COLLAPSED);
        } else {
            super.onBackPressed();
        }
    }

    @OnClick({R.id.ivMul, R.id.ivCha,R.id.layNavi,R.id.layTide,R.id.layEdit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivMul:
                break;
            case R.id.ivCha:
                layMyFishSpotDetail.setVisibility(View.GONE);
                lvFishSpot.setVisibility(View.VISIBLE);
                ivCha.setVisibility(View.GONE);
                break;
            case R.id.layNavi:
                Toast.makeText(SlidingMapAct.this, "navi", Toast.LENGTH_SHORT).show();
                break;
            case R.id.layTide:
                Toast.makeText(SlidingMapAct.this, "tide", Toast.LENGTH_SHORT).show();
                break;
            case R.id.layEdit:
                Toast.makeText(SlidingMapAct.this, "edit", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
