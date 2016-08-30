package com.joephone.codebox.act.other.vote.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
/**
 * Customer GridView to void the change line issue, when
 * the component was added into ScrollView
 * @author coolbeetle.net
 * @since 1.0
 */
public class OtherVoteGridView extends GridView {

	 public OtherVoteGridView(Context context, AttributeSet attrs) { 
	        super(context, attrs); 
	    } 

	    public OtherVoteGridView(Context context) { 
	        super(context); 
	    } 

	    public OtherVoteGridView(Context context, AttributeSet attrs, int defStyle) { 
	        super(context, attrs, defStyle); 
	    } 

	    @Override 
	    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { 

	        int expandSpec = MeasureSpec.makeMeasureSpec( 
	                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST); 
	        super.onMeasure(widthMeasureSpec, expandSpec); 
	    } 
}
