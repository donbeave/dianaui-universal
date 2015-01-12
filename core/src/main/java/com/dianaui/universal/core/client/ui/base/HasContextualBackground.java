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
package com.dianaui.universal.core.client.ui.base;

import com.dianaui.universal.core.client.ui.constants.ContextualBackground;

/**
 * An object that implements this interface has contextual background, which can be set and
 * retrieved using these methods.
 *
 * @author David Buhler
 */
public interface HasContextualBackground {

    /**
     * Sets the object's contextual background.
     *
     * @param contextualBackground the object's new contextual background
     */
    void setContextualBackground(ContextualBackground contextualBackground);

    /**
     * Get the object's contextual background.
     *
     * @return the object's contextual background
     */
    ContextualBackground getContextualBackground();

}