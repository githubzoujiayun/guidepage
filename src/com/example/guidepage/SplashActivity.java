//��ӭ����
//�ж��ǲ��ǵ�һ���������������������Ӧ��activity;
//���ǵ�һ���������ȼ���GuideActivity���ټ���mainactivity�����ǵڶ���������ֱ�Ӽ���mainactivity��
package com.example.guidepage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class SplashActivity extends Activity {
	public final static int MAIN_ACTIVITY=1000;
	public final static int GUIDE_ACTIVITY=1001;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		Boolean mIsFirstEnter=IsFirstEnter(SplashActivity.this,SplashActivity.this.getClass().getName());
		
		if (mIsFirstEnter) {
			mHandler.sendEmptyMessageDelayed(GUIDE_ACTIVITY, 5000);//5000���ӳٵ�ʱ��5��
			
		}
		else {
			mHandler.sendEmptyMessageDelayed(MAIN_ACTIVITY, 5000);
		}
	}
	//�ж��ǲ��ǵ�һ�������ĺ���
	private static final String SHAREDPREFERENCES_NAME = "my_pref";
    private static final String KEY_GUIDE_ACTIVITY = "guide_activity";
	private Boolean IsFirstEnter(Context context, String name) {
		// TODO Auto-generated method stub
		if (context==null||name==null||"".equalsIgnoreCase(name)){
			return false;
		}//��ʾ��������
		String mResultString=context.getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_WORLD_READABLE).getString(KEY_GUIDE_ACTIVITY, "");
		if (mResultString.equalsIgnoreCase("false")) {
			return false;
		}
		else {
			return true;//�ǵ�һ������
		}
		
		
	}
	Handler mHandler=new Handler(){
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case GUIDE_ACTIVITY:
				Intent intent=new Intent();
				intent.setClass(SplashActivity.this, GuideActivity.class);
				SplashActivity.this.startActivity(intent);
				SplashActivity.this.finish();
				break;
			case MAIN_ACTIVITY:
				intent=new Intent();
				intent.setClass(SplashActivity.this, MainActivity.class);
				SplashActivity.this.startActivity(intent);
				SplashActivity.this.finish();
				break;

			}
			super.handleMessage(msg);
		};
	};
}
