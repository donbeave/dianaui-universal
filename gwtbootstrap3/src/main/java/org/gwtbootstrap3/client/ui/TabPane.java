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

import com.google.gwt.user.client.Timer;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.base.mixin.ActiveMixin;
import org.gwtbootstrap3.client.ui.constants.HasActive;
import org.gwtbootstrap3.client.ui.constants.Styles;
import org.gwtbootstrap3.client.ui.html.Div;

/**
 * @author Joshua Godi
 * @author <a href='mailto:donbeave@gmail.com'>Alexey Zhokhov</a>
 */
public class TabPane extends Div implements HasActive {

    private static int DEFAULT_TRANSITION_MS = 150;

    private final ActiveMixin<TabPane> activeMixin = new ActiveMixin<TabPane>(this);

    public TabPane() {
        setStyleName(Styles.TAB_PANE);
    }

    public boolean isFade() {
        return StyleHelper.containsStyle(getStyleName(), Styles.FADE);
    }

    public void setFade(final boolean fade) {
        if (fade) {
            addStyleName(Styles.FADE);
        } else {
            removeStyleName(Styles.FADE);
        }
    }

    public void setIn(final boolean in) {
        Timer timer = new Timer() {
            @Override
            public void run() {
                if (in) {
                    addStyleName(Styles.IN);
                } else {
                    removeStyleName(Styles.IN);
                }
            }
        };

        timer.schedule(isFade() ? DEFAULT_TRANSITION_MS : 0);
    }

    @Override
    public boolean isActive() {
        return activeMixin.isActive();
    }

    @Override
    public void setActive(final boolean active) {
        activeMixin.setActive(active);

        if (isFade()) {
            setIn(active);
        }
    }

}
