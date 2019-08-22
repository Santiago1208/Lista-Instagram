package com.mocte.listainstagram;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.zip.Inflater;

public class PostAdapter extends BaseAdapter {

    // The posts
    private ArrayList<Post> posts;

    public PostAdapter() {
        posts = new ArrayList<>();
        configurePosts();
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        Post post = posts.get(position);
        long postId = post.getId();
        return postId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_item, null);

        ImageView photoImage = view.findViewById(R.id.row_photo_image);
        TextView dateText = view.findViewById(R.id.row_date_text);
        TextView descriptionText = view.findViewById(R.id.row_description_text);
        Button likeButton = view.findViewById(R.id.row_like_button);
        TextView viewsText = view.findViewById(R.id.row_views_text);
        Button removeButton = view.findViewById(R.id.row_remove_btn);

        final Post post = (Post) getItem(position);

        likeButton.setOnClickListener(
                (View v) -> {
                    likePost(post);
                }
        );

        removeButton.setOnClickListener(
                (View v) -> {
                    removePost(post);
                }
        );

        photoImage.setImageResource(post.getPhoto());
        dateText.setText(post.getPublishDate());
        descriptionText.setText(post.getDescription());
        viewsText.setText(post.getViews() + "");
        if(post.isLiked()) {
            likeButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#0000FF")));
        }

        return view;
    }

    private void removePost(Post post) {
        posts.remove(post);
        notifyDataSetChanged();
    }


    private void likePost(Post post) {
        post.setLiked(!post.isLiked());
        notifyDataSetChanged();
    }

    private void configurePosts() {
        Random random = new Random(123456789L);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        posts.add(new Post(random.nextLong() * 100000 + 123456789, R.drawable.photo1, formatter.format(new Date(System.currentTimeMillis())), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In sit amet tortor sit amet sem tempor eleifend et maximus justo.", random.nextInt(1000), random.nextBoolean()));
        posts.add(new Post(random.nextLong() * 100000 + 123456789, R.drawable.photo2, formatter.format(new Date(System.currentTimeMillis())), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In sit amet tortor sit amet sem tempor eleifend et maximus justo.", random.nextInt(1000), random.nextBoolean()));
        posts.add(new Post(random.nextLong() * 100000 + 123456789, R.drawable.photo3, formatter.format(new Date(System.currentTimeMillis())), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In sit amet tortor sit amet sem tempor eleifend et maximus justo.", random.nextInt(1000), random.nextBoolean()));
        posts.add(new Post(random.nextLong() * 100000 + 123456789, R.drawable.photo4, formatter.format(new Date(System.currentTimeMillis())), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In sit amet tortor sit amet sem tempor eleifend et maximus justo.", random.nextInt(1000), random.nextBoolean()));
        posts.add(new Post(random.nextLong() * 100000 + 123456789, R.drawable.photo5, formatter.format(new Date(System.currentTimeMillis())), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In sit amet tortor sit amet sem tempor eleifend et maximus justo.", random.nextInt(1000), random.nextBoolean()));
        posts.add(new Post(random.nextLong() * 100000 + 123456789, R.drawable.photo1, formatter.format(new Date(System.currentTimeMillis())), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In sit amet tortor sit amet sem tempor eleifend et maximus justo.", random.nextInt(1000), random.nextBoolean()));
        posts.add(new Post(random.nextLong() * 100000 + 123456789, R.drawable.photo2, formatter.format(new Date(System.currentTimeMillis())), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In sit amet tortor sit amet sem tempor eleifend et maximus justo.", random.nextInt(1000), random.nextBoolean()));
        posts.add(new Post(random.nextLong() * 100000 + 123456789, R.drawable.photo3, formatter.format(new Date(System.currentTimeMillis())), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In sit amet tortor sit amet sem tempor eleifend et maximus justo.", random.nextInt(1000), random.nextBoolean()));
        posts.add(new Post(random.nextLong() * 100000 + 123456789, R.drawable.photo4, formatter.format(new Date(System.currentTimeMillis())), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In sit amet tortor sit amet sem tempor eleifend et maximus justo.", random.nextInt(1000), random.nextBoolean()));


    }



}
