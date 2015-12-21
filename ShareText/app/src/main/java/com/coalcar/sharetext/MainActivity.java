package com.coalcar.sharetext;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.unity3d.player.UnityPlayerActivity;

import com.youku.player.ApiManager;
import com.youku.player.YoukuPlayerBaseConfiguration;

import com.baseproject.utils.Logger;
import com.youku.player.ApiManager;
import com.youku.player.VideoQuality;
import com.youku.player.base.YoukuBasePlayerManager;
import com.youku.player.base.YoukuPlayer;
import com.youku.player.base.YoukuPlayerView;
import com.youku.service.download.DownloadManager;
import com.youku.service.download.OnCreateDownloadListener;

public class MainActivity extends UnityPlayerActivity {
    private YoukuBasePlayerManager basePlayerManager;
    // 播放器控件
    private YoukuPlayerView mYoukuPlayerView;
    private YoukuPlayer youkuPlayer;
    private String vid;

    // 清晰度相关按钮
    private Button btn_standard, btn_hight, btn_super, btn_1080;

    // 下载视频按钮
    private Button btn_download;

    // 需要播放的本地视频的id
    private String local_vid;

    // 标示是否播放的本地视频
    private boolean isFromLocal = false;

    // YoukuPlayer实例，进行视频播放控制

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        basePlayerManager = new YoukuBasePlayerManager(this) {

            @Override
            public void setPadHorizontalLayout() {
                // TODO Auto-generated method stub

            }

            @Override
            public void onInitializationSuccess(YoukuPlayer player) {
                // TODO Auto-generated method stub
                // 初始化成功后需要添加该行代码
                addPlugins();

                // 实例化YoukuPlayer实例
                youkuPlayer = player;

                // 进行播放
                //goPlay();
            }

            @Override
            public void onSmallscreenListener() {
                // TODO Auto-generated method stub

            }

            @Override
            public void onFullscreenListener() {
                // TODO Auto-generated method stub

            }
        };
        basePlayerManager.onCreate();
/*
        // 通过上个页面传递过来的Intent获取播放参数
        //getIntentData(getIntent());

        //if (TextUtils.isEmpty(id)) {
            vid = "XMTQxNzMyMDcxMg"; // 默认视频
        //} else {
          //  vid = id;
        //}

        // 播放器控件
        mYoukuPlayerView = (YoukuPlayerView) this
                .findViewById(R.id.full_holder);
        //控制竖屏和全屏时候的布局参数。这两句必填。
        mYoukuPlayerView
                .setSmallScreenLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
        mYoukuPlayerView
                .setFullScreenLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT));
        // 初始化播放器相关数据
        mYoukuPlayerView.initialize(basePlayerManager);
*/
    //}

    //Code for toasting
    public void shareText(String subject, String body) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, body);
        startActivity(Intent.createChooser(sharingIntent, "Share vi2"));
    }

    //Code for PLaying video
    public void go2Player(){
        Intent i = new Intent(MainActivity.this,PlayerActivity.class);
        i.putExtra("vid", "XMTQxNzMyMDcxMg");
        MainActivity.this.startActivity(i);

        basePlayerManager.onCreate();

        // 通过上个页面传递过来的Intent获取播放参数
        //getIntentData(getIntent());

        //if (TextUtils.isEmpty(id)) {
            vid = "XMTQxNzMyMDcxMg"; // 默认视频
        //} else {
          //  vid = id;
        //}

        // 播放器控件
        mYoukuPlayerView = (YoukuPlayerView) this
                .findViewById(R.id.full_holder);
        //控制竖屏和全屏时候的布局参数。这两句必填。
        mYoukuPlayerView
                .setSmallScreenLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
        mYoukuPlayerView
                .setFullScreenLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT));
        // 初始化播放器相关数据
        mYoukuPlayerView.initialize(basePlayerManager);

        youkuPlayer.playVideo(vid);
    }

}