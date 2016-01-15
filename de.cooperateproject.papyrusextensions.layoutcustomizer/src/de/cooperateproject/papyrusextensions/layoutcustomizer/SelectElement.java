package de.cooperateproject.papyrusextensions.layoutcustomizer;

import java.util.ArrayList;
import java.util.Iterator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.views.modelexplorer.*;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.IPage;

public class SelectElement {

	public void setSelectedElementsInEditor() {
	}

	public static void setSelectedElementsInModelExplorer() {

		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
		IViewPart modelexplorer;
		// Getting the selection and put it in an ArrayList
		ISelection selection = window.getActivePage().getSelection();
		Iterator<?> selectionIterator = ((IStructuredSelection) selection).iterator();
		ArrayList<Object> semanticElementList = new ArrayList<Object>();
		while (selectionIterator.hasNext()) {
			Object currentSelection = selectionIterator.next();
			Object semanticElement = EMFHelper.getEObject(currentSelection);
			if (semanticElement != null) {
				semanticElementList.add(semanticElement);
				// get the modelexplorerView and select the elements there.
				try {
					modelexplorer = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
							.showView(ModelExplorerPageBookView.VIEW_ID);
					ModelExplorerPageBookView view = (ModelExplorerPageBookView) modelexplorer;
					IPage currentPage = view.getCurrentPage();
					ModelExplorerPage page = (ModelExplorerPage) currentPage;
					IViewPart viewer = page.getViewer();
					ModelExplorerView modelExplorerView = (ModelExplorerView) viewer;
					modelExplorerView.setFocus();
					modelExplorerView.revealSemanticElement(semanticElementList);
				} catch (PartInitException ex) {
					System.out.println("ERROR");
					return;
				}
			}
		}
	}
}