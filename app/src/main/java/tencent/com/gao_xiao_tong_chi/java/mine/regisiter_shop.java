package tencent.com.gao_xiao_tong_chi.java.mine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import tencent.com.gao_xiao_tong_chi.R;
import tencent.com.gao_xiao_tong_chi.java.Activity.Managershop;
import tencent.com.gao_xiao_tong_chi.java.Activity.Modify_shop;
import tencent.com.gao_xiao_tong_chi.java.houduan.usertoken;
import tencent.com.gao_xiao_tong_chi.java.houduan.HttpUrlData;

public class regisiter_shop extends Activity {
    private String shop_name_true;
    private String shop_address_true;
    private int shop_number_true;
    private String shop_picture_true;
    private String shop_card_picture1_true;
    private String shop_card_picture2_true;
    private String url_path= HttpUrlData.getUrl();
    public static final String TAG ="提交审核" ;
    private String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.regisiter_shop );
        EditText shop_name=(EditText)findViewById( R.id.shop_name );
        EditText shop_address=(EditText)findViewById( R.id.shop_address );
        EditText shop_number=(EditText)findViewById( R.id.shop_number );

        ImageView shop_picture=(ImageView)findViewById( R.id.shop_picture );
        ImageView shop_card_picture1=(ImageView)findViewById( R.id.shop_card_picture1 );
        ImageView shop_card_picture2=(ImageView)findViewById( R.id.shop_card_picture2 );
        Button shop_register_finish=(Button)findViewById( R.id.shop_register_finish );
        ImageButton return_managershopnull = findViewById( R.id.return_managershopnull );
        return_managershopnull.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        } );
        shop_name.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shop_name.getText().toString().equals( "" )) {
                    Toast.makeText( regisiter_shop.this, "店铺名称不能为空", Toast.LENGTH_SHORT ).show();
                }
               }
        } );
        shop_address.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shop_address.getText().toString().equals( "" )) {
                    Toast.makeText( regisiter_shop.this, "店铺名称不能为空", Toast.LENGTH_SHORT ).show();
                }
            }
        } );
        shop_number.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shop_number.getText().toString().equals( "" )) {
                    Toast.makeText( regisiter_shop.this, "联系方式不能为空", Toast.LENGTH_SHORT ).show();
                }
            }
        } );

        //完成注册
        shop_register_finish.setOnClickListener( new View.OnClickListener() {
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
                Toast.makeText(regisiter_shop.this,"注册店铺成功",Toast.LENGTH_SHORT).show();
                regisiter_shop.this.startActivity( new Intent( regisiter_shop.this, Managershop.class ) );
            }
        });
    }
    void getData(){
        {
            // usertoken_str`shop_name`shop_address`shop_number`shop_class`shop_picture`shop_card_picture1`shop_card_picture2
            AsyncHttpClient client = new AsyncHttpClient();
            RequestParams params = new RequestParams();//新建请求参数
            usertoken usertoken2=new usertoken();
            uid=usertoken2.getUsertoken();
            params.put("usertoken_str",uid);
            params.put("shop_name",shop_name_true);
            params.put("shop_address",shop_address_true);
            params.put("shop_number",shop_number_true);
            params.put("shop_class","jiebiantan");
            params.put("shop_picture"," XX.jpg");
            params.put("shop_card_picture1","XX.jpg");
            params.put("shop_card_picture2","XX.jpg");
            Log.i(TAG, "123333333"+uid);
            Log.i(TAG, "123333333"+shop_name_true+shop_address_true+shop_number_true);
            Log.i(TAG, "123333333"+params);
            client.post(url_path+"/v1/user/myshop/add/", params,new JsonHttpResponseHandler(){
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response)  {
                    try {
                        Boolean bool = Boolean.valueOf( response.get("infostatus").toString());
                        String str = response.get("infomsg").toString();
                        Log.i(TAG, "在里面啦啦啦"+bool+str);
                        if (bool){
                            //店铺的ID是string
                            String shop_id = response.get("inforesult").toString();
                            Log.i(TAG, "店铺的Id"+shop_id);
                            Intent intent = new Intent( regisiter_shop.this, Managershop.class );
                            intent.putExtra("shop_id",shop_id);
                            regisiter_shop.this.startActivity( intent );
                            Toast.makeText(regisiter_shop.this,str,Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(regisiter_shop.this,str,Toast.LENGTH_SHORT).show();
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