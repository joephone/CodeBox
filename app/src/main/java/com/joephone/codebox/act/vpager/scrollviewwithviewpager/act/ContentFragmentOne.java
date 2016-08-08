package com.joephone.codebox.act.vpager.scrollviewwithviewpager.act;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joephone.codebox.R;

public class ContentFragmentOne extends Fragment {

	private String str;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i("aaaaa", "222:" + str);
		return inflater.inflate(R.layout.fragment_content1, container, false);
	}
	
	public ContentFragmentOne(String str){
		Log.i("aaaaa", "111:" + str);
		this.str = str;
	}

	public ContentFragmentOne(){
		Log.i("aaaaa", "111:" + str);
		this.str = str;
	}
	
}
