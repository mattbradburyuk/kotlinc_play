import net.corda.yo.*


val bnoproxy = connect(10013)
val aproxy = connect(10023)
val bproxy = connect(10033)
val bnoparty = getParty(bnoproxy)
val aparty = getParty(aproxy)
val bparty = getParty(bproxy)



