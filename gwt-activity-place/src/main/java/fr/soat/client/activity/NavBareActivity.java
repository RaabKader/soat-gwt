package fr.soat.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;

/**
 * Cette activity va gérer la barre de navigation 
 * Cette barre est une partie commune aux différentes pages de l'application 
 * @author Kader
 *
 */
public class NavBareActivity extends AbstractActivity {
	
	/*Vue passive */
	public interface INavBarView extends IsWidget{
		Anchor getPersonne();
		void setPresenter(NavBareActivity presenter);
	}
	
	private final INavBarView navBarView;
	private final PlaceController placeController;
	
	@Inject
	public NavBareActivity(final INavBarView navBarView, final PlaceController placeController) {
		super();
		this.placeController = placeController;
		this.navBarView = navBarView;
	}
	
	/**
	 * Demarrer l'activity pour l'afichage de la barre de navigation 
	 */
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		this.navBarView.setPresenter(this);
		panel.setWidget(this.navBarView);
	}
	
	/**
	 * Lien Recherche 
	 */
	public void onRechercheEleves(){
		//this.placeController.goTo(new RechercheElevePlace());
	}
	
	/**
	 * Lien Liste
	 */
	public void onListEleves() {
			//this.placeController.goTo(new ListElevesPlace());
	}
}
