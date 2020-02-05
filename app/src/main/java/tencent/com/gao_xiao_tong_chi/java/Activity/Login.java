package tencent.com.gao_xiao_tong_chi.java.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import tencent.com.gao_xiao_tong_chi.R;
import tencent.com.gao_xiao_tong_chi.java.houduan.HttpUrlData;
import tencent.com.gao_xiao_tong_chi.java.houduan.usertoken;

public class Login extends AppCompatActivity {
    private EditText et_name;
    private EditText et_password;
    public static final String TAG ="提交审核" ;
    Button loginBtn;
    Button registerfinal;
    private TextView login_TextView,forget_pwd,register;

    private String user_name;
    private String user_password;

    private String url_login= HttpUrlData.getUrl();
    private boolean login_type=true;
    private static final String LOG="log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.in);
        TextView forget_password = findViewById( R.id.forget_password );
        forget_password.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login.this.startActivity( new Intent( Login.this,Psw_search.class ) );
            }
        } );
        et_name = (EditText)findViewById(R.id.login_username);
        et_password = (EditText)findViewById(R.id.login_password);
        loginBtn = (Button)findViewById(R.id.login_button);
        registerfinal=(Button) findViewById(R.id.registerfinal);
        registerfinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login.this.startActivity( new Intent( Login.this, Register_one.class ) );
            }
            });
//登录按钮
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG, "onClick: 登录点击");
                user_name = et_name.getText().toString();
                user_password = et_password.getText().toString();
                if (!user_name.equals("") && !user_password.equals("")&&login_type) {
                    login_type=false;
                    Log.i(LOG, "onClick: 登录判断");
                    AsyncHttpClient client = new AsyncHttpClient();
                    RequestParams params = new RequestParams();//新建请求参数
                    params.put("user_name", et_name.getText().toString());
                    params.put("user_password", et_password.getText().toString());
                    //
                    client.post(url_login+"/v1/user/login/", params, new JsonHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            try {
                                Log.i(LOG, "onSuccess: 进入判断");
                                Boolean bool = Boolean.valueOf(response.get("infostatus").toString()).booleanValue();
                                String str = response.get("infomsg").toString();
                               // String strs=response.get("inforesult").toString();
                                if (bool) {
                                    String usertoken_str = response.get("inforesult").toString();
                                    Toast.makeText(Login.this, str, Toast.LENGTH_SHORT).show();
                                    usertoken usertoken1=new usertoken();
                                    usertoken1.setUsertoken( usertoken_str );
                                    Log.i(TAG, "123333333"+usertoken_str);
                                    Login.this.startActivity( new Intent( Login.this,MainActivity.class ) );
                                } else {
                                    Toast.makeText(getApplicationContext(), "您输入的用户名或密码错误!", Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    });
                }else {
                    if (!login_type){

                    }else {
                        Toast.makeText(getApplication(), "用户名或者密码不得为空", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
            }
}
