package tencent.com.gao_xiao_tong_chi.java.houduan;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by 立立西 on 2018/5/12.
 */

/**
 * HelpHttp助手返回值处理
 */
public class JSONreturn {
    private JSONObject jsonObject_infomsg,jsonObject_inforesult;
    private JSONArray jsonArray_infomsg,jsonArray_inforesult;

    public JSONreturn(){

    }
    /**
     * JSONObject对象处理
     * @param jsonObject_infomsg
     * @param jsonObject_inforesult
     */
    public JSONreturn(JSONObject jsonObject_infomsg,JSONObject jsonObject_inforesult){
           this.jsonObject_infomsg=jsonObject_infomsg;
           this.jsonObject_inforesult=jsonObject_inforesult;
    }

    /**
     * JSONArray对象处理
     * @param jsonArray_infomsg
     * @param jsonArray_inforesult
     */
    public JSONreturn(JSONArray jsonArray_infomsg,JSONArray jsonArray_inforesult){
           this.jsonArray_infomsg=jsonArray_infomsg;
           this.jsonArray_inforesult=jsonArray_inforesult;
    }

    /**
     * 一样一个
     * @param jsonObject_infomsg
     * @param jsonArray_inforesult
     */
    public JSONreturn(JSONObject jsonObject_infomsg,JSONArray jsonArray_inforesult){
            this.jsonObject_infomsg=jsonObject_infomsg;
            this.jsonArray_inforesult=jsonArray_inforesult;
    }
    public JSONObject getJsonObject_infomsg() {
        return jsonObject_infomsg;
    }

    public void setJsonObject_infomsg(JSONObject jsonObject_infomsg) {
        this.jsonObject_infomsg = jsonObject_infomsg;
    }

    public JSONArray getJsonArray_infomsg() {
        return jsonArray_infomsg;
    }

    public void setJsonArray_infomsg(JSONArray jsonArray_infomsg) {
        this.jsonArray_infomsg = jsonArray_infomsg;
    }
}
