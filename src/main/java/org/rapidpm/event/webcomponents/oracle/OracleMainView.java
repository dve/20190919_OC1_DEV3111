package org.rapidpm.event.webcomponents.oracle;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.rapidpm.dependencies.core.logger.HasLogger;

import java.util.Arrays;

@Route(OracleMainView.NAV)
public class OracleMainView
    extends Composite<VerticalLayout>
    implements HasLogger {

  public static final String NAV = "";

  public OracleMainView() {

    final OracleJetTrain oracleJetTrain = new OracleJetTrain();
    oracleJetTrain.setSteps(Arrays.asList("Step A", "Step B"));
    getContent().add(oracleJetTrain);
  }
}
