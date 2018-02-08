package com.assesment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.assesment.NewsApp;
import com.assesment.magazineapp.R;
import com.assesment.model.Row;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;



public class FactsAdapter extends RecyclerView.Adapter<FactsAdapter.ViewHolder> {

    private List<Row> mDataSet = new ArrayList<>();

    @Inject
    Picasso picasso;

    @Inject
    Context mContext;


    public FactsAdapter( ) {

        NewsApp.getInstance().appComponent.inject(this);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtFactHead) TextView txtFactHead ;
        @BindView(R.id.txtFactDescription) TextView txtFactDescription;
        @BindView(R.id.imgFact) ImageView imgFactImage;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }


    @Override
    public FactsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        // inflating view for the row
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.facts_row_layout, parent, false);


        return new ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(FactsAdapter.ViewHolder holder, int position) {

        Row row = mDataSet.get(position);



        holder.txtFactHead.setText(null != row.getTitle() ? row.getTitle() : mContext.getResources().getString(R.string.no_titile));

        holder.txtFactDescription.setText(null != row.getDescription() ? row.getDescription() : mContext.getResources().getString(R.string.no_description));



        picasso.load(row.getImageHref())
                .into(holder.imgFactImage);


    }

    @Override
    public int getItemCount() {
        return null != mDataSet ? mDataSet.size() : 0;
    }


    public void addFacts(List<Row> facts)
    {
        mDataSet.clear();
        mDataSet.addAll(facts);
        notifyDataSetChanged();
    }
}
