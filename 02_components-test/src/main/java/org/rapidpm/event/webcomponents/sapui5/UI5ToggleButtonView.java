package org.rapidpm.event.webcomponents.sapui5;

import static org.rapidpm.event.webcomponents.sapui5.UI5ToggleButtonView.NAV;
import static org.rapidpm.event.webcomponents.sapui5.UI5VersionDefinitions.UI5_VERSION;
import org.rapidpm.dependencies.core.logger.HasLogger;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route(NAV)
@NpmPackage(value = "@ui5/webcomponents", version = UI5_VERSION)
@JsModule("@ui5/webcomponents/dist/ToggleButton.js")
public class UI5ToggleButtonView extends Composite<Div> implements HasLogger {
  public static final String NAV = "UI5ToggleButtonView";

  public UI5ToggleButtonView() {
    UI5ToggleButton toggleButton = new UI5ToggleButton("Toggle me");

    toggleButton.addValueChangeListener(
        event -> System.out.println("ValueChangeEvent: " + event.getValue()));
    getContent().add(toggleButton);
  }
}
