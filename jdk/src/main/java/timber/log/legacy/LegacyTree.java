package timber.log.legacy;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.Nullable;

import timber.log.Timber;
import timber.log.Tree;

@SuppressWarnings("unused")
public final class LegacyTree extends Tree {

    private final String defaultTag;


    LegacyTree(@Nullable String defaultTag) {
        this.defaultTag = defaultTag;
    }

    @Override
    public boolean isLoggable(int priority, @Nullable String tag) {
        if (tag == null) {
            tag = defaultTag;
        }
        return Timber.INSTANCE.isLoggable(priority, tag);
    }

    @Override
    protected void performLog(int priority, @Nullable String tag, @Nullable Throwable throwable, @Nullable String message) {
        if (tag == null) {
            tag = defaultTag;
        }
        Timber.INSTANCE.log(priority, tag, throwable, message);
    }

    /**
     * Log a verbose message with optional format args.
     */
    public void v(@NonNls String message, Object... args) {
        log(Timber.VERBOSE, null, null, String.format(message, args));
    }

    /**
     * Log a verbose exception and a message with optional format args.
     */
    public void v(Throwable t, @NonNls String message, Object... args) {
        log(Timber.VERBOSE, null, t, String.format(message, args));
    }

    /**
     * Log a verbose exception.
     */
    public void v(Throwable t) {
        log(Timber.VERBOSE, null, t, null);
    }

    /**
     * Log a debug message with optional format args.
     */
    public void d(@NonNls String message, Object... args) {
        log(Timber.DEBUG, null, null, String.format(message, args));
    }

    /**
     * Log a debug exception and a message with optional format args.
     */
    public void d(Throwable t, @NonNls String message, Object... args) {
        log(Timber.DEBUG, null, t, String.format(message, args));
    }

    /**
     * Log a debug exception.
     */
    public void d(Throwable t) {
        log(Timber.DEBUG, null, t, null);
    }

    /**
     * Log an info message with optional format args.
     */
    public void i(@NonNls String message, Object... args) {
        log(Timber.INFO, null, null, String.format(message, args));
    }

    /**
     * Log an info exception and a message with optional format args.
     */
    public void i(Throwable t, @NonNls String message, Object... args) {
        log(Timber.INFO, null, t, String.format(message, args));
    }

    /**
     * Log an info exception.
     */
    public void i(Throwable t) {
        log(Timber.INFO, null, t, null);
    }

    /**
     * Log a warning message with optional format args.
     */
    public void w(@NonNls String message, Object... args) {
        log(Timber.WARNING, null, null, String.format(message, args));
    }

    /**
     * Log a warning exception and a message with optional format args.
     */
    public void w(Throwable t, @NonNls String message, Object... args) {
        log(Timber.WARNING, null, t, String.format(message, args));
    }

    /**
     * Log a warning exception.
     */
    public void w(Throwable t) {
        log(Timber.WARNING, null, t, null);
    }

    /**
     * Log an error message with optional format args.
     */
    public void e(@NonNls String message, Object... args) {
        log(Timber.ERROR, null, null, String.format(message, args));
    }

    /**
     * Log an error exception and a message with optional format args.
     */
    public void e(Throwable t, @NonNls String message, Object... args) {
        log(Timber.ERROR, null, t, String.format(message, args));
    }

    /**
     * Log an error exception.
     */
    public void e(Throwable t) {
        log(Timber.ERROR, null, t, null);
    }

    /**
     * Log an assert message with optional format args.
     */
    public void wtf(@NonNls String message, Object... args) {
        log(Timber.ASSERT, null, null, String.format(message, args));
    }

    /**
     * Log an assert exception and a message with optional format args.
     */
    public void wtf(Throwable t, @NonNls String message, Object... args) {
        log(Timber.ASSERT, null, t, String.format(message, args));
    }

    /**
     * Log an assert exception.
     */
    public void wtf(Throwable t) {
        log(Timber.ASSERT, null, t, null);
    }

    /**
     * Log at {@code priority} a message with optional format args.
     */
    public void log(int priority, @NonNls String message, Object... args) {
        log(priority, null, null, String.format(message, args));
    }

    /**
     * Log at {@code priority} an exception and a message with optional format args.
     */
    public void log(int priority, Throwable t, @NonNls String message, Object... args) {
        log(priority, null, t, String.format(message, args));
    }

    /**
     * Log at {@code priority} an exception.
     */
    public void log(int priority, Throwable t) {
        log(priority, null, t, null);
    }
}
