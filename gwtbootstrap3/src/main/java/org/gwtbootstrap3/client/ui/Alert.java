package org.gwtbootstrap3.client.ui;

/*
 * #%L
 * GWT Widgets
 * %%
 * Copyright (C) 2014 GWT Widgets
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.Event;
import org.gwtbootstrap3.client.shared.event.AlertCloseEvent;
import org.gwtbootstrap3.client.shared.event.AlertClosedEvent;
import org.gwtbootstrap3.client.ui.base.button.CloseButton;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.AlertType;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.html.Div;
import org.gwtbootstrap3.client.ui.html.Text;

/**
 * Alert block.
 * Use {@link #setDismissable(boolean)} to add a close ("x") button.
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @author <a href='mailto:donbeave@gmail.com'>Alexey Zhokhov</a>
 * @see org.gwtbootstrap3.client.shared.event.AlertCloseEvent
 * @see org.gwtbootstrap3.client.shared.event.AlertClosedEvent
 */
public class Alert extends Div implements HasType<AlertType>, HasResponsiveness {

    private static final String CLOSE = "close";

    private final Text text = new Text();
    private final CloseButton closeButton = new CloseButton();

    /**
     * Builds a default alert
     */
    public Alert() {
        setStyleName(Styles.ALERT);
        setType(AlertType.WARNING);
    }

    /**
     * Builds a default alert with the desired text
     *
     * @param text text for the alert
     */
    public Alert(final String text) {
        this();
        setText(text);
    }

    /**
     * Builds an alert with the desired text and type
     *
     * @param text text for the alert
     * @param type type for the alert
     */
    public Alert(final String text, final AlertType type) {
        this(text);
        setType(type);
    }

    public Alert(final SafeHtml safeHtml) {
        this(safeHtml.asString());
    }

    public Alert(final SafeHtml safeHtml, final AlertType type) {
        this(safeHtml.asString(), type);
    }

    @Override
    public AlertType getType() {
        return AlertType.fromStyleName(getStyleName());
    }

    /**
     * Sets alert type.
     *
     * @param type Alert type
     * @see AlertType
     */
    @Override
    public void setType(final AlertType type) {
        StyleHelper.addUniqueEnumStyleName(this, AlertType.class, type);
    }

    /**
     * Returns the text of the alert.
     *
     * @return text of the alert
     */
    public String getText() {
        return text.getText();
    }

    /**
     * Sets the text for the alert
     *
     * @param text the text of the alert
     */
    public void setText(final String text) {
        this.text.setText(text);
        insert(this.text, 0);
    }

    public boolean isDismissable() {
        return closeButton.getParent() != null;
    }

    /**
     * Adds a close button to the alert
     *
     * @param dismissable Adds close button when {@code true}
     */
    public void setDismissable(final boolean dismissable) {
        if (dismissable) {
            insert(closeButton, (Element) getElement(), 0, true);
            addStyleName(Styles.ALERT_DISMISSABLE);
        } else {
            closeButton.removeFromParent();
            removeStyleName(Styles.ALERT_DISMISSABLE);
        }
    }

    /**
     * Closes alert.
     */
    public void close() {
        // TODO
        // alert(getElement(), CLOSE);
    }

    protected void onClose(final Event evt) {
        fireEvent(new AlertCloseEvent(evt));
    }

    protected void onClosed(final Event evt) {
        fireEvent(new AlertClosedEvent(evt));
    }

    @Override
    public void setVisibleOn(final String deviceSizeString) {
        StyleHelper.setVisibleOn(this, deviceSizeString);
    }

    @Override
    public void setHiddenOn(final String deviceSizeString) {
        StyleHelper.setHiddenOn(this, deviceSizeString);
    }

}
