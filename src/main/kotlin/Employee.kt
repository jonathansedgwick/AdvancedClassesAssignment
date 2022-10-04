import java.text.DecimalFormat

class Employee constructor(name: String,
                           position: PositionTitle,
                           salary: Boolean,
                           payRate: Double,
                           shift: Int) {

    var round = DecimalFormat("$#,###.00")

    var name: String = ""
        get() = field
        set(value) {
            field = value
        }
    var position: PositionTitle = PositionTitle.ADMINISTRATION
        get() = field
        set(value) {
            field = value
        }
    var salary: Boolean = false
        get() = field
        set(value) {
            field = value
        }
    var payRate: Double = 0.0
        get() = field
        set(value) {
            field = value
        }
    var shift: Int = 0
        get() = field
        set(value) {
            field = value
        }

    init {
        this.name = name
        this.position = position
        this.salary = salary
        this.payRate = payRate
        this.shift = shift
    }
    fun calculate(hoursIn: Int){
        var pay = 0.0
        if (shift == 2)
            payRate *= 1.05
        else if (shift == 3)
            payRate *= 1.10
        if (hoursIn <= 40) {
            pay = hoursIn * payRate
            println("$name earned ${round.format(pay)}")
        }
        else {
            var overHours = hoursIn - 40
            var overPay = payRate * 1.5
            pay = overPay * overHours
            pay += 40 * payRate
            println("$name earned ${round.format(pay)}")
        }


    }

    fun display() {
        println("$name\n${position.pos}\n" +
                "Salary: $salary | Shift: $shift\n" +
                "Rate of ray: $payRate")
    }
}
