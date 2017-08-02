package com.example.jduong321.fitnessapplication;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Jacky on 6/5/2017.
 */

public class FitnessAdapter extends BaseAdapter {
    private Context mContext;          // This will have to be passed to the ImageView
    private List<Integer> mThumbIds;   // Adapter must store AdapterView's items
    private List<String> mNames;

    public FitnessAdapter(Context c, List<Integer> ids,List<String> names)
    {
        mContext = c;
        mThumbIds = ids;
        mNames = names;
    }

    @Override
    public int getCount() {
        return mThumbIds.size();
    }

    // Return the data item at position
    @Override
    public Object getItem(int position) {
        return mThumbIds.get(position);
    }

    // Will get called to provide the ID that
    // is passed to OnItemClickListener.onItemClick()
    @Override
    public long getItemId(int position) {
        return mThumbIds.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //is this for grid or the checkbox?

        // if convertView's not recycled, initialize some attributes
        if (convertView == null) {

            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.activity_layout, null);

        }
        else{
            //convertView = (View) convertView.getTag();
        }

        TextView textView = (TextView) convertView.findViewById(R.id.text1);
        textView.setText(mNames.get(position));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,22);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.image1);
        imageView.setImageResource(mThumbIds.get(position));
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);


        return convertView;

    }
}
