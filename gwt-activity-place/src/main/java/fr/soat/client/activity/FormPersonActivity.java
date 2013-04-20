package fr.soat.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import fr.soat.client.place.DetailPersonPlace;
import fr.soat.client.util.PersonData;
import fr.soat.shared.Person;

/**
 * Cette activity va permettre d'afficher le formulaire de saisie des coordonées de la personne 
 * @author Kader
 *
 */
public class FormPersonActivity extends AbstractActivity {

	/*Vue passive qui sera implementee par la vue concrete */
	public interface IFormPersonView extends IsWidget {
		Widget asWidget();
		void setPrenseter(FormPersonActivity presenter);
		Person getPerson();
	}
	
	private final IFormPersonView formPersonView;
	private final PlaceController placeController;
	private final PersonData personData;
	
	@Inject
	public FormPersonActivity(final IFormPersonView formPersonView, final PlaceController placeController, final PersonData personData) {
		super();
		this.formPersonView = formPersonView;
		this.placeController = placeController;
		this.personData = personData;
	}

	
	/*Demarrer l'activité et afficher le formulaire de saisie des coordonnes de la personne */
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		this.formPersonView.setPrenseter(this);
		personData.setPerson(null);
		panel.setWidget(this.formPersonView);
	}

	/**
	 * Afficher le détail des coordonnées de la personne 
	 * @param person
	 */
	public void doEnregistrerPerson(Person person) {
		personData.setPerson(this.formPersonView.getPerson()); //TODO 
		placeController.goTo(new DetailPersonPlace());
	}

}
