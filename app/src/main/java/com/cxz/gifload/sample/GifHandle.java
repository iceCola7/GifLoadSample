package com.cxz.gifload.sample;

import android.graphics.Bitmap;

/**
 * @author admin
 * @date 2019/10/11
 * @desc
 */
public class GifHandle {

    static {
        System.loadLibrary("native-lib");
    }

    private volatile long gifInfo;

    /**
     * gif 加载
     */
    public GifHandle(String path) {
        gifInfo = openFile(path);
    }

    public synchronized int getWidth() {
        return getWidth(gifInfo);
    }

    public synchronized int getHeight() {
        return getHeight(gifInfo);
    }

    public long renderFrame(Bitmap bitmap) {
        return renderFrame(gifInfo, bitmap);
    }


    private native long openFile(String path);

    private native int getWidth(long gifInfo);

    private native int getHeight(long gifInfo);

    private native long renderFrame(long gifInfo, Bitmap bitmap);

}
