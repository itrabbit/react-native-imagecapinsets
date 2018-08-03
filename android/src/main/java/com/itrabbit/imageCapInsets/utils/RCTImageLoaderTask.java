package com.itrabbit.imageCapInsets.utils;

import java.net.URL;
import java.io.InputStream;
import java.io.IOException;
import android.os.AsyncTask;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class RCTImageLoaderTask extends AsyncTask<String, Void, Bitmap> {
    private final String mUri;
    private final Context mContext;
    private final RCTResourceDrawableIdHelper mResourceDrawableIdHelper;
    private final RCTImageLoaderListener mListener;

    public RCTImageLoaderTask(String uri, Context context, RCTImageLoaderListener listener) {
        mUri = uri;
        mContext = context;
        mListener = listener;
        mResourceDrawableIdHelper = new RCTResourceDrawableIdHelper();
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        if (mUri.startsWith("http")) {
            return loadBitmapByExternalURL(mUri);
        }
        return loadBitmapByLocalResource(mUri);
    }

    private Bitmap loadBitmapByLocalResource(String uri) {
        return BitmapFactory.decodeResource(mContext.getResources(), mResourceDrawableIdHelper.getResourceDrawableId(mContext, uri));
    }

    private Bitmap loadBitmapByExternalURL(String uri) {
        Bitmap bitmap = null;
        try {
            InputStream in = new URL(uri).openStream();
            bitmap = BitmapFactory.decodeStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (!isCancelled()) {
            mListener.onImageLoaded(bitmap);
        }
    }
}
