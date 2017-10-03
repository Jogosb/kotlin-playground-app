package com.filipradon.kotlinplaygroundapp

import com.filipradon.kotlinplaygroundapp.ui.utils.toDateString
import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.DateFormat

/**
 * Created by filipradon on 01/10/17.
 */
class ExtensionsTest {

    @Test fun testLongToDateString() {
        assertEquals("Oct 19, 2015", 1445275635000L.toDateString())
    }

    @Test fun testDateStringFullFormat() { assertEquals("Monday, October 19, 2015",
            1445275635000L.toDateString(DateFormat.FULL))
    }
}