package tencent.com.gao_xiao_tong_chi.java.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import tencent.com.gao_xiao_tong_chi.R;

public class home_yingxiang extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstatceState)
    {
        View view = inflater.inflate(R.layout.home_yinxiang,null);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );
        ImageView add=  getActivity().findViewById(R.id.add);
        add.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getActivity().getBaseContext(), yinxiang_pinglun.class);
                startActivity(intent);
            }
        } );  }
    }
