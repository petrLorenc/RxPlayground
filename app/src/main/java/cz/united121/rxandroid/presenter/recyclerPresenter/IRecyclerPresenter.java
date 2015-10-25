package cz.united121.rxandroid.presenter.recyclerPresenter;

import rx.Observable;

/**
 * Interface for presenter in MVP
 * Created by Petr Lorenc[Lorenc55Petr@seznam.cz] on {10/25/2015}
 **/
public interface IRecyclerPresenter {
	void textChangedOnEditView(Observable<? extends String> observable);

	void updateRecyclerViewClick();
}
