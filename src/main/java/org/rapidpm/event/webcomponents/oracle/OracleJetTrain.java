package org.rapidpm.event.webcomponents.oracle;

import com.google.gson.Gson;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

import java.util.Collection;


//@Tag("oj-train")
//@NpmPackage(value = "@oracle/oraclejet", version = "7.1.0")
//@JsModule("@oracle/oraclejet/dist/types/ojtrain/index.d.ts")
public class OracleJetTrain
    extends Component {

  //selected-step
  //steps

  public void setSteps(String[] steps){
    Gson gson = new Gson();
    getElement().setAttribute("steps", gson.toJson(steps));
  }

  public void setSteps(Collection<String> steps){
    Gson gson = new Gson();
    getElement().setAttribute("steps", gson.toJson(steps));
  }

  public void setSelectedSteps(String step){
    Gson gson = new Gson();
    getElement().setAttribute("selected-step", step);
  }

}
