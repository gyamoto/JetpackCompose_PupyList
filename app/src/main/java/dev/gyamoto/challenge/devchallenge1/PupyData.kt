package dev.gyamoto.challenge.devchallenge1

data class Pupy(
    val id: String,
    val name: String,
    val imageUrl: String,
    val address: String,
    val birthday: String
)

object PupyData {

    val list = listOf(
        Pupy(
            id = "1234",
            name = "John",
            imageUrl = "https://place-puppy.com/300x300",
            address = "Davenport, California",
            birthday = "December 2020",
        ),
        Pupy(
            id = "5678",
            name = "Jane",
            imageUrl = "https://place-puppy.com/301x301",
            address = "Fresno, California",
            birthday = "May 2020",
        ),
        Pupy(
            id = "90ab",
            name = "Ken",
            imageUrl = "https://place-puppy.com/302x302",
            address = "Davis, California",
            birthday = "June 2020",
        ),
        Pupy(
            id = "cdef",
            name = "Karen",
            imageUrl = "https://place-puppy.com/303x303",
            address = "Concord, California",
            birthday = "December 2020",
        ),
    )
}