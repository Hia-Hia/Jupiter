/*
 * Copyright (c) 2015 The Jupiter Project
 *
 * Licensed under the Apache License, version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jupiter.rpc;

import org.jupiter.registry.Registry;
import org.jupiter.rpc.model.metadata.ServiceWrapper;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * The rpc server.
 *
 * jupiter
 * org.jupiter.rpc
 *
 * @author jiachun.fjc
 */
public interface JServer extends Registry {

    /**
     * Service registry.
     */
    interface ServiceRegistry {

        /**
         * Sets up the service provider.
         */
        ServiceRegistry provider(Object serviceProvider);

        /**
         * The proprietary processors for this provider.
         */
        ServiceRegistry executor(Executor executor);

        /**
         * Register this provider to local.
         */
        ServiceWrapper register();
    }

    /**
     * To obtains a service registry.
     */
    ServiceRegistry serviceRegistry();

    /**
     * Looks for the specified service.
     */
    ServiceWrapper lookupService(Directory directory);

    /**
     * Removes the registered service.
     */
    ServiceWrapper removeService(Directory directory);

    /**
     * Returns all the registered services.
     */
    List<ServiceWrapper> getRegisteredServices();

    /**
     * Publishing a service.
     * @param serviceWrapper service provider wrapper, created by {@link ServiceRegistry}.
     */
    void publish(ServiceWrapper serviceWrapper);

    /**
     * Publishing a service.
     * @param serviceWrapper service provider wrapper, created by {@link ServiceRegistry}.
     * @param weight the weight of this provider at current server.
     */
    void publish(ServiceWrapper serviceWrapper, int weight);

    /**
     * Publishing all services.
     */
    void publishAll();

    /**
     * Publishing all services.
     * @param weight the weight of these providers at current server.
     */
    void publishAll(int weight);
}
