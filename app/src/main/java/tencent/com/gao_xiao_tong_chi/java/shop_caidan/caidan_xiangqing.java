package tencent.com.gao_xiao_tong_chi.java.shop_caidan;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import tencent.com.gao_xiao_tong_chi.R;

public class caidan_xiangqing extends Activity {
    private RollPagerView mRollViewPager;/*轮播图 - 滚动条*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_caidan_xiangqing );
        ImageButton fanhui_shop=(ImageButton)findViewById(R.id.fanhui_shop );
        fanhui_shop.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
            });
        setRollPagerView();/*设置轮播图*/
    }
    /*设置轮播图*/
    private void setRollPagerView(){

        mRollViewPager = findViewById(R.id.caidan_rollPagerView);//少了个v
        //设置透明度
        mRollViewPager.setAnimationDurtion(500);
        //设置适配器
        mRollViewPager.setAdapter(new TestNormalAdapter());
        //设置指示器（顺序依次）
        //自定义指示器图片
        //设置圆点指示器颜色
        //设置文字指示器
        //隐藏指示器
        //mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));
        mRollViewPager.setHintView(new ColorPointHintView(this, R.color.yellow, Color.WHITE));
        //mRollViewPager.setHintView(new TextHintView(this));
        //mRollViewPager.setHintView(null);

    }

    /*RollPagerView设置内部类*/
    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] img = {
                R.mipmap.cai1,
                R.mipmap.cai2,
                R.mipmap.cai3,
                R.mipmap.cai4,
        };
        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(img[position]);
            view.setScaleType(ImageView.ScaleType.FIT_XY);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }
        @Override
        public int getCount() {
            return img.length;
        }
    }
}

