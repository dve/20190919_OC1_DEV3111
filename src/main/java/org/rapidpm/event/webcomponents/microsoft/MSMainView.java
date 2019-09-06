package org.rapidpm.event.webcomponents.microsoft;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route(MSMainView.NAV)
public class MSMainView
    extends Composite<Div> {
  public static final String NAV = "ms-world";


  public MSMainView() {
    final MSRating msRating = new MSRating();
    msRating.setMaxValue(5);
    msRating.setMinValue(0);
    msRating.setRating(3);

    getContent().add(msRating);
  }
}


