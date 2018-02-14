package com.ooyala.sample.players;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ooyala.android.OoyalaPlayer;
import com.ooyala.android.PlayerDomain;
import com.ooyala.android.configuration.Options;
import com.ooyala.android.item.Stream;
import com.ooyala.android.item.UnbundledVideo;
import com.ooyala.sample.R;
import com.ooyala.android.skin.OoyalaSkinLayout;
import com.ooyala.android.skin.OoyalaSkinLayoutController;
import com.ooyala.android.skin.configuration.SkinOptions;

import org.json.JSONObject;

/**
 * This activity illustrates how you can play basic playback video using the Skin SDK
 * you can also play Ooyala and VAST advertisements programmatically
 * through the SDK
 *
 */
public class OoyalaSkinPlayerActivity extends AbstractHookActivity {

	Button seekBtn;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.player_skin_simple_layout);
		completePlayerSetup(asked);

		seekBtn = findViewById(R.id.seekBtn);
		seekBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				player.seek(10000);
			}
		});
	}

	@Override
	void completePlayerSetup(boolean asked) {
		if (asked) {
			// Get the SkinLayout from our layout xml
			skinLayout = (OoyalaSkinLayout) findViewById(R.id.ooyalaSkin);
			// Create the OoyalaPlayer, with some built-in UI disabled
			PlayerDomain playerDomain = new PlayerDomain(domain);
			Options options = new Options.Builder().setShowNativeLearnMoreButton(false).setShowPromoImage(false).setUseExoPlayer(true).build();
			player = new OoyalaPlayer(pcode, playerDomain, options);
			//Create the SkinOptions, and setup React
			JSONObject overrides = createSkinOverrides();
			SkinOptions skinOptions = new SkinOptions.Builder().setSkinOverrides(overrides).build();
			playerLayoutController = new OoyalaSkinLayoutController(getApplication(), skinLayout, player, skinOptions);
			//Add observer to listen to fullscreen open and close events
			playerLayoutController.addObserver(this);
			player.addObserver(this);

			Stream stream = new Stream("https://siriusxm-no-token-priuatlivevideo.siriusxm.com/video/d691737e967a4a5d979755ceb8a116e4/ha?ssai_guid=cc204f61-88da-45f1-8d77-2d45db7feb28", Stream.DELIVERY_TYPE_HLS);
			UnbundledVideo unbundledVideo = new UnbundledVideo(stream);
			player.setUnbundledVideo(unbundledVideo);
//			if (player.setEmbedCode(embedCode)) {
//			} else {
//				Log.e(TAG, "Asset Failure");
//			}
		}
	}

	/**
	 * Create skin overrides to show up in the skin.
	 * Default commented. Uncomment to show changes to the start screen.
	 * @return the overrides to apply to the skin.json in the assets folder
	 */
	private JSONObject createSkinOverrides() {
		JSONObject overrides = new JSONObject();
//    JSONObject startScreenOverrides = new JSONObject();
//    JSONObject playIconStyleOverrides = new JSONObject();
//    try {
//      playIconStyleOverrides.put("color", "red");
//      startScreenOverrides.put("playButtonPosition", "bottomLeft");
//      startScreenOverrides.put("playIconStyle", playIconStyleOverrides);
//      overrides.put("startScreen", startScreenOverrides);
//    } catch (Exception e) {
//      Log.e(TAG, "Exception Thrown", e);
//    }
		return overrides;
	}
}