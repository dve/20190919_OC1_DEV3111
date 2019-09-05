package org.rapidpm.event.webcomponents.sapui5;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route(SAPMainView.NAV)
public class SAPMainView
    extends Composite<Div> {
  public static final String NAV = "";


  public SAPMainView() {
    final UI5Badge badge = new UI5Badge();
    badge.setText("badge");
    badge.setVisible(true);
    badge.setColorScheme("5");
    badge.setWidth("50px");


    getContent().add(badge);


    final UI5Switch aSwitch = new UI5Switch();
    aSwitch.setTextOn("okok I will do it");
    aSwitch.setTextOff("nonono I am to lazy");
    aSwitch.setWidth("250px");

    getContent().add(aSwitch);
  }
}
