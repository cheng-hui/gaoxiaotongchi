package tencent.com.gao_xiao_tong_chi.java.zhuye;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import tencent.com.gao_xiao_tong_chi.R;

public class Add_menu extends Activity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.add_menu );
        ImageButton return_shop_manager = findViewById( R.id.return_shop_manager );
        Button addmenu_finish = findViewById( R.id.addmenu_finish );
        return_shop_manager.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        } );
        addmenu_finish.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        } );
    }

}
