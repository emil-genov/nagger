package notification;

import model.Nagger;

import java.io.IOException;

public class Notifier {

    private String alerterPath;

    public Notifier(String alerterPath) {
        this.alerterPath = alerterPath;
    }

    public void notify(Nagger nagger){
       try {
            Runtime.getRuntime().exec(new String[]{alerterPath,
                    "-message", nagger.getText(),
                    "-title", nagger.getTitle(),
                    "-timeout", Long.toString(nagger.getLength()/1000),
                    "-appIcon", Notifier.class.getResource("/images/notifyIcon.png").getPath(),
                    "-contentImage", Notifier.class.getResource("/images/"+nagger.getIconName()).getPath(),
                    "-group", "com.emilgenov.Nagger"
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
