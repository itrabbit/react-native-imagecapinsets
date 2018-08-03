package com.itrabbit.imageCapInsets.utils;

import android.net.Uri;
import android.content.Context;
import com.facebook.common.util.UriUtil;
import android.graphics.drawable.Drawable;

import java.util.Map;
import java.util.HashMap;
import javax.annotation.Nullable;

public class RCTResourceDrawableIdHelper {
    private Map<String, Integer> mResourceDrawableIdMap;

    @SuppressWarnings("WeakerAccess")
    public RCTResourceDrawableIdHelper() {
        mResourceDrawableIdMap = new HashMap<>();
    }

    public int getResourceDrawableId(Context context, @Nullable String name) {
        if (name == null || name.isEmpty()) {
            return 0;
        }
        name = name.toLowerCase().replace("-", "_");
        if (mResourceDrawableIdMap.containsKey(name)) {
            return mResourceDrawableIdMap.get(name);
        }
        int id = context.getResources().getIdentifier(name, "drawable", context.getPackageName());
        mResourceDrawableIdMap.put(name, id);
        return id;
    }

    @SuppressWarnings("unused")
    public @Nullable Drawable getResourceDrawable(Context context, @Nullable String name) {
        int resId = getResourceDrawableId(context, name);
        return resId > 0 ? context.getResources().getDrawable(resId) : null;
    }

    @SuppressWarnings("unused")
    public Uri getResourceDrawableUri(Context context, @Nullable String name) {
        int resId = getResourceDrawableId(context, name);
        return resId > 0 ? new Uri.Builder()
                .scheme(UriUtil.LOCAL_RESOURCE_SCHEME)
                .path(String.valueOf(resId))
                .build() : Uri.EMPTY;
    }
}