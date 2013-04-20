package fr.soat.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import fr.soat.client.util.PersonData;
import fr.soat.shared.Person;

/**
 * Cette activity va permettre d'afficher le détail des coordonnées de la personne 
 * @author Kader
 *
 */
public class DetailPersonActivity extends AbstractActivity {

	/* Vue passive */ 
	public interface IDetailPersonView extends IsWidget {
		Widget asWidget();
		/*Setter le Presenter dans la vue */
		void setPrenseter(DetailPersonActivity presenter);
		/*Editer la personne dans la vue*/
		void setPerson(Person person);
	}
	
	private final IDetailPersonView detailPersonView;
	private final PersonData personData;
		
	@Inject
	public DetailPersonActivity(final IDetailPersonView detailPersonView, final PersonData personData) {
		super();
		this.detailPersonView = detailPersonView;
		this.personData = personData;
	}

	/*Demarrer l'activité et afficher le detail de la personne */	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		this.detailPersonView.setPrenseter(this);
		if(personData.getPerson()!=null){
			this.detailPersonView.setPerson(this.personData.getPerson());
		}
		panel.setWidget(this.detailPersonView);
	}
}
