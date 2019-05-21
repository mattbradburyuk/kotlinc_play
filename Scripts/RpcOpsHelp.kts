

val str = """
The key RPC operations exposed by the node are:

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
"""

fun rpcOpsHelp() = println(str)
