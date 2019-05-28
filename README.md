# Corda Kotlin Shell

## Overview

As a Cordapp developer or Cordapp deployer, having set up a Corda Network with installed Cordapps, I want to be able to interact with my nodes including invoking all the arbitrarily complex Flows of the CorDapps installed on my Corda nodes without having to write a dedicated rpc client, springbot/UI layer, JavaFX app or any other front end/ service layer to trigger the flows.

The current Corda shell allows partial control of a CorDapp but is limited because:
- Some Flows can’t be invoked as the input parameters cannot be represented 
- The shell cannot hold user defined shell variables resulting in commands which are difficult or impossible to construct in one command

The Corda Kotlin Shell gives you a Jetbrain's Kotlin Interactive Shell with some preloaded Corda/ Cordapp specific classes and some extra helper functions to make it easier to connect and interact with your Corda nodes.



## Kotlin Interactive Shell

The Kotlin interactive shell (REPL) is part of the Kotlin Command Line Compiler

For information on downloading, setting up and using the compiler and REPL see: https://kotlinlang.org/docs/tutorials/command-line.html



## Extending the shell to interact with Corda

Follow these steps to set up the Corda extensions to the shell:

(note this is for Mac, I'm not sure how the scripts run on PC)


1. git clone this repo to your local machine.

2. Download the Corda-4.0.jar and put it in the root directory of this project.

3. Put your cordapp jars in the cordapp directory.

4. Run the compileHelpers.sh script (you may need to chmod it so you can run it)

5. Run the startup.sh script (you may need to chmod it so you can run it)

This should give you the Kotlin Shell prompt:
```text
>>> type kotlin commands here

```

6 Import the helper function

```text
>>> import helpers.*

```

This will give you access to a set of helper functions, you can see the helper functions if you type help():

```text

>>> help()


    Note: sometimes the REPL gets confused, especially if you write a single ':' eg,

          >>> some_statment_that_went_wrong_with_an:
          ...
          ...

          try typing '\n' to break out of the statement. If it still behaves strangly, restart the console.


    Helper functions:

        fun help()  --> Prints this help

        fun pretty(obj: Any)  --> formats returned objects to be easier to read

        fun connect(port: Int,
                    host: String = "localhost",
                    rpcUsername: String = "user1",
                    rpcPassword: String = "test")  --> connects to the specified node and returns a proxy


    RPC operations which can be called on the proxy:

        proxy.vaultQueryBy() -> Extract states from the node’s vault based on a query criteria
        proxy.vaultTrackBy() -> As above, but also returns an observable of future states matching the query
        proxy.networkMapFeed() -> A list of network nodes, and an observable of changes to the network map
        proxy.registeredFlows() -> See a list of registered flows on the node
        proxy.startFlowDynamic()-> Start one of the node’s registered flows
        proxy.startTrackedFlowDynamic() -> As above, but also returns a progress handle for the flow
        proxy.nodeInfo() -> Returns information about the node
        proxy.currentNodeTime() -> Returns the current time according to the node’s clock
        proxy.partyFromKey() -> Retrieves a party on the network based on a public key
        proxy.wellKnownPartyFromX500Name() -> Retrieves a party on the network based on an X500 name
        proxy.uploadAttachment() -> Uploads attachments
        proxy.openAttachment() -> Opens attatchments
        proxy.attachmentExists() -> Checks for the existence of attachments


        fun getParty(proxy: CordaRPCOps): Party --> takes a proxy for a node and returns the Party from the nodeInfo, only works with nodes with single Legal identity.


        fun getClass(obj: Any)  --> prints out the javaclass of an object


```

The key function above is connect(). By specifying the port, host and rpc details you can connect over RPC to a node. the function returns a proxy which you can use to interact with you node. 

You can set up many proxies from one shell session. 


## Scripts

When the Shell is restarted it loses its memory of variables you have stored. This is good in that you can easily reset your session, but bad if the thing you are doing requires lots of set up steps. 

Fortunately you can write scripts which you can run in the Shell. 

There is an example script called 'example_script.kts' in the scripts folder. 



```kotlin
println("this is a test script")

var myVar = "This is variable myVar"
```

You can run this script using the load command and access variable created in the script from the shell, eg

```text

>>> :load ./scripts/example_script.kts
this is a test script
>>> myVar
This is variable myVar

```


There is a setup.kts script which imports some of the classes required for starting flows and querying the vault. You can add extra setup steps into this file tomake your setup easier

```text

>>> :load ./scripts/setup.kts

```

example_vault_script.kts shows how you can write a script to start a flow then query the vault on a node: 

```kotlin

// start a flow
val fhandle = bnoproxy.startFlowDynamic(YoFlow::class.java , aparty)

// get the return value for the futre and print the result (should be a signed transaction)
println(fhandle.returnValue.get())

// set up a query criteria
val criteria: QueryCriteria = QueryCriteria.VaultQueryCriteria(Vault.StateStatus.ALL)

// run the query against the vault
val result = aproxy.vaultQueryByCriteria<ContractState>(criteria, YoState::class.java)

// make the results more easy to read
pretty(result)

```

This is more of an example for the syntax as you won't be able to run this script unless you:
 - Have the Yo app installed on your nodes 
 - Have the Yo jar copied in to the cordapps folder in this repo
 - Have a network set up with two nodes, one called BNO and another called PartyA
 - Have run the setupYo.kts script included in this repo



## Extending the helpers and scripts

You can add extra helpers by writing new *.kt files and putting them in the helpers folder. the compileHelpers.sh bash script will compile all .kt files in the helper folder. the startup.sh bash script will automatically load the helpers.jar so they will be included. 

You can write new scripts by just writing a new script, you can save them anywhere but its probably neatest to put them in th scripts folder.


## Stability

The Kotlin shell can be a little temperamental. sometimes the REPL gets confused, especially if you write a single ':' eg,
```text
          >>> some_statment_that_went_wrong_with_an:
          ...
          ...
```

try typing '\n' to break out of the statement. If it still behaves strangly, restart the console.


The code for the Kotlin shell can be found here: https://github.com/JetBrains/kotlin/tree/master/compiler/cli/bin



## Caveat

This is an experimental project, it is not a robust product, use it, play with it, don't rely on it in production.  