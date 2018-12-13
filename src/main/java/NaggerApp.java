import factory.NaggerRepository;
import factory.PropertiesNaggerRepository;
import model.Nagger;
import notification.Notifier;
import scheduller.Scheduller;

import java.util.List;

public class NaggerApp {

    public static void main(String[] args){
        final NaggerRepository naggerRepository = new PropertiesNaggerRepository();
        final List<Nagger> naggers = naggerRepository.getNaggers();
        final String alerterPath = naggerRepository.getAlerterPath().orElse(NaggerApp.class.getResource("/alerter").getPath());
        new Scheduller().schedule(naggers, new Notifier(alerterPath));
    }
}
