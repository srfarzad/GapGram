package com.gapgram.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gapgram.R;
import com.gapgram.model.Posts;
import com.gapgram.serviceCaller.ApiClient;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    List<Posts> postsList;
    Context context;
    public PostsAdapter(Context context, List<Posts> posts){
        this.postsList=posts;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Posts posts=postsList.get(position);

        holder.textViewHead.setText(posts.getTitle());
        Picasso.with(context).load(ApiClient.ImagePath+posts.getPostSource()).into( holder.imagePost);
    //    Picasso.with(context).load(posts.get).into( holder.imageViewIcon);

    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.imageViewIcon)AppCompatImageView imageViewIcon;
        @BindView(R.id.imagePost)AppCompatImageView imagePost;
        @BindView(R.id.like)AppCompatImageButton like;
        @BindView(R.id.comment)AppCompatImageButton comment;
        @BindView(R.id.message)AppCompatImageButton message;
        @BindView(R.id.savetocollection)AppCompatImageButton savetocollection;
        @BindView(R.id.textViewHead)AppCompatTextView textViewHead;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
