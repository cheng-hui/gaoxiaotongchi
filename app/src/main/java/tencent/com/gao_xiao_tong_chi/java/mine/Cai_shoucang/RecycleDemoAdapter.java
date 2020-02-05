package tencent.com.gao_xiao_tong_chi.java.mine.Cai_shoucang;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tencent.com.gao_xiao_tong_chi.R;

public class RecycleDemoAdapter extends RecyclerView.Adapter<RecycleDemoAdapter.MyHolder> {
   // // 获取当前项的Fruit实例
    private Context context;   // 方便视图的操作
    private List<Cai> list;
    public  RecycleDemoAdapter(Context context,List<Cai> list)
    {
        this.context = context;
        this.list = list;
    }
    // 获取 item 的布局
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate( R.layout.recyclerview_cai_item,viewGroup,false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
       // Cai cai = (Cai) getItem(position);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    // 绑定类
    public class MyHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.cai_image);
            textView = itemView.findViewById(R.id.cai_name);
        }
    }

    //   实际绑定 item 操作
    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, final int position) {
        myHolder.imageView.setImageResource(list.get( position).getCai_image());
        myHolder.textView.setText(list.get(position).getCai_name());
    }

}

