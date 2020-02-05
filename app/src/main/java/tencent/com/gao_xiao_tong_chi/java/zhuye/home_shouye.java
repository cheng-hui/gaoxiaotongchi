package tencent.com.gao_xiao_tong_chi.java.zhuye;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import tencent.com.gao_xiao_tong_chi.R;
import tencent.com.gao_xiao_tong_chi.java.mine.Login;
import tencent.com.gao_xiao_tong_chi.java.shop.jiebiantan;

public class home_shouye extends Fragment implements View.OnClickListener,View.OnTouchListener,GestureDetector.OnGestureListener{
    private RollPagerView mRollViewPager;/*轮播图 - 滚动条*/
    private GestureDetector mGestureDetector;
    private ScrollView mLinearLayout;

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstatceState) {
        View view = inflater.inflate( R.layout.home_shouye, null );
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageView guanggao=getActivity().findViewById( R.id.guanggao);
        guanggao.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getActivity().getBaseContext(), Login.class);
                startActivity(intent);
            }
        } );
    setRollPagerView();/*设置轮播图*/
        ImageButton jiebiantan= getActivity().findViewById( R.id.jiebiantan);
        jiebiantan.setOnClickListener(this);
            ImageButton search_button = (ImageButton)getActivity().findViewById(R.id.search_button);
            search_button.setOnClickListener( new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent intent = new Intent( getActivity().getBaseContext(), Search.class);
                  startActivity(intent);
              }
          } );
            ImageButton zuohua = (ImageButton)getActivity(). findViewById( R.id.zuohua1 );

        //初始化控件
            Spinner spinnerschool = (Spinner)  getActivity().findViewById( R.id.schoolchose );
 //建立数据源
           String[] mItems = getResources().getStringArray( R.array.school );
 //建立Adapter并且绑定数据源
          //  ArrayAdapter<String> adapter = new ArrayAdapter<String>( home_shouye.this, android.R.layout.simple_spinner_item, mItems );
          ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1,mItems);
            adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
//绑定 Adapter到控件c
          spinnerschool.setAdapter( adapter );
        /* setContentView(); */
       // findView();

         }
//     private void findView(){
//        mLinearLayout = (ScrollView) getActivity().findViewById(R.id.scroll);
//        mLinearLayout.setOnTouchListener(this);
//        mLinearLayout.setLongClickable(true);
//         mGestureDetector = new GestureDetector(getActivity().getBaseContext(),this);
//
//    }
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.search_button:
//                home_shouye.this.startActivity( new Intent( home_shouye.this, home_mine.class) );
//                break;
            case R.id.jiebiantan:
                home_shouye.this.startActivity( new Intent( getActivity().getBaseContext(), jiebiantan.class) );
                break;
        }
    }

    /*设置轮播图*/
    private void setRollPagerView(){

        mRollViewPager =  getActivity().findViewById(R.id.shouye_rollPagerView);//少了个v
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
        mRollViewPager.setHintView(new ColorPointHintView(getActivity().getBaseContext(), R.color.yellow,Color.WHITE));
    }
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        // TODOAuto-generatedmethodstub
//        mGestureDetector.onTouchEvent(ev); // 让GestureDetector响应触碰事件
//        super.dispatchTouchEvent(ev); // 让Activity响应触碰事件
//        return false;
//    }
    @Override
    //用户按下屏幕就会触发：
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    //短按触摸屏
    public void onShowPress(MotionEvent e) {

    }

    @Override
    //点击屏幕后抬起时触发该事件
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    //在屏幕上拖动控件
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    //长按触摸屏
    public void onLongPress(MotionEvent e) {

    }

   //滑屏，用户按下触摸屏、快速移动后松开，由1个MotionEvent ACTION_DOWN, 多个ACTION_MOVE, 1个       
    //ACTION_UP触发；参数分别表示：按下事件、抬起事件、x方向移动速度、y方向移动速度。 
   // 监听手势滑动事件 e1表示滑动的起点,e2表示滑动终点 velocityX表示水平速度 velocityY表示垂直速度 
        @Override
public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
 final int FLING_MIN_DISTANCE = 100;
final int FLING_MIN_VELOCITY = 200;
      //if ((int) (e1.getX() - e2.getX()) > FLING_MIN_DISTANCE&& Math.abs(velocityX) > FLING_MIN_VELOCITY ) 右滑
     if ((int) (e2.getX() - e1.getX()) > FLING_MIN_DISTANCE ) {
         //左滑右滑皆可
           Intent intent = new Intent( getActivity().getBaseContext(), Map.class);
            startActivity(intent);
             //finish();
 }
          return true;
      }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
}
    //实现OnTouchListener接口中的方法

    /*RollPagerView设置内部类*/
    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] img = {
                R.mipmap.lunbo1,
                R.mipmap.lunbo2,
                R.mipmap.lunbo3,
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

