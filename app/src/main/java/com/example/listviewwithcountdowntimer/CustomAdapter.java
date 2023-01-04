package com.example.listviewwithcountdowntimer;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<DataModel> {
    private static final String TAG = "CustomAdapter";

    Context mContext;
    private ArrayList<DataModel> dataSet;

    public CustomAdapter(ArrayList<DataModel> data, Context context) {
        super(context, R.layout.mylist, data);
        this.dataSet = data;
        this.mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        DataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {
            Log.d(TAG, "ssss getView created: ");
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.mylist, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);

            result = convertView;

            convertView.setTag(viewHolder);

            new CountDownTimer(30000, 1000) {

                public void onTick(long millisUntilFinished) {
//                mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
                    viewHolder.txtName.setText(dataModel.nothing+ ": "+"seconds remaining: " + millisUntilFinished / 1000);
                    // logic to set the EditText could go here
                }

                public void onFinish() {
                    viewHolder.txtName.setText(dataModel.nothing+ ": "+"done!");
                }

            }.start();
        } else {
            Log.d(TAG, "ssss getViewa  created already-----: ");
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

//        viewHolder.txtName.setText(dataModel.nothing);

        // Return the completed view to render on screen
        return convertView;
    }

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
    }
}