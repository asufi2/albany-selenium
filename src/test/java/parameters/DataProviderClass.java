package parameters;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {
    @DataProvider(name = "SingleValue")
    public Object[][] storeSingleValue() {
        return new Object[][]{
                {"Rifat"},
                {"Mohammad"},
                {"Ashraf"},
                {"Abu"}};
    }

    @DataProvider(name = "MultipleValues")
    public Object[][] StoreMultipleValues() {
        return new Object[][] {
                {"Rifat", "Florida", 33018},
                {"Mohammad", "Kansas", 24493},
                {"Ashfar", "Texas", 45789},
                {"Abu", "New York", 11421}
        };
    }

    @DataProvider(name = "RealAprRates")
    public Object[][] storeRealAprRatesData() {
        return new Object[][] {
                {"200000", "15000", "3", "3.130%"}
        };
    }

    @Test(dataProvider = "SingleValue")
    public void readSingleValue(String name) {
        System.out.println("[Single Value] Name is: " + name);
    }

    @Test(dataProvider = "MultipleValues")
    public void readMultipleValues(String name, String state, int zipCode) {
        System.out.println("[Multiple Column Value] Name is: " + name);
        System.out.println("[Multiple Column Value] State is: " + state);
        System.out.println("[Multiple Column Value] Zip is: " + zipCode);
    }
}


