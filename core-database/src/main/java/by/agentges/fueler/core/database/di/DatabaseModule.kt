/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.template.core.database.di

import android.content.Context
import androidx.room.Room
import by.agentges.fueler.core.database.FuelerDatabase
import by.agentges.fueler.core.database.RefillDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun provideRefillDao(appDatabase: FuelerDatabase): RefillDao {
        return appDatabase.refillDao()
    }

    @Provides
    @Singleton
    fun provideFuelerDatabase(@ApplicationContext appContext: Context): FuelerDatabase {
        return Room.databaseBuilder(
            appContext,
            FuelerDatabase::class.java,
            "Refill"
        ).build()
    }
}
