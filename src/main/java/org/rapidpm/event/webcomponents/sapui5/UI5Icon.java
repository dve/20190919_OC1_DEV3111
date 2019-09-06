package org.rapidpm.event.webcomponents.sapui5;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

import static org.rapidpm.event.webcomponents.sapui5.UI5VersionDefinitions.UI5_VERSION;

@Tag("ui5-icon")
@NpmPackage(value = "@ui5/webcomponents", version = UI5_VERSION)
@JsModule("@ui5/webcomponents/dist/Icon.js")
public class UI5Icon
    extends Component {

  public void setSource(String src){
    getElement().setAttribute("src", src);
  }

  public String getSource(){
    return getElement().getAttribute("src");
  }

  public void setSource(UI5Icons icon) {
    setSource(icon.code());
  }
}
