package helpers

import net.corda.core.messaging.CordaRPCOps
import net.corda.core.identity.Party

fun getParty(proxy: CordaRPCOps): Party{


    val nodeInfo = proxy.nodeInfo()

    val legalIdentitiesAndCerts = nodeInfo.legalIdentitiesAndCerts

    if (legalIdentitiesAndCerts.size > 1) {

        println("more than one party, returning first in list")

    }

    return legalIdentitiesAndCerts[0].party


}