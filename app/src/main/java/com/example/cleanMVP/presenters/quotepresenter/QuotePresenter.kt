package com.example.cleanMVP.presenters.quotepresenter

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanMVP.domain.entities.Quote
import com.example.cleanMVP.interactors.quoteinteractor.IQuoteInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class QuotePresenter(private val iQuoteInteractor: IQuoteInteractor) : IQuotePresenter, ViewModel() {

    private val allQuotes : MutableLiveData<List<Quote>> = MutableLiveData()

    init {
        loadQuotes()
    }

    override fun insert(quote: Quote) {
        iQuoteInteractor.insert(quote)
    }

    override fun update(quote: Quote) {
        iQuoteInteractor.update(quote)
    }

    override fun delete(quote: Quote) {
        iQuoteInteractor.delete(quote)
    }

    override fun deleteAllQuotes() {
        iQuoteInteractor.deleteAllQuotes()
    }

    override fun getAllQuotes(): LiveData<List<Quote>> {
        return allQuotes
    }

    @SuppressLint("CheckResult")
    override fun loadQuotes() {
        iQuoteInteractor.getAllQuotes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { quotes -> allQuotes.postValue(quotes) },
                { error -> Log.d("RxJava", "Error getting info from interactor into presenter") }
            )
    }
}