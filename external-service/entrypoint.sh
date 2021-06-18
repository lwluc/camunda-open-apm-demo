#!/bin/bash

JAVA_AGENT_PATH=$1

java_command_options=""

if [ -n "$JAVA_AGENT_PATH" ]; then
  echo Adding Agnet $JAVA_AGENT_PATH
  java_command_options="-javaagent:$JAVA_AGENT_PATH"
fi

cd /app && java ${java_command_options} -jar target/external-service-0.0.1-SNAPSHOT.jar