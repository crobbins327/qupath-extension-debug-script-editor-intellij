/*-
 * #%L
 * This file is part of QuPath.
 * %%
 * Copyright (C) 2014 - 2016 The Queen's University of Belfast, Northern Ireland
 * Contact: IP Management (ipmanagement@qub.ac.uk)
 * Copyright (C) 2018 - 2020 QuPath developers, The University of Edinburgh
 * %%
 * QuPath is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * QuPath is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License 
 * along with QuPath.  If not, see <https://www.gnu.org/licenses/>.
 * #L%
 */

package qupath.lib.gui.scripting.debugscripteditor;


import org.controlsfx.control.action.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import qupath.lib.gui.QuPathGUI;
import qupath.lib.gui.extensions.QuPathExtension;

/**
 * 
 * @author Peter Haub,  01'2021
 *
 */
public class DebugScriptEditorExtension implements QuPathExtension {
	
	private static Logger logger = LoggerFactory.getLogger(DebugScriptEditorExtension.class);
	
	private static boolean alreadyInstalled = false;
	
	protected Action runDebugScriptAction;

	@Override
	public void installExtension(QuPathGUI qupath) {
		if (alreadyInstalled)
			return;
		try {			
			// Add DebugScriptEditor
			Menu menu = qupath.getMenu("Automate", true);
			MenuItem item = new MenuItem("Show DebugScriptEditor");
			item.setOnAction(e -> {
				new DefaultDebugScriptEditor(qupath).showEditor();
			});
			
			menu.getItems().add(2, new SeparatorMenuItem());		
			menu.getItems().add(3, item);	
			
		} catch (Throwable t) {
			logger.debug("Unable to add DebugScriptEditor to menu", t);
		}
	}

	@Override
	public String getName() {
		return "DebugScriptEditor extension";
	}

	@Override
	public String getDescription() {
		return "Add DebugScriptEditor to QuPath menu";
	}	
	
	
}