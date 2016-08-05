package com.joephone.codebox.act.classic.act;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.joephone.codebox.R;

/**
 * 
 * @author wtw
 * @version 
 * @create_date 2015-5-22下午5:13:01
 */
public class SelectCitiesActivity extends Activity {

	private Button mBtnShow;
	private TextView mTvShowAddress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_citys_main);
		initView();
	}
	
	private void initView(){
		mBtnShow=(Button)findViewById(R.id.btn_show);
		mTvShowAddress=(TextView)findViewById(R.id.tv_showAddress);
		mBtnShow.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//跳往选择界面
				Intent intent=new Intent(SelectCitiesActivity.this,SelectCitiesDialogActivity.class);
				intent.putExtra("address", mTvShowAddress.getText().toString());//不传参数也可以，就不会有默认选中某个值
				startActivityForResult(intent, 1001);
			}
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==1001&&resultCode==1002){
			mTvShowAddress.setText(data.getStringExtra("address"));
		}
	}

}
