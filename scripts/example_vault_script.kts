/*
Example script which starts a flow, resolves the flowhandle , performs a vault query and displays the pretty results

Note, you would need to set up a network with a bno and PartyA node, and run setupYo.kts for this to run

 */


// immports some classes needed in the code below

import net.corda.core.node.services.vault.*
import net.corda.core.contracts.*
import net.corda.core.node.services.*


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

