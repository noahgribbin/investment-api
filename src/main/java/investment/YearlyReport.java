package investment;

public class YearlyReport  {
  private double price;
  private double income;
  private double incomeAfterIflation;
  private double cashflow;

  public YearlyReport(double price, double income, double incomeAfterIflation, double cashflow) {
    this.price = price;
    this.income = income;
    this.incomeAfterIflation = incomeAfterIflation;
    this.cashflow = cashflow;
  };

  public double getPrice() {
    return this.price;
  }
  public double getIncome() {
    return this.income;
  }
  public double getincomeAfterInflation() {
    return this.incomeAfterIflation;
  }
  public double getCashflow() {
    return this.cashflow;
  }
}
