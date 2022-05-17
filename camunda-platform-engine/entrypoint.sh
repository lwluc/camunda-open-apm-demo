#!/bin/bash

JAVA_AGENT_PATH=$1

java_command_options=""

if [ ! -z "$JAVA_AGENT_ENABLED" ]; then
  echo "Adding Agnet [$JAVA_AGENT_ENABLED]"
  java_command_options="-javaagent:./inspectit-ocelot-agent.jar"
fi

java ${java_command_options}  -jar /usr/app/application.jar