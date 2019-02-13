package com.example.cleanMVP.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.example.cleanMVP.R
import com.example.cleanMVP.domain.entities.Quote
import com.example.cleanMVP.presenters.quotepresenter.QuotePresenter
import kotlinx.android.synthetic.main.activity_quotes.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class QuotesActivity : FragmentActivity() {

    //Lazy injected presenter-viewmodel, if you want to share the same instance with a fragment just change viewModel() to sharedViewModel() in the fragment
    val quotePresenter: QuotePresenter by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)

        initializeUI()
    }

    private fun initializeUI() {
        quotePresenter.getAllQuotes().observe(this, Observer<List<Quote>> { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text = stringBuilder.toString()
        })

        button_add_quote.setOnClickListener {
            val quote = Quote(
                null,
                editText_quote.text.toString(),
                editText_author.text.toString()
            )
            quotePresenter.insert(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }

        button_delete_quote.setOnClickListener {
            quotePresenter.deleteAllQuotes()
        }
    }
}
