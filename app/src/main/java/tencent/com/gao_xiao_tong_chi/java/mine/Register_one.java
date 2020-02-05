package tencent.com.gao_xiao_tong_chi.java.mine;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import tencent.com.gao_xiao_tong_chi.R;
import tencent.com.gao_xiao_tong_chi.java.houduan.HttpUrlData;

public class Register_one extends AppCompatActivity {
    public static final String TAG = "提交审核";
    private int index = 0;//记录ietm的下标
    private EditText user_id, user_password, re_user_password, user_name;
    private String url_path = HttpUrlData.getUrl();

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.basicinformation );
        //setContentView( R.layout.informationcomplete);
        //Button insert = (Button) findViewById(R.id.m_insert);
        ImageView user_head = (ImageView) findViewById( R.id.user_head );
        final EditText user_name = (EditText) findViewById( R.id.user_name );
        final EditText user_zhanghao = (EditText) findViewById( R.id.user_zhanghao );
        final EditText user_password = (EditText) findViewById( R.id.user_password );
        final EditText re_user_password = (EditText) findViewById( R.id.re_user_password );
        Button register_next = (Button) findViewById( R.id.register_next );
//用户名
        user_name.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user_name.getText().toString().equals( "" )) {
                    Toast.makeText( Register_one.this, "用户名不能为空", Toast.LENGTH_SHORT ).show();
                }
            }
        } );

 //用户账号
        user_zhanghao.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user_zhanghao.getText().toString().equals( "" )) {
                    Toast.makeText( Register_one.this, "账号不能为空", Toast.LENGTH_SHORT ).show();
                }
            }
        } );

        //用户密码
        user_password.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user_password.getText().toString().equals( "" )) {
                    Toast.makeText( Register_one.this, "密码不能为空", Toast.LENGTH_SHORT ).show();
                }
            }
        } );
        //用户确认密码
        re_user_password.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (re_user_password.getText().toString().equals( "" )) {
                    Toast.makeText( Register_one.this, "确认密码不能为空", Toast.LENGTH_SHORT ).show();
                }
                if (re_user_password.getText().toString()!=user_password.getText().toString()) {
                    Toast.makeText( Register_one.this, "两次密码输入不一致", Toast.LENGTH_SHORT ).show();
                }
            }
        } );
        //下一步
        register_next.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent( Register_one.this, Register_two.class );
                intent.putExtra("user_name",user_name.getText().toString());
                intent.putExtra("user_zhanghao",user_zhanghao.getText().toString());
                intent.putExtra("user_password",user_password.getText().toString());
                Register_one.this.startActivity( intent );
        } });
    }
    }
