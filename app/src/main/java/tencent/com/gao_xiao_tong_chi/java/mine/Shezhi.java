package tencent.com.gao_xiao_tong_chi.java.mine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import tencent.com.gao_xiao_tong_chi.R;
import tencent.com.gao_xiao_tong_chi.java.zhuye.MainActivity;

public class Shezhi extends Activity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.shezhi );
        TextView return_mine2 = findViewById( R.id.return_mine2 );
        return_mine2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        } );
        //退出登录
        TextView exit_login = findViewById( R.id.exit_login );
        exit_login.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Shezhi.this, MainActivity.class);
                intent.putExtra(MainActivity.TAG_EXIT, true);
                startActivity(intent);
            }
        } );
        //关于通吃
        TextView about_app = findViewById( R.id.about_app );
        about_app.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Shezhi.this.startActivity( new Intent( Shezhi.this, About_app.class ) );
            }
        } );
        //修改信息
        TextView modify_information = findViewById( R.id.modify_information );
        modify_information.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Shezhi.this.startActivity( new Intent( Shezhi.this, Modify_information.class ) );
            }
        } );
    }
}
