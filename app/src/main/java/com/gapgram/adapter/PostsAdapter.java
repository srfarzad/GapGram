package com.gapgram.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gapgram.BR;
import com.gapgram.R;
import com.gapgram.model.GetUserAllPost;
import com.gapgram.model.Posts;
import com.gapgram.serviceCaller.ApiClient;
import com.squareup.picasso.Picasso;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    List<GetUserAllPost> postsList;
    Context context;

    public PostsAdapter(Context context, List<GetUserAllPost> posts) {
        this.postsList = posts;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

      GetUserAllPost posts = postsList.get(position);

      holder.bind(posts);

 /*
        holder.textViewHead.setText(posts.getUserFirstName() + " " + posts.getUserLastName());
        String imgPath = ApiClient.ImagePath + posts.getPostSource();
        try {
            if (!posts.getPostSource().matches("")) {
                Picasso.with(context)
                        .load(imgPath).centerCrop().resize(230, 230).centerCrop()
                        .into(holder.imagePost);
            } else {
                holder.imagePost.setImageResource(R.drawable.background_button);
            }
        } catch (Exception e) {
        }*/
//        Picasso.with(context).load(ApiClient.ImagePath+posts.getPostSource()).into( holder.imagePost);
        //    Picasso.with(context).load(posts.get).into( holder.imageViewIcon);

    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

     /*   @BindView(R.id.imageViewIcon)
        AppCompatImageView imageViewIcon;
        @BindView(R.id.imagePost)
        AppCompatImageView imagePost;
        @BindView(R.id.like)
        AppCompatImageButton like;
        @BindView(R.id.comment)
        AppCompatImageButton comment;
        @BindView(R.id.message)
        AppCompatImageButton message;
        @BindView(R.id.savetocollection)
        AppCompatImageButton savetocollection;
        @BindView(R.id.textViewHead)
        AppCompatTextView textViewHead;
*/

        ViewDataBinding binding;

        public ViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
            //ButterKnife.bind(this, itemView);
        }

        public void bind(Object GetUserAllPost) {
            binding.setVariable(BR.getUserAllPost,GetUserAllPost);
            binding.executePendingBindings();
        }
    }

}
