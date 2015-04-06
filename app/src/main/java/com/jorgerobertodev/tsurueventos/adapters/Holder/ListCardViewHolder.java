package com.jorgerobertodev.tsurueventos.adapters.Holder;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jorgerobertodev.tsurueventos.R;
import com.squareup.picasso.Picasso;

/**
 * Created by jorge on 04/04/2015.
 */
public class ListCardViewHolder extends RecyclerView.ViewHolder {
    public TextView title;
    public ImageView image;

    public ListCardViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
        image = (ImageView) itemView.findViewById(R.id.image);
    }

    public TextView getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(String imageuri) {
        Picasso.with(itemView.getContext()).load(imageuri).into(this.image);
    }
}
