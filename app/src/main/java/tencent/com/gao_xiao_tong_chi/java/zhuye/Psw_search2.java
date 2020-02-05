package tencent.com.gao_xiao_tong_chi.java.zhuye;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import tencent.com.gao_xiao_tong_chi.R;
import tencent.com.gao_xiao_tong_chi.java.mine.Login;

public class Psw_search2 extends Activity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.pasw_search2 );
            Button find_finish = findViewById( R.id.find_finish );
            find_finish.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Psw_search2.this.startActivity( new Intent( Psw_search2.this, Login.class ) );
                }
            } );
        }

        }
