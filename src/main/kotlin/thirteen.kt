package thirteen

val sequence = longArrayOf(1, 10, 9, 12, 3, 4, 1)

fun thirt(n: Long): Long {
    var currentSum =
        n.toString().reversed().map { it - '0' }.mapIndexed { i, c -> sequence[i % sequence.size] * c }.sum().toLong()
    return if (currentSum == n) n else thirt(currentSum)
}
