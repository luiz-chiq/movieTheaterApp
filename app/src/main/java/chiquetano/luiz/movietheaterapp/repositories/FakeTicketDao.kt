package chiquetano.luiz.movietheaterapp.repositories

import chiquetano.luiz.movietheaterapp.model.Ticket

class FakeTicketDao() : GenericDao<Ticket, Int> {

    private val ticketMap = mutableMapOf<Int, Ticket>()
    private var currentId = 1

    override fun create(ticket: Ticket): Int {
        val newId = currentId++
        ticketMap[newId] = ticket.copy(id = newId)
        return newId
    }

    override fun getOne(id: Int): Ticket? {
        return ticketMap[id]
    }

    override fun getAll(): MutableList<Ticket> {
        return ticketMap.values.toMutableList()
    }

    override fun update(ticket: Ticket): Int {
        return -1
    }

    override fun delete(id: Int): Int {
        if (ticketMap.containsKey(id)) {
            ticketMap.remove(id)
            return id
        }
        return -1
    }


}
