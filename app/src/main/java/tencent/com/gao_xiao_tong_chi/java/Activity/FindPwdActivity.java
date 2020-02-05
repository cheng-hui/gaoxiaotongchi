package tencent.com.gao_xiao_tong_chi.java.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class FindPwdActivity extends AppCompatActivity {
    private EditText name;
    private TextView find_question;
    private EditText find_answer;
    private Button find_next;
    private String question_name;
    private String user_answer;
    private String usertoken_str;

    private String url_findpwd_qs= HttpUrlData.getUrl()+"/v1/user/question/show/";
    private String url_findpwd= HttpUrlData.getUrl()+"/v1/user/check/answer/";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pasw_search);
        name = (EditText)findViewById(R.id.name);
        find_question = (TextView) findViewById( R.id.find_question);
        find_answer = (EditText) findViewById(R.id.find_answer);
        find_next = (Button) findViewById(R.id.find_next);

        find_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( !question_name.equals("")) {
                    AsyncHttpClient client = new AsyncHttpClient();//网络请求
                    RequestParams params = new RequestParams();//新建请求参数
                    params.put("question_name", find_question.getText().toString());
                    client.get(url_findpwd_qs + "/v1/user/question/show/", params, new JsonHttpResponseHandler() {

                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            try {
                                Boolean bool = Boolean.valueOf(
                                        response.get("infostatus").toString()).booleanValue();
                                String str = response.get("infomsg").toString();
                                if (bool) {
                                        String usertoken_str = response.get("inforesult").toString();
                                        Toast.makeText(FindPwdActivity.this, str, Toast.LENGTH_LONG).show();
                                   /* Intent intent = new Intent(FindPwdActivity.this, FindPwd2Activity.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("usertoken_str", usertoken_str);
                                    intent.putExtras(bundle);
                                    startActivity(intent);
                                    finish();*/
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    });
                }
            }
        });

        find_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( user_answer.equals("")) {
                    Toast.makeText(FindPwdActivity.this, "密保答案不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    AsyncHttpClient client = new AsyncHttpClient();
                    RequestParams params = new RequestParams();//新建请求参数
                    //params.put("user_name", find_question.getText().toString());
                    params.put("user_answer", find_answer.getText().toString());
                    client.get(url_findpwd + "/v1/user/check/answer/", params, new JsonHttpResponseHandler() {

                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            try {
                                Boolean bool = Boolean.valueOf(
                                        response.get("infostatus").toString()).booleanValue();
                                String str = response.get("infomsg").toString();
                                if (bool) {
                                    //String usertoken_str = response.get("inforesult").toString();
                                    Toast.makeText(FindPwdActivity.this, str, Toast.LENGTH_LONG).show();
                                    /*Intent intent = new Intent(FindPwdActivity.this, FindPwd2Activity.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("usertoken_str", usertoken_str);
                                    intent.putExtras(bundle);
                                    startActivity(intent);
                                    finish();*/
                                }else {
                                    Toast.makeText(
                                            getApplicationContext(),
                                            "问题答案不对！", Toast.LENGTH_LONG)
                                            .show();
                                    ((EditText) findViewById(R.id.find_answer)).setText("");
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    });
                }
            }
        });

        find_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( !user_answer.equals("")) {
                    AsyncHttpClient client = new AsyncHttpClient();
                    RequestParams params = new RequestParams();//新建请求参数
                    params.put("question_name", find_question.getText().toString());
                    params.put("user_answer", find_answer.getText().toString());
                    client.get(url_findpwd + "/v1/user/find_next/", params, new JsonHttpResponseHandler() {

                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            try {
                                Boolean bool = Boolean.valueOf(
                                        response.get("infostatus").toString()).booleanValue();
                                String str = response.get("infomsg").toString();
                                if (bool) {
                                    String usertoken_str = response.get("inforesult").toString();
                                    Toast.makeText(FindPwdActivity.this, str, Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(FindPwdActivity.this, FindPwd2Activity.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("usertoken_str", usertoken_str);
                                    intent.putExtras(bundle);
                                    startActivity(intent);

                                }else {
                                    Toast.makeText(getApplicationContext(), "您输入的密保答案错误!", Toast.LENGTH_LONG).show();
                                    ((EditText) findViewById(R.id.find_answer)).setText("");// 清空密保答案编辑框
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
