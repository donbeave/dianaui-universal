package org.gwtbootstrap3.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2014 GwtBootstrap3
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

import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import org.gwtbootstrap3.client.ui.constants.*;

/**
 * A ButtonCell with Bootstrap Style, supporting Icons and icon types.
 *
 * @author Carlos A Becker
 * @author <a href='mailto:donbeave@gmail.com'>Alexey Zhokhov</a>
 * @see org.gwtbootstrap3.client.ui.Button
 */
public class ButtonCell extends com.google.gwt.cell.client.ButtonCell implements HasIcon, HasIconPosition,
        HasSize<ButtonSize> {

    private ButtonType type = null;
    private ButtonSize size = null;
    private IconType fontAwesomeIcon = null;
    private GlyphiconType glyphicon = null;
    private IconSize iconSize = null;
    private IconFlip iconFlip = null;
    private IconRotate iconRotate = null;
    private boolean iconBordered = false;
    private boolean iconMuted = false;
    private boolean iconLight = false;
    private boolean iconSpin = false;
    private IconPosition iconPosition = null;

    public ButtonCell() {
    }

    public ButtonCell(ButtonType type) {
        setType(type);
    }

    public ButtonCell(IconType icon) {
        setFontAwesomeIcon(icon);
    }

    public ButtonCell(GlyphiconType icon) {
        setGlyphicon(icon);
    }

    public ButtonCell(ButtonSize size) {
        setSize(size);
    }

    public ButtonCell(IconType icon, ButtonType type) {
        setFontAwesomeIcon(icon);
        setType(type);
    }

    public ButtonCell(IconType icon, ButtonSize size) {
        setFontAwesomeIcon(icon);
        setSize(size);
    }

    public ButtonCell(ButtonType type, ButtonSize size) {
        setType(type);
        setSize(size);
    }

    public ButtonCell(IconType icon, ButtonType type, ButtonSize size) {
        setFontAwesomeIcon(icon);
        setType(type);
        setSize(size);
    }

    @Override
    public void render(Context context, SafeHtml data, SafeHtmlBuilder sb) {
        sb.appendHtmlConstant("<button type=\"button\" class=\"btn "
                + (type != null ? type.getCssName() : "") + (size != null ? " " + size.getCssName() : "") + "\" tabindex=\"-1\">");
        if (data != null) {
            if (fontAwesomeIcon != null || glyphicon != null) {
                String iconClasses = fontAwesomeIcon != null ? fontAwesomeIcon.getCssName() : glyphicon.getCssName();

                sb.appendHtmlConstant("<i class=\"" + iconClasses + "\"></i> ");
            }
            sb.append(data);
        }
        sb.appendHtmlConstant("</button>");
    }

    public ButtonType getType() {
        return type;
    }

    public void setType(ButtonType type) {
        this.type = type;
    }

    @Override
    public ButtonSize getSize() {
        return size;
    }

    @Override
    public void setSize(ButtonSize size) {
        this.size = size;
    }


    @Override
    public void setFontAwesomeIcon(IconType iconType) {
        fontAwesomeIcon = iconType;
    }

    @Override
    public IconType getFontAwesomeIcon() {
        return fontAwesomeIcon;
    }

    @Override
    public void setGlyphicon(GlyphiconType iconType) {
        glyphicon = iconType;
    }

    @Override
    public GlyphiconType getGlyphicon() {
        return glyphicon;
    }

    @Override
    public void clearIcon() {
        fontAwesomeIcon = null;
        glyphicon = null;
    }

    @Override
    public void setIconSize(IconSize iconSize) {
        this.iconSize = iconSize;
    }

    @Override
    public IconSize getIconSize() {
        return iconSize;
    }

    @Override
    public void setIconFlip(IconFlip iconFlip) {
        this.iconFlip = iconFlip;
    }

    @Override
    public IconFlip getIconFlip() {
        return iconFlip;
    }

    @Override
    public void setIconRotate(IconRotate iconRotate) {
        this.iconRotate = iconRotate;
    }

    @Override
    public IconRotate getIconRotate() {
        return iconRotate;
    }

    @Override
    public void setIconBordered(boolean iconBordered) {
        this.iconBordered = iconBordered;
    }

    @Override
    public boolean isIconBordered() {
        return iconBordered;
    }

    @Override
    public void setIconMuted(boolean iconMuted) {
        this.iconMuted = iconMuted;
    }

    @Override
    public boolean isIconMuted() {
        return iconMuted;
    }

    @Override
    public void setIconLight(boolean iconLight) {
        this.iconLight = iconLight;
    }

    @Override
    public boolean isIconLight() {
        return iconLight;
    }

    @Override
    public void setIconSpin(boolean iconSpin) {
        this.iconSpin = iconSpin;
    }

    @Override
    public boolean isIconSpin() {
        return iconSpin;
    }

    @Override
    public void setIconPosition(IconPosition iconPosition) {
        this.iconPosition = iconPosition;
    }

    @Override
    public IconPosition getIconPosition() {
        return iconPosition;
    }

}