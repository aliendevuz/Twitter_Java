package com.example.twitterjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twitterjava.R;
import com.example.twitterjava.databinding.ItemFeedPostBinding;
import com.example.twitterjava.model.Post;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<Post> feeds;

    public FeedAdapter(Context context, ArrayList<Post> feeds) {
        this.context = context;
        this.feeds = feeds;
    }

    static class FeedViewHolder extends RecyclerView.ViewHolder {

        ItemFeedPostBinding binding;
        ShapeableImageView feedProfile;
        TextView feedName;
        ImageView feedImage;

        public FeedViewHolder(View view) {
            super(view);
            binding = ItemFeedPostBinding.bind(view);
            feedProfile = binding.postProfile;
            feedName = binding.postName;
            feedImage = binding.postImage;
        }
    }

    void postInit(FeedViewHolder holder, Post post) {
        holder.feedProfile.setImageResource(post.profile);
        holder.feedName.setText(post.name);
        holder.feedImage.setImageResource(post.photo);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FeedViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed_post, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FeedViewHolder) postInit((FeedViewHolder) holder, feeds.get(position));
    }

    @Override
    public int getItemCount() {
        return feeds.size();
    }
}
