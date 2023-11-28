package chiquetano.luiz.movietheaterapp.controller


import chiquetano.luiz.movietheaterapp.model.FilmSession
import chiquetano.luiz.movietheaterapp.model.User
import chiquetano.luiz.movietheaterapp.model.UserType
import chiquetano.luiz.movietheaterapp.repositories.FakeFilmSessionDao
import chiquetano.luiz.movietheaterapp.views.MainActivity

class AdminController(private val mainActivity: MainActivity) {


    fun insertSession(filmSession: FilmSession, user: User) {
        if(user.userType == UserType.ADMIN)
            FakeFilmSessionDao.create(filmSession)
    }

    fun getSession(id: Int, user: User) {
        if(user.userType == (UserType.ADMIN))
            FakeFilmSessionDao.getOne(id)
    }

    fun getSessions(user: User) {
        if(user.userType == (UserType.ADMIN))
            FakeFilmSessionDao.getAll()

    }

    fun removeSession(id: Int, user: User) {
        if(user.userType == (UserType.ADMIN))
            FakeFilmSessionDao.delete(id)

    }
}
