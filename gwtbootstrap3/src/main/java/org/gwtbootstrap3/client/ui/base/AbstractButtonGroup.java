package org.gwtbootstrap3.client.ui.base;

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

import com.google.gwt.event.logical.shared.HasOpenHandlers;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.Widget;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.base.mixin.PullMixin;
import org.gwtbootstrap3.client.ui.base.mixin.ToggleMixin;
import org.gwtbootstrap3.client.ui.constants.*;
import org.gwtbootstrap3.client.ui.gwt.FlowPanel;

/**
 * Abstract base class for button groups.
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see org.gwtbootstrap3.client.ui.ButtonGroup
 * @see org.gwtbootstrap3.client.ui.VerticalButtonGroup
 */
public abstract class AbstractButtonGroup extends FlowPanel implements HasName, HasToggle, HasJustified, HasPull,
        HasResponsiveness, HasOpenHandlers<Boolean> {

    private final PullMixin<AbstractButtonGroup> pullMixin = new PullMixin<AbstractButtonGroup>(this);
    private final ToggleMixin<AbstractButtonGroup> toggleMixin = new ToggleMixin<AbstractButtonGroup>(this);
    private String name;

    protected AbstractButtonGroup(final String styleName) {
        setStyleName(styleName);
    }

    /**
     * Makes this a "drop up" container for dropdown menus where the menu opens upwards.
     *
     * @param dropUp dropup or not
     */
    public void setDropUp(final boolean dropUp) {
        if (dropUp) {
            addStyleName(Styles.DROP_UP);
        } else {
            removeStyleName(Styles.DROP_UP);
        }
    }

    /**
     * Causes the group to open or close dropdown menu
     */
    public void toggle() {
        if (isOpen()) {
            hide();
        } else {
            show();
        }
    }

    public void show() {
        addStyleName(Styles.OPEN);

        OpenEvent.fire(this, true);
    }

    public void hide() {
        removeStyleName(Styles.OPEN);

        OpenEvent.fire(this, false);
    }

    public boolean isOpen() {
        return StyleHelper.containsStyle(getStyleName(), Styles.OPEN);
    }

    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Convenience method that will set the name of all child widgets that can have a name
     *
     * @param name Name of group
     * @see #add(com.google.gwt.user.client.ui.Widget)
     */
    @Override
    public void setName(final String name) {
        this.name = name;

        if (name == null) {
            return;
        }

        for (final Widget w : getChildren()) {
            if (w instanceof HasName) {
                ((HasName) w).setName(name);
            }
        }
    }

    @Override
    public Toggle getToggle() {
        return toggleMixin.getToggle();
    }

    @Override
    public void setToggle(final Toggle toggle) {
        toggleMixin.setToggle(toggle);
    }

    @Override
    public boolean isJustified() {
        return StyleHelper.containsStyle(getStyleName(), Styles.BTN_GROUP_JUSTIFIED);
    }

    /**
     * Make a group of buttons stretch at the same size to span the entire width of its parent.
     * <strong>Note:</strong> Justified button groups only work with {@link org.gwtbootstrap3.client.ui.AnchorButton} child elements!
     *
     * @param justified Stretch button group
     */
    @Override
    public void setJustified(final boolean justified) {
        if (justified) {
            addStyleName(Styles.BTN_GROUP_JUSTIFIED);
        } else {
            removeStyleName(Styles.BTN_GROUP_JUSTIFIED);
        }
    }

    @Override
    public Pull getPull() {
        return pullMixin.getPull();
    }

    @Override
    public void setPull(final Pull pull) {
        pullMixin.setPull(pull);
    }

    @Override
    public void setVisibleOn(final String deviceSizeString) {
        StyleHelper.setVisibleOn(this, deviceSizeString);
    }

    @Override
    public void setHiddenOn(final String deviceSizeString) {
        StyleHelper.setHiddenOn(this, deviceSizeString);
    }

    @Override
    public void add(final Widget w) {
        super.add(w);

        if (name == null) {
            return;
        }

        // Add group's name to child widgets that can have a name
        if (w instanceof HasName) {
            ((HasName) w).setName(name);
        }
    }

    @Override
    public HandlerRegistration addOpenHandler(OpenHandler<Boolean> openHandler) {
        return addHandler(openHandler, OpenEvent.getType());
    }

}
