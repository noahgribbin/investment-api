# Investment-api

 #### This is an API that calculates financial information about the worthiness of a venture. 

 ##### URL : http://javaapi-env.ufwrj6szqa.us-west-1.elasticbeanstalk.com

 ## API Calls

 ### GET
  #### /getYearlyDetails
  
   ##### Params
    
   ###### Required
   
   * investmentAmount ```[double]```
        * numerical value of the initial value of the investment
        * ex: ```investmentAmount=500000```
      
   * yearlyIncome ```[double]```
      * numerical value of the yearly income from the venture.
       * ex: ```yearlyIncome=2500```
        
  ###### Optional
  
  * yearlyInvestmentGrowth ```[double]``` default: 1.05  
       * percentave value in decimal of the growth rate of the ventures price.
       * ex: ```yearlyInvestmentGrowth=1.05```
       
   * yearlyIncomeGrowth ```[double]``` default: 1.03
       * percentave value in decimal of the growth rate of the ventures income.
       * ex: ```yearlyInvestmentGrowth=1.05```
       
   * inflation ```[double]``` default: 1.018
       * percentave value in decimal of the current inflation rate.
       * ex: ```yearlyInvestmentGrowth=1.05```
      
   ###### example: http://javaapi-env.ufwrj6szqa.us-west-1.elasticbeanstalk.com/getYearlyDetails?investmentAmount=500000&yearlyIncome=2500   
  

##### Response
  
  * Code: 200
  
      * Body: 
      ```
      [
        {
        "price":500000.0,
        "income":2500.0,
        "cashflow":-497500.0,
        "incomeAfterInflation":2545.0
       },
       {
       "price":525000.0,
       "income":2575.0,
       "cashflow":2621.35,
       "incomeAfterInflation":2621.35
       }, ...
     ]
    
   The response will be an array of yearly report objects consititng of price, income, income after inflation, and cashflow. The report will generate 30 years of reports.
       
   * Code: 400
      * Body: ```{error: Bad Request}```
    
  This error may be produced by ommiting a required paramater, or by providing an invalid type.
   
  #### /getFinancials
  
   ##### Params
    
   ###### Required
   
   * investmentAmount ```[double]```
        * numerical value of the initial value of the investment
        * ex: ```investmentAmount=500000```
      
   * yearlyIncome ```[double]```
      * numerical value of the yearly income from the venture.
       * ex: ```yearlyIncome=2500```
        
  ###### Optional
  
  * yearlyInvestmentGrowth ```[double]``` default: 1.05  
       * percentave value in decimal of the growth rate of the ventures price.
       * ex: ```yearlyInvestmentGrowth=1.05```
       
   * yearlyIncomeGrowth ```[double]``` default: 1.03
       * percentave value in decimal of the growth rate of the ventures income.
       * ex: ```yearlyInvestmentGrowth=1.05```
       
   * inflation ```[double]``` default: 1.018
       * percentave value in decimal of the current inflation rate.
       * ex: ```yearlyInvestmentGrowth=1.05```
    ###### example: http://javaapi-env.ufwrj6szqa.us-west-1.elasticbeanstalk.com/getYearlyDetails?investmentAmount=500000&yearlyIncome=2500
    
   ##### Response
  
   * Code: 200
      * Body:
      ```
        {
          "roi":4.334078687506616,
          "cagr":0.050098149267489234,
          "irr":0.054231414748166916
        }
        ```
  The response will be an object comtaining the percentages for "Return on Investment", "Compound Annual Growth Rate" and "Internal Rate of Return".
    
   * Code: 400
      * Body: {error: Bad Request}
    
  This error may be cause by ommiting a required paramater, or by providing an invalid type.

## Running Locally

 #### If you would like to run this project locally follow these instructions.
  * Clone this repo  ```git clone https://github.com/noahgribbin/investment-api.git```
  * Navigate into the new directory ```cd investment-api```
  * Build the project with Gradle ``` gradle build ```
     * If you do not have Gradle installed you can find instructions on how to do so here https://gradle.org/install/
  * Navigate to the ```build/lib``` directory
  * Start the ```.jar``` file with ```java -jar investment-api-0.1.0.jar```
  * The project will be up and running on ```localhost:8080``` and awaiting requests
