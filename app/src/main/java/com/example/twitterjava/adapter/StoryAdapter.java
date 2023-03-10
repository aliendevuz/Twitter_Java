package com.example.twitterjava.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twitterjava.R;
import com.example.twitterjava.databinding.ItemFeedStoryBinding;
import com.example.twitterjava.model.Story;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class StoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Story> stories;

    public StoryAdapter(ArrayList<Story> stories) {
        this.stories = stories;
    }

    static class StoryViewHolder extends RecyclerView.ViewHolder {

        ItemFeedStoryBinding binding;

        ShapeableImageView storyProfile;
        TextView storyName;
        StoryViewHolder(View view) {
            super(view);
            binding = ItemFeedStoryBinding.bind(view);
            storyProfile = binding.storyProfile;
            storyName = binding.storyName;
        }

    }
    void init(StoryViewHolder holder, Story story) {
        holder.storyProfile.setImageResource(story.profile);
        holder.storyName.setText(story.name);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed_story, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof StoryViewHolder) init((StoryViewHolder) holder, stories.get(position));
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }
}
