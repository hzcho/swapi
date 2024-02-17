package com.example.swapi.di

import android.app.Application
import androidx.room.Room
import com.example.swapi.data.datastore.DataStoreManager
import com.example.swapi.data.domain.MainDb
import com.example.swapi.data.domain.dao.PersonDao
import com.example.swapi.data.mapper.PersonMapper
import com.example.swapi.data.network.api.PersonService
import com.example.swapi.data.repository.PersonRepository
import com.example.swapi.data.repository.PersonRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMainDb(app: Application): MainDb {
        return Room.databaseBuilder(
            app,
            MainDb::class.java,
            "main_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit {
        val intercepter = HttpLoggingInterceptor()
        intercepter.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(intercepter)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providePersonService(retrofit: Retrofit): PersonService {
        return retrofit.create(PersonService::class.java)
    }

    @Provides
    @Singleton
    fun providePersonRepository(db: MainDb, service: PersonService): PersonRepository {
        return PersonRepositoryImpl(db.personDao, service)
    }

    @Provides
    @Singleton
    fun provideDataStoreManager(app:Application):DataStoreManager{
        return DataStoreManager(app)
    }
}