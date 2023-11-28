package chiquetano.luiz.movietheaterapp.repositories

import chiquetano.luiz.movietheaterapp.model.FilmSession
import chiquetano.luiz.movietheaterapp.model.Ticket

class FakeFilmSessionDao() : GenericDao<FilmSession, Int> {

    private val filmSessionMap = mutableMapOf<Int, FilmSession>()
    private var currentId = 1

    override fun create(filmSession: FilmSession): Int {
        val newId = currentId++
        filmSessionMap[newId] = filmSession.copy(id = newId)
        return newId
    }

    fun addTicketsToSession(id: Int, ticket: Ticket){
        filmSessionMap[id]?.seats?.add(ticket)
    }

    override fun getOne(id: Int): FilmSession? {
        return filmSessionMap[id]
    }

    override fun getAll(): MutableList<FilmSession> {
        return filmSessionMap.values.toMutableList()
    }

    override fun update(filmSession: FilmSession): Int {
        val existingSession = filmSessionMap[filmSession.id]
        if (existingSession != null) {
            filmSessionMap[filmSession.id] = filmSession
            return filmSession.id
        }
        return -1
    }

    override fun delete(id: Int): Int {
        if (filmSessionMap.containsKey(id)) {
            filmSessionMap.remove(id)
            return id
        }
        return -1
    }


}
