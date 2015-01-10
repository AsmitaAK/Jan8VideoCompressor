package com.v.c;

//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.content.IntentFilter;
import android.util.Log;
//import android.view.Gravity;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
//import org.apache.cordova.LOG;
//import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
//import org.json.JSONObject;
import com.netcompss.ffmpeg4android_client.BaseWizard;
import com.netcompss.ffmpeg4android_client.Prefs;


public class VideoCompressor extends CordovaPlugin  {
	

  private static final String ACTION_SHOW_EVENT = "start";
  

  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    if (ACTION_SHOW_EVENT.equals(action)) {
		
		Runnable getWavmarc = new Runnable() {

				@Override
				public void run() {
					Intent intent = new Intent(cordova.getActivity() , Main.class); 
					cordova.setActivityResultCallback(VideoCompressor.this);
					cordova.getActivity().startActivityForResult(intent, 1);
				}
			};
			this.cordova.getActivity().runOnUiThread(getWavmarc);
		
      return true;
    } else {
      callbackContext.error("Recording." + action + " is not a supported function. Did you mean '" + ACTION_SHOW_EVENT + "'?");
      return false;
    }
    
    
    
  }




}
