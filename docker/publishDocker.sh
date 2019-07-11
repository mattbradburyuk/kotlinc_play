#!/usr/bin/env bash


docker tag corda-kotlin-shell:latest ianmorgan/corda-kotlin-shell:$1
docker push ianmorgan/corda-kotlin-shell:$1

