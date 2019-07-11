#!/usr/bin/env bash
docker run  \
 -v /Users/ianmorgan/.ccl-local-network/pets/blinky_node/cordapps:/opt/corda/cordapps \
 -it corda-kotlin-shell
