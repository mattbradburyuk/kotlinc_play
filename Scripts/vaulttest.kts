//bnoproxy.vaultQueryBy<ContractState>(crit, PageSpecification(), Sort(emptySet())

import net.corda.core.node.services.vault.*
import net.corda.core.contracts.*
import net.corda.core.node.services.*

//val criteria: QueryCriteria = QueryCriteria.VaultQueryCriteria()


val fhandle = bnoproxy.startFlowDynamic(YoFlow::class.java , aparty)

println(fhandle.returnValue.get())



val criteria: QueryCriteria = QueryCriteria.VaultQueryCriteria(Vault.StateStatus.ALL)
//val paging: PageSpecification = PageSpecification()
//val sorting: Sort = Sort(emptySet())): Vault.Page<ContractState>

val result = aproxy.vaultQueryByCriteria<ContractState>(criteria, YoState::class.java)
//
//bnoproxy.vaultQueryByCriteria<ContractState>(criteria, ContractState::class.java)

pretty(result)