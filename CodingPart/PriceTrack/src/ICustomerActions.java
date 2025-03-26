public interface ICustomerActions {

    void changeCompany(String company);
    String getCurrentCompany();

    //start and end date of the graph
    void setStartDate(String currentDate);
    void setEndDate(String endDate);
    String getStartDate();
    String getEndDate();

    void displayStockPrice();
    void displayComparisonGraph();
    void displayFiltersStock();

    void generateGraph();
    void downloadGraph();
    void loadData();

}