package com.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.HandlerList;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Properties;

public class RESTMapping
{
    public static void main(String[] args) throws Exception
    {
        Properties properties = new Properties();
        properties.putAll(System.getenv());

        Server server = new Server();

        int httpPort = Integer.parseInt(properties.getProperty("PORT", "8080"));

        // Setup HTTP Connector
        HttpConfiguration httpConf = new HttpConfiguration();

        // Establish the HTTP ServerConnector
        ServerConnector httpConnector = new ServerConnector(server,
                new HttpConnectionFactory(httpConf));
        httpConnector.setPort(httpPort);
        server.addConnector(httpConnector);

        // Add a Handlers for requests
        HandlerList handlers = new HandlerList();
        handlers.addHandler(new UploadHandler());
        server.setHandler(handlers);

        server.start();
        server.join();
    }

    public static class UploadHandler extends AbstractHandler {

        ObjectMapper mapper = new ObjectMapper();
        Order order = new Order("cb84240a-033f-11ed-b2b4-2f6f7b3fe079", "10545bbc-0341-11ed-81dc-effa955c4fe8", "Apple Juice");
        Partner partner = new Partner("10545bbc-0341-11ed-81dc-effa955c4fe8", "Edeka", "Central Street");
        public UploadHandler() throws IOException
        {
            super();
        }

        @Override
        public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
        {

            if (!request.getMethod().equalsIgnoreCase("GET"))
            {
                response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
                return;
            }

            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");

            switch (target) {
                case "/partner":
                    response.getWriter().println(this.mapper.writeValueAsString(this.partner));
                    break;
                case "/order":
                    response.getWriter().println(this.mapper.writeValueAsString(this.order));
                    break;
            }

            response.setStatus(HttpServletResponse.SC_OK);
            baseRequest.setHandled(true);
        }
    }
}