package fr.soat.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;

import fr.soat.client.place.FormPersonPlace;

/**
 * Cette activity va permettre d'afficher la page de login à l'application et de gérer la connexion 
 * 
 * @author Kader
 *
 */
public class HomePageActivity extends AbstractActivity {
	
	/*vue passive */
	public interface IHomePageView extends IsWidget{
		void setPresenter(HomePageActivity presenter);
		TextBox getUserBox();
		PasswordTextBox getPassBox();
	}

	private final IHomePageView homePageView;
	private final PlaceController placeController;
		
	@Inject
	public HomePageActivity(final IHomePageView homePageView, final PlaceController placeController) {
		super();
		this.homePageView = homePageView;
		this.placeController = placeController;
	}
	
	/**
	 * Activity start 
	 */
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		this.homePageView.setPresenter(this);
		panel.setWidget(this.homePageView);
	}
	
	/**
	 * connection 
	 */
	public void connect() {
		if(validate()){
			this.placeController.goTo(new FormPersonPlace());
		}else{
			Window.alert("Veuillez saisir les champs obligatoires ");
		}
	}

	private boolean validate() {
		return homePageView.getUserBox()!=null && !homePageView.getUserBox().getValue().trim().equals("")
				&& homePageView.getPassBox()!=null && !homePageView.getPassBox().getValue().trim().equals("");
	}
	
	/**
	 * clear fields 
	 */
	public void reset() {
		this.homePageView.getUserBox().setValue("");
		this.homePageView.getPassBox().setValue("");
	}
}
