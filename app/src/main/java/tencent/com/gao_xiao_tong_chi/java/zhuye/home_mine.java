package tencent.com.gao_xiao_tong_chi.java.zhuye;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import tencent.com.gao_xiao_tong_chi.R;
import tencent.com.gao_xiao_tong_chi.java.mine.My_impression;
import tencent.com.gao_xiao_tong_chi.java.mine.Cai_shoucang.mine_menu;
import tencent.com.gao_xiao_tong_chi.java.mine.Shezhi;
import tencent.com.gao_xiao_tong_chi.java.mine.impression_shoucang.mine_impression;

public class home_mine extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstatceState) {
        View view = inflater.inflate( R.layout.home_mine, null );
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageButton Manager_shop = getActivity().findViewById( R.id.Manager_shop );
        ImageButton shezhibutton = getActivity().findViewById( R.id.shezhibutton );
        ImageButton my_impression = getActivity().findViewById( R.id.my_impression );

        TextView mine_menu=getActivity().findViewById( R.id.mine_menu );
        TextView mine_impression=getActivity().findViewById( R.id.mine_impression );
        Manager_shop.setOnClickListener( this );
        shezhibutton.setOnClickListener( this );
        mine_menu.setOnClickListener( this );
        mine_impression.setOnClickListener( this );
        my_impression.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
          case R.id.Manager_shop:
              home_mine.this.startActivity( new Intent( getActivity().getBaseContext(), Managershopnull.class) );
              break;
            case R.id.shezhibutton:
                home_mine.this.startActivity( new Intent( getActivity().getBaseContext(), Shezhi.class) );
                break;
            case R.id.mine_menu:
                home_mine.this.startActivity( new Intent( getActivity().getBaseContext(), mine_menu.class) );
                break;
            case R.id.mine_impression:
                home_mine.this.startActivity( new Intent( getActivity().getBaseContext(), mine_impression.class) );
                break;
            case R.id.my_impression:
                home_mine.this.startActivity( new Intent( getActivity().getBaseContext(), My_impression.class) );
                break;
        }
    }
}
