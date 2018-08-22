package investment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvestmentController {
    @RequestMapping(path="/getFinancials")
    public Investment getFinancials(
      @RequestParam(value="investmentAmmount", defaultValue="500000") int investmentAmmount,
      @RequestParam(value="yearlyIncome", defaultValue="2500") int yearlyIncome) {
        return new Investment(investmentAmmount, yearlyIncome);
        // return investmentAmmount
      }
}
