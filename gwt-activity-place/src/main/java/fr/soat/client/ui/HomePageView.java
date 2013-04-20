package fr.soat.client.ui;

import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import fr.soat.client.activity.HomePageActivity;

public class HomePageView extends Composite implements
		HomePageActivity.IHomePageView {

	private static HomePageViewUiBinder uiBinder = GWT
			.create(HomePageViewUiBinder.class);

	interface HomePageViewUiBinder extends UiBinder<Widget, HomePageView> {
	}

	private HomePageActivity presenter;

	@UiField
	TextBox userBox;
	@UiField
	PasswordTextBox passBox;

	@UiField
	Button validate;

	@UiField
	Button reset;

	public HomePageView() {
		validate = new Button();
		reset = new Button();

		initWidget(uiBinder.createAndBindUi(this));

	}

	@UiHandler("validate")
	public void onValidate(ClickEvent event) {
		this.presenter.connect();
	}

	@UiHandler("reset")
	public void onReset(ClickEvent event) {
		this.presenter.reset();
	}

	@Override
	public void setPresenter(HomePageActivity presenter) {
		this.presenter = presenter;
	}

	@Override
	public TextBox getUserBox() {
		return this.userBox;
	}

	@Override
	public PasswordTextBox getPassBox() {
		return this.passBox;
	}
}
