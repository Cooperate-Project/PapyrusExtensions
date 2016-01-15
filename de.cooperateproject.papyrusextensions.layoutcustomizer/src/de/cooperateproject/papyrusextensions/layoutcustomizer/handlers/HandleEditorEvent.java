/**
 * 
 */
/**
 * @author kiehl
 *
 */
package de.cooperateproject.papyrusextensions.layoutcustomizer.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import de.cooperateproject.papyrusextensions.layoutcustomizer.SelectElement;

public class HandleEditorEvent extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		SelectElement.setSelectedElementsInModelExplorer();
		return null;
	}

}