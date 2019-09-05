#!/bin/bash
docker build -t javaevents/2019-oc1-dev3111 .
#docker tag javaevents/2019-oc1-dev3111:latest javaevents/2019-oc1-dev3111:20190826-001
#docker push javaevents/2019-oc1-dev3111:20190826-001
docker push javaevents/2019-oc1-dev3111:latest
