package scheduller;

import model.Nagger;
import notification.Notifier;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduller {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void schedule(List<Nagger> naggers, Notifier notifier) {
        naggers.stream().forEach(nagger -> {
            scheduler.scheduleAtFixedRate(() -> notifier.notify(nagger), nagger.getInterval(), nagger.getInterval(),
                    TimeUnit.MILLISECONDS);
        });
    }
}
