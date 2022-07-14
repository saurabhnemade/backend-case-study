## Architecture

We have two servers. One written in java and one written in nodejs

The java server is the mapping server. It is responsible for handling all the heavy lifting in terms of edifact mapping.

The nodejs server is the aggregation server. It is responsible for handling requests in terms of API aggregation.

## Status quo

Right now both serve are running on the same machine under different services.

## Improvements

Create dockerfiles for both servers and start both services using docker-compose.