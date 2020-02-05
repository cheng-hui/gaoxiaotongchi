package tencent.com.gao_xiao_tong_chi.java.mine.impression_shoucang;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.util.ArrayList;
import java.util.List;

import tencent.com.gao_xiao_tong_chi.R;
import tencent.com.gao_xiao_tong_chi.java.mine.Cai_shoucang.Cai;
import tencent.com.gao_xiao_tong_chi.java.mine.Cai_shoucang.RecycleDemoAdapter;
import tencent.com.gao_xiao_tong_chi.java.mine.Cai_shoucang.mine_menu;

public class mine_impression extends Activity {
    private SwipeMenuRecyclerView swipeRecyclerView;
    private List<Impression> list1 = new ArrayList<>();
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.mine_impression );
        ImageButton return_mine6 = findViewById( R.id.return_mine6);
        return_mine6.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        } );
        loadCH();
    }
    private void loadCH() {

        swipeRecyclerView = findViewById(R.id.slide_impression);
//// 向list 里添加数据
        addData();
        adapter = new RecycleDemoAdapter_impression(this, list1);
        //        设置 recyclerView 的 布局管理器
//        就是 recyclerview 的显示效果
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        swipeRecyclerView.setLayoutManager(layoutManager);

        // 创建菜单：
        SwipeMenuCreator mSwipeMenuCreator = new SwipeMenuCreator() {
            @Override
            public void onCreateMenu(SwipeMenu leftMenu, SwipeMenu rightMenu, int viewType) {

                int width = getResources().getDimensionPixelOffset(R.dimen.dp_100);
                int height = ViewGroup.LayoutParams.MATCH_PARENT;
                // 注意：哪边不想要菜单，那么不要添加即可。
                SwipeMenuItem addItem = new SwipeMenuItem( mine_impression.this)
                        // .setBackground(R.drawable.selector_green)
                        .setImage(R.mipmap.ic_action_delete)
                        .setText("添加")
                        .setTextColor( Color.WHITE)
                        .setWidth(width)
                        .setHeight(height);
                rightMenu.addMenuItem(addItem); // 添加菜单到右侧。
            }
        };
// 设置监听器。
        swipeRecyclerView.setSwipeMenuCreator(mSwipeMenuCreator);

        SwipeMenuItemClickListener mMenuItemClickListener = new SwipeMenuItemClickListener() {
            @Override
            public void onItemClick(SwipeMenuBridge menuBridge) {
                // 任何操作必须先关闭菜单，否则可能出现Item菜单打开状态错乱。
                menuBridge.closeMenu();
                int direction = menuBridge.getDirection(); // 左侧还是右侧菜单。
                int adapterPosition = menuBridge.getAdapterPosition(); // RecyclerView的Item的position。
                int menuPosition = menuBridge.getPosition(); // 菜单在RecyclerView的Item中的Position。
                Toast.makeText(mine_impression.this, direction + " " + adapterPosition + " " + menuPosition, Toast.LENGTH_SHORT).show();
            }
        };

        // 菜单点击监听。
        swipeRecyclerView.setSwipeMenuItemClickListener(mMenuItemClickListener);

        // 添加适配器
        swipeRecyclerView.setAdapter(adapter);
    }

    private void addData() {
       Impression impression1=new Impression(R.mipmap.caiping1,"标题，或者前面几个字");
        Impression impression2=new Impression(R.mipmap.caiping2,"标题，或者前面几个字");
        Impression impression3=new Impression(R.mipmap.caiping3,"标题，或者前面几个字");

        list1.add(impression1);
        list1.add(impression2);
        list1.add(impression3);


    }
}
