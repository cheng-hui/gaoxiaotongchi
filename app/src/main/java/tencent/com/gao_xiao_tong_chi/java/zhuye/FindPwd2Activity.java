package tencent.com.gao_xiao_tong_chi.java.zhuye;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import tencent.com.gao_xiao_tong_chi.R;
import tencent.com.gao_xiao_tong_chi.java.houduan.HttpUrlData;
import tencent.com.gao_xiao_tong_chi.java.mine.Login;

public class FindPwd2Activity extends AppCompatActivity {
    private EditText new_pwd,find_pwd;
    private Button find_finish;
    //private String user_newpassword;
    private String url_findpwd= HttpUrlData.getUrl()+"/v1/user/find/password/";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView( R.layout.pasw_search2);
        new_pwd = (EditText) findViewById(R.id.new_pwd);
        find_pwd = (EditText) findViewById(R.id.find_pwd);
        find_finish = (Button) findViewById(R.id.find_finish);
        new_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new_pwd.setInputType( InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);  //文本以密码形式显示
                //login_password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);//文本正常显示
            }
        });
        find_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                find_pwd.setInputType( InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);  //文本以密码形式显示
                //login_password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);//文本正常显示
            }
        });

        find_pwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub
                if (hasFocus) {
                    // 处于焦点，什么也不做
                } else {

                    if (!(new_pwd.equals(find_pwd))) { // 判断两次输入的密码是否一致
                        Toast.makeText(FindPwd2Activity.this,
                                "两次输入的密码不一致，请重新输入！", Toast.LENGTH_LONG).show();
                        ((EditText) findViewById(R.id.new_pwd))
                                .setText(""); // 清空密码编辑框
                        ((EditText) findViewById(R.id.find_pwd))
                                .setText(""); // 清空确认密码编辑框

                    }

                }
            }

        });

        find_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( !new_pwd.equals("")&& !find_pwd.equals("")) {
                    AsyncHttpClient client = new AsyncHttpClient();
                    RequestParams params = new RequestParams();//新建请求参数
                    params.put("user_newpassword", new_pwd.getText().toString());
                    params.put("user_password", find_pwd.getText().toString());
                    client.post(url_findpwd + "/v1/user/find/password/", params, new JsonHttpResponseHandler() {

                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            try {
                                Boolean bool = Boolean.valueOf(
                                        response.get("infostatus").toString()).booleanValue();
                                String str = response.get("infomsg").toString();
                                if (bool) {
                                    String usertoken_str = response.get("inforesult").toString();
                                    Toast.makeText(FindPwd2Activity.this, str, Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(FindPwd2Activity.this, Login.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("usertoken_str", usertoken_str);
                                    intent.putExtras(bundle);
                                    startActivity(intent);
                                    finish();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    });
                }
            }
        });

    }
}
