package com.djes.altice.restproject;

import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyRecycleItemViewHolder> {

    private final List<Fruit> items;
    private final Context context;


    @Override
    public int getItemViewType(int position) {
        return R.layout.card_view;
    }

    @Override
    public void onBindViewHolder(MyRecycleItemViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

        public MyRecyclerAdapter(Context context, List<Fruit> fruits)
        {
            this.context=context;
            this.items = fruits;
        }


        @Override
        public MyRecycleItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View view = LayoutInflater.from(context).inflate(viewType,parent,false);
            MyRecycleItemViewHolder holder = new MyRecycleItemViewHolder(view,items,context);
            return holder;
        }

    public static class MyRecycleItemViewHolder extends RecyclerView.ViewHolder
    {

        private TextView txtName;
        private TextView txtDescription;
        private ImageView fruitImage;
        private Context _context;
        public MyRecycleItemViewHolder(View itemView, List<Fruit> items,Context context)
        {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtDescription = (TextView) itemView.findViewById(R.id.txtDescription);
            fruitImage = (ImageView) itemView.findViewById(R.id.fruitImage);
            _context=context;
        }

        public void bind(Fruit item) {
            txtName.setText(item.getName());
            txtDescription.setText(item.getDescription());
            Glide.with(_context).load(item.Image)
                    .into(fruitImage);
        }
    }

}
