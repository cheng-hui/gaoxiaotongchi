package tencent.com.gao_xiao_tong_chi.java.shop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import tencent.com.gao_xiao_tong_chi.R;
import tencent.com.gao_xiao_tong_chi.java.Adapter.shopAdapter;
import tencent.com.gao_xiao_tong_chi.java.Entity.Shop;
import tencent.com.gao_xiao_tong_chi.java.houduan.HttpUrlData;
import tencent.com.gao_xiao_tong_chi.java.shop_caidan.shop_detail;

public class jiebiantan extends Activity {
    private String url_path = HttpUrlData.getUrl();
    public static final String TAG = "提交审核";
    private String usertoken_str;
    private List<Shop> shopList = new ArrayList<Shop>();
    int a =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate( savedInstanceState );
        setContentView( R.layout.jiebiantan );
        //new Thread(runnable).start();
        // initShops(); // 初始化店铺数据
        shopAdapter adapter = new shopAdapter( jiebiantan.this, R.layout.shop_item, shopList );
        ListView listView = (ListView) findViewById( R.id.shop_view );
        listView.setAdapter( adapter );
        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> mAdapterView, View mView, int mI, long mL) {
                switch (mI) {
                    case 0:
                       // int  shop_id = shopList.get( mI ).getShop_id();
                        Intent intent = new Intent( jiebiantan.this, shop_detail.class );
                        //intent.putExtra( "shop_id", shop_id );
                        jiebiantan.this.startActivity( intent );
                        break;
                    case 1:
                        jiebiantan.this.startActivity( new Intent( jiebiantan.this, shop_detail.class ) );
                        break;
                    case 2:
                        jiebiantan.this.startActivity( new Intent( jiebiantan.this, shop_detail.class ) );
                        break;
                    case 3:
                        jiebiantan.this.startActivity( new Intent( jiebiantan.this, shop_detail.class ) );
                        break;
                }
            }
        } );
        initShopsnot();
//        initShops();
    }
        private void initShopsnot() {
           // String name, String headId, int starId,String distance)
            Shop zlmlt = new Shop("张亮麻辣烫","33",3.0,"距离您1.5公里");
            shopList.add(zlmlt);
            Shop dbsj = new Shop("东北水饺", "33",4.0,"距离您2.0公里");
            shopList.add(dbsj);
            Shop nrbdx = new Shop("牛肉爆大虾", "33",2.0,"距离您3.0公里");
            shopList.add(nrbdx);
        }
//        l链接后端
    //从后端获取数据并传入LISTVIEW
//    @SuppressLint("WrongConstant")
//    private void initShops() {
//        // 创建客户端对象
////        AsyncHttpClient client = new AsyncHttpClient();
////        RequestParams params = new RequestParams();//新建请求参数
//        usertoken usertoken3 = new usertoken();
//        usertoken_str = usertoken3.getUsertoken();
////        params.put( "usertoken_str", usertoken_str );
//        Toast.makeText(this, "发送请求到服务器", NULL).show();
//        //   client.get(url_path+"1/roadsidestand/", new JsonHttpResponseHandler() {
//        Log.i( TAG, usertoken_str );
//        OkGo.<String>get(url_path+"/v1/eat/roadsidestand/")
//                .params( "usertoken_str", usertoken_str )
//                .execute( new StringCallback() {
//                    @Override
//                    public void onSuccess(Response<String> response) {
//                        {
//                            DBFormat bean = GsonUtil.GsonToBean( response.body(), DBFormat.class );
//                            String beanarray = bean.getInforesult().toString();
//                            try {
//                                JSONArray beanlist2 = new JSONArray( beanarray );
//                                for (int i = 0; i < beanlist2.length(); i++) {
//                                    JSONObject jsonObject = beanlist2.getJSONObject( i );
//                                    Log.i( TAG, "在里面啦啦啦" + jsonObject.getString( "shop_name" ) + jsonObject.getString( "shop_picture" ) );
//                                    Shop nrbdx = new Shop( jsonObject.getString( "shop_name" ), jsonObject.getString( "shop_picture" ), a, "距离您3.0公里" );
//                                    shopList.add( nrbdx );
//                                }
//                            } catch (Exception e) {
//                                Log.i( TAG, "出错了" );
//                            }
//                            ;
//                        }
//                    }
//                    @Override
//                    public void onError(Response<String> response) {
//                        super.onError( response );
//                        Log.d( TAG, "onError: ------------------ 出错 message:" +
//                                response.message() + "getException" + response.getException() );
//                    }
//                } );
//
//    }
}



