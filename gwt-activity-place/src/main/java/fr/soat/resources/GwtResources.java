package fr.soat.resources;

import com.github.gwtbootstrap.client.ui.resources.Resources;
import com.google.gwt.resources.client.TextResource;

public interface GwtResources extends Resources {
    @Override
	@Source("css/bootstrap.min.css")
    TextResource bootstrapCss();
    
    @Override
	@Source("js/bootstrap.min.js")
    TextResource bootstrapJs();
}
