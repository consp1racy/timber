package timber.log

import android.os.Build
import android.util.Log
import java.util.regex.Pattern

private const val MAX_TAG_LENGTH = 23
private const val CALL_STACK_INDEX = 4
private val ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$")

/**
 * A [Tree] for debug builds. Automatically infers the tag from the calling class.
 *
 * @param tag If provided, will check [Log.isLoggable] with specified tag as argument.
 */
open class DebugTree(private val tag: String? = null) : Tree() {

    init {
        require(tag == null || tag.length <= MAX_TAG_LENGTH) { "Tag must be shorter than ${MAX_TAG_LENGTH + 1} characters." }
    }

    private val impl = LogcatTree()

    override fun isLoggable(priority: Int, tag: String?): Boolean {
        val theTag = this.tag
        return theTag == null || Log.isLoggable(theTag, priority)
    }

    override fun performLog(priority: Int, tag: String?, throwable: Throwable?, message: String?) {
        val actualTag = tag ?: getStackTraceTag()
        impl.log(priority, actualTag, throwable, message)
    }

    /**
     * Extract the tag which should be used for the message from the `element`. By default
     * this will use the class name without any anonymous class suffixes (e.g., `Foo$1`
     * becomes `Foo`).
     *
     *
     * Note: This will not be called if a [manual tag][.tag] was specified.
     */
    protected fun createStackElementTag(element: StackTraceElement): String {
        var tag = element.className
        val m = ANONYMOUS_CLASS.matcher(tag)
        if (m.find()) {
            tag = m.replaceAll("")
        }
        tag = tag.substring(tag.lastIndexOf('.') + 1)
        // Tag length limit was removed in API 24.
        return if (tag.length <= MAX_TAG_LENGTH || Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tag
        } else {
            tag.substring(0, MAX_TAG_LENGTH)
        }
    }

    private fun getStackTraceTag(): String {
        // DO NOT switch this to Thread.getCurrentThread().getStackTrace(). The test will pass
        // because Robolectric runs them on the JVM but on Android the elements are different.
        val stackTrace = Throwable().stackTrace
        val callStackIndex = CALL_STACK_INDEX + callStackOffset(stackTrace)
        if (stackTrace.size <= callStackIndex) {
            throw IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?")
        }
        return createStackElementTag(stackTrace[callStackIndex])
    }

    private fun callStackOffset(stackTrace: Array<StackTraceElement>): Int {
        var klazz: Class<in DebugTree> = javaClass
        while (klazz != DebugTree::class.java) {
            // This allows proper tag inference from subclasses.
            val offset = stackTrace.indexOfLast { it.className == javaClass.name }
            if (offset != -1) {
                return offset - 1
            }
            @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
            klazz = klazz.superclass
        }
        return 0
    }
}
