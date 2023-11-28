package chiquetano.luiz.movietheaterapp.repositories

interface GenericDao<T, V> {
    fun create(entity: T): V
    fun getOne(id: V): T?
    fun getAll(): MutableList<T>
    fun update(entity: T): V
    fun delete(id: V): V
}