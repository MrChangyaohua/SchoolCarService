package com.example.serverlocation;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class FirstService extends Service{

	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}    
	
	

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		System.out.println("���񴴽��ɹ�");
		
		
	}



	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		System.out.println("����ʼ");
//		startActivity(new Intent(FirstService.this,MainActivity.class));
		return START_STICKY;
	}
	

    
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Intent sevice = new Intent(this, FirstService.class);  
	    this.startService(sevice); 
	}



}
