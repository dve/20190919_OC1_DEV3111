#!/bin/bash
docker build -t javaevent/2019-OC1-DEV3111 .
#docker tag javaevent/2019-OC1-DEV3111:latest javaevent/2019-OC1-DEV3111:20190826-001
#docker push javaevent/2019-OC1-DEV3111:20190826-001
docker push javaevent/2019-OC1-DEV3111:latest
