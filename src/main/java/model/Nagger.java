package model;

public class Nagger {
    private String id;
    private long interval;
    private long length;
    private String text;
    private String title;
    private String iconName;

    public String getId() {
        return id;
    }

    public long getInterval() {
        return interval;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public long getLength() {
        return length;
    }

    public String getIconName() {
        return iconName;
    }

    public Nagger(String id, long interval, long length, String text, String title, String iconName) {
        this.id = id;
        this.interval = interval;
        this.length = length;
        this.text = text;
        this.title = title;
        this.iconName = iconName;
    }

    @Override
    public String toString() {
        return "Nagger{" +
                "id='" + id + '\'' +
                ", interval=" + interval +
                ", length=" + length +
                ", text='" + text + '\'' +
                ", title='" + title + '\'' +
                ", iconName='" + iconName + '\'' +
                '}';
    }
}
