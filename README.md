# Camunda + Open APM  <!-- omit in toc -->

A small demo to show how you can monitor Camunda and the surrounding systems with Open Source Application Performance Management (APM) tools.

The landscape we use:

![Architecture](./assets/camunda-open-apm-demo.png "Components and how they interact with each other").

## Table of Contents <!-- omit in toc -->

- [✨ Features](#-features)
- [🚀 Getting Started](#-getting-started)
- [🏛 Architecture](#-architecture)

## ✨ Features

- Jaeger at http://localhost:16686
- Zipkin at http://localhost:9411
- Prometheus at http://localhost:9090

You can start the Camunda example process manually via the Camunda [Tasklist](http://localhost:7777/camunda/app/tasklist/), login as user with **username** `admin` and **password** `pw`.

The process contains a service task which calls an external service.

## 🚀 Getting Started

To start the docker container run `docker-compose up`.

## 🏛 Architecture

![Architecture](./assets/camunda-open-apm-demo.png "Components and how they interact with each other").

The image shows all components and how they communicate with each other. The [Camunda Platform Engine](./camunda-platform-engine/) uses a [JavaDelegate]() to fetch data from the [Data Service](./external-service/). The [Mirconaut External Task Worker](./micronaut-client/) fetches task from the engine and loads data from the Data Service and store some information back to the engine.

To monitor all these components and their interactions I added the [OTEL Java Agent](https://opentelemetry.io/docs/instrumentation/java/) to each docker container they are running in. The Agent collects as much information as you want. Using APM Tools like Jaeger, Zipkin or Prometheus you could monitor and analyze them.
