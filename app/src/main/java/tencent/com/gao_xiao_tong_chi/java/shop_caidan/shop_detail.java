package tencent.com.gao_xiao_tong_chi.java.shop_caidan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cz.msebera.android.httpclient.Header;
import tencent.com.gao_xiao_tong_chi.R;
import tencent.com.gao_xiao_tong_chi.java.houduan.HttpUrlData;

import static java.sql.Types.NULL;
public class shop_detail extends Activity{
    private String url_path= HttpUrlData.getUrl();
    private String shop_id;
   // private List<Map<String, Object>> dataList;
    public ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    private SimpleAdapter adapter;
    private Context context;
    private TextView shop_nametwo;
    private ImageView shop_picture;
    private TextView shop_star;
    private TextView shop_address;
    private TextView shop_number;
    private TextView  shop_userid;
    private TextView shop_class;
    private List<caidan> menuList = new ArrayList<caidan>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.shopcai );
       // True,{shop_id,shop_name,shop_rate,shop_address,shop_number,shop_userid,shop_class,shop_picture}
        ImageButton fanhui_shop = (ImageButton) findViewById( R.id.fanhui_shop );
        fanhui_shop.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView shop_nametwo=(TextView)findViewById( R.id.shop_nametwo );
        TextView shop_rate=(TextView)findViewById( R.id.shop_star );
        TextView shop_address=(TextView)findViewById( R.id.shop_address );
        TextView shop_number=(TextView)findViewById( R.id.shop_number );
        ImageView shop_picture=(ImageView) findViewById( R.id.shop_head );
        initShop(); // 初始化菜单数据
        initMenu();//初始化店铺
        Intent intent = getIntent();
        shop_id = intent.getStringExtra("shop_id");
        caidanAdapter adapter = new caidanAdapter( shop_detail.this, R.layout.caidan_item, menuList );
        GridView listView = (GridView) findViewById( R.id.caidan_gridview );
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> mAdapterView, View mView, int mI, long mL) {
                switch (mI) {
                    case 0:
                        String shop_id= menuList.get(mI).getMenu_id();
                        Intent intent = new Intent( shop_detail.this, caidan_xiangqing.class  );
                        intent.putExtra("shop_id",shop_id);
                        shop_detail.this.startActivity( intent );
                        break;
                    case 1:
                        shop_detail.this.startActivity( new Intent( shop_detail.this, caidan_xiangqing.class  ) );
                        break;
                    case 2:
                        shop_detail.this.startActivity( new Intent( shop_detail.this, caidan_xiangqing.class ) );
                        break;
                    case 3:
                        shop_detail.this.startActivity( new Intent( shop_detail.this, caidan_xiangqing.class  ) );
                        break;
                }
            }
        });
    }
    //调用后端的获取菜单页
    private void initMenu() {
            // 创建客户端对象
            AsyncHttpClient client = new AsyncHttpClient();
            RequestParams params = new RequestParams();//新建请求参数
             params.put("shop_id",shop_id);
            Toast.makeText(this, "发送请求到服务器", NULL).show();
            client.get(url_path+"/v1/eat/shop/menu", new JsonHttpResponseHandler() {

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    //返回JSONObject对象|JSONOArray对象
                    // TODO Auto-generated method stub
                    super.onSuccess( statusCode, headers, response );

                    if (statusCode == 200) {
                        //遍历json数组
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                // 获取具体的一个JSONObject对象
                                JSONObject obj = response.getJSONObject( String.valueOf( i ) );
                                //JSONObject对象get(“属性名”)，getString(“属性名”),getInt(“属性名”)等方法来获取指定属性名的值
                                // public caidan( String menu_id,String menu_name, int menu_picture, String menu_price) {
                                caidan caidan = new caidan(obj.getString("menu_id"),obj.getString("menu_name"),obj.getInt("menu_picture"),obj.getString("menu_price"));
                                menuList.add(caidan);
                            } catch (JSONException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });
        }

    //调用后端数据初始化店铺页
private void initShop()
{
    AsyncHttpClient client = new AsyncHttpClient();
    RequestParams params = new RequestParams();//新建请求参数
    params.put("usertoken_str","aa");
    params.put("shop_id",shop_id);
    Toast.makeText(this, "发送请求到服务器", NULL).show();
    client.get(url_path+"/v1/eat/shop/menu", new JsonHttpResponseHandler() {

        @Override
        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
            // TODO Auto-generated method stub
            super.onSuccess( statusCode, headers, response );

        }
    });
}
}
