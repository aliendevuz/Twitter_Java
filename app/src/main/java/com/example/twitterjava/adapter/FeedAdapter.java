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
import com.example.twitterjava.databinding.ItemFeedPostDoubleBinding;
import com.example.twitterjava.databinding.ItemFeedPostSingleBinding;
import com.example.twitterjava.model.ObjectType;
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

    static class SingleFeedViewHolder extends RecyclerView.ViewHolder {

        ItemFeedPostSingleBinding binding;
        ShapeableImageView feedProfile;
        TextView feedName;
        ImageView feedImage;

        public SingleFeedViewHolder(View view) {
            super(view);
            binding = ItemFeedPostSingleBinding.bind(view);
            feedProfile = binding.postProfile;
            feedName = binding.postName;
            feedImage = binding.postImage;
        }
    }

    static class DoubleFeedViewHolder extends RecyclerView.ViewHolder {

        ItemFeedPostDoubleBinding binding;
        ShapeableImageView feedProfile;
        TextView feedName;
        ImageView feedImage1;
        ImageView feedImage2;

        public DoubleFeedViewHolder(View view) {
            super(view);
            binding = ItemFeedPostDoubleBinding.bind(view);
            feedProfile = binding.postProfile;
            feedName = binding.postName;
            feedImage1 = binding.postImage1;
            feedImage2 = binding.postImage2;
        }
    }

    void singleInit(SingleFeedViewHolder holder, Post post) {
        holder.feedProfile.setImageResource(post.profile);
        holder.feedName.setText(post.name);
        holder.feedImage.setImageResource(post.photos[0]);
    }

    void doubleInit(DoubleFeedViewHolder holder, Post post) {
        holder.feedProfile.setImageResource(post.profile);
        holder.feedName.setText(post.name);
        holder.feedImage1.setImageResource(post.photos[0]);
        holder.feedImage2.setImageResource(post.photos[1]);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ObjectType.singleImage)
            return new SingleFeedViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed_post_single, parent, false));
        else
            return new DoubleFeedViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed_post_double, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof SingleFeedViewHolder) singleInit((SingleFeedViewHolder) holder, feeds.get(position));
        if (holder instanceof DoubleFeedViewHolder) doubleInit((DoubleFeedViewHolder) holder, feeds.get(position));
    }

    @Override
    public int getItemCount() {
        return feeds.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (feeds.get(position).photos.length > 1)
            return ObjectType.doubleImage;
        return ObjectType.singleImage;
    }
}
