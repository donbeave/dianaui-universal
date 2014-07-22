package org.gwtbootstrap3.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 GwtBootstrap3
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

import com.google.gwt.user.client.ui.FlowPanel;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.HasResponsiveness;
import org.gwtbootstrap3.client.ui.constants.Styles;

/**
 * Combines multiple button groups.
 * <h3>UiBinder example</h3>
 * <pre>{@code
 *     <b:ButtonToolBar>
 *         <b:ButtonGroup>
 *             <b:Button>Button 1</b:Button>
 *             <b:Button>Button 2</b:Button>
 *         </b:ButtonGroup>
 *         <b:ButtonGroup>
 *             <b:Button>Button 3</b:Button>
 *             <b:Button>Button 4</b:Button>
 *         </b:ButtonGroup>
 *     </b:ButtonToolBar>
 * }</pre>
 *
 * @author Sven Jacobs
 * @author Joshua Godi
 * @see ButtonGroup
 */
public class ButtonToolBar extends FlowPanel implements HasResponsiveness {

    public ButtonToolBar() {
        setStyleName(Styles.BTN_TOOLBAR);
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
