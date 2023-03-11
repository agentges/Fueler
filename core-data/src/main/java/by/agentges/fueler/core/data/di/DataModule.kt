package by.agentges.fueler.core.data.di

import by.agentges.fueler.core.data.DefaultRefillRepository
import by.agentges.fueler.core.data.RefillRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Singleton
    @Binds
    fun bindsRefillRepository(
        refillRepository: DefaultRefillRepository
    ): RefillRepository
}

class FakeRefillRepository @Inject constructor() : RefillRepository {
    override val refills: Flow<List<String>> = flowOf(fakeRefills)

    override suspend fun add(name: String) {
        throw NotImplementedError()
    }
}

val fakeRefills = listOf("One", "Two", "Three")
