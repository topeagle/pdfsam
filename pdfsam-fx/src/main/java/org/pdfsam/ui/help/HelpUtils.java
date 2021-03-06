/* 
 * This file is part of the PDF Split And Merge source code
 * Created on 15 dic 2015
 * Copyright 2013-2014 by Andrea Vacondio (andrea.vacondio@gmail.com).
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as 
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.pdfsam.ui.help;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import javafx.geometry.Point2D;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;

/**
 * @author Andrea Vacondio
 *
 */
public final class HelpUtils {

    private HelpUtils() {
        // hide
    }

    /**
     * Creates an help icon that shows a popup with the given message
     * 
     * @param text
     * @return the help icon
     */
    public static final Text helpIcon(String text) {
        HelpPopup popup = new HelpPopup(text);
        return helpIcon(popup);
    }

    /**
     * Creates an help icon that shows a popup with the given content
     * 
     * @param text
     * @return the help icon
     */
    public static final Text helpIcon(Region content) {
        HelpPopup popup = new HelpPopup(content);
        return helpIcon(popup);
    }

    private static Text helpIcon(HelpPopup popup) {
        Text icon = GlyphsDude.createIcon(MaterialDesignIcon.HELP_CIRCLE, "1.1em");
        icon.setOnMouseEntered(e -> {
            Point2D p = icon.localToScreen(icon.getLayoutBounds().getMaxX(), icon.getLayoutBounds().getMaxY());
            popup.show(icon, p.getX(), p.getY());
        });
        icon.setOnMouseExited(e -> popup.hide());
        return icon;
    }
}
