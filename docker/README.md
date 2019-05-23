# Creating and Running under Docker  

## Building images 

Use the Dockerfile. `./buildDocker.sh` has the default scripts for building new images

## Running 

```bash
.\runDocker.sh 
```

This will start a container with an interactive console connected to the Kotlin shell 

## Connecting to a Corda Node

As this is now running under Docker, you will need to ensure that your Docker container
can resolve the host correctly. If having problems, try this to investigate 

```bash
docker exec -it <container-name-or-id> /bin/bash
apt-get update 
apt-get install telnet 
telnet <host> <port>
```

If Docker is running on the same host as your nodes (common for local development), 
you will probably need to resort to one of these tricks:

### OSX

Use `host.docker.internal` for the address of your node 

### Windows 

TODO 

### Ubuntu 

TODO 
