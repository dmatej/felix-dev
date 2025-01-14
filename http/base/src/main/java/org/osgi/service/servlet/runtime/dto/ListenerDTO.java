/*******************************************************************************
 * Copyright (c) Contributors to the Eclipse Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0 
 *******************************************************************************/

package org.osgi.service.servlet.runtime.dto;

import org.osgi.dto.DTO;

/**
 * Represents a listener currently being used by a servlet context.
 * 
 * @NotThreadSafe
 * @author $Id: d774ac5b249f95b9f5f684830f3854ce225835cf $
 */
public class ListenerDTO extends DTO {

	/**
	 * The fully qualified type names the listener. This array is never empty.
	 */
	public String[]				types;

	/**
	 * Service property identifying the listener. In the case of a Listener
	 * registered in the service registry and picked up by a Http Whiteboard
	 * Implementation, this value is not negative and corresponds to the service
	 * id in the registry. If the listener has not been registered in the
	 * service registry, the value is negative and a unique negative value is
	 * generated by the Http Service Runtime in this case.
	 */
	public long					serviceId;

	/**
	 * The service id of the servlet context for the listener represented by
	 * this DTO.
	 */
	public long		servletContextId;
}
