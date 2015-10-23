package com.ooyala.sample.ChromecastSampleApp;

import android.app.Application;
import android.content.pm.ApplicationInfo;

import com.ooyala.android.castsdk.CastManager;
import com.ooyala.android.castsdk.CastOptions;
import com.ooyala.android.util.DebugMode;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by zchen on 10/9/15.
 */

public class SampleApplication extends Application implements Observer {
  private static final String TAG = "SampleApplication";
  private final String NAMESPACE = "urn:x-cast:ooyala";
//  private final String APP_ID = "23DEFD5C"; // Default receiver
//  private final String APP_ID = "D4C7BD4A"; // Custom receiver
  private final String APP_ID = "ED0DE097"; // Custom QA receiver

  @Override
  public void onCreate() {
    super.onCreate();
    try {
      boolean isDebuggable =  ( 0 != ( getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE ) );
      CastOptions options = new CastOptions.Builder(APP_ID, NAMESPACE).setEnableCastDebug(isDebuggable).setTargetActivity(ChromecastPlayerActivity.class).build();
      CastManager.initialize(this, options);
      CastManager.getCastManager().addObserver(this);
    } catch (CastManager.CastManagerInitializationException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  @Override
  public void update(Observable observable, Object data) {
    DebugMode.logD(TAG, data.toString());
  }
}
