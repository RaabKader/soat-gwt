package fr.soat.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;


public class FormPersonPlace extends Place {
	
	@Prefix("formPerson")
	public static class Tokenizer implements PlaceTokenizer<FormPersonPlace>{

		@Override
		public FormPersonPlace getPlace(String token) {
			return new FormPersonPlace();
		}

		@Override
		public String getToken(FormPersonPlace place) {
			return "";
		}
		
	}
}
