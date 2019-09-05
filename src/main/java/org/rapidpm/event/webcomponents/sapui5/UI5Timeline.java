package org.rapidpm.event.webcomponents.sapui5;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;


/**
 * <ui5-timeline>
 * 	<ui5-timeline-item id="test-item"
 * 	                   title-text="called"
 * 	                   subtitle-text="20.02.2017 11:30"
 * 	                   icon="sap-icon://phone"
 * 	                   item-name="John Smith"
 * 	                   item-name-clickable>
 * 	</ui5-timeline-item>
 * 	<ui5-timeline-item title-text="Weekly Sync - CP Design" subtitle-text="27.07.2017 (11:00 - 12:30)" icon="sap-icon://calendar">
 * 		<div>MR SOF02 2.43</div>
 * 	</ui5-timeline-item>
 * 	<ui5-timeline-item title-text="Video Converence Call - UI5" subtitle-text="31.01.2018 (12:00 - 13:00)" icon="sap-icon://calendar">
 * 		<div>Online meeting</div>
 * 	</ui5-timeline-item>
 * </ui5-timeline>
 *
 *
 *
 */

@Tag("ui5-timeline")
@NpmPackage(value = "@ui5/webcomponents", version = "v1.0.0-rc.2")
@JsModule("@ui5/webcomponents/dist/Timeline.js")
public class UI5Timeline
    extends Component {





}
