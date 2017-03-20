package com.anakin.ireader.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

/**
 * Created by demo on 2017/3/20 0020
 * <p/>
 * 自定义的Glide ,实现模糊图片
 */
public class BlurTransformation extends BitmapTransformation {

    private RenderScript rs;

    public BlurTransformation(Context context) {
        super(context);
        rs = RenderScript.create(context);
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {


        Bitmap copy = toTransform.copy(Bitmap.Config.ARGB_8888, true);
        Allocation input = Allocation.createFromBitmap(
                rs,
                copy,
                Allocation.MipmapControl.MIPMAP_FULL,
                Allocation.USAGE_SHARED
        );

        Allocation output = Allocation.createTyped(rs, input.getType());

        ScriptIntrinsicBlur script = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));

        script.setInput(input);

        script.setRadius(10);

        script.forEach(output);

        output.copyTo(copy);

        toTransform.recycle();

        return copy;
    }

    @Override
    public String getId() {
        return "blur";
    }
}
