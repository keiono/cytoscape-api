package org.cytoscape.view.vizmap.gui.editor;

import javax.swing.table.TableCellRenderer;

/**
 * A factory for creating TableCellRenderers for a particular ContinuousMappingEditor.
 *  
 * @CyAPI.Api.Interface
 * @CyAPI.InModule vizmap-gui-api
 */
public interface ContinuousMappingCellRendererFactory {
	 TableCellRenderer createTableCellRenderer(ContinuousMappingEditor<? extends Number, ?> editor);
}
