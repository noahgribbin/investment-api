package investment;

import java.lang.Math;
public class Investment {
  public double investmentAmount;
  public double yearlyIncome;
  public double yearsInvested = 30;
  public double inflation = 1.8;
  public double priceAppreciation  = 1.05;
  public double incomeAppreciation  = 1.03;

  public double[] cashflows;
  public double ROI;
  public double CAGR;
  public double IRR;

  public Investment(double investmentAmount, int yearlyIncome) {
    this.investmentAmount = investmentAmount;
    this.yearlyIncome = yearlyIncome;
    this.yearsInvested = yearsInvested;
    this.priceAppreciation  = priceAppreciation ;
    this.incomeAppreciation  = incomeAppreciation ;
  }

  public double getInvestmentAmount() {
    return this.investmentAmount;
  }

  public double getyearlyIncome() {
    return this.yearlyIncome;
  }

  public double getLastYearPrice() {
      double lastYearPrice = (Math.pow(this.priceAppreciation , this.yearsInvested) * this.investmentAmount);
      return lastYearPrice;
  }

  public double getLastYearIncome() {
      double lastYearIncome = (Math.pow(this.incomeAppreciation , this.yearsInvested) * this.yearlyIncome);
      // inflation?
      return lastYearIncome;
  }

  private double getNthYearIncome(double n) {
    double nthYearIncome = (Math.pow(this.incomeAppreciation , n) * this.yearlyIncome);
    return nthYearIncome;
  }

  public double getFirstYearCashflow() {
    return  (0 - this.investmentAmount) + this.yearlyIncome;
  }

  public double[] getVentureCashflow() {
    double[] cashflows;
    int years = (int)this.yearsInvested;
    cashflows = new double[years];
    cashflows[0] = this.getFirstYearCashflow();
    cashflows[years - 1] = this.getLastYearPrice() + this.getLastYearIncome();
    for (int i = 1 ; i <= this.yearsInvested - 2; i++ ) {
      cashflows[i] = this.getNthYearIncome(i + 1);
    }
    return this.cashflows = cashflows;
  }

  public double getROI() {
    double lastYearPrice = this.getLastYearPrice();
    double lastYearIncome = this.getLastYearIncome();
    double lastYearCashflow = lastYearPrice + lastYearIncome;
    return this.ROI = lastYearCashflow / this.investmentAmount;
  }

  public double getCAGR() {
    double exponent = 1 / this.yearsInvested;
    double CAGR = Math.pow(this.ROI, exponent);
    return this.CAGR = CAGR;
    //  could be rounded
  }

  public double getIRR(double cf[], int numOfFlows){
    double LOW_RATE = 0.01;
    double HIGH_RATE = 0.5;
    double MAX_ITERATION = 1000;
    double PRECISION_REQ = 0.00000001;
    int i = 0;
    int j = 0;
    double m = 0.0;
    double old = 0.00;
    double New = 0.00;
    double oldguessRate = LOW_RATE;
    double newguessRate = LOW_RATE;
    double guessRate = LOW_RATE;
    double lowGuessRate = LOW_RATE;
    double highGuessRate = HIGH_RATE;
    double npv = 0.0;
    double denom = 0.0;
   for(i=0; i<MAX_ITERATION; i++){
      npv = 0.00;
      for(j=0; j<numOfFlows; j++){
       denom = Math.pow((1 + guessRate),j);
       npv = npv + (cf[j]/denom);
      }

      // stop checking if percise enough
      if((npv > 0) && (npv < PRECISION_REQ)){

        System.out.println("i: " + i);
        break;
      }

      if(old == 0)
        old = npv;
      else
        old = New;
        New = npv;
      if(i > 0){
        if(old < New){
          if(old < 0 && New < 0)
            highGuessRate = newguessRate;
          else
            lowGuessRate = newguessRate;
        }
        else{
          if(old > 0 && New > 0)
            lowGuessRate = newguessRate;
          else
            highGuessRate = newguessRate;
        }
      }
      oldguessRate = guessRate;
      guessRate = (lowGuessRate + highGuessRate) / 2;
      newguessRate = guessRate;
   }
   return this.IRR = guessRate;
  }

}
