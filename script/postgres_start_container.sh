#!/usr/bin/env bash

docker rm -f postgres
docker run --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=mysecretpassword -d postgres