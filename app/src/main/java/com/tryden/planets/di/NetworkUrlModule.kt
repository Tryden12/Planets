package com.tryden.planets.di

import com.tryden.planets.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * This is the Hilt NetworkUrlModule class which provides the base url to the NetworkModule.
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkUrlModule {

    @Provides
    @Singleton
    fun provideUrl(): String {
        return BASE_URL
    }
}