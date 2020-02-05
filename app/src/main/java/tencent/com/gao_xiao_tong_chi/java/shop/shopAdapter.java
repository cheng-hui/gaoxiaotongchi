package tencent.com.gao_xiao_tong_chi.java.shop;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tencent.com.gao_xiao_tong_chi.R;

public class shopAdapter extends ArrayAdapter {
    private final int resourceId;
    public shopAdapter(Context context, int textViewResourceId, List<Shop> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Shop shop = (Shop) getItem(position); // 获取当前项的Fruit实例
        //View view = LayoutInflater.from(getContext()).inflate(resourceId, null);使用Inflater对象来将布局文件解析成一个View
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象
        //String name, int headId, int starId,String distance)
        ImageView headImage = (ImageView) view.findViewById( R.id.shop_head);//获取该布局内的图片视图
        TextView shop_star= (TextView) view.findViewById( R.id.shop_star);//获取该布局内的图片视图
        TextView shopName = (TextView) view.findViewById(R.id.shop_name);//获取该布局内的文本视图
        TextView shop_distance = (TextView) view.findViewById(R.id.shop_distance);//获取该布局内的文本视图

        headImage.setImageResource(Integer.parseInt(shop.getheadId()));//为图片视图设置图片资源
        shop_star.setText(String.valueOf(  shop.getStarId()));//评分
        shopName.setText(shop.getName());//为文本视图设置文本内容
        shop_distance.setText(shop.getDistance());//为文本视图设置文本内容
        return view;
    }
}
