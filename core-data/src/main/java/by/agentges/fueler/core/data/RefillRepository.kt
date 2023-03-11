package by.agentges.fueler.core.data

import by.agentges.fueler.core.database.Refill
import by.agentges.fueler.core.database.RefillDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface RefillRepository {
    val refills: Flow<List<String>>

    suspend fun add(name: String)
}

class DefaultRefillRepository @Inject constructor(
    private val refillDao: RefillDao
) : RefillRepository {

    override val refills: Flow<List<String>> =
        refillDao.getRefills().map { items -> items.map { it.name } }

    override suspend fun add(name: String) {
        refillDao.insertRefill(Refill(name = name))
    }
}
