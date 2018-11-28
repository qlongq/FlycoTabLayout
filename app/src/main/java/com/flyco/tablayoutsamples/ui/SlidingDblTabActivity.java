package com.flyco.tablayoutsamples.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.flyco.tablayout.SlidingDblTabLayout;
import com.flyco.tablayout.listener.DblTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.flyco.tablayout.widget.MsgView;
import com.flyco.tablayoutsamples.R;
import com.flyco.tablayoutsamples.utils.ViewFindUtils;

import java.util.ArrayList;
import java.util.List;

public class SlidingDblTabActivity extends AppCompatActivity implements OnTabSelectListener {
    private Context mContext = this;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private List<DblTabEntity> mTitles ;
    private MyPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_dbl_tab);
        mTitles = new ArrayList<>();
        for (int i=0; i<12; i++)
        {
            DblTabEntity entity = new DblTabEntity(i+"月", "2018");
            mTitles.add(entity);
            mFragments.add(SimpleCardFragment.getInstance("2018"));
        }


        View decorView = getWindow().getDecorView();
        ViewPager vp = ViewFindUtils.find(decorView, R.id.vp);
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(mAdapter);

        /** 默认 */
        SlidingDblTabLayout tabLayout_1 = ViewFindUtils.find(decorView, R.id.tl_1);
        /**自定义部分属性*/
        SlidingDblTabLayout tabLayout_2 = ViewFindUtils.find(decorView, R.id.tl_2);
        /** 字体加粗,大写 */
        SlidingDblTabLayout tabLayout_3 = ViewFindUtils.find(decorView, R.id.tl_3);
        /** tab固定宽度 */
        SlidingDblTabLayout tabLayout_4 = ViewFindUtils.find(decorView, R.id.tl_4);
        /** indicator固定宽度 */
        SlidingDblTabLayout tabLayout_5 = ViewFindUtils.find(decorView, R.id.tl_5);
        /** indicator圆 */
        SlidingDblTabLayout tabLayout_6 = ViewFindUtils.find(decorView, R.id.tl_6);
        /** indicator矩形圆角 */
        final SlidingDblTabLayout tabLayout_7 = ViewFindUtils.find(decorView, R.id.tl_7);
        /** indicator三角形 */
        SlidingDblTabLayout tabLayout_8 = ViewFindUtils.find(decorView, R.id.tl_8);
        /** indicator圆角色块 */
        SlidingDblTabLayout tabLayout_9 = ViewFindUtils.find(decorView, R.id.tl_9);
        /** indicator圆角色块 */
        SlidingDblTabLayout tabLayout_10 = ViewFindUtils.find(decorView, R.id.tl_10);

        tabLayout_1.setViewPager(vp, mTitles);
        tabLayout_2.setViewPager(vp, mTitles);
        tabLayout_2.setOnTabSelectListener(this);
        tabLayout_3.setViewPager(vp, mTitles);
        tabLayout_4.setViewPager(vp, mTitles);
        tabLayout_5.setViewPager(vp, mTitles);
        tabLayout_6.setViewPager(vp, mTitles);
        tabLayout_7.setViewPager(vp, mTitles);
        tabLayout_8.setViewPager(vp, mTitles, this, mFragments);
        tabLayout_9.setViewPager(vp, mTitles);
        tabLayout_10.setViewPager(vp, mTitles);


        vp.setCurrentItem(mTitles.size()-1);
//
//        tabLayout_1.showDot(4);
//        tabLayout_3.showDot(4);
//        tabLayout_2.showDot(4);
//
//        tabLayout_2.showMsg(3, 5);
//        tabLayout_2.setMsgMargin(3, 0, 10);
//        MsgView rtv_2_3 = tabLayout_2.getMsgView(3);
//        if (rtv_2_3 != null) {
//            rtv_2_3.setBackgroundColor(Color.parseColor("#6D8FB0"));
//        }
//
//        tabLayout_2.showMsg(5, 5);
//        tabLayout_2.setMsgMargin(5, 0, 10);

//        tabLayout_7.setOnTabSelectListener(new OnTabSelectListener() {
//            @Override
//            public void onTabSelect(int position) {
//                Toast.makeText(mContext, "onTabSelect&position--->" + position, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onTabReselect(int position) {
//                mFragments.add(SimpleCardFragment.getInstance("后端"));
//                mAdapter.notifyDataSetChanged();
//                tabLayout_7.addNewTab("后端");
//            }
//        });
    }

    @Override
    public void onTabSelect(int position) {
        Toast.makeText(mContext, "onTabSelect&position--->" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabReselect(int position) {
        Toast.makeText(mContext, "onTabReselect&position--->" + position, Toast.LENGTH_SHORT).show();
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position).bottom;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}
