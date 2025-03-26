public class CustomerActions implements ICustomerActions {

    private String currentCompany;
    private String startDate;
    private String endDate;

    @Override
    public void changeCompany(String company) {
        this.currentCompany = company;
    }

    @Override
    public String getCurrentCompany() {
        return currentCompany;
    }

    @Override
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String getStartDate() {
        return startDate;
    }

    @Override
    public String getEndDate() {
        return endDate;
    }

    @Override
    public void displayStockPrice() {}

    @Override
    public void displayComparisonGraph() {}

    @Override
    public void displayFiltersStock() {}

    @Override
    public void generateGraph() {}

    @Override
    public void downloadGraph() {}

    @Override
    public void loadData() {}
}

