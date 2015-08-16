/*
 *  Copyright 2014 Zhennian Li
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.sneagle.scaleview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * An Adapter that can scale the child view of ListView according to the screen
 * size.
 * Created by lizhennian on 2014/5/30.
 */
public abstract class ScaleAdapter extends BaseAdapter {

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        boolean isScale = false;
        if (convertView == null) {
            isScale = true;
        }
        View view = this.getScaleView(position, convertView, parent);
        if (isScale) {
            ScaleCalculator.getInstance().scaleView(view);
        }
        return view;
    }

    /**
     * Need to subclass overrides
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    public abstract View getScaleView(int position, View convertView,
            ViewGroup parent);
}
