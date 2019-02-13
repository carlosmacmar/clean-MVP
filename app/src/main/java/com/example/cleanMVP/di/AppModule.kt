package com.example.cleanMVP.di

import androidx.room.Room
import com.example.cleanMVP.interactors.quoteinteractor.IQuoteInteractor
import com.example.cleanMVP.interactors.quoteinteractor.QuoteInteractor
import com.example.cleanMVP.presenters.quotepresenter.QuotePresenter
import com.example.cleanMVP.repositories.databases.AppDatabase
import com.example.cleanMVP.repositories.quoterepository.IQuoteRepository
import com.example.cleanMVP.repositories.quoterepository.QuoteRepository
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {

    single { Room.databaseBuilder(get(), AppDatabase::class.java, "quotes_database").build() }

    single { get<AppDatabase>().quoteDao() }

    single<IQuoteRepository> {
        QuoteRepository(
            get()
        )
    }

    single<IQuoteInteractor> {
        QuoteInteractor(
            get()
        )
    }

    viewModel { QuotePresenter(get()) }
}
