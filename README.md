
<center>
<a href="https://vaadin.com">
 <img src="https://vaadin.com/images/hero-reindeer.svg" width="200" height="200" /></a>
</center>


# Nano Vaadin - Ramp up in a second.

## THIS README IS WORK IN PROGRESS

A nano project to start a Vaadin project. Perfect for Micro-UIs packed as fat jar in a docker image.


## SAP Componets
[Component Playground](https://sap.github.io/ui5-webcomponents/playground/)
* [Icons](https://openui5.hana.ondemand.com/test-resources/sap/m/demokit/iconExplorer/webapp/index.html#/overview/SAP-icons/?tab=grid&icon=activate)
* [Timeline](https://github.com/SAP/ui5-webcomponents/blob/master/packages/main/src/Timeline.js)

[NPM UI5](https://www.npmjs.com/package/@ui5/webcomponents)

## Oracle JET
* https://www.oracle.com/webfolder/technetwork/jet/jetCookbook.html?component=train&demo=basic
* https://docs.oracle.com/en/middleware/developer-tools/jet/7.1/develop/web-components.html#GUID-AEC650BD-EA77-4CDC-8476-AC22E7FF9EEE

## Stencil - Apple
* https://stenciljs.com

## Ing Lions
*https://github.com/ing-bank/lion


## Microsoft Components
* https://developer.microsoft.com/de-de/fabric#/controls/web/checkbox
* https://github.com/OfficeDev/office-ui-fabric-react
* https://www.npmjs.com/package/office-ui-fabric-react
### Infos for Devs
* https://stackoverflow.com/questions/47721962/webpack-react-typescript-module-not-found-in-node-modules-react

## Maven 
To understand what is going on during the build process use the following command

```bash
mvn fr.jcgay.maven.plugins:buildplan-maven-plugin:list
```


## Supported JDK
This example is running from JDK8 up to JDK13

## Support for Heroku
To support the Heroku pipeline we need a few preparations.
1) the app must be able to get a configured port for the http port during the start up
1) add the shade plugin to create a fat jar
1) create the file **Procfile** and add the line 
    ```web: java -jar target/vaadin-app.jar -port $PORT```
    * **web** - to activate the web profile
    * **-jar** - define what fat jar must be started
    * **-port** make the dynamic associated port available for the app
1) add a file **settings.xml** to configure the maven build process


## target of this project
The target of this project is a minimal rampup time for a first hello world.
Why we need one more HelloWorld? Well, the answer is quite easy. 
If you have to try something out, or you want to make a small POC to present something,
there is no time and budget to create a demo project.
You don´t want to copy paste all small things together.
Here you will get a Nano-Project that will give you all in a second.

Clone the repo and start editing the class ```BasicTestUI``` or ```BasicTestUIRunner```.
Nothing more. 

## How does it work?
This project will not use any additional maven plugin or technology.
Core Kotlin and the Vaadin Dependencies are all that you need to put 
a Vaadin app into a Servlet-container.

Here we are using the plain **meecrowave** as Servlet-Container.
[http://openwebbeans.apache.org/meecrowave/index.html](http://openwebbeans.apache.org/meecrowave/index.html)


As mentioned before, there is not additional technology involved.
No DI to wire all things together. 

But let´s start from the beginning.

## Start the Servlet-Container (java/kotlin) 
The class ```StartupJava``` or ```StartupKotlin``` will ramp up the Container.

Here all the basic stuff is being done. The start will init. a ServletContainer at port **8899**.
The WebApp will deployed as **ROOT.war**. 

```java
public class StartupJava {
  private StartupJava() { }

  public static void main(String[] args) throws ParseException {
    new CoreUIJavaService().startup(args);
  }

  public static void shutdown() { }
}
```

After this you can start the app invoking the main-method.

## The UI itself
The UI itself is quite easy. 
There is only a button you can click.
For every click, the counter will be increased.

```kotlin
@Route("")
class VaadinApp : Composite<Div>(), HasLogger {

  private val btnClickMe = Button("click me")
  private val lbClickCount = Span("0")
  private val layout = VerticalLayout(btnClickMe, lbClickCount)

  private var clickcount = 0

  init {
    btnClickMe.setId(BTN_CLICK_ME)
    btnClickMe.addClickListener { event -> lbClickCount.text = (++clickcount).toString() }

    lbClickCount.setId(LB_CLICK_COUNT)

    //set the main Component
    logger().info("setting now the main ui content..")
    content.add(layout)
  }

  companion object {
    // read http://vaadin.com/testing for more infos
    val BTN_CLICK_ME = buttonID().apply(VaadinApp::class.java, "btn-click-me")
    val LB_CLICK_COUNT = spanID().apply(VaadinApp::class.java, "lb-click-count")
  }
}
```


## Kotlin, Vaadin and TDD

For UI Tests I am using Selenoid. You will find this on github at []()

After the selenoid node is (locally) started you could check the status 
at [http://localhost:4444/status](http://localhost:4444/status).

Default location for videos when installed with cm is ~/.aerokube/selenoid/video or C:\Users\<user>\.aerokube\selenoid\video.







For testing the Vaadin app, the Open Source project Testbench-NG is used.
This is a jUnit5 / Webdriver - manager AddOn for the Selenium and Testbench projects.
To read more about it, plase have a look at 

[https://github.com/vaadin-developer/vaadin-testbench-ng](https://github.com/vaadin-developer/vaadin-testbench-ng)
The lates version of Testbench NG is : 

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.rapidpm/rapidpm-vaadin-testbench-ng/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.rapidpm/rapidpm-vaadin-testbench-ng)
 

The next step is to create a PageObject for the UI.
This can be done straight forward.

```kotlin
class BasicTestPageObject(webDriver: WebDriver, containerInfo: ContainerInfo)
  : AbstractVaadinPageObject(webDriver, containerInfo) {

  fun button(): ButtonElement {
    return btn().id(BasicTestUI.BUTTON_ID)
  }

  fun counterLabel(): LabelElement {
    return label().id(BasicTestUI.LABEL_ID)
  }
}
```

Now we can start writing logical tests. One could be 

```kotlin
@VaadinWebUnitTest
internal class BasicUnitTest {

  @Test
  fun test001(pageObject: BasicTestPageObject) {
    pageObject.loadPage()

    Assertions.assertEquals("0", pageObject.counterLabel().text)
    pageObject.button().click()
    Assertions.assertEquals("1", pageObject.counterLabel().text)
    pageObject.screenshot()
  }
}
```

## Mutation Testing
This project will give you the basic config for MutationTesting as well.
Invoke the maven target **pitest:mutationCoverage** to create the report. 
The report itself will be under **target/pit-reports**

![_data/PiTest_Report_001.png](_data/PiTest_Report_001.png)


Happy Coding.

if you have any questions: ping me on Twitter [https://twitter.com/SvenRuppert](https://twitter.com/SvenRuppert)
or via mail.
