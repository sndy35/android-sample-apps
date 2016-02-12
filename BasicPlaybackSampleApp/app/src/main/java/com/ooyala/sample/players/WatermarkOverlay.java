package com.ooyala.sample.players;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;

import com.ooyala.android.OoyalaPlayer;
import com.ooyala.android.OoyalaPlayerLayout;
import com.ooyala.android.ui.OoyalaPlayerControls;

import java.util.Observable;

/**
 * Created by michael.len on 2/12/16.
 */
public class WatermarkOverlay implements OoyalaPlayerControls {
  TextView _view;

  public WatermarkOverlay(Context c){
    _view = new TextView(c);
    _view.setText("HELlO \nHELlO \nHELlO \nHELlO \nHELlO \nHELlO \nHELlO \nHELlO \nHELlO \nHELlO \nHELlO \nHELlO \nHELlO \nHELlO \nHELlO \nHELlO \nHELlO \nHELlO \nHELlO \nHELlO \nHELlO \nHELlO \nHELlO \nHELlO \nHELlO \nHELlO \nHELlO \nHELlO \nHELlO \nHELlO \nHELlO \nHELlO \nHELlO \n");
    _view.setBackgroundColor(Color.TRANSPARENT);
  }

  @Override
  public void setParentLayout(OoyalaPlayerLayout ooyalaPlayerLayout) {
  ooyalaPlayerLayout.addView(_view);
  }

  @Override
  public void setOoyalaPlayer(OoyalaPlayer ooyalaPlayer) {

  }

  @Override
  public void show() {
    _view.bringToFront();
  }

  @Override
  public void hide() {
//    _view.back
  }

  @Override
  public boolean isShowing() {
    return false;
  }

  @Override
  public int bottomBarOffset() {
    return 0;
  }

  @Override
  public int topBarOffset() {
    return 0;
  }

  @Override
  public void setFullscreenButtonShowing(boolean b) {

  }

  @Override
  public void setVisible(boolean b) {

  }

  @Override
  public void update(Observable observable, Object o) {

  }
}
