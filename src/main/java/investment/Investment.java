package investment;

public class Investment {
  private final int investmentAmmount;
  private final int yearlyIncome;

  public Investment(int investmentAmmount, int yearlyIncome) {
    this.investmentAmmount = investmentAmmount;
    this.yearlyIncome = yearlyIncome;
  }

  public int getInvestmentAmmount() {
    return this.investmentAmmount;
  }
  public int getyearlyIncome() {
    return this.yearlyIncome;
  }
}
