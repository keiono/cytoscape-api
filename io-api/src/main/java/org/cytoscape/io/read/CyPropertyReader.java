package org.cytoscape.io.read;

/*
 * #%L
 * Cytoscape IO API (io-api)
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2006 - 2013 The Cytoscape Consortium
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 2.1 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-2.1.html>.
 * #L%
 */

import org.cytoscape.work.Task;

/**
 * An extension of the Task interface that returns a property 
 * object. The type of the object returned can be be anything, 
 * but will in practice be
 * {@link java.util.Properties}, 
 * {@link org.cytoscape.property.bookmark.Bookmarks}, 
 * {@link org.cytoscape.property.session.Cysession}. The system
 * determines the specific object type based on the {@link org.cytoscape.io.CyFileFilter}
 * associated with the InputStreamTaskFactory service that  
 * produces this reader.
 * Instances of this interface are created by InputStreamTaskFactory
 * objects registered as OSGi services, which are in turn processed
 * by associated reader manager objects that distinguish 
 * InputStreamTaskFactories based on the DataCategory associated with
 * the {@link org.cytoscape.io.CyFileFilter}.
 * @CyAPI.Spi.Interface
 * @CyAPI.InModule io-api
 */
public interface CyPropertyReader extends Task {

	/**
	 * Return a property object.
	 * @return A property object.  The type can be
	 * be anything, but in practice will be
	 * {@link java.util.Properties}, 
	 * {@link org.cytoscape.property.bookmark.Bookmarks}, and
	 * {@link org.cytoscape.property.session.Cysession}.
	 */
    Object getProperty();

}

