package chiquetano.luiz.movietheaterapp.repositories

import chiquetano.luiz.movietheaterapp.model.User
import chiquetano.luiz.movietheaterapp.model.UserType

class FakeUserDao() {

    companion object {
        private val userMap = mutableMapOf<String, User>()

        init {
            userMap["admin"] = User("admin", "123", UserType.ADMIN)
        }

        fun create(user: User): String {
            userMap[user.username] = user
            return user.username
        }

        fun getOne(username: String): User? {
            return userMap[username]
        }

        fun getAll(): MutableList<User> {
            return userMap.values.toMutableList()
        }

        fun update(user: User): String {
            val existingUser = userMap[user.username]
            if (existingUser != null) {
                userMap[user.username] = user
                return user.username
            }
            return ""
        }

        fun delete(username: String): String {
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
}
