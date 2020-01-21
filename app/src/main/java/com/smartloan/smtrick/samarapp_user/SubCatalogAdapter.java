package com.smartloan.smtrick.samarapp_user;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.List;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

public class SubCatalogAdapter extends RecyclerView.Adapter<SubCatalogAdapter.ViewHolder> {

    private List<String> sublist;
    String mainproductname;


    public SubCatalogAdapter(List<String> catalogList, String mainproductname) {
        this.mainproductname = mainproductname;
        sublist = catalogList;
    }

    @Override
    public SubCatalogAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cataloglist, parent, false);
        SubCatalogAdapter.ViewHolder viewHolder = new SubCatalogAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final SubCatalogAdapter.ViewHolder holder, final int position) {
        final String subcatname = sublist.get(position);
        holder.catalogSubname.setText(subcatname);

        holder.subcardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Do on click stuff
                Intent subintent = new Intent(holder.catalogSubname.getContext(), MainCatalog_Activity.class);
                subintent.putExtra("mianproduct", mainproductname);
                subintent.putExtra("subproduct", subcatname);
                holder.catalogSubname.getContext().startActivity(subintent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return sublist.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView catalogSubname;
        public CardView subcardView;

        public ViewHolder(View itemView) {
            super(itemView);

            catalogSubname = (TextView) itemView.findViewById(R.id.catalog_name);
            subcardView = (CardView) itemView.findViewById(R.id.card);
        }
    }
}
