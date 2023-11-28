package chiquetano.luiz.movietheaterapp.repositories

import chiquetano.luiz.movietheaterapp.model.User
import chiquetano.luiz.movietheaterapp.model.UserType

class FakeUserDao() : GenericDao<User, String> {
    private val userMap = mutableMapOf<String, User>()

    override fun create(user: User): String {
        userMap[user.username] = user
        return user.username
    }

    override fun getOne(username: String): User? {
        return userMap[username]
    }

    override fun getAll(): MutableList<User> {
        return userMap.values.toMutableList()
    }

    override fun update(user: User): String {
        val existingUser = userMap[user.username]
        if (existingUser != null) {
            userMap[user.username] = user
            return user.username
        }
        return ""
    }

    override fun delete(username: String): String {
        if (userMap.containsKey(username)) {
            userMap.remove(username)
            return username
        }
        return ""
    }

    fun getUserType(username: String): UserType {
        return userMap[username]!!.userType
    }
}
