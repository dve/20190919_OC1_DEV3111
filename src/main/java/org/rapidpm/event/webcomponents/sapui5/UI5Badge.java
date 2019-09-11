package org.rapidpm.event.webcomponents.sapui5;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.html.Span;

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

  public void setColorScheme(ColorScheme colorScheme) {
    getElement().setProperty("colorScheme", colorScheme.asString());
  }

  public void setUI5Icon(UI5Icon icon) {
    getElement().appendChild(icon.getElement());
  }


  @Override
  public void setText(String text) {
    add(text);
  }

  @Override
  public String getText() {
    return null;
  }

  public enum ColorScheme {
    One(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10);

    private int colorScheme;
    ColorScheme(int i) {
      this.colorScheme = i;
    }

    public int value(){
      return this.colorScheme;
    }

    public String asString(){
      return String.valueOf(value());
    }

  }

}
