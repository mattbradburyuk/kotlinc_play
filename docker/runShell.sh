#!/usr/bin/env bash


CORDACLASSPATH="corda-4.0.jar:\
./jars/corda-core-4.0.jar:\
./jars/corda-rpc-4.0.jar:\
./jars/slf4j-api-1.7.25.jar:\
./jars/caffeine-2.6.2.jar:\
./jars/corda-serialization-4.0.jar:\
./jars/proton-j-0.27.1.jar:\
./jars/corda-node-api-4.0.jar:\
./jars/artemis-core-client-2.6.2.jar:\
./jars/artemis-commons-2.6.2.jar:\
./jars/jboss-logging-3.3.2.Final.jar:\
./jars/bcprov-jdk15on-1.60.jar:\
./jars/commons-lang-2.6.jar:\
./jars/eddsa-0.2.0.jar:\
./jars/commons-beanutils-1.9.3.jar:\
./jars/jcl-over-slf4j-1.7.25.jar:\
./jars/guava-25.1-jre.jar:\
./jars/quasar-core-0.7.10-jdk8.jar:\
./jars/rxjava-1.3.8.jar:\
./jars/netty-common-4.1.22.Final.jar:\
./jars/netty-transport-native-epoll-4.1.22.Final-linux-x86_64.jar:\
./jars/netty-transport-native-kqueue-4.1.22.Final-osx-x86_64.jar:\
./jars/netty-transport-4.1.22.Final.jar:\
./jars/netty-resolver-4.1.22.Final.jar:\
./jars/netty-buffer-4.1.22.Final.jar:\
./jars/netty-codec-4.1.22.Final.jar:\
./jars/netty-handler-4.1.22.Final.jar"


CORDAPPS=$(echo cordapps/*.jar | tr ' ' ':')


echo $CORDACLASSPATH
echo $CORDAPPS


echo $CORDACLASSPATH:$CORDAPPS

kotlinc-jvm  -classpath $CORDACLASSPATH:$CORDAPPS

