package com.example.serverlocation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Receiver3 extends BroadcastReceiver {


	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Bundle bundle = intent.getExtras();
        // 根据广播的status来确定是在区域内还是在区域外
        int status = bundle.getInt("status");
        if (status == 0 && MainActivity.count == 3 && MainActivity.flag == 1) {
        	
        	Toast.makeText(context, "离开第三站", Toast.LENGTH_SHORT).show();
        	MainActivity.flag = 0;
        	MainActivity.frontStation = 3;
        	
        } else if(status == 1 && MainActivity.flag == 0){
        	
        	Toast.makeText(context, "进入第三站", Toast.LENGTH_SHORT).show();
        	MainActivity.flag = 1;
        	MainActivity.count = 3;
   	
        	}
		
            
	}

}
