package fr.soat.client.gin;

import com.google.common.collect.ImmutableMap;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;

import fr.soat.client.activity.DetailPersonActivity;
import fr.soat.client.activity.DetailPersonActivity.IDetailPersonView;
import fr.soat.client.activity.FormPersonActivity;
import fr.soat.client.activity.FormPersonActivity.IFormPersonView;
import fr.soat.client.activity.HomePageActivity;
import fr.soat.client.activity.HomePageActivity.IHomePageView;
import fr.soat.client.activity.NavBareActivity;
import fr.soat.client.activity.NavBareActivity.INavBarView;
import fr.soat.client.layout.MainLayout;
import fr.soat.client.layout.NavBar;
import fr.soat.client.place.DetailPersonPlace;
import fr.soat.client.place.FormPersonPlace;
import fr.soat.client.place.HomePagePlace;
import fr.soat.client.ui.DetailPersonView;
import fr.soat.client.ui.FormPersonView;
import fr.soat.client.ui.HomePageView;
import fr.soat.client.util.PersonData;

@SuppressWarnings("deprecation")
public class GwtModule extends AbstractGinModule {

	/**
	 * Identifier toutes les places de l'application
	 * La place, un état du système 
	 */
	@WithTokenizers({ HomePagePlace.Tokenizer.class, DetailPersonPlace.Tokenizer.class, FormPersonPlace.Tokenizer.class })
	
	public static interface AppHistoryMapper extends PlaceHistoryMapper {
	}

	@Override
	protected void configure() {
		// bind EventBus and PlaceHistoryMapper
		bind(PlaceHistoryMapper.class).to(AppHistoryMapper.class).in(Singleton.class);
		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
		bind(Place.class).to(HomePagePlace.class);
		bind(MainLayout.class).in(Singleton.class);
		// bind view waiting image 
		
		// bind view
		bind(INavBarView.class).to(NavBar.class).in(Singleton.class);
		bind(IHomePageView.class).to(HomePageView.class).in(Singleton.class);
		bind(IDetailPersonView.class).to(DetailPersonView.class).in(Singleton.class);
		bind(IFormPersonView.class).to(FormPersonView.class).in(Singleton.class);
		
		// bind Activity
		bind(HomePageActivity.class);
		bind(NavBareActivity.class);
		bind(DetailPersonActivity.class);
		bind(FormPersonActivity.class);
		
		// Bind PersonData 
		bind(PersonData.class).in(Singleton.class);
		
	}


	/**
	 *  Bind ActivityMapper
	 *  Permet de retrouver l'activité relative à la place 
	 * @param homePageActivity
	 * @param detailPersonActivity
	 * @param formPersonActivity
	 * @return
	 */
	@Provides
	@Singleton
	ActivityMapper provideActivityMapper(final HomePageActivity homePageActivity, final DetailPersonActivity detailPersonActivity,
			final FormPersonActivity formPersonActivity) {

		return new ActivityMapper() {
			private final ImmutableMap<Class<? extends Place>, Activity> map = new ImmutableMap.Builder<Class<? extends Place>, Activity>()
					.put(HomePagePlace.class, homePageActivity).
					put(DetailPersonPlace.class, detailPersonActivity).
					put(FormPersonPlace.class, formPersonActivity).
					build();
			
			// A partir du placeController.goto(Place), on récupère l'Activity liée à la place, et la méthode 
			// start() sera executée 
			@Override
			public Activity getActivity(Place place) {
				Activity activity = map.get(place.getClass());
				return activity;
			}
		};
	}

	@Provides
	@Inject
	IsWidget provideLayout(MainLayout layout) {
		return layout;
	}

	// bind placeController
	@Provides
	@Singleton
	PlaceController providePlaceController(EventBus eventBus) {
		return new PlaceController(eventBus);
	}

	@Provides
	@Singleton
	PlaceHistoryHandler provideHistoryHandler(final EventBus eventBus,
			final PlaceHistoryMapper historyMapper, final Place defaultPlace,
			final PlaceController placeController,
			final ActivityMapper activityMapper, final MainLayout layout,
			final NavBareActivity navBareActivity) {

		// Main container
		final ActivityManager activityManager = new ActivityManager(
				activityMapper, eventBus);
		activityManager.setDisplay(layout.getCenterContainer());
		final PlaceHistoryHandler placeHistoryHandler = new PlaceHistoryHandler(historyMapper);

		// NavBar
		final ActivityManager activityNavManager = new ActivityManager(new ActivityMapper() {

					@Override
					public Activity getActivity(Place place) {
						return navBareActivity;
					}
				}, eventBus);

		activityNavManager.setDisplay(layout.getNavBar());
		placeHistoryHandler.register(placeController, eventBus, defaultPlace);
		return placeHistoryHandler;
	}
}
