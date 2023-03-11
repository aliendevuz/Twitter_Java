package com.example.twitterjava.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.twitterjava.R;
import com.example.twitterjava.adapter.FeedAdapter;
import com.example.twitterjava.adapter.StoryAdapter;
import com.example.twitterjava.databinding.ActivityMainBinding;
import com.example.twitterjava.model.Post;
import com.example.twitterjava.model.Story;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    ActivityMainBinding binding;
    RecyclerView storyList;
    RecyclerView feedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    void init() {
        Objects.requireNonNull(getSupportActionBar()).hide();

        storyList = binding.storyList;
        feedList = binding.feedList;

        storyList.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        feedList.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));

        ArrayList<Story> stories = new ArrayList<>();
        ArrayList<Post> feeds = new ArrayList<>();

        storyLoad(stories);
        feedLoad(feeds);

        StoryAdapter storyAdapter = new StoryAdapter(stories);
        FeedAdapter feedAdapter = new FeedAdapter(context, feeds);

        storyList.setAdapter(storyAdapter);
        feedList.setAdapter(feedAdapter);
    }

    void storyLoad(ArrayList<Story> stories) {
        stories.add(new Story(R.drawable.image1, "Ocean"));
        stories.add(new Story(R.drawable.image2, "Ibrohim"));
        stories.add(new Story(R.drawable.image3, "Alien"));
        stories.add(new Story(R.drawable.image1, "Ocean"));
        stories.add(new Story(R.drawable.image2, "Ibrohim"));
        stories.add(new Story(R.drawable.image3, "Alien"));
        stories.add(new Story(R.drawable.image1, "Ocean"));
        stories.add(new Story(R.drawable.image2, "Ibrohim"));
        stories.add(new Story(R.drawable.image3, "Alien"));
    }

    void feedLoad(ArrayList<Post> feeds) {
        feeds.add(new Post(R.drawable.image1, "Alien Ware", new int[] {R.drawable.post1}));
        feeds.add(new Post(R.drawable.image2, "Khalilov Ibrohim", new int[] {R.drawable.post2, R.drawable.image3}));
        feeds.add(new Post(R.drawable.image3, "Alien Dev", "android.resource://" + getPackageName() + "/" + R.raw.video1));
        feeds.add(new Post(R.drawable.image1, "Alien Ware", new int[] {R.drawable.post1, R.drawable.image2}));
        feeds.add(new Post(R.drawable.image2, "Khalilov Ibrohim", new int[] {R.drawable.post2}));
        feeds.add(new Post(R.drawable.image3, "Alien Dev", "android.resource://" + getPackageName() + "/" + R.raw.video2));
    }
}
