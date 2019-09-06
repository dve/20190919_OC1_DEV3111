package org.rapidpm.event.webcomponents.microsoft;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;


//@Tag("Rating")
//@NpmPackage(value = "office-ui-fabric-react", version = "7.31.0")
//@NpmPackage(value = "@types/react", version = "16.9.2")
//@NpmPackage(value = "@types/react-dom", version = "16.9.0")
//@NpmPackage(value = "react", version = "16.9.0")
//@NpmPackage(value = "react-dom", version = "16.9.0")
//@JsModule("office-ui-fabric-react/lib/Rating")
public class MSRating
    extends Component {

  public void setMinValue(Integer min){
    getElement().setAttribute("min",String.valueOf(min));
  }

  public void setMaxValue(Integer max) {
    getElement().setAttribute("max", String.valueOf(max));
  }

  public void setRating(Integer rating){
    getElement().setAttribute("rating",String.valueOf(rating));
  }
}
