package com.joephone.codebox.act.classic.act;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.joephone.codebox.R;
import com.joephone.codebox.act.classic.friendCircle.ActionItem;
import com.joephone.codebox.act.classic.friendCircle.TitlePopup;
import com.joephone.codebox.util.DensityUtils;

public class FriendCircleAct extends Activity implements TitlePopup.OnItemOnClickListener {
    private String tag = this.getClass().getName();
    private ImageView btn1, btn2, btn3;
    private TitlePopup titlePopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friend_circle);
        btn1 = (ImageView) findViewById(R.id.button1);
        btn1.setOnClickListener(onclick);
        btn2 = (ImageView) findViewById(R.id.button2);
        btn2.setOnClickListener(onclick);
        btn3 = (ImageView) findViewById(R.id.button3);
        btn3.setOnClickListener(onclick);
        titlePopup = new TitlePopup(this, DensityUtils.dip2px(this, 165), DensityUtils.dip2px(
                this, 40));
        titlePopup
                .addAction(new ActionItem(this, "赞",
                R.drawable.circle_praise));
        titlePopup.addAction(new ActionItem(this, "评论",
                R.drawable.circle_comment));
        titlePopup.setItemOnClickListener(this);
    }

    View.OnClickListener onclick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            titlePopup.setAnimationStyle(R.style.cricleBottomAnimation);
            titlePopup.show(v);
        }

    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    @Override
    public void onItemClick(ActionItem item,
                            int position) {
        switch (position){
            case 0:
                Log.i(tag,"0");
                break;
            case 1:
                Log.i(tag,"1");
                break;
        }

    }
}
