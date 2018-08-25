package investment;

import java.lang.Math;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import investment.YearlyReport;
import investment.Financials;

public class Investment {
  public double investmentAmount;
  public double yearlyIncome;
  public double yearsInvested = 30;
  public double inflation = 1.018;
  public double priceAppreciation  = 1.05;
  public double incomeAppreciation  = 1.03;

  public double[] cashflows;
  public double ROI;
  public double CAGR;
  public double IRR;

  public YearlyReport[] ventureDetails;
  public Financials financials;

  public Investment(double investmentAmount, int yearlyIncome, double priceAppreciation, double incomeAppreciation, double inflation) {
    this.investmentAmount = investmentAmount;
    this.yearlyIncome = yearlyIncome;
    this.yearsInvested = yearsInvested;
    this.priceAppreciation = priceAppreciation;
    this.incomeAppreciation = incomeAppreciation;
    this.inflation = inflation;
  }

  public double getInvestmentAmount() {
    return this.investmentAmount;
  }

  public double getYearlyIncome() {
    return this.yearlyIncome;
  }

  public double getNthYearPrice(double n) {
      double lastYearPrice = (Math.pow(this.priceAppreciation , n) * this.investmentAmount);
      return lastYearPrice;
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

  public double getNthYearIncomeAfterInflation(double n) {
    return this.getNthYearIncome(n) * this.inflation;
  }

  public double getFirstYearCashflow() {
    return  (0 - this.investmentAmount) + this.yearlyIncome;
  }

  public double getLastYearCashflow() {
    return this.getLastYearPrice() + this.getNthYearIncomeAfterInflation(this.yearsInvested);
  }

  public double[] getVentureCashflow() {
    double[] cashflows;
    int years = (int)this.yearsInvested;
    cashflows = new double[years + 1];
    cashflows[0] = this.getFirstYearCashflow();
    cashflows[years] = this.getLastYearCashflow();
    for (int i = 1 ; i <= years - 1; i++ ) {
      cashflows[i] = this.getNthYearIncomeAfterInflation(i);
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
    return this.CAGR = CAGR - 1;
  }

  public double getIRR(double cashFlows[]){
    int maxIteration = 30;
    double checkEpsilon = 0.0000001;
    double x = 0.1;

    for (int i = 0; i < maxIteration; i++ ) {
      double x1 = 1.0 + x;
      double fx = 0.0;
      double dfx = 0.0;
      for (int j = 0; j < cashFlows.length; j++) {
        double v = cashFlows[j];
        double x1_j = Math.pow(x1, j);
        fx += v / x1_j;
        double x1_j1 = x1_j * x1;
        dfx += -j * v / x1_j1;
      }
      double new_x = x - fx / dfx;
      double epsilon = Math.abs(new_x - x);

      if (epsilon <= checkEpsilon) {
        if (x == 0.0 && Math.abs(new_x) <= checkEpsilon) {
          return this.IRR = 0.0;
        }
        else {
          return this.IRR = new_x;
        }
      }
      x = new_x;
    }
    return this.IRR = x;
  }

  public YearlyReport[] getVentureDetails() {
      YearlyReport[] ventureDetails;
      int years = (int)this.yearsInvested;
      ventureDetails = new YearlyReport[years + 1];
      ventureDetails[0] = new investment.YearlyReport(this.investmentAmount, this.yearlyIncome, this.getNthYearIncomeAfterInflation(0), this.getFirstYearCashflow());
      ventureDetails[years] = new investment.YearlyReport(this.getLastYearPrice(), this.getLastYearIncome(), this.getNthYearIncomeAfterInflation(years), this.getLastYearCashflow());
      for (int i = 1; i <= years - 1; i++ ) {
        ventureDetails[i] = new investment.YearlyReport(this.getNthYearPrice(i), this.getNthYearIncome(i), getNthYearIncomeAfterInflation(i), this.getNthYearIncomeAfterInflation(i));
      }
      return this.ventureDetails = ventureDetails;
  }

  public Financials getFinancials() {
    Financials financials;
    financials = new investment.Financials(this.ROI, this.CAGR, this.IRR);
    return this.financials = financials;
  };

}
