package chiquetano.luiz.movietheaterapp.controller

import chiquetano.luiz.movietheaterapp.model.Ticket
import chiquetano.luiz.movietheaterapp.model.User
import chiquetano.luiz.movietheaterapp.model.UserType
import chiquetano.luiz.movietheaterapp.repositories.FakeFilmSessionDao
import chiquetano.luiz.movietheaterapp.views.MainActivity

class ClientController (private val mainActivity: MainActivity) {

    var sessionDao = FakeFilmSessionDao()

    fun buyTicket(sessionId: Int, seat: String, user: User) {
        if(user.userType == UserType.CLIENT){
            var ticket = Ticket(-1, user, seat)
            sessionDao.addTicketsToSession(sessionId, ticket)
        }
    }

    fun getSessions(user: User) {
        if(user.userType == (UserType.CLIENT))
            sessionDao.getAll()

    }

}