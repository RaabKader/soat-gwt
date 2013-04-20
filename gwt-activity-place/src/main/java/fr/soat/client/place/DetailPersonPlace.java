package fr.soat.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;


public class DetailPersonPlace extends Place {
	
	
	@Prefix("detailPerson")
	public static class Tokenizer implements PlaceTokenizer<DetailPersonPlace>{

		@Override
		public DetailPersonPlace getPlace(String token) {
			return new DetailPersonPlace();
		}

		@Override
		public String getToken(DetailPersonPlace place) {
			return "";
		}
		
	}
}
