#!/bin/bash

APP_NAME="your-custom-name.jar"
JVM_OPTS="-Xms512m -Xmx1024m -XX:MetaspaceSize=256m -XX:MaxMetaspaceSize=512m"

java $JVM_OPTS -jar $APP_NAME