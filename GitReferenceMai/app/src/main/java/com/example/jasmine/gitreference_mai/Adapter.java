package com.example.jasmine.gitreference_mai;

/**
 * Created by Jasmine on 2/28/2018.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter
{
    Context mContext;
    LayoutInflater mInflater;
    ArrayList<GitReference> mData;
    public Adapter(Context context, ArrayList<GitReference> data)
    {
        mContext = context;
        mData = data;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return mData.size();
    }

    @Override
    public Object getItem(int position)
    {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View rowView = mInflater.inflate(R.layout.content_main, parent, false);
        TextView commandView = rowView.findViewById(R.id.command);
        TextView explanationView = rowView.findViewById(R.id.explanation);
        TextView exampleView = rowView.findViewById(R.id.example);
        GitReference gitReference = (GitReference) getItem(position);
        commandView.setText(gitReference.getCommand());
        explanationView.setText(gitReference.getExplanation());
        exampleView.setText(gitReference.getExample());
        return rowView;
    }
}
