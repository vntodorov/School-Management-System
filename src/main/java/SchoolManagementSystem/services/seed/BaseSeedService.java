package SchoolManagementSystem.services.seed;

import java.io.IOException;

public interface BaseSeedService {

    void seedBaseCountries() throws IOException;

    void seedBaseTowns() throws IOException;

    void seedAllBaseData() throws IOException;
}
