package fr.soat.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

import fr.soat.client.gin.GwtInjector;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GwtActivityPlace implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		// RootPanel.get().add(new NavBar());
		// Gin
		// ResourceInjector.configure();
		GwtInjector injector = GWT.create(GwtInjector.class);
		RootPanel.get().add(injector.getDisplay());
		injector.getHistoryHandler().handleCurrentHistory();
	}
}
