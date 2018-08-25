package investment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvestmentController {
    @RequestMapping(path="/getFinancials")
    public Financials getFinancials(
      @RequestParam(value="investmentAmount") int investmentAmount,
      @RequestParam(value="yearlyIncome") int yearlyIncome,
      @RequestParam(value="yearlyInvestmentGrowth", defaultValue="1.05") double yearlyInvestmentGrowth,
      @RequestParam(value="yearlyIncomeGrowth", defaultValue="1.03") double yearlyIncomeGrowth,
      @RequestParam(value="inflation", defaultValue="1.018") double inflation){
        Investment sample = new Investment(investmentAmount, yearlyIncome, yearlyInvestmentGrowth, yearlyIncomeGrowth, inflation);
          int years = (int)sample.yearsInvested;
          sample.getROI();
          sample.getCAGR();
          sample.getVentureCashflow();
          sample.getIRR(sample.cashflows);
          sample.getFinancials();
          return sample.financials;
      }
    @RequestMapping(path="/getYearlyDetails")
    public YearlyReport[] getYeaerlyDetails(
    @RequestParam(value="investmentAmount") int investmentAmount,
    @RequestParam(value="yearlyIncome") int yearlyIncome,
    @RequestParam(value="yearlyInvestmentGrowth", defaultValue="1.05") double yearlyInvestmentGrowth,
    @RequestParam(value="yearlyIncomeGrowth", defaultValue="1.03") double yearlyIncomeGrowth,
    @RequestParam(value="inflation", defaultValue="1.018") double inflation) {
      Investment sample = new Investment(investmentAmount, yearlyIncome, yearlyInvestmentGrowth, yearlyIncomeGrowth, inflation);
      sample.getVentureDetails();
      return sample.ventureDetails;
    }
}
