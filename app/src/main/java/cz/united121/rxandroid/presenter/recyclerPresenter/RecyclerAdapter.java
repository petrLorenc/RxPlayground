package cz.united121.rxandroid.presenter.recyclerPresenter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cz.united121.rxandroid.R;
import cz.united121.rxandroid.model.data.TestObject;

/**
 * Created by Petr Lorenc[Lorenc55Petr@seznam.cz] on {10/25/2015}
 **/
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
	public static final String TAG = RecyclerAdapter.class.getName();

	private List<TestObject> mData;

	public RecyclerAdapter() {
		mData = new ArrayList<>();
	}

	public RecyclerAdapter(List<TestObject> data) {
		mData = data;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		Log.d(TAG, "onCreateViewHolder");
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_main, parent, false);
		ViewHolder viewHolder = new ViewHolder(view);
		return viewHolder;
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		Log.d(TAG, "onBindViewHolder");
		holder.id.setText(mData.get(position).getId() + "");
		holder.content.setText(mData.get(position).getTitle());
	}

	@Override
	public int getItemCount() {
		Log.d(TAG, "getItemCount");
		return mData.size();
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {
		TextView id;
		TextView content;

		public ViewHolder(View itemView) {
			super(itemView);
			id = (TextView) itemView.findViewById(R.id.item_id);
			content = (TextView) itemView.findViewById(R.id.item_content);
		}
	}


}
