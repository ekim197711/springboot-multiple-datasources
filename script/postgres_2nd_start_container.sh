#!/usr/bin/env bash

docker rm -f postgressport
docker run --name postgressport -p 5532:5432 -e POSTGRES_PASSWORD=secret1234 -d postgres