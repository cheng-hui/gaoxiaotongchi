package tencent.com.gao_xiao_tong_chi.java.mine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;
import cz.msebera.android.httpclient.Header;
//import cz.msebera.android.httpclient.entity.mime.Header;
import tencent.com.gao_xiao_tong_chi.R;
import tencent.com.gao_xiao_tong_chi.java.houduan.HttpUrlData;

public class Register_two extends Activity {
    boolean flag1=false,flag2=false,flag3=false,flag4=false,flag5=false,flag6=false,flag7=false,flag8=false
            ,flag9=false,flag10=false,flag11=false,flag12=false;
    int i=0;
    String  [] label = new String[12];
    String  [] labeltrue = new String[3];
    private  String user_name;
    private String user_zhanghao;
    private String user_password;
    private String user_question;
    private String user_answer_true;
    private String url_path= HttpUrlData.getUrl();
    public static final String TAG ="提交审核" ;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.informationcomplete);
         final Button label_xila =(Button) findViewById(R.id.label_xila);
        final Button label_xitian =(Button) findViewById(R.id.label_xitian);
        final Button label_xisuan =(Button) findViewById(R.id.label_xisuan);
        final Button label_zhongkouwei =(Button) findViewById(R.id.label_zhongkouwei);
        final Button label_qingdan =(Button) findViewById(R.id.label_qingdan);
        final Button label_shizhong =(Button) findViewById(R.id.label_shizhong);
        final Button label_buyaocong =(Button) findViewById(R.id.label_buyaocong);
        final Button label_buyaojiang =(Button) findViewById(R.id.label_buyaojiang);
        final Button label_buyaosuan =(Button) findViewById(R.id.label_buyaosuan);
        final Button label_buyaocuo =(Button) findViewById(R.id.label_buyaocuo);
        final Button label_buyaola =(Button) findViewById(R.id.label_buyaola);
        final Button label_bujikou =(Button) findViewById(R.id.label_bujikou);
        final EditText user_answer=(EditText)findViewById( R.id.user_answer );
        Button register_finish =(Button) findViewById(R.id.register_finish);
        //喜辣
        label_xila.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag1 = !flag1;
                if (flag1) {
                    int c = 0xffffca1a;
                    label_xila.setBackgroundColor(c);
                    label[0]=label_xila.getText().toString();
                }
                else{ int c = 0xffffffff;
                    label_xila.setBackgroundColor(c);
                    label[0]=null;}
            }
        } );
        //喜甜
        label_xitian.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag2 = !flag2;
                if (flag2) {
                    int c = 0xffffca1a;
                    label_xitian.setBackgroundColor(c);
                    label[1]=label_xitian.getText().toString();
                }
                else{ int c = 0xffffffff;
                    label_xitian.setBackgroundColor(c);
                    label[1]=null;}
            }
        } );
        //喜酸
        label_xisuan.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag3 = !flag3;
                if (flag3) {
                    int c = 0xffffca1a;
                    label_xisuan.setBackgroundColor(c);
                    label[2]=label_xisuan.getText().toString();
                }
                else{ int c = 0xffffffff;
                    label_xisuan.setBackgroundColor(c);
                    label[2]=null;}
            }
        } );
//重口味
        label_zhongkouwei.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag4 = !flag4;
                if (flag4) {
                    int c = 0xffffca1a;
                    label_zhongkouwei.setBackgroundColor(c);
                    label[3]=label_zhongkouwei.getText().toString();
                }
                else{ int c = 0xffffffff;
                    label_zhongkouwei.setBackgroundColor(c);
                    label[3]=null;}
            }
        } );
        // 5 清淡
        label_qingdan.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag5 = !flag5;
                if (flag5) {
                    int c = 0xffffca1a;
                    label_qingdan.setBackgroundColor(c);
                    label[3]=label_qingdan.getText().toString();
                }
                else{ int c = 0xffffffff;
                    label_qingdan.setBackgroundColor(c);
                    label[4]=null;}
            }
        } );
        // 6  适中
        label_shizhong.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag6 = !flag6;
                if (flag6) {
                    int c = 0xffffca1a;
                    label_shizhong.setBackgroundColor(c);
                    label[5]=label_shizhong.getText().toString();
                }
                else{ int c = 0xffffffff;
                    label_shizhong.setBackgroundColor(c);
                    label[5]=null;}
            }
        } );
        // 7  不要葱
        label_buyaocong.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag7 = !flag7;
                if (flag7) {
                    int c = 0xffffca1a;
                    label_buyaocong.setBackgroundColor(c);
                    label[6]=label_buyaocong.getText().toString();
                }
                else{ int c = 0xffffffff;
                    label_buyaocong.setBackgroundColor(c);
                    label[6]=null;}
            }
        } );
        // 8 不要姜
        label_buyaojiang.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag8 = !flag8;
                if (flag8) {
                    int c = 0xffffca1a;
                    label_buyaojiang.setBackgroundColor(c);
                    label[7]=label_buyaojiang.getText().toString();
                }
                else{ int c = 0xffffffff;
                    label_buyaojiang.setBackgroundColor(c);
                    label[7]=null;}
            }
        } );
        // 9 不要蒜
        label_buyaosuan.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag9 = !flag9;
                if (flag9) {
                    int c = 0xffffca1a;
                    label_buyaosuan.setBackgroundColor(c);
                    label[8]=label_buyaosuan.getText().toString();
                }
                else{ int c = 0xffffffff;
                    label_buyaosuan.setBackgroundColor(c);
                    label[8]=null;}
            }
        } );
        // 10  不要醋
        label_buyaocuo.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag10 = !flag10;
                if (flag10) {
                    int c = 0xffffca1a;
                    label_buyaocuo.setBackgroundColor(c);
                    label[9]=label_buyaocuo.getText().toString();
                }
                else{ int c = 0xffffffff;
                    label_buyaocuo.setBackgroundColor(c);
                    label[9]=null;}
            }
        } );
        // 11 不要辣
        label_buyaola.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag11 = !flag11;
                if (flag11) {
                    int c = 0xffffca1a;
                    label_buyaola.setBackgroundColor(c);
                    label[10]=label_buyaola.getText().toString();
                }
                else{ int c = 0xffffffff;
                    label_buyaola.setBackgroundColor(c);
                    label[10]=null;}
            }
        } );
        // 12 不忌口
        label_bujikou.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag12 = !flag12;
                if (flag12) {
                    int c = 0xffffca1a;
                    label_bujikou.setBackgroundColor(c);
                    label[11]=label_bujikou.getText().toString();
                }
                else{ int c = 0xffffffff;
                    label_bujikou.setBackgroundColor(c);
                    label[11]=null;}
            }
        } );
        Intent intent = getIntent();
        user_name = intent.getStringExtra("user_name");
        user_zhanghao = intent.getStringExtra("user_zhanghao");
        user_password = intent.getStringExtra( "user_password" );
        //密保问题
        Spinner spinner_user_question = (Spinner) findViewById( R.id.user_question );
        //建立数据源
        String[] mItems = getResources().getStringArray( R.array.SecurityQuestion );
        //建立Adapter并且绑定数据源
        ArrayAdapter<String> adapter = new ArrayAdapter<String>( Register_two.this, android.R.layout.simple_spinner_item, mItems );
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
//绑定 Adapter到控件c
        spinner_user_question.setAdapter( adapter );
        // 为下拉列表绑定事件监听器
        spinner_user_question.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                                  user_question = parent.getItemAtPosition(position).toString();
                                // if(user_question.equals( "" )){  Toast.makeText( informationcomplete.this, "密保问题不能为空", Toast.LENGTH_SHORT ).show();}
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //密保答案
        user_answer.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user_answer.getText().toString().equals( "" )) {
                    Toast.makeText( Register_two.this, "密保答案不能为空", Toast.LENGTH_SHORT ).show();
                }
                else{
                    user_answer_true=user_answer.getText().toString();
                }
            }
        } );
        //完成注册
        register_finish.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // getLable();
                getData();
                Toast.makeText(Register_two.this,"注册",Toast.LENGTH_SHORT).show();

            }
        });

    }
//    void  getLable() {
//        //得到标签
//        //得到标签
//        for (int j = 0; j < 12; j++) {
//            if (label[j] != null) {
//                labeltrue[i] = label[j];
//                i++;
//            }
//        }
//    }
//        //检查标签是否为空
//        for(int i=0;i<3;i++){
//            if(labeltrue[i]==null)labeltrue[i]="为空";
//        }

    //把注册的信息传到后端和本地数据库

    void  getData(){

        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();//新建请求参数
        params.put("user_nickname",user_name);
        params.put("user_name",user_zhanghao);
        params.put("user_password",user_password);
        params.put("user_question",user_question);
        params.put("user_answer",user_answer_true);
        params.put("user_head"," XX.jpg");
        params.put("user_label1","aa");
        params.put("user_label2","aaa");
        params.put("user_label3","aaa");
        Log.i(TAG, "123333333"+labeltrue[0]+labeltrue[1]+labeltrue[2]);
        Log.i(TAG, "!1222222"+user_question+user_answer_true);
        Log.i(TAG, url_path+"/v1/user/signup/"+user_question+user_answer_true);
        Log.i(TAG, "123333333"+params);
        client.post(url_path+"/v1/user/signup/", params,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response)  {
                try {
                    Boolean bool = Boolean.valueOf( response.get("infostatus").toString());
                    String str = response.get("infomsg").toString();
                    Log.i(TAG, "在里面啦啦啦"+params);
                    Log.i(TAG, "在里面啦啦啦"+bool+str);
                    if (bool){
                        Toast.makeText(Register_two.this,str,Toast.LENGTH_SHORT).show();
                        Register_two.this.startActivity( new Intent( Register_two.this, Login.class ) );

                    }
                    else {
                        Toast.makeText(Register_two.this,str,Toast.LENGTH_SHORT).show();
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

