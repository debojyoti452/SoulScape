package com.swing.soulscape.features.custom_view.fonttextview

import android.content.Context
import android.graphics.Typeface
import java.util.*

object TypeFaces {
    private val cacheTable: Hashtable<String, Typeface> by lazy {
        Hashtable<String, Typeface>()
    }

    fun get(context: Context, name: String): Typeface? {
        synchronized(cacheTable) {
            if (!cacheTable.containsKey(name)) {
                val typeface = Typeface.createFromAsset(context.assets, name)
                cacheTable[name] = typeface
            }
            return cacheTable.get(key = name)
        }
    }
}
