package org.rapidpm.event.webcomponents.sapui5;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.jetbrains.annotations.NotNull;
import org.rapidpm.dependencies.core.logger.HasLogger;
import org.rapidpm.event.webcomponents.sapui5.UI5TimelineItem.TimeLineItemClicked;

@Route(SAPMainView.NAV)
public class SAPMainView
    extends Composite<VerticalLayout>
    implements HasLogger {
  public static final String NAV = "SAP";


  public SAPMainView() {

    final UI5Icon ui5Icon = new UI5Icon();
    ui5Icon.setSource(UI5Icons.PHONE);
    getContent().add(ui5Icon);

    final UI5Badge badge = new UI5Badge();
    badge.setText("A nice Badge");
    badge.setVisible(true);
    badge.setColorScheme(UI5Badge.ColorScheme.FIVE);
//    badge.setWidth("50px");
    badge.setUI5Icon(UI5Icons.ADD_EQUIPMENT.asUI5Icon());
    getContent().add(badge);


    final UI5Switch aSwitch = new UI5Switch();
    aSwitch.setTextOn("okok I will do it");
    aSwitch.setTextOff("nonono I am to lazy");
    aSwitch.setWidth("250px");
    getContent().add(aSwitch);

    final UI5Timeline ui5Timeline = new UI5Timeline();
    ui5Timeline.add(nextTimeLineItem());
    ui5Timeline.add(nextTimeLineItem());
    ui5Timeline.add(nextTimeLineItem());
    getContent().add(ui5Timeline);
  }

  @NotNull
  private UI5TimelineItem nextTimeLineItem() {
    final UI5TimelineItem ui5TimelineItem = new UI5TimelineItem();
    ui5TimelineItem.setItemName("timeLineIcon");
    ui5TimelineItem.setTitleText("Title");
    ui5TimelineItem.setSubtitleText("SubTitle");
    ui5TimelineItem.setIcon(UI5Icons.PHONE);
//    ui5TimelineItem.setIcon("sap-icon://activate");
    ui5TimelineItem.setItemNameClickable(true);
    ui5TimelineItem.add(new ComboBox<>("CB Label", "A", "B"));
    ui5TimelineItem.add(new Text("Huhu"));
    ui5TimelineItem.addItemNameClickEventListener((TimeLineItemClicked) domEvent -> {
      logger().info("got an event (data)" + domEvent.getEventData());
      logger().info("got an event (source)" + domEvent.getSource());
      logger().info("got an event (type)" + domEvent.getType());
    });
    return ui5TimelineItem;
  }
}
