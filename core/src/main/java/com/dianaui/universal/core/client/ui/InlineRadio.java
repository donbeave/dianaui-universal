/*
 * #%L
 * Diana UI Core
 * %%
 * Copyright (C) 2014 Diana UI
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
package com.dianaui.universal.core.client.ui;

import com.dianaui.universal.core.client.ui.constants.Styles;
import com.google.gwt.dom.client.Document;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.i18n.shared.DirectionEstimator;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.DirectionalTextHelper;

/**
 * An inline radio button widget.
 *
 * @author Sven Jacobs
 * @see Radio
 */
public class InlineRadio extends Radio {

    /**
     * Creates a new radio associated with a particular group, and initialized
     * with the given HTML label. All radio buttons associated with the same
     * group name belong to a mutually-exclusive set.
     * <p/>
     * Radio buttons are grouped by their name attribute, so changing their name
     * using the setName() method will also change their associated group.
     *
     * @param name  the group name with which to associate the radio button
     * @param label this radio button's html label
     */
    public InlineRadio(String name, SafeHtml label) {
        this(name, label.asString(), true);
    }

    /**
     * @param name  the group name with which to associate the radio button
     * @param label this radio button's html label
     * @param dir   the text's direction. Note that {@code DEFAULT} means
     *              direction should be inherited from the widget's parent
     *              element.
     * @see #InlineRadio(String, SafeHtml)
     */
    public InlineRadio(String name, SafeHtml label, Direction dir) {
        this(name);
        setHTML(label, dir);
    }

    /**
     * @param name               the group name with which to associate the radio button
     * @param label              this radio button's html label
     * @param directionEstimator A DirectionEstimator object used for automatic direction
     *                           adjustment. For convenience,
     *                           {@link #DEFAULT_DIRECTION_ESTIMATOR} can be used.
     * @see #InlineRadio(String, SafeHtml)
     */
    public InlineRadio(String name, SafeHtml label, DirectionEstimator directionEstimator) {
        this(name);
        setDirectionEstimator(directionEstimator);
        setHTML(label.asString());
    }

    /**
     * Creates a new radio associated with a particular group, and initialized
     * with the given HTML label. All radio buttons associated with the same
     * group name belong to a mutually-exclusive set.
     * <p/>
     * Radio buttons are grouped by their name attribute, so changing their name
     * using the setName() method will also change their associated group.
     *
     * @param name  the group name with which to associate the radio button
     * @param label this radio button's label
     */
    public InlineRadio(String name, String label) {
        this(name);
        setText(label);
    }

    /**
     * @param name  the group name with which to associate the radio button
     * @param label this radio button's label
     * @param dir   the text's direction. Note that {@code DEFAULT} means
     *              direction should be inherited from the widget's parent
     *              element.
     * @see #InlineRadio(String, SafeHtml)
     */
    public InlineRadio(String name, String label, Direction dir) {
        this(name);
        setText(label, dir);
    }

    /**
     * @param name               the group name with which to associate the radio button
     * @param label              this radio button's label
     * @param directionEstimator A DirectionEstimator object used for automatic direction
     *                           adjustment. For convenience,
     *                           {@link #DEFAULT_DIRECTION_ESTIMATOR} can be used.
     * @see #InlineRadio(String, SafeHtml)
     */
    public InlineRadio(String name, String label, DirectionEstimator directionEstimator) {
        this(name);
        setDirectionEstimator(directionEstimator);
        setText(label);
    }

    /**
     * Creates a new radio button associated with a particular group, and
     * initialized with the given label (optionally treated as HTML). All radio
     * buttons associated with the same group name belong to a
     * mutually-exclusive set.
     * <p/>
     * Radio buttons are grouped by their name attribute, so changing their name
     * using the setName() method will also change their associated group.
     *
     * @param name   name the group with which to associate the radio button
     * @param label  this radio button's label
     * @param asHTML <code>true</code> to treat the specified label as HTML
     */
    public InlineRadio(String name, String label, boolean asHTML) {
        this(name);
        if (asHTML) {
            setHTML(label);
        } else {
            setText(label);
        }
    }

    /**
     * Creates a new radio associated with a particular group name. All radio
     * buttons associated with the same group name belong to a
     * mutually-exclusive set.
     * <p/>
     * Radio buttons are grouped by their name attribute, so changing their name
     * using the setName() method will also change their associated group.
     *
     * @param name the group name with which to associate the radio button
     */
    @UiConstructor
    public InlineRadio(String name) {
        super(DOM.createLabel());
        setStyleName(Styles.RADIO_INLINE);

        inputElem = Document.get().createRadioInputElement(name);
        labelElem = Document.get().createSpanElement();

        getElement().appendChild(inputElem);
        getElement().appendChild(labelElem);

        directionalTextHelper = new DirectionalTextHelper(labelElem, true);

        // Accessibility: setting tab index to be 0 by default, ensuring element
        // appears in tab sequence. FocusWidget's setElement method already
        // calls setTabIndex, which is overridden below. However, at the time
        // that this call is made, inputElem has not been created. So, we have
        // to call setTabIndex again, once inputElem has been created.
        setTabIndex(0);

        sinkEvents(Event.ONCLICK);
        sinkEvents(Event.ONMOUSEUP);
        sinkEvents(Event.ONBLUR);
        sinkEvents(Event.ONKEYDOWN);
    }

}
