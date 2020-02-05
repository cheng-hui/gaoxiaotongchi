package tencent.com.gao_xiao_tong_chi.java.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import tencent.com.gao_xiao_tong_chi.R;
import tencent.com.gao_xiao_tong_chi.java.mine.regisiter_shop;

public class Managershopnull extends Activity {
    private TextView shop_register1;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.managershopnull );
        shop_register1=(TextView)findViewById( R.id.shop_register );
        shop_register1.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent( Managershopnull.this, regisiter_shop.class );
                Managershopnull.this.startActivity( intent );
            } });
        ImageButton return_mine = findViewById( R.id.return_mine );
        return_mine.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            } });
    }
}
