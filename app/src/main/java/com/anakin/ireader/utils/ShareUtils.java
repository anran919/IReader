package com.anakin.ireader.utils;

import android.content.Context;

import com.anakin.ireader.R;

import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by demo on 2017/6/17 0017
 */
public class ShareUtils {

    private static ShareUtils instance;

    private Context mContext;

    public ShareUtils(Context context) {
        this.mContext = context;
    }

    public synchronized static ShareUtils getInstance(Context context) {
        if (instance == null) {
            synchronized (ShareUtils.class) {
                if (instance == null) {
                    instance = new ShareUtils(context);
                }
            }
        }
        return instance;
    }

    public void showShare() {
        OnekeyShare oks = new OnekeyShare();
//关闭sso授权
        oks.disableSSOWhenAuthorize();

// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle("标题");
// titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl("http://sharesdk.cn");
// text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
// url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
// comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
// site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(mContext.getString(R.string.app_name));
// siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(mContext);
    }

}
