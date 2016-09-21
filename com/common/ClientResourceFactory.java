package com.common;

import org.restlet.Client;
import org.restlet.Context;
import org.restlet.data.Protocol;
import org.restlet.resource.ClientResource;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ClientResourceFactory {

    public ClientResource getClientResource(String url, int connectionTimeOutInMilliSeconds) {
        ClientResource clientResource = new ClientResource(url);
        Context context = new Context();
        context.getParameters().add("socketTimeout", String.valueOf(connectionTimeOutInMilliSeconds));
        clientResource.setNext(new Client(context, Arrays.asList(Protocol.HTTP, Protocol.HTTPS)));
        return clientResource;
    }
}
