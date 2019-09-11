package org.rapidpm.event.webcomponents.oracle;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import org.rapidpm.dependencies.core.logger.HasLogger;

import java.util.Arrays;

//@Route(OracleMainView.NAV)
public class OracleMainView
    extends Composite<Div>
    implements HasLogger {

  public static final String NAV = "";

  public OracleMainView() {
    final OracleJetTrain oracleJetTrain = new OracleJetTrain();
    oracleJetTrain.setSteps(Arrays.asList("Step A", "Step B"));
    getContent().add(oracleJetTrain);
  }
}
