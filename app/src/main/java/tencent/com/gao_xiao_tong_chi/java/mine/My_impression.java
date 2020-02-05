package tencent.com.gao_xiao_tong_chi.java.mine;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import tencent.com.gao_xiao_tong_chi.R;

public class My_impression extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.my_impression );
        //返回我的的注册按钮的监听
        ImageButton return_mine7 = findViewById( R.id.return_mine7 );
        return_mine7.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            finish();
            }
        } );
    }
}
