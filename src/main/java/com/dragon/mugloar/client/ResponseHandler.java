package com.dragon.mugloar.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;

/**
 * Handles http response from game client
 * @author gusciarv
 */
class ResponseHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ResponseHandler.class);

    /**
     * Converts http response to entity which class is provided by parameter
     * @param response - http response from the client
     * @param className - class name to convert response to
     * @param <T> - type of class
     * @return entity from response
     */
    public static <T> T handleResponse(Response response, Class<T> className) {
        if (handleStatus(response)) {
            return response.readEntity(className);
        }
        return null;
    }

    private static boolean handleStatus(Response response) {
        switch (response.getStatus()) {
            case 200 : {
                return true;
            }
            default: {
                LOG.error("Response status: {}. Response body: {}", response.getStatus(), response.readEntity(String.class));
                throw new RuntimeException("exception calling game api");
            }
        }
    }
}
