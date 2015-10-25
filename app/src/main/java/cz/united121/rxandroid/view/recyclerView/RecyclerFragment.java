package cz.united121.rxandroid.view.recyclerView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding.widget.RxTextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import cz.united121.rxandroid.BuildConfig;
import cz.united121.rxandroid.R;
import cz.united121.rxandroid.presenter.recyclerPresenter.IRecyclerPresenter;
import cz.united121.rxandroid.presenter.recyclerPresenter.RecyclerPresenter;

/**
 * Implementation of view's interface (in MVP)
 * Created by Petr Lorenc[Lorenc55Petr@seznam.cz] on {10/25/2015}
 **/
public class RecyclerFragment extends Fragment implements IRecyclerView {
	public static final String TAG = RecyclerFragment.class.getName();
	@Bind(R.id.main_edit)
	EditText mEditText;
	@Bind(R.id.main_text)
	TextView mTextView;
	private IRecyclerPresenter mPresenter;

	public static RecyclerFragment newInstance() {
		RecyclerFragment recyclerFragment = new RecyclerFragment();

		return recyclerFragment;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		if (BuildConfig.DEBUG) {
			Log.d(TAG, "onCreateView");
		}
		//if(savedInstanceState == null){
		View view = inflater.inflate(R.layout.fragment_main, container, false);
		//}
		ButterKnife.bind(this, view);
		initialize();
		return view;
	}

	private void initialize() {
		mPresenter = new RecyclerPresenter(this);
		mPresenter.textChangedOnEditView(RxTextView.textChanges(mEditText).map(CharSequence::toString));
	}

	@Override
	public void setTextToTextView(String text) {
		Log.d(TAG, "setTextToTextView");
		mTextView.setText(text);
	}
}
