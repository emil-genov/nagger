package factory;

import model.Nagger;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PropertiesNaggerRepository implements NaggerRepository {

    private final Properties properties;

    public PropertiesNaggerRepository() {
        properties = getProperties();
    }

    @Override
    public List<Nagger> getNaggers() {
        final Properties properties = getProperties();
        return Stream.of(properties.getProperty("naggers").split(","))
                .map(naggerId -> new Nagger(naggerId,
                        Long.parseLong(properties.getProperty(naggerId + ".interval")),
                        Long.parseLong(properties.getProperty(naggerId + ".length")),
                        properties.getProperty(naggerId + ".text"),
                        properties.getProperty(naggerId + ".title"),
                        properties.getProperty(naggerId + ".iconName")
                ))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<String> getAlerterPath() {
        return Optional.ofNullable(properties.getProperty("alerterApp.path"));
    }

    private Properties getProperties() {
        final Properties properties = new Properties();
        try {
            properties.load(NaggerRepository.class.getResourceAsStream("/settings.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}
