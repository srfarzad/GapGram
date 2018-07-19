package com.gapgram.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gapgram.R;
import com.gapgram.model.GetUserAllPost;
import com.gapgram.serviceCaller.ApiClient;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.MainViewHolder> {

    private Context Context;
    private List<GetUserAllPost> mList = new ArrayList<>();


    public PostsAdapter(Context context) {
        this.Context = context;
    }

    public void setPosts(List<GetUserAllPost> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(Context).inflate(R.layout.cmlist_post,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.bindAppCategory(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class MainViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout ln_backgroundItemsMain;
        private TextView textViewHead;
        ImageView imagePost;

        public MainViewHolder(View itemView) {
            super(itemView);
            imagePost = itemView.findViewById(R.id.imagePost);
            textViewHead = itemView.findViewById(R.id.textViewHead);
        }

        public void bindAppCategory(GetUserAllPost post) {
            textViewHead.setText(post.getUserFirstName());

            Picasso.with(Context).load(ApiClient.ImagePath + post.getPostSource())
                    .error(R.drawable.digikalacom)
                    .into(imagePost);
        }
    }


}
