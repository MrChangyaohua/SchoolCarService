package com.example.serverlocation;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.listener.UpdateListener;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.LocationProviderProxy;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolylineOptions;

public class MainActivity extends Activity implements AMapLocationListener{

	private AMap mAMap;
	private MapView mMapView;
	private Marker mGPSMarker;
	private LocationManagerProxy mLocationManagerProxy;
	private Model current;
	private LatLng temp;
	
	public static int flag = 0;
	public static int count = 0;
	public static int frontStation = 0;
	
	
	private static final LatLng ONE = new LatLng(38.0143004487611845,112.45582768843197);
	private static final LatLng TEMP1 = new LatLng(38.01425552781914,112.4545531489705);
	private static final LatLng TWO = new LatLng(38.01556027982925,112.4544496388025);
	private static final LatLng THREE = new LatLng(38.01539498774411,112.45000964587852);
	private static final LatLng TEMP2 = new LatLng(38.016943886093784,112.44990964587852);
	private static final LatLng FOUR = new LatLng(38.01682156955341,112.44621322359004);
	private static final LatLng FIVE = new LatLng(38.01518249093445,112.44621322359004);
	private static final LatLng TEMP3 = new LatLng(38.01303480789175,112.4457897234504);
	private static final LatLng SIX = new LatLng(38.01262826009574,112.44356875082703);
	private static final LatLng TEMP4 = new LatLng(38.009768664695216,112.44379796955457);
	private static final LatLng TEMP5 = new LatLng(38.00971031039748,112.44269299210835);
	private static final LatLng SEVEN = new LatLng(38.0086102273198,112.44289429105383);
	
	private static final int RADIUS = 50;
	private static final int TIME = 3000;
	
	private PendingIntent mPendingIntent1;
	private PendingIntent mPendingIntent2;
    private PendingIntent mPendingIntent3;
    private PendingIntent mPendingIntent4;
    private PendingIntent mPendingIntent5;
    private PendingIntent mPendingIntent6;
    private PendingIntent mPendingIntent7;
    
    private Handler handler;
	private Runnable runnable;
	
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		init(savedInstanceState);
		
		Bmob.initialize(this, "9f24e0ab1056f46b9b4fd6b7e530124c");
		
		startService(new Intent(MainActivity.this,FirstService.class));
		
	}
	
	
		private void init(Bundle savedInstanceState) {
	        mMapView = (MapView) findViewById(R.id.map);
	        mMapView.onCreate(savedInstanceState);
	        mAMap = mMapView.getMap();
	        
	       //更改可视区域
			//设置当期地图显示为中北大学
            mAMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(new LatLng(38.01492392538442,112.44981391049477), 15, 10, 0)));
	        
	        PolylineOptions polylineOptions = new PolylineOptions();
	        polylineOptions.add(ONE,TEMP1,TWO,THREE,TEMP2,FOUR,FIVE,TEMP3,SIX,TEMP4,TEMP5,SEVEN);
			polylineOptions.color(Color.GREEN);
			polylineOptions.width(10);
	        mAMap.addPolyline(polylineOptions);
	        
	        
	      //设置定点位置为中心的圆圈代表地理围栏
	        CircleOptions circleOptions1 = new CircleOptions();
	        circleOptions1.center(ONE).radius(RADIUS)
	        .fillColor(Color.argb(100, 224, 171, 10))
	        . strokeColor(Color.argb(0, 0, 0, 0));
	        mAMap.addCircle(circleOptions1);
	        
	        CircleOptions circleOptions2 = new CircleOptions();
	        circleOptions2.center(TWO).radius(RADIUS)
	               .fillColor(Color.argb(100, 224, 171, 10))
	                . strokeColor(Color.argb(0, 0, 0, 0));
	        mAMap.addCircle(circleOptions2);
	        
	        CircleOptions circleOptions3 = new CircleOptions();
	        circleOptions3.center(THREE).radius(RADIUS)
	        .fillColor(Color.argb(100, 224, 171, 10))
	                . strokeColor(Color.argb(0, 0, 0, 0));
	        mAMap.addCircle(circleOptions3);
	        
	        
	        CircleOptions circleOptions4 = new CircleOptions();
	        circleOptions4.center(FOUR).radius(RADIUS)
	        .fillColor(Color.argb(100, 224, 171, 10))
	        . strokeColor(Color.argb(0, 0, 0, 0));
	        mAMap.addCircle(circleOptions4);
	        
	        CircleOptions circleOptions5 = new CircleOptions();
	        circleOptions5.center(FIVE).radius(RADIUS)
	        .fillColor(Color.argb(100, 224, 171, 10))
	        . strokeColor(Color.argb(0, 0, 0, 0));
	        mAMap.addCircle(circleOptions5);
	        
	        CircleOptions circleOptions6 = new CircleOptions();
	        circleOptions6.center(SIX).radius(RADIUS)
	        .fillColor(Color.argb(100, 224, 171, 10))
	        . strokeColor(Color.argb(0, 0, 0, 0));
	        mAMap.addCircle(circleOptions6);
	        
	        CircleOptions circleOptions7 = new CircleOptions();
	        circleOptions7.center(SEVEN).radius(RADIUS)
	        .fillColor(Color.argb(100, 224, 171, 10))
	        . strokeColor(Color.argb(0, 0, 0, 0));
	        mAMap.addCircle(circleOptions7);
	        
	      
	      //设置定点位置的标记
	        MarkerOptions markerOptions = new MarkerOptions();
	        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.bus));
	        mGPSMarker = mAMap.addMarker(markerOptions);
	        
	        setBroadcast();
        
	    }
		
		public void setBroadcast(){
	        
	        
	        //此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
	        //注意设置合适的定位时间的间隔，并且在合适时间调用removeUpdates()方法来取消定位请求
	        //在定位结束后，在合适的生命周期调用destroy()方法     
	        //其中如果间隔时间为-1，则定位只定一次
	        mLocationManagerProxy = LocationManagerProxy.getInstance(this);
	        
	        mLocationManagerProxy.requestLocationData(
	                LocationProviderProxy.AMapNetwork, 2000, 5, this);
	 
	      
	        
	      //设置延迟意图，一旦满足条件后交付与onReceive处理
	        Intent intent1 = new Intent(this,Receiver1.class);   //定义广播的 Action
	        mPendingIntent1 = PendingIntent.getBroadcast(getApplicationContext(), 0,
	                intent1, 0);
	        
	        Intent intent2 = new Intent(this,Receiver2.class);   //定义广播的 Action
	        mPendingIntent2 = PendingIntent.getBroadcast(getApplicationContext(), 0,
	        		intent2, 0);
	        
	        Intent intent3 = new Intent(this,Receiver3.class);   //定义广播的 Action
	        mPendingIntent3 = PendingIntent.getBroadcast(getApplicationContext(), 0,
	        		intent3, 0);
	        
	        Intent intent4 = new Intent(this,Receiver4.class);   //定义广播的 Action
	        mPendingIntent4 = PendingIntent.getBroadcast(getApplicationContext(), 0,
	        		intent4, 0);
	        
	        Intent intent5 = new Intent(this,Receiver5.class);   //定义广播的 Action
	        mPendingIntent5 = PendingIntent.getBroadcast(getApplicationContext(), 0,
	        		intent5, 0);
	        
	        Intent intent6 = new Intent(this,Receiver6.class);   //定义广播的 Action
	        mPendingIntent6 = PendingIntent.getBroadcast(getApplicationContext(), 0,
	        		intent6, 0);
	        
	        Intent intent7 = new Intent(this,Receiver7.class);   //定义广播的 Action
	        mPendingIntent7 = PendingIntent.getBroadcast(getApplicationContext(), 0,
	        		intent7, 0); 

	        
	        this.handler=new Handler();  
			this.runnable=new Runnable() {  
			    @Override  
			    public void run() {  
			        // TODO Auto-generated method stub  
			        //要做的事情  
			    	mLocationManagerProxy.addGeoFenceAlert(ONE.latitude,
			    			ONE.longitude, RADIUS, -1, mPendingIntent1);
			    	
			    	mLocationManagerProxy.addGeoFenceAlert(TWO.latitude,
			    			TWO.longitude, RADIUS, -1, mPendingIntent2);
			    	
			    	mLocationManagerProxy.addGeoFenceAlert(THREE.latitude,
			    			THREE.longitude, RADIUS, -1, mPendingIntent3);
			    	
			    	mLocationManagerProxy.addGeoFenceAlert(FOUR.latitude,
			    			FOUR.longitude, RADIUS, -1, mPendingIntent4);
			    	
			    	mLocationManagerProxy.addGeoFenceAlert(FIVE.latitude,
			    			FIVE.longitude, RADIUS, -1, mPendingIntent5);
			    	
			    	mLocationManagerProxy.addGeoFenceAlert(SIX.latitude,
			    			SIX.longitude, RADIUS, -1, mPendingIntent6);
			    	
			    	mLocationManagerProxy.addGeoFenceAlert(SEVEN.latitude,
			    			SEVEN.longitude, RADIUS, -1, mPendingIntent7);
			    	
			        handler.postDelayed(this, TIME);  
			    } 
			};
			handler.postDelayed(runnable, TIME);//每十秒执行一次runnable. 
		}
		
		@Override
		protected void onResume() {
			// TODO Auto-generated method stub
			super.onResume();
			MainActivity.this.mMapView.onResume();
//			startService(new Intent(MainActivity.this,FirstService.class));
		}
		
		@Override
		protected void onPause() {
			// TODO Auto-generated method stub
			super.onPause();
			MainActivity.this.mMapView.onPause();
		}
		
		
		@Override
		protected void onDestroy() {
			// TODO Auto-generated method stub
			super.onDestroy();
			MainActivity.this.mMapView.onDestroy();
			
			 // 销毁定位
//	        mLocationManagerProxy.destroy();
			
			startService(new Intent(MainActivity.this,FirstService.class));
		}


		@Override
		public void onLocationChanged(Location arg0) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void onProviderDisabled(String arg0) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void onProviderEnabled(String arg0) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void onLocationChanged(AMapLocation location) {
			// TODO Auto-generated method stub
			if (location.getAMapException().getErrorCode() == 0) {
	            updateLocation(location.getLatitude(), location.getLongitude());
	        }
			
		}
		
		/*
	     * 根据新的经纬度更新GPS位置和设置地图中心,并且及时更新定位数据，上传到Bmob中，供客户端获取
	     */
	    private void updateLocation(double latitude, double longtitude) {
	        if (mGPSMarker != null) {
	        	temp = new LatLng(latitude, longtitude);
	            mGPSMarker.setPosition(temp);
	            mAMap.moveCamera(CameraUpdateFactory.changeLatLng(temp)) ;	
	            
	            MainActivity.this.current = new Model();
	    		current.setLocation(new LatLng(latitude, longtitude));
	    		current.setFlag(flag);
	    		current.setCount(count);
	    		current.setFrontStation(frontStation);
	    		current.update(MainActivity.this,"3b77fb8d08", new UpdateListener() {
	    		    @Override
	    		    public void onSuccess() {
	    		        // TODO Auto-generated method stub
	    		    	System.out.println("更新数据成功。");
	    		    }
	    
	    		    @Override
	    		    public void onFailure(int code, String msg) {
	    		        // TODO Auto-generated method stub
	    		    	System.out.println("更新数据失败.");	    		        
	    		    }
	    		});
	        }
	 
	    }
		
		
		
		
}
