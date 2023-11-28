package chiquetano.luiz.movietheaterapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.time.LocalDateTime

@Parcelize
@Entity
data class FilmSession(
    @PrimaryKey(autoGenerate = true)
    var id: Int = -1,
    var film: String = "",
    var sessionDateTime: LocalDateTime = LocalDateTime.now(),
    var seats : MutableList<Ticket> = mutableListOf()

) : Parcelable