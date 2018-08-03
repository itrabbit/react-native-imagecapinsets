package com.itrabbit.imageCapInsets;

import android.graphics.*;
import android.content.Context;
import android.widget.ImageView;
import android.graphics.drawable.NinePatchDrawable;
import com.itrabbit.imageCapInsets.utils.RCTImageLoaderTask;
import com.itrabbit.imageCapInsets.utils.RCTImageLoaderListener;
import com.itrabbit.imageCapInsets.utils.NinePatchBitmapFactory;

public class RCTImageCapInsetView extends ImageView {
    private Rect mCapInsets;
    private String mUri;

    public RCTImageCapInsetView(Context context) {
        super(context);
        mCapInsets = new Rect();
    }

    public void setCapInsets(Rect insets) {
        mCapInsets = insets;
        reload();
    }

    public void setSource(String uri) {
        mUri = uri;
        reload();
    }

    public void reload() {
        final String key = mUri + "-" + mCapInsets.toShortString();
        final RCTImageCache cache = RCTImageCache.getInstance();
        if (cache.has(key)) {
            setBackground(cache.get(key).getConstantState().newDrawable());
            return;
        }
        RCTImageLoaderTask task = new RCTImageLoaderTask(mUri, getContext(), new RCTImageLoaderListener() {
            @Override
            public void onImageLoaded(Bitmap bitmap) {
                if(bitmap != null) {
                    int top = mCapInsets.top * ratio;
                    int left = mCapInsets.left * ratio;
                    int ratio = Math.round(bitmap.getDensity() / 160);
                    int right = bitmap.getWidth() - (mCapInsets.right * ratio);
                    int bottom = bitmap.getHeight() - (mCapInsets.bottom * ratio);
                    NinePatchDrawable ninePatchDrawable = NinePatchBitmapFactory.createNinePathWithCapInsets(getResources(), bitmap, top, left, bottom, right, null);
                    setBackground(ninePatchDrawable);
                    cache.put(key, ninePatchDrawable);
                }
            }
        });
        task.execute();
    }
}
