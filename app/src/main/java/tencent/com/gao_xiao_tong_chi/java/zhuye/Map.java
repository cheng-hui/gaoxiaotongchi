package tencent.com.gao_xiao_tong_chi.java.zhuye;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import tencent.com.gao_xiao_tong_chi.R;

public class Map extends Activity implements View.OnTouchListener, GestureDetector.OnGestureListener {
    private GestureDetector mGestureDetector;
    private LinearLayout youhua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate( savedInstanceState );
        setContentView( R.layout.map );
        LinearLayout youhua = (LinearLayout) findViewById( R.id.youhua );
        youhua.setOnTouchListener(this);
        youhua.setLongClickable(true);
        mGestureDetector = new GestureDetector(this,this);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        final int FLING_MIN_DISTANCE = 100;
        final int FLING_MIN_VELOCITY = 200;
        if ((int) (e1.getX() - e2.getX()) > FLING_MIN_DISTANCE&& Math.abs(velocityX) > FLING_MIN_VELOCITY ){
            finish();
        }
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

}