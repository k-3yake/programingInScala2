package chapter20_AbstractMember

abstract class CurrencyZone {
  type Currency <: AbstractCurrency
  def make(x: Long): Currency
  val CurrencyUnit: Currency
  abstract class AbstractCurrency {
    val amount: Long
    val designation: String
    def + (that: Currency):Currency = make(this.amount + that.amount)
    def * (x: Double):Currency = make((this.amount * x).toLong)
    //def from (that: CurrencyZone#AbstractCurrency) = make(this.amount)
    def from (that: CurrencyZone#AbstractCurrency) = {
      make(Math.round(that.amount.toDouble * Converter.exchangeRate(that.designation)(this.designation)))
    }
    override def toString()={
      ((amount.toDouble / CurrencyUnit.amount.toDouble).formatted("%." + decimals(CurrencyUnit.amount) + "f")
        + " " + designation)
    }
    def decimals(n: Long): Int = if(n==1) 0 else 1 + decimals(n/10)
  }

  object Converter{
    var exchangeRate = Map{ "USD" -> Map( "JPY" -> 1.211 )  }
  }
}

object US extends CurrencyZone {
  abstract class Dollar extends AbstractCurrency {
    val designation = "USD"
  }
  override type Currency = Dollar
  val Dollar = make(100)
  val CurrencyUnit = Dollar
  override def make(cent: Long): Currency = new Dollar { val amount = cent }
}

object Japan extends CurrencyZone {
  abstract class Yen extends AbstractCurrency {
    val designation = "JPY"
  }
  override type Currency = Yen
  val Yen = make(1)
  val CurrencyUnit = Yen
  override def make(yen: Long): Currency = new Yen { val amount = yen }
}

object Europe extends CurrencyZone {
  abstract class Euro extends AbstractCurrency {
    override val designation: String = "EUR"
  }
  override type Currency = Euro
  override def make(x: Long) = new Euro {val amount = x }
  override val CurrencyUnit:Currency = make(100)
}


