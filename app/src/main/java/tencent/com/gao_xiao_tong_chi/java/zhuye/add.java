package tencent.com.gao_xiao_tong_chi.java.zhuye;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import tencent.com.gao_xiao_tong_chi.R;
import tencent.com.gao_xiao_tong_chi.java.yingxiang.yinxiang_pinglun;

/**
 * Created by chenghui  2019/7/23.
 */

public class add extends Activity {
    private ImageView add;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_yinxiang );

        add = (ImageView)findViewById( R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(add.this , yinxiang_pinglun.class);

                startActivity(i);
            }
        });

    }
}
