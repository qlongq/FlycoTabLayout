package com.daimajia.slider.library;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;

import java.util.ArrayList;

/**
 * A slider adapter
 */
public class SliderAdapter extends PagerAdapter{

    private Context mContext;
    private ArrayList<BaseSliderView> mImageContents;

    public SliderAdapter(Context context){
        mContext = context;
        mImageContents = new ArrayList<BaseSliderView>();
    }

    public <T extends BaseSliderView> void addSlider(T slider){
        mImageContents.add(slider);
        notifyDataSetChanged();
    }

    public BaseSliderView getSliderView(int position){
        if(position < 0 || position >= mImageContents.size()){
            return null;
        }else{
            return mImageContents.get(position);
        }
    }

    /**
     * 获取适配器中所有SliderView的bundle
     * @return
     */
    public ArrayList<Bundle> getAllBundles()
    {
        if (mImageContents==null || mImageContents.size()==0)
            return null;
        ArrayList<Bundle> list = new ArrayList<>();
        for (BaseSliderView view:mImageContents)
        {
            if (view.getBundle()!=null) {
                list.add(view.getBundle());
            }
        }
        return list;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    public <T extends BaseSliderView> void removeSlider(T slider){
        if(mImageContents.contains(slider)){
            mImageContents.remove(slider);
            notifyDataSetChanged();
        }
    }

    public void removeSliderAt(int position){
        if(mImageContents.size() > position){
            mImageContents.remove(position);
            notifyDataSetChanged();
        }
    }

    public void removeAllSliders(){
        mImageContents.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mImageContents.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        BaseSliderView b = mImageContents.get(position);
        View v = b.getView();
        container.addView(v);
        return v;
    }

}
