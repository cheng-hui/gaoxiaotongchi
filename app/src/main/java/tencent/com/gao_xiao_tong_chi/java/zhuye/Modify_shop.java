package tencent.com.gao_xiao_tong_chi.java.zhuye;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import tencent.com.gao_xiao_tong_chi.R;
import tencent.com.gao_xiao_tong_chi.java.houduan.HttpUrlData;

public class Modify_shop extends Activity {
    private String shop_name_true;
    private String shop_address_true;
    private int shop_number_true;
    private String url_path= HttpUrlData.getUrl();
    public static final String TAG ="提交审核" ;
    private int shop_id_true;
    private String shop_id;
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.modify_shop );
        Button modify_finish = (Button) findViewById( R.id.modify_finish );
        EditText shop_name=(EditText)findViewById( R.id.shop_name );
        EditText shop_address=(EditText)findViewById( R.id.shop_address );
        EditText shop_number=(EditText)findViewById( R.id.shop_number );
        //保存并返回
        modify_finish.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shop_name_true=shop_name.getText().toString();
                shop_address_true=shop_address.getText().toString();

                try {
                    shop_number_true = Integer.parseInt(shop_number.getText().toString());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                getData();
                finish();
            }
        } );
        ImageButton return_managershop = findViewById( R.id.return_managershop );
        return_managershop.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        } );



    }
    void getData(){
        {
            // usertoken_str`shop_name`shop_address`shop_number`shop_class`shop_picture`shop_card_picture1`shop_card_picture2
            AsyncHttpClient client = new AsyncHttpClient();
            RequestParams params = new RequestParams();//新建请求参数
            Intent intent = getIntent();
            shop_id = intent.getStringExtra("shop_id");
            try {
                shop_id_true= Integer.parseInt( shop_id );
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
//            usertoken usertoken2=new usertoken();
//            uid=usertoken2.getUsertoken();
            params.put("shop_id",shop_id_true);
            params.put("shop_name",shop_name_true);
            params.put("shop_address",shop_address_true);
            params.put("shop_number",shop_number_true);
            params.put("shop_class","jiebiantan");
            params.put("shop_picture"," XX.jpg");
            params.put("shop_card_picture1","XX.jpg");
            params.put("shop_card_picture2","XX.jpg");
            Log.i(TAG, "123333333"+shop_id_true);
            Log.i(TAG, "123333333"+shop_name_true+shop_address_true+shop_number_true);
            Log.i(TAG, "123333333"+params);
            client.post(url_path+"/v1/user/myshop/modify/", params,new JsonHttpResponseHandler(){
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response)  {
                    try {
                        Boolean bool = Boolean.valueOf( response.get("infostatus").toString());
                        String str = response.get("infomsg").toString();
                        Log.i(TAG, "在里面啦啦啦"+bool+str);
                        if (bool){
                            Toast.makeText( Modify_shop.this,str,Toast.LENGTH_SHORT).show();
                            Modify_shop.this.startActivity( new Intent( Modify_shop.this,Managershop.class ) );
                        }
                        else {
                            Toast.makeText(Modify_shop.this,str,Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        Log.i(TAG, "抛出异常");
                        e.printStackTrace();
                    }
                }
            });
            //registerPost(url_path+"/v1/user/signup/post/",client,params);
        }
    }
}
