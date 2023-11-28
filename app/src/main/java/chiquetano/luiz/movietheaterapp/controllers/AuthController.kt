package chiquetano.luiz.movietheaterapp.controller

import chiquetano.luiz.movietheaterapp.model.User
import chiquetano.luiz.movietheaterapp.model.UserType
import chiquetano.luiz.movietheaterapp.repositories.FakeUserDao
import chiquetano.luiz.movietheaterapp.views.MainActivity

class AuthController () {

    var userDao = FakeUserDao()
    var authUser = ""

    fun signIn(username: String, password: String): Boolean {
        if(userDao.getOne(username) != null) return false
        var user = User(username, password, UserType.CLIENT)
        userDao.create(user)
        authUser = username
        return true
    }

    fun logIn(username: String, password: String): Boolean {
        if(userDao.getOne(username) == null) return false
        if(userDao.getOne(username)!!.password != password) return false
        authUser = username
        return true
    }

    fun logOut() {
        authUser = ""
    }

    fun userIsAdmin(): Boolean {
        if (userDao.getUserType(authUser) == UserType.ADMIN) return true
        return false
    }

}