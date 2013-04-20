package fr.soat.client.gin;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.IsWidget;
/*Declare l'interface avec les methodes des types désirés à retourner */
@GinModules({GwtModule.class})
public interface GwtInjector extends Ginjector {
	PlaceHistoryHandler getHistoryHandler();
	IsWidget getDisplay();
}
