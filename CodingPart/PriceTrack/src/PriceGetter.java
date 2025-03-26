import java.util.List;
import java.util.ArrayList;

public class PriceGetter implements IPriceGetter {
    private String company;
    private String startDate;
    private String endDate;

    @Override
    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String getCompany() {
        return company;
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
    public List<Double> fetchCurrentPrice() {
        return new ArrayList<>();
    }

    @Override
    public List<Double> fetchPriceHistory() {
        return new ArrayList<>();
    }

    @Override
    public List<Double> fetchComparisonData() {
        return new ArrayList<>();
    }

    @Override
    public void applyFilters() {
    }
}