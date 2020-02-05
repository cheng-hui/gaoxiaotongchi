package tencent.com.gao_xiao_tong_chi.java.zhuye;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;

import tencent.com.gao_xiao_tong_chi.R;
public class Managershop extends Activity {
    private String modify_shop;
    private String shop_id;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.shop_mamager);
        TextView modify_shop = findViewById( R.id.modify_shop );
        ImageButton add_menu = findViewById( R.id.add_menu );
        ImageButton return_mine1 = findViewById( R.id.return_mine1 );
        modify_shop.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();
                shop_id = intent1.getStringExtra("shop_id");
                Intent intent = new Intent( Managershop.this, Modify_shop.class );
                intent.putExtra("shop_id",shop_id);
                Managershop.this.startActivity( intent );
            }
        } );
        add_menu.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Managershop.this.startActivity( new Intent( Managershop.this,Add_menu.class ) );
            }
        } );
        return_mine1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Managershop.this,MainActivity.class);
                intent.putExtra("fragement", 1);
                startActivity(intent);
            }
        } );
    }
}
