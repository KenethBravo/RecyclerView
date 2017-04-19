package com.jonmid.tallerasynctask.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jonmid.tallerasynctask.Models.Post;
import com.jonmid.tallerasynctask.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc-12 on 19/04/17.
 */

// sirve para manejar las vistas (Injeccion de vistas)
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder>{
    List<Post> myPost = new ArrayList<>();
    Context context; // hace referencia dde donde se trabaja, en este caso Activity Main

    //constructor de mi clase PostAdapter
    public PostAdapter(Context context,List<Post> myPost) {
        this.myPost = myPost;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Vincular mi vista item.xml con la vista principal activity_main.xml

        // Inyecta my layout (item.xml) en la vista principal
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);

        // crea objeto de la subclase  para manejar y asignar los componentes del layout item.xml
        ViewHolder viewHolder = new ViewHolder(itemview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //lanza la vista en mi layout principal (activity_main)


        //establecer el valor de mi textview con el valor del JSON
        holder.myText.setText(myPost.get(position).getTitle());
        holder.myText2.setText(myPost.get(position).getBody());
    }

    // trae tamaño de tola la lista que llega
    @Override
    public int getItemCount() {
        return myPost.size();
    }


    // sirve para hacer injeccion de la vista y pasarla al recyclerView
    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView myImage;
        TextView myText;
        TextView myText2;

        // constructor subclase
        public ViewHolder(View item) {
            super(item);
            this.myImage = (ImageView) item.findViewById(R.id.logo);
            this.myText = (TextView) item.findViewById(R.id.txt_item);
            this.myText2 = (TextView) item.findViewById(R.id.txt_item_2);
        }
    }
}
