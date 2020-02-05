package tencent.com.gao_xiao_tong_chi.java.mine;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import tencent.com.gao_xiao_tong_chi.R;

public class About_app extends Activity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.about_app );
        ImageButton return_mine3 = findViewById( R.id.return_mine3 );
        return_mine3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        } );
    }
}
