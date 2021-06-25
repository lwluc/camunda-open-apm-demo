# Camunda + Open APM  <!-- omit in toc -->

A small demo to show how you can monitor Camunda and the surrounding systems with Open Source APM tools ([openapm.io](https://openapm.io)).

The landscape we use:

[![openapm.io](./assets/openapm-io-landscape.png "openapm.io1")](https://openapm.io/landscape?agent=inspectit-ocelot-agent&collector=zipkin-server&storage=influx-db&visualization=zipkin-server&dashboarding=grafana&alerting=grafana&showCommercial=true&showFormats=false)

## Table of Contents <!-- omit in toc -->

- [✨ Features](#-features)
- [🚀 Getting Started](#-getting-started)

## ✨ Features

- Grafana Dashboard, e.g. http://localhost:3001/d/Kx4wbZRZk/service-graph  
  You could log in as User with **username** `admin` and **password** `demo`

- Zipkin UI: http://localhost:9411/

You can start the Camunda example process manually via the Tasklist under http://localhost:7777/camunda/app/tasklist/, login as User with **username** `admin` and **password** `pw`.

The process contains a service task which calls an external service.

## 🚀 Getting Started

To start the docker container run `docker-compose up`.
