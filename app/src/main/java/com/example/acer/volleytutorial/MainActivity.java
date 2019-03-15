package com.example.acer.volleytutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.acer.volleytutorial.adapters.BookAdapter;
import com.example.acer.volleytutorial.volley.BookModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    RequestQueue requestQueue;
    String url="https://www.googleapis.com/books/v1/volumes?q=java";
    String book_title,book_author,book_desc,book_img;
    ArrayList<BookModel> bookarraylist;
    RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.recycler);
        requestQueue=Volley.newRequestQueue(this);
        bookarraylist=new ArrayList<>();


        fetchdata();

    }
    public void fetchdata()
    {
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                //Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                parsedata(response);
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(MainActivity.this, "Data not available", Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(stringRequest);
    }
    public void parsedata(String response)
    {
        try {
            JSONObject root=new JSONObject(response);
            JSONArray items=root.getJSONArray("items");
            for(int i=0;i<items.length();i++)
            {
                JSONObject object=items.getJSONObject(i);
                JSONObject volumeinfo=object.getJSONObject("volumeInfo");
                book_title=volumeinfo.optString("title");
                book_desc=volumeinfo.optString("description");
                JSONArray authors=volumeinfo.getJSONArray("authors");
               book_author=authors.getString(0);
               JSONObject imagelinks=volumeinfo.getJSONObject("imageLinks");
               book_img=imagelinks.optString("thumbnail");
               // Toast.makeText(this, book_title+"\n"+book_img+"\n"+book_author+"\n"+book_desc, Toast.LENGTH_SHORT).show();
                BookModel bookModel=new BookModel(book_author,book_title,book_img,book_desc);
                bookarraylist.add(bookModel);
                BookAdapter bookAdapter=new BookAdapter(MainActivity.this,bookarraylist);
                rv.setAdapter(bookAdapter);
                rv.setLayoutManager(new GridLayoutManager(this,2));



            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
