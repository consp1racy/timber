@file:JvmName("-TimberKt")
@file:Suppress("NOTHING_TO_INLINE", "unused")

package com.github.ajalt.timberkt

import timber.log.*

//
// Extensions on trees
//

/** Log a verbose exception and a message that will be evaluated lazily when the message is printed */
inline fun Tree.v(t: Throwable? = null, message: () -> String) = verbose(t, message)

/** Log a debug exception and a message that will be evaluated lazily when the message is printed */
inline fun Tree.d(t: Throwable? = null, message: () -> String) = debug(t, message)

/** Log an info exception and a message that will be evaluated lazily when the message is printed */
inline fun Tree.i(t: Throwable? = null, message: () -> String) = info(t, message)

/** Log a warning exception and a message that will be evaluated lazily when the message is printed */
inline fun Tree.w(t: Throwable? = null, message: () -> String) = warn(t, message)

/** Log an error exception and a message that will be evaluated lazily when the message is printed */
inline fun Tree.e(t: Throwable? = null, message: () -> String) = error(t, message)

/** Log an assert exception and a message that will be evaluated lazily when the message is printed */
inline fun Tree.wtf(t: Throwable? = null, message: () -> String) = assert(t, message)

//
// Plain functions
//

/** Log a verbose exception and a message that will be evaluated lazily when the message is printed */
inline fun v(t: Throwable? = null, message: () -> String) = Timber.verbose(t, message)

inline fun v(t: Throwable?) = t?.let { Timber.log(Timber.VERBOSE, t) }

/** Log a debug exception and a message that will be evaluated lazily when the message is printed */
inline fun d(t: Throwable? = null, message: () -> String) = Timber.debug(t, message)

inline fun d(t: Throwable?) = t?.let { Timber.log(Timber.DEBUG, t) }

/** Log an info exception and a message that will be evaluated lazily when the message is printed */
inline fun i(t: Throwable? = null, message: () -> String) = Timber.info(t, message)

inline fun i(t: Throwable?) = t?.let { Timber.log(Timber.INFO, t) }

/** Log a warning exception and a message that will be evaluated lazily when the message is printed */
inline fun w(t: Throwable? = null, message: () -> String) = Timber.warn(t, message)

inline fun w(t: Throwable?) = t?.let { Timber.log(Timber.WARNING, t) }

/** Log an error exception and a message that will be evaluated lazily when the message is printed */
inline fun e(t: Throwable? = null, message: () -> String) = Timber.error(t, message)

inline fun e(t: Throwable?) = t?.let { Timber.log(Timber.ERROR, t) }

/** Log an assert exception and a message that will be evaluated lazily when the message is printed */
inline fun wtf(t: Throwable? = null, message: () -> String) = Timber.assert(t, message)

inline fun wtf(t: Throwable?) = t?.let { Timber.log(Timber.ASSERT, t) }

@Deprecated("Obsolete, inaccurate.", ReplaceWith("block()"))
@PublishedApi
internal inline fun log(block: () -> Unit) {
    if (Timber.size > 0) block()
}
