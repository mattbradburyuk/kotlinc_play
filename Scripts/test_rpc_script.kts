import net.corda.client.rpc.CordaRPCClient
import net.corda.core.utilities.NetworkHostAndPort
import net.corda.core.utilities.NetworkHostAndPort.Companion.parse
import net.corda.core.utilities.loggerFor
import org.slf4j.LoggerFactory

/**
 * Connects to a Corda node via RPC and performs RPC operations on the node.
 *
 * The RPC connection is configured using command line arguments.
 */

println("script start")


// could move these to a config file

val nodeAddress = NetworkHostAndPort("localhost",10013)
val rpcUsername = "user1"
val rpcPassword = "test"



val client = CordaRPCClient(hostAndPort = nodeAddress)
val proxy = client.start(rpcUsername, rpcPassword).proxy


val nodes = proxy.networkMapSnapshot()
println("nodes: $nodes")

/*
fun main(args: Array<String>) = Client().main(args)

private class Client {


    fun (args: Array<String>) {
        // Create an RPC connection to the node.

        println("args: ${args[0]}")



        require(args.size == 3) { "Usage: Client <node address> <rpc username> <rpc password>" }
        val nodeAddress = parse(args[0])
        val rpcUsername = args[1]
        val rpcPassword = args[2]
        val client = CordaRPCClient(nodeAddress)
        val proxy = client.start(rpcUsername, rpcPassword).proxy

        // Interact with the node.
        // For example, here we print the nodes on the network.
        val nodes = proxy.networkMapSnapshot()
        println("nodes: $nodes")

    }
}
*/
