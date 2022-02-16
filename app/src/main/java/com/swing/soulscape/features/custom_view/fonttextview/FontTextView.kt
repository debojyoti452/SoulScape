package com.swing.soulscape.features.custom_view.fonttextview

import android.content.Context
import android.content.res.TypedArray
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.text.HtmlCompat
import com.swing.soulscape.R

open class FontTextView : AppCompatTextView {

    private var fontName: String = DEFAULT_STRING
    private var htmlText: String = DEFAULT_STRING

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(context, attrs)
    }

    fun setHtml(htmlText: String) {
        this.htmlText = htmlText
        text = htmlText
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        var typedArray: TypedArray? = null
        try {
            typedArray = context.obtainStyledAttributes(attrs, R.styleable.FontTextView)
            fontName = typedArray.getString(R.styleable.FontTextView_custom_font) ?: "-1"
        } catch (e: ExceptionInInitializerError) {
            e.printStackTrace()
        } finally {
            updateView(context)
            typedArray?.recycle()
        }
    }

    private fun updateView(context: Context) {
        if (fontName != "-1") {
            typeface = TypeFaces.get(context, fontName)
        }
//        setTextAppearance(R.style.BaseTextViewTheme)
    }

    override fun setText(text: CharSequence?, type: BufferType?) {
        if (htmlText != DEFAULT_STRING) {
            super.setText(htmlParse(text), type)
        } else {
            super.setText(text, type)
        }
    }


    private fun htmlParse(text: CharSequence?): Spanned {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(text.toString(), Html.FROM_HTML_MODE_COMPACT)
        } else {
            HtmlCompat.fromHtml(
                text.toString(),
                HtmlCompat.FROM_HTML_MODE_COMPACT
            )
        }
    }

    companion object {
        const val DEFAULT_STRING = "-1"
    }
}
