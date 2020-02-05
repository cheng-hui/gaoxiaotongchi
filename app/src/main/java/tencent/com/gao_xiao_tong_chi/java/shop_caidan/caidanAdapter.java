package tencent.com.gao_xiao_tong_chi.java.shop_caidan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tencent.com.gao_xiao_tong_chi.R;
import tencent.com.gao_xiao_tong_chi.java.Entity.caidan;

public class caidanAdapter extends ArrayAdapter {
    private final int resourceId;
    public caidanAdapter(Context context, int textViewResourceId, List<caidan> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        caidan cai_dan = (caidan) getItem(position); // 获取当前项的Fruit实例
        //View view = LayoutInflater.from(getContext()).inflate(resourceId, null);使用Inflater对象来将布局文件解析成一个View
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象
        //String menu_id,String menu_name, int menu_picture, String menu_price
        ImageView cai_tu = (ImageView) view.findViewById( R.id.cai_tu);//获取该布局内的图片视图
        TextView caidan_name= (TextView) view.findViewById( R.id.caidan_name);//获取该布局内的图片视图
        TextView money = (TextView) view.findViewById(R.id.money);//获取该布局内的文本视图
        cai_tu.setImageResource(cai_dan.getMenu_picture());//为图片视图设置图片资源
        caidan_name.setText(cai_dan.getMenu_name());//为图片视图设置图片资源getStarId
        money.setText(cai_dan.getMenu_price());//为文本视图设置文本内容
        return view;
    }
}

