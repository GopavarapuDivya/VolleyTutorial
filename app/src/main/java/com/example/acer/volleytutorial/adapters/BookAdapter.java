package com.example.acer.volleytutorial.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.acer.volleytutorial.DetailsActivity;
import com.example.acer.volleytutorial.R;
import com.example.acer.volleytutorial.volley.BookModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>
{
    Context context;
    ArrayList<BookModel> bookModels;

    public BookAdapter(Context context, ArrayList<BookModel> bookModels) {
        this.context = context;
        this.bookModels = bookModels;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View v=LayoutInflater.from(context).inflate(R.layout.item,viewGroup,false);
        BookViewHolder bookViewHolder=new BookViewHolder(v);
        return bookViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder bookViewHolder, int i)
    {
        Picasso.with(context).load(bookModels.get(i).getImg()).placeholder(R.mipmap.ic_launcher).into(bookViewHolder.imgview);

    }

    @Override
    public int getItemCount()
    {
        return bookModels.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imgview;
        public BookViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imgview=itemView.findViewById(R.id.imgview);
            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    int position=getAdapterPosition();
                    if (position!=RecyclerView.NO_POSITION)
                    {
                        Intent intent=new Intent(context,DetailsActivity.class);
                        intent.putExtra("title",bookModels.get(position).getTitle());
                        intent.putExtra("author",bookModels.get(position).getAuthor());
                        intent.putExtra("image",bookModels.get(position).getImg());
                        intent.putExtra("description",bookModels.get(position).getDesc());

                        context.startActivity(intent);
                    }
                }
            });
        }
    }
}
