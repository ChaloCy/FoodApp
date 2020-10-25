package com.inducesmile.androidfoodordering.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.inducesmile.androidfoodordering.R;
import com.inducesmile.androidfoodordering.entities.HotDealObject;
import com.inducesmile.androidfoodordering.util.Helper;

import java.util.List;

public class CustomViewPagerAdapter extends PagerAdapter {

    private Context context;
    private List<HotDealObject> hotDealList;
    private LayoutInflater layoutInflater;


    public CustomViewPagerAdapter(Context context, List<HotDealObject> hotDealList) {
        this.context = context;
        this.hotDealList = hotDealList;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return hotDealList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View)object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.hot_deal_layout, container, false);
        HotDealObject mHotDealObject = hotDealList.get(position);

        ImageView favoriteIcon = (ImageView)view.findViewById(R.id.hot_deal_favorite);
        TextView hotDealPrice = (TextView)view.findViewById(R.id.hot_deal_price);
        ImageView hotDealFoodImage = (ImageView)view.findViewById(R.id.hot_deal_food_image);
        TextView hotDealFoodName = (TextView)view.findViewById(R.id.hot_deal_food_name);
        TextView hotDealFoodDescription = (TextView)view.findViewById(R.id.hot_deal_food_description);

        //bind value to the View Widgets
        hotDealPrice.setText("Sh" + String.valueOf(mHotDealObject.getItem_price()) + "0");
        hotDealFoodName.setText(mHotDealObject.getItem_name());
        hotDealFoodDescription.setText(mHotDealObject.getDescription());

        String pic = Helper.PUBLIC_FOLDER +
                mHotDealObject.getItem_picture();

        Glide.with(context)
                .load(pic)
                .apply(new RequestOptions().override(900, 900))
                .into(hotDealFoodImage);

        container.addView(view);
        return view;
    }
}
