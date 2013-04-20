package fr.soat.client.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import fr.soat.client.activity.NavBareActivity;

public class NavBar extends Composite implements NavBareActivity.INavBarView {

	private static NavBarUiBinder uiBinder = GWT.create(NavBarUiBinder.class);

	interface NavBarUiBinder extends UiBinder<Widget, NavBar> {
	}

	private NavBareActivity presenter;

	 @UiField
	 Anchor personne;
	
	 @UiField
	 Anchor logOut;
	 
	 @UiField
	 Anchor logOn;
	 
	public NavBar() {
		initWidget(uiBinder.createAndBindUi(this));
		/**
		 * Init Handlers 
		 */
	}
	
	@Override
	public void setPresenter(NavBareActivity presenter) {
		this.presenter = presenter;
	}

	@Override
	public Anchor getPersonne() {
		return personne;
	}

	public Anchor getLogOut() {
		return logOut;
	}

	public Anchor getLogOn() {
		return logOn;
	}

}
