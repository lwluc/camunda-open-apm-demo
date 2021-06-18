# Camunda + Open APM

A small demo to show how one can monitor Camunda and the surrounding systems with Open Source APM tools ([openapm.io](https://openapm.io)). 

Start all the components with `docker-compose up` and start monitoring the environment with the following tools: 

- Grafan: http://localhost:3001/d/Kx4wbZRZk/service-graph
  You could log in as User with **username** `admin` and **password** `demo`

- Zipkin: http://localhost:9411/

You can start the Camunda exemaple process manually via the Tasklist under http://localhost:7777/camunda/app/tasklist/, login as User with **username** `admin` and **password** `pw`.


The process contains a service task which calls an external service.