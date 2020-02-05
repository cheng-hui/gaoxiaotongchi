package tencent.com.gao_xiao_tong_chi.java.zhuye;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;

import java.lang.reflect.Field;

import tencent.com.gao_xiao_tong_chi.R;

public class Search extends Activity {
    private SearchView mSearchView;
    private AutoCompleteTextView mAutoCompleteTextView;//搜索输入框
    private ImageView mDeleteButton;//搜索框中的删除按钮

   // private Button mBtnNext;//下一界面
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.search1 );
        ImageButton return_shouye1 = findViewById( R.id.return_shouye1 );
        return_shouye1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        } );
        initView();
        initData();
    }
    private void initView(){
       // mBtnNext=findViewById(R.id.btn_next);
        mSearchView=findViewById(R.id.searchView);
        mAutoCompleteTextView=mSearchView.findViewById(R.id.search_src_text);
        mDeleteButton=mSearchView.findViewById(R.id.search_close_btn);
    }
    private void initData(){
        mSearchView.setIconifiedByDefault(false);//设置搜索图标是否显示在搜索框内
        //1:回车
        //2:前往
        //3:搜索
        //4:发送
        //5:下一項
        //6:完成
        mSearchView.setImeOptions(2);//设置输入法搜索选项字段，默认是搜索，可以是：下一页、发送、完成等
//        mSearchView.setInputType(1);//设置输入类型
//        mSearchView.setMaxWidth(200);//设置最大宽度
        mSearchView.setQueryHint("请输入店名或种类");//设置查询提示字符串
//        mSearchView.setSubmitButtonEnabled(true);//设置是否显示搜索框展开时的提交按钮
        //设置SearchView下划线透明
       // setUnderLinetransparent(mSearchView);
    }

    private void setListener(){
        mSearchView.setOnClickListener( (View.OnClickListener) this );
        //mBtnNext.setOnClickListener(this);

        // 设置搜索文本监听
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //当点击搜索按钮时触发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                //LogUtil.e(MainActivity.class,"=====query="+query);
                return false;
            }

            //当搜索内容改变时触发该方法
            @Override
            public boolean onQueryTextChange(String newText) {
               // LogUtil.e(MainActivity.class,"=====newText="+newText);
                return false;
            }
        });
    }

    /**设置SearchView下划线透明**/
    private void setUnderLinetransparent(SearchView searchView){
        try {
            Class<?> argClass = searchView.getClass();
            // mSearchPlate是SearchView父布局的名字
            Field ownField = argClass.getDeclaredField("mSearchPlate");
            ownField.setAccessible(true);
            View mView = (View) ownField.get(searchView);
            mView.setBackgroundColor( Color.TRANSPARENT);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    }
