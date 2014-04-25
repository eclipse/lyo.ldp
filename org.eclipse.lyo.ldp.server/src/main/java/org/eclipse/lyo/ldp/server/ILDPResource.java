/*******************************************************************************
 * Copyright (c) 2014 IBM Corporation.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 *  
 *  The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 *  and the Eclipse Distribution License is available at
 *  http://www.eclipse.org/org/documents/edl-v10.php.
 *  
 *  Contributors:
 *  
 *     Steve Speicher - support for various container types
 *******************************************************************************/
package org.eclipse.lyo.ldp.server;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.core.Response;

public interface ILDPResource {

	public abstract String getURI();

	public abstract void setURI(String resourceURI);

	public abstract Object getModel();

	public abstract void setModel(Object model);

	public abstract String getTypeURI();
	
	/**
	 * Set the value of the container or member resource to the content of the specified stream.
	 * <p>The Content-Type of the input stream is specified by the
	 * <code>contentType</code> argument. Supported values are "application/rdf+xml",
	 * "text/turtle", and "application/x-turtle".</p>
	 * @param resourceURI the URI of the BPC or a member resource.
	 * @param stream the input stream containing the resource representation.
	 * @param contentType the Content-Type of the input stream.
	 */
	public abstract void put(String resourceURI, InputStream stream,
			String contentType, String user);

	public abstract void patch(String resourceURI, InputStream stream,
			String contentType, String user);

	/**
	 * Delete the specified member resource and remove it from the container.
	 * @param resourceURI the URI of the resource to delete.
	 */
	public abstract void delete(String resourceURI);

	/**
	 * Get the container or member resource with the specified URI.
	 * <p>The Content-Type of which to write the model is specified by the
	 * <code>contentType</code> argument. Supported values are "application/rdf+xml",
	 * "text/turtle", and "application/x-turtle".</p>
	 * @param resourceURI the URI of the BPC (or one of its pages) or a member resource.
	 * @param contentType the Content-Type of which to write the model.
	 * @return the HTTP response
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	public abstract Response get(String resourceURI, String contentType);


}