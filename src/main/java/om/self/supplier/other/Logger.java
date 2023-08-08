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
    /**
     * The list of all the logged values while logging was enabled
     */
    private final LinkedList<T> log = new LinkedList<>();
    /**
     * The list of all the times associated with logged values while logging was enabled
     */
    private final LinkedList<Long> times = new LinkedList<>();
    /**
     * Sets whether this modifier should log the input
     */
    private boolean loggingEnabled = true;
    /**
     * Sets whether this modifier should log the time of the input <br>
     * Note: this is only used if {@link Logger#loggingEnabled} is true
     */
    private boolean timestampEnabled = true;

    /**
     * returns all the logged values while logging was enabled
     * @return {@link Logger#log}
     */
    public LinkedList<T> getLog() {
        return log;
    }

    /**
     * returns all the times associated with logged values while logging was enabled
     * @return {@link Logger#times}
     */
    public LinkedList<Long> getTimes() {
        return times;
    }

    /**
     * writes the log to a file
     * @param path the path to the file
     * @param includeTimestamps whether to include timestamps in the log file
     * @throws IOException if the file cannot be written to
     */
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

    /**
     * checks if logging is enabled
     * @return {@link Logger#loggingEnabled}
     */
    public boolean isLoggingEnabled() {
        return loggingEnabled;
    }

    /**
     * sets whether logging is enabled
     * @param loggingEnabled whether logging is enabled
     */
    public void setLoggingEnabled(boolean loggingEnabled) {
        this.loggingEnabled = loggingEnabled;
    }

    /**
     * checks if timestamps are enabled
     * @return {@link Logger#timestampEnabled}
     */
    public boolean isTimestampEnabled() {
        return timestampEnabled;
    }

    /**
     * sets whether timestamps are enabled
     * @param timestampEnabled whether timestamps are enabled
     */
    public void setTimestampEnabled(boolean timestampEnabled) {
        this.timestampEnabled = timestampEnabled;
    }

    /**
     * logs the input if enabled and returns it
     * @param t the input
     * @return the input
     */
    @Override
    public T apply(T t) {
        if(loggingEnabled) {
            log.add(t);
            times.add(timestampEnabled ? System.currentTimeMillis() : null);
        }
        return t;
    }
}
