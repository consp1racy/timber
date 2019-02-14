package timber.log.legacy;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import timber.log.Tree;


@SuppressWarnings("unused")
public final class Timber {

    private static final LegacyTree THE_TREE = new LegacyTree(null);

    /**
     * Log a verbose message with optional format args.
     */
    public static void v(@NonNls String message, Object... args) {
        THE_TREE.log(timber.log.Timber.VERBOSE, null, null, String.format(message, args));
    }

    /**
     * Log a verbose exception and a message with optional format args.
     */
    public static void v(Throwable t, @NonNls String message, Object... args) {
        THE_TREE.log(timber.log.Timber.VERBOSE, null, t, String.format(message, args));
    }

    /**
     * Log a verbose exception.
     */
    public static void v(Throwable t) {
        THE_TREE.log(timber.log.Timber.VERBOSE, null, t, null);
    }

    /**
     * Log a debug message with optional format args.
     */
    public static void d(@NonNls String message, Object... args) {
        THE_TREE.log(timber.log.Timber.DEBUG, null, null, String.format(message, args));
    }

    /**
     * Log a debug exception and a message with optional format args.
     */
    public static void d(Throwable t, @NonNls String message, Object... args) {
        THE_TREE.log(timber.log.Timber.DEBUG, null, t, String.format(message, args));
    }

    /**
     * Log a debug exception.
     */
    public static void d(Throwable t) {
        THE_TREE.log(timber.log.Timber.DEBUG, null, t, null);
    }

    /**
     * Log an info message with optional format args.
     */
    public static void i(@NonNls String message, Object... args) {
        THE_TREE.log(timber.log.Timber.INFO, null, null, String.format(message, args));
    }

    /**
     * Log an info exception and a message with optional format args.
     */
    public static void i(Throwable t, @NonNls String message, Object... args) {
        THE_TREE.log(timber.log.Timber.INFO, null, t, String.format(message, args));
    }

    /**
     * Log an info exception.
     */
    public static void i(Throwable t) {
        THE_TREE.log(timber.log.Timber.INFO, null, t, null);
    }

    /**
     * Log a warning message with optional format args.
     */
    public static void w(@NonNls String message, Object... args) {
        THE_TREE.log(timber.log.Timber.WARNING, null, null, String.format(message, args));
    }

    /**
     * Log a warning exception and a message with optional format args.
     */
    public static void w(Throwable t, @NonNls String message, Object... args) {
        THE_TREE.log(timber.log.Timber.WARNING, null, t, String.format(message, args));
    }

    /**
     * Log a warning exception.
     */
    public static void w(Throwable t) {
        THE_TREE.log(timber.log.Timber.WARNING, null, t, null);
    }

    /**
     * Log an error message with optional format args.
     */
    public static void e(@NonNls String message, Object... args) {
        THE_TREE.log(timber.log.Timber.ERROR, null, null, String.format(message, args));
    }

    /**
     * Log an error exception and a message with optional format args.
     */
    public static void e(Throwable t, @NonNls String message, Object... args) {
        THE_TREE.log(timber.log.Timber.ERROR, null, t, String.format(message, args));
    }

    /**
     * Log an error exception.
     */
    public static void e(Throwable t) {
        THE_TREE.log(timber.log.Timber.ERROR, null, t, null);
    }

    /**
     * Log an assert message with optional format args.
     */
    public static void wtf(@NonNls String message, Object... args) {
        THE_TREE.log(timber.log.Timber.ASSERT, null, null, String.format(message, args));
    }

    /**
     * Log an assert exception and a message with optional format args.
     */
    public static void wtf(Throwable t, @NonNls String message, Object... args) {
        THE_TREE.log(timber.log.Timber.ASSERT, null, t, String.format(message, args));
    }

    /**
     * Log an assert exception.
     */
    public static void wtf(Throwable t) {
        THE_TREE.log(timber.log.Timber.ASSERT, null, t, null);
    }

    /**
     * Log at {@code priority} a message with optional format args.
     */
    public static void log(int priority, @NonNls String message, Object... args) {
        THE_TREE.log(priority, null, null, String.format(message, args));
    }

    /**
     * Log at {@code priority} an exception and a message with optional format args.
     */
    public static void log(int priority, Throwable t, @NonNls String message, Object... args) {
        THE_TREE.log(priority, null, t, String.format(message, args));
    }

    /**
     * Log at {@code priority} an exception.
     */
    public static void log(int priority, Throwable t) {
        THE_TREE.log(priority, null, t, null);
    }

    /**
     * A view into Timber's planted trees as a tree itself. This can be used for injecting a logger
     * instance rather than using static methods or to facilitate testing.
     */
    @NotNull
    public static LegacyTree asTree() {
        return THE_TREE;
    }

    /**
     * Set a one-time tag for use on the next logging call.
     */
    @NotNull
    public static LegacyTree tag(String tag) {
        return new LegacyTree(tag);
    }

    /**
     * Add a new logging tree.
     */
    @SuppressWarnings("ConstantConditions") // Validating public API contract.
    public static void plant(@NotNull Tree tree) {
        timber.log.Timber.INSTANCE.plant(tree);
    }

    /**
     * Adds new logging trees.
     */
    @SuppressWarnings("ConstantConditions") // Validating public API contract.
    public static void plant(@NotNull Tree... trees) {
        timber.log.Timber.INSTANCE.plant(trees);
    }

    /**
     * Remove a planted tree.
     */
    public static void uproot(@NotNull Tree tree) {
        timber.log.Timber.INSTANCE.uproot(tree);
    }

    /**
     * Remove all planted trees.
     */
    public static void uprootAll() {
        timber.log.Timber.INSTANCE.uprootAll();
    }

    /**
     * Return a copy of all planted {@linkplain LegacyTree trees}.
     */
    @NotNull
    public static List<Tree> forest() {
        return timber.log.Timber.INSTANCE.getTrees();
    }

    public static int treeCount() {
        return timber.log.Timber.INSTANCE.getSize();
    }

    private Timber() {
    }
}
