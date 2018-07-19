//package com.gapgram.adapter;
//
//import android.content.Context;
//import android.databinding.DataBindingUtil;
//import android.databinding.ViewDataBinding;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.ViewGroup;
//import com.gapgram.R;
//import com.gapgram.model.GetUserAllPost;
//import java.util.List;
//
//public class MainPostsAdapter extends RecyclerView.Adapter<MainPostsAdapter.ViewHolder> {
//
//    private List<GetUserAllPost> postsList;
//    private Context context;
//
//    class ViewHolder extends RecyclerView.ViewHolder {
//        private ViewDataBinding binding;
//        public ViewHolder(ViewDataBinding binding) {
//            super(binding.getRoot());
//            this.binding = binding;
//        }
//
//        public void bind(Object GetUserAllPost) {
////            binding.setVariable(BR.getUserAllPost, GetUserAllPost);
//            binding.executePendingBindings();
//        }
//    }
//
//    public MainPostsAdapter(Context context, List<GetUserAllPost> posts) {
//        this.postsList = posts;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false);
//        return new ViewHolder(binding);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        GetUserAllPost posts = postsList.get(position);
//        holder.bind(posts);
////        holder.binding.setPost(posts);
//    }
//
//    @Override
//    public int getItemCount() {
//        return postsList.size();
//    }
//
//
//}
