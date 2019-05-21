package helpers

//fun makeStringPretty(str: String){
fun pretty(obj: Any){

    val str = obj.toString()

    var offset = 0
    val TAB = 4
/*
  40 -> (
  41 -> )
  [ -> 91
  ] -> 93
  , -> 44

*/
    var newStr = ""

    for (i in str){

        when(i){
            // [
            40.toChar() -> {
                offset = offset + TAB
                newStr = "$newStr$i\n${addspace(offset)}"
            }
            // (
            91.toChar() -> {
                offset = offset + TAB
                newStr = "$newStr$i\n${addspace(offset)}"
            }
            // ,
            44.toChar() -> {
              newStr = "$newStr$i\n${addspace(offset)}"
            }
            // ]
            41.toChar() -> {
                offset = offset - TAB
                newStr = "$newStr$i"
            }
            // )
            93.toChar() -> {
              offset = offset - TAB
              newStr = "$newStr$i"
            }
            // space
            32.toChar() -> {

            }
            else -> newStr = "$newStr$i"

        }
    }
    println(newStr)
}



fun addspace(x: Int): String{

    var str = ""
    repeat(x){
        str = "$str "
    }
    return str
}
