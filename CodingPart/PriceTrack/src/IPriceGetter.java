import java.util.List;

public interface IPriceGetter {

    void setCompany(String company);
    String getCompany();

    void setStartDate(String startDate);
    void setEndDate(String endDate);
    String getStartDate();
    String getEndDate();

    List<Double> fetchCurrentPrice();
    List<Double> fetchPriceHistory();
    List<Double> fetchComparisonData();

    void applyFilters();
}
