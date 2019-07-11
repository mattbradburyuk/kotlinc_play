FROM openjdk:8u181-jre


# Install Kotlin
RUN cd /usr/lib && \
    wget https://github.com/JetBrains/kotlin/releases/download/v1.2.71/kotlin-compiler-1.2.71.zip && \
    unzip kotlin-compiler-*.zip && \
    rm kotlin-compiler-*.zip && \
    rm -f kotlinc/bin/*.bat
ENV PATH $PATH:/usr/lib/kotlinc/bin

# Install Corda
RUN mkdir -p /opt/corda/cordapps
WORKDIR /opt/corda
RUN wget https://azureblockchainworkbench.blob.core.windows.net/artifacts/corda/corda-4.0.jar
RUN unzip corda-4.0.jar -d jars


# setup shell
COPY ./runShell.sh .
RUN chmod +x ./runShell.sh
CMD "./runShell.sh"
