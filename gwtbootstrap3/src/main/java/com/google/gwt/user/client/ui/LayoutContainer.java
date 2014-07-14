package com.google.gwt.user.client.ui;

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

import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.Window;

/**
 * @author <a href='mailto:donbeave@gmail.com'>Alexey Zhokhov</a>
 */
public class LayoutContainer extends LayoutPanel {

    public LayoutContainer() {
        this(true);
    }

    @UiConstructor
    public LayoutContainer(boolean resize) {
        if (resize) {
            Window.addResizeHandler(new ResizeHandler() {
                public void onResize(ResizeEvent event) {
                    LayoutContainer.this.onResize();
                }
            });
        }
    }

    @Override
    protected void onLoad() {
        getLayout().onAttach();
        getLayout().fillParent();
    }

}
