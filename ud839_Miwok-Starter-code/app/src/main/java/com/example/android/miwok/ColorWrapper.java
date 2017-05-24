package com.example.android.miwok;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by nayantiwari on 5/23/17.
 */

public class ColorWrapper implements Serializable {

    private int drawable;

    public ColorWrapper() {
    }

    public ColorWrapper(Drawable drawable) {
        if (drawable instanceof ColorDrawable) {
            ColorDrawable colorDrawable  = (ColorDrawable) drawable;
            this.drawable = colorDrawable.getColor();
        }
    }

    public ColorDrawable getColorDrawable(){
        return new ColorDrawable(drawable);
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }
}
