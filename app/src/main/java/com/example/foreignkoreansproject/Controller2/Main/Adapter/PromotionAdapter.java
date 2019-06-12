package com.example.foreignkoreansproject.Controller2.Main.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foreignkoreansproject.Model.Promotion;
import com.example.foreignkoreansproject.Model.PromotionResult;
import com.example.foreignkoreansproject.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PromotionAdapter extends RecyclerView.Adapter<PromotionAdapter.PromotionViewHolder> {
    public List<PromotionResult> data;
    Context context;

    public void setData(List<PromotionResult> data) {
        this.data = data;
    }

    public void setContext(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public PromotionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.promotion_item_layout,viewGroup,false);
        return new PromotionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PromotionViewHolder promotionViewHolder, int i) {
        PromotionResult promotion = data.get(i);
        Picasso.get().load(promotion.getUrlImage()).into(promotionViewHolder.imgPromotion);
        promotionViewHolder.tvPlaceName.setText(promotion.getPlaceDetail().getPlaceName());
        promotionViewHolder.tvPromotionName.setText(promotion.getPromotionName());
    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }
    public class PromotionViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPromotion;
        TextView tvPlaceName;
        TextView tvPromotionName;

        public PromotionViewHolder (@NonNull View itemView){
            super(itemView);
            imgPromotion = itemView.findViewById(R.id.img_url_promotion);
            tvPlaceName = itemView.findViewById(R.id.tv_place_name);
            tvPromotionName = itemView.findViewById(R.id.tv_promotion_name);
        }
    }
}
