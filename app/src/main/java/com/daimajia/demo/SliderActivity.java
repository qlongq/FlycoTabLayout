package com.daimajia.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.flyco.tablayoutsamples.R;

public class SliderActivity extends AppCompatActivity {

    SliderLayout sliderLayout;
    PagerIndicator custom_indicator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_main);
        sliderLayout = findViewById(R.id.banner_slider);
        custom_indicator = findViewById(R.id.custom_indicator);
        addSlideViewWithEntity();
    }

    //添加banner轮播图数据
    private void addSlideViewWithEntity() {


        for (int i = 0; i < 4; i++) {
            DefaultSliderView textSliderView = new DefaultSliderView(SliderActivity.this, true, 2);
            textSliderView.description("测试").image("http://f.hiphotos.baidu.com/image/h%3D300/sign=e6821d0a831001e9513c120f880f7b06/a71ea8d3fd1f4134d244519d2b1f95cad0c85ee5.jpg").setScaleType(BaseSliderView.ScaleType.Fit);
            final int finalI = i;
            textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {

                }
            });
            Bundle bundle = new Bundle();
            bundle.putSerializable("entity", "adf");
            textSliderView.bundle(bundle);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Default);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(5000);
        sliderLayout.startAutoCycle();
    }
}
