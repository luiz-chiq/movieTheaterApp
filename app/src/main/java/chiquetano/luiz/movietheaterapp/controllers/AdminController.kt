package chiquetano.luiz.movietheaterapp.controller


import chiquetano.luiz.movietheaterapp.model.FilmSession
import chiquetano.luiz.movietheaterapp.model.User
import chiquetano.luiz.movietheaterapp.model.UserType
import chiquetano.luiz.movietheaterapp.repositories.FakeFilmSessionDao
import chiquetano.luiz.movietheaterapp.views.MainActivity

class AdminController(private val mainActivity: MainActivity) {

    var sessionDao = FakeFilmSessionDao()

    fun insertSession(filmSession: FilmSession, user: User) {
        if(user.userType == UserType.ADMIN)
            sessionDao.create(filmSession)
    }

    fun getSession(id: Int, user: User) {
        if(user.userType == (UserType.ADMIN))
            sessionDao.getOne(id)
    }

    fun getSessions(user: User) {
        if(user.userType == (UserType.ADMIN))
            sessionDao.getAll()

    }

    fun removeSession(id: Int, user: User) {
        if(user.userType == (UserType.ADMIN))
            sessionDao.delete(id)

    }
}
