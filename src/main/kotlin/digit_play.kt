import kotlin.math.pow

//
//fun digPow(n: Int, p: Int): Int {
//    val digits = n.toString().toCharArray().map { it.toString().toInt() }
//    var sum = 0
//    for (index in digits.indices)
//    {
//        sum += digits[index].toDouble().pow(p + index).toInt()
//    }
//    for (k in 1..n) {
//        if (sum == n * k) {
//            println("sum: $sum, $n, $k, ${n*k}")
//            return k
//        }
//    }
//    return -1
//}

fun digPow(n: Int, p: Int) = n.toString().mapIndexed { i, c -> c.toString().toDouble().pow(p + i).toInt() }.sum()
    .let { if (it % n == 0) it / n else -1 }