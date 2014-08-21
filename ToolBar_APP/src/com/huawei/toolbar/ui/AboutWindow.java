package com.huawei.toolbar.ui;

import com.huawei.toolbar.GlobleConstants;
import com.huawei.toolbar.R;

import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class AboutWindow extends BaseWindow
{
    private static Boolean isWindowAdded = false;
    
    private Button mBackBtn;
    
    private Button mCloseBtn;
    
    private Button mFeedbackBtn;
    
    public AboutWindow(Handler handler)
    {
        super(handler);
        
        mBackBtn = (Button) mWindow.findViewById(R.id.back_btn);
        mBackBtn.setOnClickListener(this);
        mCloseBtn = (Button) mWindow.findViewById(R.id.close_btn);
        mCloseBtn.setOnClickListener(this);
        mFeedbackBtn = (Button) mWindow.findViewById(R.id.feedback_about);
        mFeedbackBtn.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View v)
    {
        if (mBackBtn == v)
        {
            mHandler.sendEmptyMessage(GlobleConstants.OprationType.BACK);
        }
        if (mCloseBtn == v)
        {
            mHandler.sendEmptyMessage(GlobleConstants.OprationType.CLOSE);
        }
        if (mFeedbackBtn == v)
        {
            mHandler.sendEmptyMessage(GlobleConstants.WindowType.FEEDBACK);
        }
    }
    
    @Override
    protected int setWindow()
    {
        return R.layout.about_view;
    }
    
    @Override
    public void create()
    {
        if (!isWindowAdded)
        {
            mManager.addView(mWindow, mParams);
            isWindowAdded = true;
        }
    }
    
    @Override
    public void remove()
    {
        if (isWindowAdded)
        {
            mManager.removeView(mWindow);
            isWindowAdded = false;
        }
    }
    
}
