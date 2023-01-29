package SchoolManagementSystem.services.seed;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface BaseSeedService {

    void seedBaseCountries() throws IOException;

    void seedBaseTowns() throws IOException;

    void seedBaseDepartments() throws FileNotFoundException;

    void seedAllBaseData() throws IOException;
}
