package junit.org.rapidpm.event.webcomponents.sapui5;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.testbench.TestBenchTestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.rapidpm.dependencies.core.logger.HasLogger;
import org.rapidpm.event.webcomponents.sapui5.UI5Switch;
import org.rapidpm.event.webcomponents.sapui5.UI5SwitchElement;
import org.rapidpm.junit5.VaadinTutorial;
import org.rapidpm.junit5.WebDriverParameterResolver;

//@VaadinTutorial(packageToDeploy = "junit.org")
public class UI5SwitchTest
    implements HasLogger {
  private static final String NAV      = "tdd/UI5SwitchTest";
  private static final String TEXT_ON  = "ON";
  private static final String TEXT_OFF = "OFF";
  private static final String ID       = "element-to-test";

  @Route(NAV)
  public static class UI5SwitchTestView
      extends Composite<VerticalLayout>
      implements HasLogger {

    public UI5SwitchTestView() {
      final VerticalLayout content = getContent();

      final UI5Switch ui5Switch = new UI5Switch();
      ui5Switch.setId(ID);
      ui5Switch.setTextOn(TEXT_ON);
      ui5Switch.setTextOff(TEXT_OFF);
      ui5Switch.addChangeListener( event -> content.add(new Span("clicked")));
      ui5Switch.setWidth("100px");
      content.add(ui5Switch);

      final Button button = new Button("switch graphical");
      button.addClickListener((event)-> ui5Switch.setGraphical(! ui5Switch.isGraphical()));
      content.add(button);

    }
  }

  public static class UI5SwitchPO
      extends WebDriverParameterResolver.GenericPageObject {

    public UI5SwitchPO(WebDriver webdriver, String hostIpAddress, String vncAdress) {
      super(webdriver, hostIpAddress, vncAdress);
      testCase.setDriver(webdriver);
    }

    public void load(String url) {
      testCase.getDriver()
              .get(url);
    }

    private final TestBenchTestCase testCase = new TestBenchTestCase() { };

    public UI5SwitchElement ui5SwitchElement() {
      return testCase.$(UI5SwitchElement.class)
                     .id(ID);
    }
  }

//  @Test
  void test001(UI5SwitchPO po) {
    final String url = "http://" + po.getHostIpAddress() + ":8899/";
    logger().info("URL : " + url + NAV);
    po.load(url + NAV);

    final UI5SwitchElement element = po.ui5SwitchElement();
    final String           textOff = element.getTextOff();
    Assertions.assertEquals(TEXT_OFF, textOff);
    final String textOn = element.getTextOn();
    Assertions.assertEquals(TEXT_ON, textOn);


    Assertions.assertFalse(element.isCheckedOn());
    element.setCheckedOn();
    Assertions.assertTrue(element.isCheckedOn());

    element.setGraphical(true);
    element.setCheckedOff();

    Assertions.assertFalse(element.isCheckedOn());
    element.setCheckedOn();
    Assertions.assertTrue(element.isCheckedOn());

  }
}
