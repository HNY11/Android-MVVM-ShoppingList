package com.java.android_mvvm_shoppinglist.data

import android.app.Application
import com.java.android_mvvm_shoppinglist.data.db.ShoppingDatabase
import com.java.android_mvvm_shoppinglist.data.repositories.ShoppingRepository
import com.java.android_mvvm_shoppinglist.data.viewmodel.ShoppingViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton


/**
 * Author Himanshu
 * Created on  29-January-2021
 */
class ShoppingApplication : Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@ShoppingApplication))
        bind() from singleton { ShoppingDatabase(instance()) }
        bind() from singleton { ShoppingRepository(instance()) }
        bind() from provider {
            ShoppingViewModelFactory(instance())
        }
    }

    override fun onCreate() {
        super.onCreate()
    }

}