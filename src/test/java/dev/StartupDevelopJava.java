package dev;

import org.apache.commons.cli.ParseException;
import org.rapidpm.vaadin.nano.CoreUIJavaService;

public class StartupDevelopJava {


  private StartupDevelopJava() {
  }

  public static void main(String[] args) throws ParseException {
    new CoreUIJavaService().startup(args);
  }

  public static void shutdown() {

  }
}
