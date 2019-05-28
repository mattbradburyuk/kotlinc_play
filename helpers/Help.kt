package helpers


fun help() {

  val str = """

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

  """

  println(str)

}
