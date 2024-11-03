package com.example.chatapplication.ui.navigation

import androidx.navigation.NamedNavArgument

interface AppRoute {
    val arguments: List<NamedNavArgument>
    val path: String
}

object AppDestinations {

    val login = object : AppRoute {
        override val arguments: List<NamedNavArgument> = emptyList()
        override val path: String = "login"
    }

    val signUp = object : AppRoute {
        override val arguments: List<NamedNavArgument> = emptyList()
        override val path: String = "signin"
    }

    val home = object : AppRoute {
        override val arguments: List<NamedNavArgument> = emptyList()
        override val path: String = "home"
    }

    val settings = object : AppRoute {
        override val arguments: List<NamedNavArgument> = emptyList()
        override val path: String = "settings"
    }
}