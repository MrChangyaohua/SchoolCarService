package com.example.serverlocation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Receiver2 extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Bundle bundle = intent.getExtras();
        // ���ݹ㲥��status��ȷ�����������ڻ�����������
        int status = bundle.getInt("status");
        if (status == 0  && MainActivity.count == 2 && MainActivity.flag == 1) {
        	
        	Toast.makeText(context, "�뿪�ڶ�վ", Toast.LENGTH_SHORT).show();
        	MainActivity.flag = 0;
        	MainActivity.frontStation = 2;
        	
        } else if(status == 1 && MainActivity.flag == 0){
        	
        	Toast.makeText(context, "����ڶ�վ", Toast.LENGTH_SHORT).show();
        	MainActivity.flag = 1;
        	MainActivity.count = 2;
        	}
		
            
	}

}
