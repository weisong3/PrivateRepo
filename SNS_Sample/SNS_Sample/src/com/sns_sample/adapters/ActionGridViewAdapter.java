package com.sns_sample.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.sns_sample.R;

public class ActionGridViewAdapter extends BaseAdapter {
	private ArrayList<String> actionList;
	private Context context;

	public ActionGridViewAdapter(ArrayList<String> actionList, Context context) {
		this.actionList = actionList;
		this.context = context;
	}

	@Override
	public int getCount() {
		return actionList.size();
	}

	@Override
	public String getItem(int position) {
		return actionList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = inflater.inflate(R.layout.main_action_gridview_item, parent, false);
		Button button = (Button) itemView.findViewById(R.id.main_action_gridView_item_button);
		button.setText(getItem(position));
		return itemView;
	}

	public void updateActionList(ArrayList<String> actionList) {
		this.actionList = actionList;
	}
	
}
