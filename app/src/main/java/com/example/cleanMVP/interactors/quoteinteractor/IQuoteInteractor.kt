package com.example.cleanMVP.interactors.quoteinteractor

import com.example.cleanMVP.domain.entities.Quote
import io.reactivex.Observable

interface IQuoteInteractor {

    fun insert(quote: Quote)

    fun update(quote: Quote)

    fun delete(quote: Quote)

    fun deleteAllQuotes()

    fun getAllQuotes(): Observable<List<Quote>>
}