const val SECONDS_IN_DAY = 86400U

fun main() {
    var time : UInt
    while (true) {
        print("Введите время в секундах: ")
        time = readLine()?.toUIntOrNull() ?: continue
        println("был(а) " + agoToText(time))
    }
}

fun agoToText(time : UInt): String {
    return when (time) {
        in 0U..60U -> "только что"
        in 61U until 3600U -> minuteAgoToText(time)
        in 3600U until SECONDS_IN_DAY -> hoursAgoToText(time)
        in SECONDS_IN_DAY until 2U * SECONDS_IN_DAY -> "сегодня"
        in 2U * SECONDS_IN_DAY until 3U * SECONDS_IN_DAY -> "вчера"
        else -> "давно"
    }
}

fun minuteAgoToText(time: UInt): String {
    val minutes = time / 60U
    return "в сети $minutes" + when {
        minutes in 11U..14U -> " минут назад"
        minutes % 10U == 1U -> " минуту назад"
        minutes % 10U in 2U..4U -> " минуты назад"
        else -> " минут назад"
    }
}

fun hoursAgoToText(time: UInt): String {
    val hours = time / 3600U
    return hours.toString() + when {
        hours in 11U..14U -> " часов назад"
        hours % 10U == 1U -> " час назад"
        hours % 10U in 2U..4U -> " часа назад"
        else -> " часов назад"
    }
}


