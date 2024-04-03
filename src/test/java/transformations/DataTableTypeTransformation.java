package transformations;

import io.cucumber.java.DataTableType;
import io.cucumber.java.Transpose;
import model.RegistrationModel;

import java.util.Map;

public class DataTableTypeTransformation {

    @DataTableType
    public RegistrationModel getRegistrationModel(@Transpose Map<String, String> entry) {
        RegistrationModel model = new RegistrationModel();

        model.setEmail(entry.get("email"));
        model.setPassword(entry.get("password"));
        model.setDomain(entry.get("domain"));

        return model;
    }
}
