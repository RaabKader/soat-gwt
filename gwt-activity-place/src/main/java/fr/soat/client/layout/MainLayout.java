package fr.soat.client.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MainLayout extends Composite {

	private static MainLayoutUiBinder uiBinder = GWT
			.create(MainLayoutUiBinder.class);

	interface MainLayoutUiBinder extends UiBinder<Widget, MainLayout> {
	}

	@UiField
	AcceptsOneWidget centerContainer;

	@UiField
	AcceptsOneWidget navBar;

	public MainLayout() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public static MainLayoutUiBinder getUiBinder() {
		return uiBinder;
	}

	public AcceptsOneWidget getCenterContainer() {
		return centerContainer;
	}

	public AcceptsOneWidget getNavBar() {
		return navBar;
	}

}
