package com.example.multiplerecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    HashMap<String ,String > hashMap;
    ArrayList<HashMap<String ,String >> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView= findViewById(R.id.recyclerView);



        arrayList = new ArrayList<>();

        hashMap=  new HashMap<>();
        hashMap.put("itemType","video");
        hashMap.put("video_id","i7bdp-1ZVLk");
        hashMap.put("title","Introduction to Next.js");
        arrayList.add(hashMap);


        hashMap=  new HashMap<>();
        hashMap.put("itemType","book");
        hashMap.put("book_name","Gitanjali");
        hashMap.put("writer_name","Rabindranath Tagore");
        hashMap.put("book_link","https://www.google.com/search?sca_esv=125395e02bc1fefe&rlz=1C1GGRV_enBD1094BD1094&q=gitanjali+book+images&uds=AMwkrPtH4R_IcK4JzT8HHqNW5j-myx8JXj7fyt8b5XR5R7NLyR0pNbfOpD28-qnBSWCNiSHU5qVAP2Pl4Hqt4lEwQ6oGkZoNkxkXLjy5JdUTrAjwxg2F-" +
                "JTjGCbSc9-2wZYuLS0taVje7FbJ2U617S3phEcqje0OymL3vQ7Qo6ZfGb7KYlesLuJgIwZVmS5bspga" +
                "BX0EiGaQe9TGLdvlxcr01EW5fPkedqT-ZRrOI3hVdF7Dj8UMpxgVKnp3LzcFG7GEGYN4iCr9mo-brhL1yWaJ2Wfo30fRVV9RQep-yh43qw6uZGuSF_Q&udm=2&prmd=isvnbmz&sa=X&sqi=2&ved=2ahUKEwjF-6OD1c2FAxVfTGwGHXJNAYkQtKgLegQIDxAB&biw=1536&bih=976&dpr=0.67#vhid=653Yhs7nrqRSWM&vssid=mosaic");
        hashMap.put("book_image","https://m.media-amazon.com/images/I/81gJA7cc3+L._AC_UF1000,1000_QL80_.jpg");
        arrayList.add(hashMap);

        hashMap=  new HashMap<>();
        hashMap.put("itemType","video");
        hashMap.put("video_id","cqpQFGnT8X8");
        hashMap.put("title"," আমার মন মজাইয়ারে");
        arrayList.add(hashMap);

        hashMap=  new HashMap<>();
        hashMap.put("itemType","book");
        hashMap.put("book_name","Gitanjali");
        hashMap.put("writer_name","Rabindranath Tagore");
        hashMap.put("book_link","https://www.google.com/search?sca_esv=125395e02bc1fefe&rlz=1C1GGRV_enBD1094BD1094&q=gitanjali+book+images&uds=AMwkrPtH4R_IcK4JzT8HHqNW5j-myx8JXj7fyt8b5XR5R7NLyR0pNbfOpD28-qnBSWCNiSHU5qVAP2Pl4Hqt4lEwQ6oGkZoNkxkXLjy5JdUTrAjwxg2F-" +
                "JTjGCbSc9-2wZYuLS0taVje7FbJ2U617S3phEcqje0OymL3vQ7Qo6ZfGb7KYlesLuJgIwZVmS5bspga" +
                "BX0EiGaQe9TGLdvlxcr01EW5fPkedqT-ZRrOI3hVdF7Dj8UMpxgVKnp3LzcFG7GEGYN4iCr9mo-brhL1yWaJ2Wfo30fRVV9RQep-yh43qw6uZGuSF_Q&udm=2&prmd=isvnbmz&sa=X&sqi=2&ved=2ahUKEwjF-6OD1c2FAxVfTGwGHXJNAYkQtKgLegQIDxAB&biw=1536&bih=976&dpr=0.67#vhid=653Yhs7nrqRSWM&vssid=mosaic");
        hashMap.put("book_image","https://m.media-amazon.com/images/I/81gJA7cc3+L._AC_UF1000,1000_QL80_.jpg");
        arrayList.add(hashMap);

        xAdapter xAdapter =new xAdapter();
        recyclerView.setAdapter(xAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }

    //--------------------------------------------------------------------------------

    public class xAdapter extends RecyclerView.Adapter{

        int BOOK_ITEM =0 ;
        int VIDEO_ITEM =1 ;
        public class videoViewHolder extends RecyclerView.ViewHolder{

            ImageView imaThum;
            TextView tvImageTitle;
            public videoViewHolder(@NonNull View itemView) {
                super(itemView);
                imaThum = itemView.findViewById(R.id.imaThum);
                tvImageTitle = itemView.findViewById(R.id.tvImageTitle);
            }
        }


        public class bookViewHolder extends RecyclerView.ViewHolder{

            ImageView imageBook;
            TextView tvBookName,tvWriterName;

            Button buttonGetBook;

            public bookViewHolder(@NonNull View itemView) {
                super(itemView);

                imageBook = itemView.findViewById(R.id.imageBook);
                tvBookName = itemView.findViewById(R.id.tvBookName);
                tvWriterName = itemView.findViewById(R.id.tvWriterName);
                buttonGetBook = itemView.findViewById(R.id.buttonGetBook);
                buttonGetBook = itemView.findViewById(R.id.buttonGetBook);
            }
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = getLayoutInflater();

            if (viewType==BOOK_ITEM){

                View myView = inflater.inflate(R.layout.bookitem,parent,false);
                return new bookViewHolder(myView);

            }else {
                View myView = inflater.inflate(R.layout.video_item,parent,false);
                return new videoViewHolder(myView);
            }


        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            if (getItemViewType(position)==BOOK_ITEM){

                bookViewHolder myHolder =(bookViewHolder) holder;
                hashMap=arrayList.get(position);

                String book_name = hashMap.get("book_name");
                String writer_name = hashMap.get("writer_name");
                String book_link = hashMap.get("book_link");
                String book_image = hashMap.get("book_image");

                myHolder.tvBookName.setText(book_name);
                myHolder.tvWriterName.setText(writer_name);
                myHolder.buttonGetBook.setOnClickListener(v -> {

                });

                Picasso.get()
                        .load(book_image)
                        .placeholder(R.drawable.ic_launcher_background)
                        .into(((bookViewHolder) holder).imageBook);

            } else if (getItemViewType(position)==VIDEO_ITEM) {
                videoViewHolder myHolder =(videoViewHolder) holder;
                hashMap=arrayList.get(position);

                String title = hashMap.get("title");
                String video_id = hashMap.get("video_id");
                String imageUri="https://img.youtube.com/vi/"+video_id+"/0.jpg";

                myHolder.tvImageTitle.setText(title);

                Picasso.get()
                        .load(imageUri)
                        .placeholder(R.drawable.ic_launcher_background)
                        .into(((videoViewHolder) holder).imaThum);

                
            }
        }



        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        @Override
        public int getItemViewType(int position) {

            hashMap= arrayList.get(position);
            String itemType =hashMap.get("itemType");

            if (itemType.contains("book")) return BOOK_ITEM;
            else return VIDEO_ITEM;



        }
    }
}