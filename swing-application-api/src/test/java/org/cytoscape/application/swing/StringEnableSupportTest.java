package org.cytoscape.application.swing;

import static org.junit.Assert.*;

import javax.swing.JMenuItem;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.view.model.CyNetworkViewManager;
import org.cytoscape.work.swing.DynamicSubmenuListener;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class StringEnableSupportTest {
	
	private StringEnableSupport support;
	
	@Mock private DynamicSubmenuListener action;
	private String enableFor = StringEnableSupport.ENABLE_FOR_NETWORK;
	@Mock private CyApplicationManager applicationManager;
	@Mock private CyNetworkViewManager networkViewManager;
	@Mock private DynamicSubmenuListener submenuListener;

	private JMenuItem menuItem = new JMenuItem();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		support = new StringEnableSupport(action, enableFor, applicationManager, networkViewManager);
	}

	@Test
	public void testUpdateEnableState() {
		support = new StringEnableSupport(action,StringEnableSupport.ENABLE_FOR_NETWORK, applicationManager, networkViewManager);
		support.updateEnableState();
		assertFalse(support.isCurrentlyEnabled());
		
		support = new StringEnableSupport(action,StringEnableSupport.ENABLE_FOR_NETWORK_AND_VIEW, applicationManager, networkViewManager);
		support.updateEnableState();
		assertFalse(support.isCurrentlyEnabled());
		
		support = new StringEnableSupport(action,StringEnableSupport.ENABLE_FOR_NETWORK_WITHOUT_VIEW, applicationManager, networkViewManager);
		support.updateEnableState();
		assertFalse(support.isCurrentlyEnabled());
		
		support = new StringEnableSupport(action,StringEnableSupport.ENABLE_FOR_SELECTED_EDGES, applicationManager, networkViewManager);
		support.updateEnableState();
		assertFalse(support.isCurrentlyEnabled());
		
		support = new StringEnableSupport(action,StringEnableSupport.ENABLE_FOR_SELECTED_NODES, applicationManager, networkViewManager);
		support.updateEnableState();
		assertFalse(support.isCurrentlyEnabled());
		
		support = new StringEnableSupport(action,StringEnableSupport.ENABLE_FOR_SELECTED_NODES_OR_EDGES, applicationManager, networkViewManager);
		support.updateEnableState();
		assertFalse(support.isCurrentlyEnabled());
		
		support = new StringEnableSupport(action,StringEnableSupport.ENABLE_FOR_TABLE, applicationManager, networkViewManager);
		support.updateEnableState();
		assertFalse(support.isCurrentlyEnabled());
		
		support = new StringEnableSupport(action,null, applicationManager, networkViewManager);
		support.updateEnableState();
		assertTrue(support.isCurrentlyEnabled());
	}

	@Test
	public void testStringEnableSupportConstructor() {
		support = new StringEnableSupport(action, enableFor, applicationManager, networkViewManager);
		assertNotNull(support);
		support = new StringEnableSupport(submenuListener, enableFor, applicationManager, networkViewManager);
		assertNotNull(support);
		support = new StringEnableSupport(menuItem, enableFor, applicationManager, networkViewManager);
		assertNotNull(support);
	}
}