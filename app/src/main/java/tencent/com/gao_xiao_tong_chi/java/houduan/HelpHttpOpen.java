package tencent.com.gao_xiao_tong_chi.java.houduan;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Administrator on 2018/5/4 0004.
 */
public class HelpHttpOpen {
    private JSONreturn jsonReturn=new JSONreturn();
    private static final String TAG ="网络助理" ;
    private AsyncHttpClient client ;
    private RequestParams params ;//新建请求参数
    private Handler handler=new Handler(){
        @Override
        public boolean sendMessageAtTime(Message msg, long uptimeMillis) {
            jsonReturn= (JSONreturn) msg.obj;
            return super.sendMessageAtTime(msg, uptimeMillis);
        }
    };
    public HelpHttpOpen(AsyncHttpClient client ,RequestParams params){
            this.client=client;
            this.params=params;
    }
    /**
     * get请求
     * @url url 请求路径
     */
    public JSONreturn httpGet(String url){
        Log.i(TAG, "httpGet: 为此准备");
        client.get(url, this.params,
                new JsonHttpResponseHandler() {
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        try {
                            Boolean bool = Boolean.valueOf(
                                    response.get("infostatus")
                                            .toString());
                            String str = response.get("infomsg")
                                    .toString();
                            String strs=response.get("inforesult").toString();
                            Log.i(TAG, "在里面啦啦啦"+bool+strs);
                            if (bool){
                                JSONObject jo=new JSONObject(str);
                                JSONArray ja=new JSONArray(strs);
                                jsonReturn.setJsonObject_infomsg(jo);
                                jsonReturn.setJsonArray_infomsg(ja);
                                Message ms=new Message();
                                ms.obj=jsonReturn;
                                handler.sendMessage(ms);
                            }else {
                                Log.i(TAG, "网络异常");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
        if (jsonReturn!=null){
            Log.i(TAG, "返回成功");
            return jsonReturn;
        }else{
            Log.i(TAG, "返回空222222222");
            return null;
        }
    }
    /**
     * post请求
     * @url url 请求路径
     */
    public void httpPost(String url){
        client.post(url, params,
                new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int i, Header[] headers,
                                          JSONObject response) {

                        try {
                            Boolean bool = Boolean.valueOf(
                                    response.get("infostatus")
                                            .toString())
                                    .booleanValue();
                            String str = response.get("infomsg")
                                    .toString();
                            if (bool) {
                                Log.i(TAG, "onSuccess: 当前为添加成功");
                            } else {
                                Log.i(TAG, "onSuccess: 当前为添加失败");
                            }
                        } catch (JSONException e) {
                            Log.i(TAG, "onSuccess: 当前为添加异常");
                            e.printStackTrace();
                        }
                    }
                });
    }
}
