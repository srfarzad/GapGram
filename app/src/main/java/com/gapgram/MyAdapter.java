 package com.gapgram;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private List<ListItem> listitems;
    private Context context;


    public MyAdapter(List<ListItem> listitems, Context context) {
        this.listitems = listitems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        ListItem listItems= listitems.get(position);
        holder.textViewHead.setText(listItems.getHead());
        holder.imageViewIcon.setImageResource(listItems.getImageIconID());
        holder.imageViewPost.setImageResource(listItems.getImagePostID());
        holder.textViewDescPost.setText(listItems.getDescPost());
        holder.textViewAllcomments.setText(listItems.getViewAllComments());


        holder.buttonViewOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                PopupMenu popup= new PopupMenu(context, holder.buttonViewOption);
                popup.inflate(R.menu.options_menu);
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId())
                        {
                            case R.id.menu1:
                                break;
                            case R.id.menu2:
                                break;
                            case R.id.menu3:
                                break;
                            case R.id.menu4:
                                break;

                        }
                        return false;
                    }
                });

                popup.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return listitems.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{


        public TextView textViewHead;
        public TextView buttonViewOption;
        public   ImageView imageViewIcon;
        public ImageView imageViewPost;
        public  TextView textViewDescPost;
        public  TextView textViewAllcomments;



        public ViewHolder(View itemView) {
            super(itemView);
            textViewHead =(TextView) itemView.findViewById(R.id.textViewHead);
            textViewDescPost =(TextView) itemView.findViewById(R.id.desPost);
            buttonViewOption= (TextView) itemView.findViewById(R.id.textViewOptions);
            imageViewPost= (ImageView) itemView.findViewById(R.id.imagePost);
            imageViewIcon= (ImageView) itemView.findViewById(R.id.imageViewIcon);
            textViewAllcomments= (TextView) itemView.findViewById(R.id.ViewAllComments);

        }
    }
}
