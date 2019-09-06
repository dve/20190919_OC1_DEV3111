package org.rapidpm.event.webcomponents.sapui5;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

import static org.rapidpm.event.webcomponents.sapui5.UI5VersionDefinitions.UI5_VERSION;

@Tag("ui5-switch")
@NpmPackage(value = "@ui5/webcomponents", version = UI5_VERSION)
@JsModule("@ui5/webcomponents/dist/Switch.js")
public class UI5Switch
    extends Component
    implements HasSize, HasStyle, HasUI5Icon {


  public void setTextOn(String value) {
    getElement().setAttribute("text-on", value);
  }

  public String getTextOn() {
    return getElement().getAttribute("text-on");
  }

  public void setTextOff(String value) {
    getElement().setAttribute("text-off", value);
  }

  public String getTextOff() {
    return getElement().getAttribute("text-off");
  }
}
