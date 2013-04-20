package fr.soat.resources;

import com.github.gwtbootstrap.client.ui.config.Configurator;
import com.github.gwtbootstrap.client.ui.resources.Resources;
import com.google.gwt.core.client.GWT;

public class GwtConfigurator implements Configurator {
    public Resources getResources() {
        return GWT.create(GwtResources.class);
    }

    public boolean hasResponsiveDesign() {
        return false;
    }
}
