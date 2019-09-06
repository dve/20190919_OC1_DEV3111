package org.rapidpm.event.webcomponents.sapui5;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.dom.DomEventListener;
import org.rapidpm.dependencies.core.logger.HasLogger;

import static org.rapidpm.event.webcomponents.sapui5.UI5VersionDefinitions.UI5_VERSION;

@Tag("ui5-timeline-item")
@NpmPackage(value = "@ui5/webcomponents", version = UI5_VERSION)
@JsModule("@ui5/webcomponents/dist/TimelineItem.js")
public class UI5TimelineItem
    extends Component
    implements HasLogger, HasComponents, HasUI5Icon {

  public void setItemName(String value) {
    getElement().setProperty("itemName", value);
  }

  public String getItemName() {
    return getElement().getProperty("itemName");
  }

  public void setItemNameClickable(Boolean value) {
    getElement().setProperty("itemNameClickable", value);
  }

  public Boolean getItemNameClickable() {
    return Boolean.parseBoolean(getElement().getProperty("itemNameClickable"));
  }

  public void setSubtitleText(String value) {
    getElement().setProperty("subtitleText", value);
  }

  public Boolean getSubtitleText() {
    return Boolean.parseBoolean(getElement().getProperty("subtitleText"));
  }

  public void setTitleText(String value) {
    getElement().setProperty("titleText", value);
  }

  public Boolean getTitleText() {
    return Boolean.parseBoolean(getElement().getProperty("titleText"));
  }

  public void addItemNameClickEventListener(TimeLineItemClicked listener) {
    getElement().addEventListener("itemNameClick", listener);
  }

  public static interface TimeLineItemClicked
      extends DomEventListener {

  }

}
