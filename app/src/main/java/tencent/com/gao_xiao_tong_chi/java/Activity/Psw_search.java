package tencent.com.gao_xiao_tong_chi.java.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import tencent.com.gao_xiao_tong_chi.R;

public class Psw_search extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.pasw_search);
        Button find_next = findViewById( R.id.find_next );
        find_next.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Psw_search.this.startActivity( new Intent( Psw_search.this,Psw_search2.class ) );
            }
        } );
    }

}
