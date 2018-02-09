package com.ooyala.sample.utils;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.ooyala.sample.R;


public class CodecSupportActivity extends Activity {

    private static final String TAG = "CodecSupportActivity";

    public static String getName() {
        return TAG;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codec_support);

        Button hevcSupportBtn = findViewById(R.id.hevcSupportBtn);
        final TextView hevcSupportText = findViewById(R.id.hevcSupportText);
        hevcSupportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaCodecInfo mediaCodecInfo = isHEVCSupported();
                if (null != mediaCodecInfo) {
                    hevcSupportText.setText("HEVC Supported: " + mediaCodecInfo.name);
                } else {
                    hevcSupportText.setText("HEVC NOT Supported :(");
                }
            }
        });
    }


    private MediaCodecInfo isHEVCSupported() {
        try {
            return MediaCodecUtil.getDecoderInfo(MimeTypes.VIDEO_H265, false);
        } catch (MediaCodecUtil.DecoderQueryException e) {
            return null;
        }
    }
}
