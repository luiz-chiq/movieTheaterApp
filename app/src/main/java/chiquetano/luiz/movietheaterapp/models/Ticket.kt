package chiquetano.luiz.movietheaterapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import androidx.room.Entity
import androidx.room.PrimaryKey

@Parcelize
@Entity
data class Ticket(
    @PrimaryKey(autoGenerate = true)
    var id: Int = -1,
    var user: User = User() ,
    var seat: String = "",

    ) : Parcelable
