package tencent.com.gao_xiao_tong_chi.java.zhuye;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;
//import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import java.util.ArrayList;
import java.util.List;

import tencent.com.gao_xiao_tong_chi.R;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    private BottomNavigationBar mBottomNavigationBar;
    private home_shouye home_shouye;
    private home_yingxiang home_yingxiang;
    private tencent.com.gao_xiao_tong_chi.java.zhuye.home_mine home_mine;
    private List<Fragment> list;
    private int id;
    public static final String TAG_EXIT = "exit";
    @Override
    protected void onNewIntent( Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            boolean isExit = intent.getBooleanExtra(TAG_EXIT, false);
            if (isExit) {
                this.finish();
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView( R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
         id = getIntent().getIntExtra("fragement", 0);
        initViews();

    }
    private void initViews() {
        list = new ArrayList<Fragment>();
        /**
         * 设置BottomNavigationBar以及Item项（BottomNavigationItem）
         *      包括按钮选中效果 导航栏背景色等
         */
        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_bar);
        mBottomNavigationBar
                /**
                 *  setMode() 内的参数有三种模式类型：
                 *  MODE_DEFAULT 自动模式：导航栏Item的个数<=3 用 MODE_FIXED 模式，否则用 MODE_SHIFTING 模式
                 *  MODE_FIXED 固定模式：未选中的Item显示文字，无切换动画效果。
                 *  MODE_SHIFTING 切换模式：未选中的Item不显示文字，选中的显示文字，有切换动画效果。
                 */
                .setMode(BottomNavigationBar.MODE_SHIFTING)
                /**
                 *  setBackgroundStyle() 内的参数有三种样式
                 *  BACKGROUND_STYLE_DEFAULT: 默认样式 如果设置的Mode为MODE_FIXED，将使用BACKGROUND_STYLE_STATIC
                 *                                    如果Mode为MODE_SHIFTING将使用BACKGROUND_STYLE_RIPPLE。
                 *  BACKGROUND_STYLE_STATIC: 静态样式 点击无波纹效果
                 *  BACKGROUND_STYLE_RIPPLE: 波纹样式 点击有波纹效果
                 */
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .setActiveColor("#FFC125")                  //选中颜色
                .setInActiveColor("#FFFFFF")                //未选中颜色
                .setBarBackgroundColor("#F7F7F7")           //导航栏背景色
                /**
                 * 添加导航按钮
                 */
                .addItem(new BottomNavigationItem(R.mipmap.shouye_before, "主页"))
                .addItem(new BottomNavigationItem(R.mipmap.yingxiang_before, "印象"))
                .addItem(new BottomNavigationItem(R.mipmap.mine_before, "我的"))
                .setFirstSelectedPosition(0)
                .initialise();

        mBottomNavigationBar.setTabSelectedListener(this);

        /**
         *因为首次进入不会主动回调选中页面的监听，所以这里进行手动调用一遍，初始化第一个页面
         */
        onTabSelected(0);
        if (id==1) {
            onTabSelected(2);
           //mBottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.mine_before, "我的")).setFirstSelectedPosition(2);
        }
    }

    /**
     * 设置导航选中的事件
     *
     * @param position
     *              选中的下标
     */
    @Override
    public void onTabSelected(int position) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        /**
         *每次添加之前隐藏所有正在显示的Fragment
         *      如果是第一次添加的话使用transaction.add();第二次显示的时候,使用transaction.show();
         * 这样子我们就可以保存Fragment的状态了
         */
        hideFragment(transaction);
        switch (position) {

            case 0:{
                if (home_shouye == null) {
                    home_shouye = new home_shouye();
                    transaction.add(R.id.fl_container, home_shouye);
                    list.add(home_shouye);
                } else {
                    transaction.show(home_shouye);
                }
                break;
            }

            case 1:{
                if (home_yingxiang == null) {
                    home_yingxiang = new home_yingxiang();
                    transaction.add(R.id.fl_container, home_yingxiang);
                    list.add(home_yingxiang);
                } else {
                    transaction.show(home_yingxiang);
                }
                break;
            }

            case 2:{
                if (home_mine == null) {
                    home_mine = new home_mine();
                    transaction.add(R.id.fl_container, home_mine);
                    list.add(home_mine);
                } else {
                    transaction.show(home_mine);
                }
                break;
            }

            default:{
                break;
            }
        }
        transaction.commit();

    }

    /**
     * 设置未选中Fragment 事件
     */
    @Override
    public void onTabUnselected(int position) {

    }

    /**
     * 设置再次选中的Fragment 事件
     */
    @Override
    public void onTabReselected(int position) {
        if (position == 1) {
            Toast.makeText(this, "神奇奇迹", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     *  隐藏所有正在显示的Fragment
     *
     * @param transaction
     *              FragmentTransaction
     */
    private void hideFragment(FragmentTransaction transaction) {

        for (Fragment fragment :
                list) {
            transaction.hide(fragment);
        }

    }

}
