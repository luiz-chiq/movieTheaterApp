package chiquetano.luiz.movietheaterapp.repositories

import chiquetano.luiz.movietheaterapp.model.Ticket

class FakeTicketDao(){
    companion object {
        private val ticketMap = mutableMapOf<Int, Ticket>()
        private var currentId = 1

        fun create(ticket: Ticket): Int {
            val newId = currentId++
            ticketMap[newId] = ticket.copy(id = newId)
            return newId
        }

        fun getOne(id: Int): Ticket? {
            return ticketMap[id]
        }

        fun getAll(): MutableList<Ticket> {
            return ticketMap.values.toMutableList()
        }

        fun update(ticket: Ticket): Int {
            return -1
        }

        fun delete(id: Int): Int {
            if (ticketMap.containsKey(id)) {
                ticketMap.remove(id)
                return id
            }
            return -1
        }
    }

}
