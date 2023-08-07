package om.self.supplier.other;

import om.self.supplier.core.SingleTypeModifier;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 * A modifier that logs all inputs to a {@link LinkedList} for later analysis.
 * @param <T> the type of the input and output
 */
public class Logger<T> implements SingleTypeModifier<T> {
    private final LinkedList<T> log = new LinkedList<>();
    private final LinkedList<Long> times = new LinkedList<>();
    private boolean loggingEnabled = true;
    private boolean timestampEnabled = true;

    public LinkedList<T> getLog() {
        return log;
    }

    public LinkedList<Long> getTimes() {
        return times;
    }

    public void writeToFile(String path, boolean includeTimestamps) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        StringBuilder content = new StringBuilder("Log:\n");
        for (int i = 0; i < log.size(); i++) {
            content.append(includeTimestamps ? times.get(i) != null ? times.get(i) + ": " : "null: " : "")
                    .append(log.get(i))
                    .append("\n");
        }
        writer.append(content);
        writer.close();
    }

    public boolean isLoggingEnabled() {
        return loggingEnabled;
    }

    public void setLoggingEnabled(boolean loggingEnabled) {
        this.loggingEnabled = loggingEnabled;
    }

    public boolean isTimestampEnabled() {
        return timestampEnabled;
    }

    public void setTimestampEnabled(boolean timestampEnabled) {
        this.timestampEnabled = timestampEnabled;
    }

    @Override
    public T apply(T t) {
        if(loggingEnabled) {
            log.add(t);
            times.add(timestampEnabled ? System.currentTimeMillis() : null);
        }
        return t;
    }
}
