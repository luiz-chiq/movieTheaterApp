package chiquetano.luiz.movietheaterapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import androidx.room.Entity
import androidx.room.PrimaryKey

@Parcelize
@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    var username: String = "",
    var password: String = "",
    var userType: UserType = UserType.CLIENT


) : Parcelable
