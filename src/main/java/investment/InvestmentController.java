package investment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvestmentController {
    @RequestMapping(path="/getFinancials")
    public Investment getFinancials(
      @RequestParam(value="investmentAmount", defaultValue="500000") int investmentAmount,
      @RequestParam(value="yearlyIncome", defaultValue="2500") int yearlyIncome) {
        Investment sample = new Investment(investmentAmount, yearlyIncome);
        sample.getROI();
        sample.getCAGR();
        sample.getVentureCashflow();
        sample.getIRR(sample.cashflows, 30);
        return sample;
        // return formatted object
      }
}
