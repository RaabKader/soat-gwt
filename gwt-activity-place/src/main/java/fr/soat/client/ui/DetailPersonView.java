package fr.soat.client.ui;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import fr.soat.client.activity.DetailPersonActivity;
import fr.soat.shared.Person;

/**
 * Détail de la personne - afficher les coordonnées saisies dans le formulaire 
 * @author Kader
 *
 */
public class DetailPersonView extends Composite implements DetailPersonActivity.IDetailPersonView {

	private static DetailPersonViewUiBinder uiBinder = GWT
			.create(DetailPersonViewUiBinder.class);

	interface DetailPersonViewUiBinder extends 
			UiBinder<Widget, DetailPersonView> {
	}
	
	private DetailPersonActivity presenter;
		
	@UiField
	Label civilite;
	
	@UiField
	Label nom;
	
	@UiField
	Label prenom;
	
	@UiField
	Label email;
	
	@UiField
	Button backForm;
	
	/**
	 * Constructeur avec construction de la vue avec UIBinder 
	 */
	public DetailPersonView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPrenseter(DetailPersonActivity presenter) {
		this.presenter = presenter;
	}
	
	/**
	 * Editer les coordonnées de la personne 
	 */
	@Override
	public void setPerson(Person person) {
		if(person==null){
			return;
		}
		this.civilite.setText(person.getCivilite());
		this.nom.setText(person.getNom());
		this.prenom.setText(person.getPrenom());
		this.email.setText(person.getEmail());
	}
	
	@UiHandler("backForm")
	public void onBackToForm(ClickEvent e){
		History.back();
	}
}
