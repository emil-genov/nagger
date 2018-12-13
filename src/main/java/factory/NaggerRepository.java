package factory;

import model.Nagger;

import java.util.List;
import java.util.Optional;

public interface NaggerRepository {

    List<Nagger> getNaggers();

    Optional<String> getAlerterPath();
}
