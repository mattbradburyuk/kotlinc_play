package helpers

import net.corda.client.rpc.CordaRPCClient
import net.corda.core.messaging.CordaRPCOps
import net.corda.core.utilities.NetworkHostAndPort
import net.corda.core.utilities.NetworkHostAndPort.Companion.parse
import net.corda.core.utilities.loggerFor
import org.slf4j.LoggerFactory

/**
 * Connects to a Corda node via RPC and returns a proxy.
 */

fun connect(port: Int,
                 host: String = "localhost",
                 rpcUsername: String = "user1",
                 rpcPassword: String = "test"): CordaRPCOps{

  println("Connecting to node")



  val nodeAddress = NetworkHostAndPort(host,port)

  val client = CordaRPCClient(hostAndPort = nodeAddress)
  val proxy = client.start(rpcUsername, rpcPassword).proxy

  return proxy

}