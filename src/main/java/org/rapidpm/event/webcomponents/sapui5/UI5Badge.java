package org.rapidpm.event.webcomponents.sapui5;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

import static org.rapidpm.event.webcomponents.sapui5.UI5VersionDefinitions.UI5_VERSION;


@Tag("ui5-badge")
@NpmPackage(value = "@ui5/webcomponents", version = UI5_VERSION)
@JsModule("@ui5/webcomponents/dist/Badge.js")
public class UI5Badge
    extends Component
    implements HasSize, HasStyle, HasText, HasComponents {

  public String getColorScheme() {
    return getElement().getProperty("colorScheme");
  }

  public void setColorScheme(String colorScheme) {
    getElement().setProperty("colorScheme", colorScheme);
  }

  public void setUI5Icon(UI5Icon icon){
    getElement().appendChild(icon.getElement());
  }

}
