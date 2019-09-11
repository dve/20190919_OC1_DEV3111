package org.rapidpm.event.webcomponents.sapui5;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.Route;
import org.rapidpm.dependencies.core.logger.HasLogger;

import static org.rapidpm.event.webcomponents.sapui5.UI5SwitchView.NAV;

@Route(NAV)
public class UI5SwitchView extends Composite<Div>
    implements HasLogger {
  public static final String NAV = "UI5SwitchView";

  public static final String TEXT_ON  = "ON";
  public static final String TEXT_OFF = "OFF";
  public static final String ID       = "element-to-test";

  public UI5SwitchView() {
    final Div       content   = getContent();
    final UI5Switch ui5Switch = new UI5Switch();
    ui5Switch.setId(ID);
    ui5Switch.setTextOn(TEXT_ON);
    ui5Switch.setTextOff(TEXT_OFF);
    ui5Switch.addChangeListener( event -> content.add(new Span("clicked"), new Html("<br/>")));
    ui5Switch.setWidth("100px");
    content.add(ui5Switch);

    final Button button = new Button("switch graphical");
    button.addClickListener((event)-> ui5Switch.setGraphical(! ui5Switch.isGraphical()));
    content.add(button);
  }
}
