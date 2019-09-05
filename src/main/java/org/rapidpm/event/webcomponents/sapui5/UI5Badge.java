package org.rapidpm.event.webcomponents.sapui5;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;


@Tag("ui5-badge")
@NpmPackage(value = "@ui5/webcomponents", version = "v1.0.0-rc.2")
@JsModule("@ui5/webcomponents/dist/Badge.js")
public class UI5Badge
    extends Component
    implements HasSize, HasStyle {

  public void setText(String value) {
    getElement().setText(value);
  }
  public String getText() {
    return getElement().getText();
  }

  public String getColorScheme() {
    return getElement().getProperty("colorScheme");
  }

  public void setColorScheme(String colorScheme) {
    getElement().setProperty("colorScheme", colorScheme);
  }

//  public Icon getIcon() {
//    return getElement().getProperty("icon");
//  }

//  public void setIcon(Icon icon) {
//    getElement().setAttribute("icon", icon);
//  }
}
