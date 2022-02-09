package com.technzone.car_auto_browser.data.enums

interface UserEnums {

    enum class UserState {
        NotLoggedIn,
        LoggedIn;

        companion object {
            fun getUserStateByPosition(position: Int): UserState {
                return when (position) {
                    0 -> NotLoggedIn
                    else -> LoggedIn
                }
            }
        }
    }
}