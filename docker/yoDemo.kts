// an example using the yo app - updated connection and node details as required


import net.corda.client.rpc.CordaRPCClient
import net.corda.core.utilities.NetworkHostAndPort
import net.corda.core.utilities.NetworkHostAndPort.Companion.parse
import net.corda.core.utilities.loggerFor
import org.slf4j.LoggerFactory
import net.corda.core.flows.FlowLogic
import java.util.concurrent.TimeUnit

val nodeAddress = NetworkHostAndPort("host.docker.internal",10011)
val rpcUsername = "user1"
val rpcPassword = "test"

val client = CordaRPCClient(hostAndPort = nodeAddress)
val proxy = client.start(rpcUsername, rpcPassword).proxy

val james = proxy.partiesFromName("James", false ).first()
val yoFlow = Class.forName("net.corda.yo.YoFlow")

val result = proxy.startFlowDynamic(yoFlow  as Class<FlowLogic<Any>>,james)
val signed = result.returnValue.get(30, TimeUnit.SECONDS)
println(signed)

