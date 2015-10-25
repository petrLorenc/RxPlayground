package cz.united121.rxandroid.view.recyclerView;

import cz.united121.rxandroid.presenter.recyclerPresenter.RecyclerAdapter;

/**
 * Interface for view (in MVP)
 * Created by Petr Lorenc[Lorenc55Petr@seznam.cz] on {10/25/2015}
 **/
public interface IRecyclerView {
	void setTextToTextView(String text);

	void setAdapterToRecyclerView(RecyclerAdapter recyclerAdapter);
}
