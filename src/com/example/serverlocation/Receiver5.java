package com.example.serverlocation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Receiver5 extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Bundle bundle = intent.getExtras();
        // ���ݹ㲥��status��ȷ�����������ڻ�����������
        int status = bundle.getInt("status");
        if (status == 0  && MainActivity.count == 5 && MainActivity.flag == 1) {
        	
        	Toast.makeText(context, "�뿪����վ", Toast.LENGTH_SHORT).show();
        	MainActivity.flag = 0;
        	MainActivity.frontStation = 5;
        	
        } else if(status == 1 && MainActivity.flag == 0){
        	
        	Toast.makeText(context, "�������վ", Toast.LENGTH_SHORT).show();
        	MainActivity.flag = 1;
        	MainActivity.count = 5;
        	}
		
            
	}

}
