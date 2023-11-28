package chiquetano.luiz.movietheaterapp.repositories

import chiquetano.luiz.movietheaterapp.model.FilmSession
import chiquetano.luiz.movietheaterapp.model.Ticket

class FakeFilmSessionDao() {
    companion object {

        private val filmSessionMap = mutableMapOf<Int, FilmSession>()
        private var currentId = 1

        fun create(filmSession: FilmSession): Int {
            val newId = currentId++
            filmSessionMap[newId] = filmSession.copy(id = newId)
            return newId
        }

        fun addTicketsToSession(id: Int, ticket: Ticket) {
            filmSessionMap[id]?.seats?.add(ticket)
        }

        fun getOne(id: Int): FilmSession? {
            return filmSessionMap[id]
        }

        fun getAll(): MutableList<FilmSession> {
            return filmSessionMap.values.toMutableList()
        }

        fun update(filmSession: FilmSession): Int {
            val existingSession = filmSessionMap[filmSession.id]
            if (existingSession != null) {
                filmSessionMap[filmSession.id] = filmSession
                return filmSession.id
            }
            return -1
        }

        fun delete(id: Int): Int {
            if (filmSessionMap.containsKey(id)) {
                filmSessionMap.remove(id)
                return id
            }
            return -1
        }
    }


}
