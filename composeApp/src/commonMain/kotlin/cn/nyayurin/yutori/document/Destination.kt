package cn.nyayurin.yutori.document

import kotlinx.serialization.Serializable

@Serializable
sealed class ScreenDestination {
    @Serializable
    data object Home : ScreenDestination()

    @Serializable
    data object Loading : ScreenDestination()

    @Serializable
    data object Document : ScreenDestination()
}

@Serializable
sealed class DocumentDestination {
    @Serializable
    data object Introduction : DocumentDestination()

    @Serializable
    data class Resource(val destination: ResourceDestination) : DocumentDestination()

    @Serializable
    data class Advanced(val destination: AdvancedDestination) : DocumentDestination()

    @Serializable
    sealed class ResourceDestination {
        @Serializable
        data object Channel : ResourceDestination()

        @Serializable
        data object Guild : ResourceDestination()

        @Serializable
        data object GuildMember : ResourceDestination()

        @Serializable
        data object GuildRole : ResourceDestination()

        @Serializable
        data object Interaction : ResourceDestination()

        @Serializable
        data object Login : ResourceDestination()

        @Serializable
        data object Message : ResourceDestination()

        @Serializable
        data object Reaction : ResourceDestination()

        @Serializable
        data object User : ResourceDestination()
    }

    @Serializable
    sealed class AdvancedDestination {
        @Serializable
        data object Multiplatform : AdvancedDestination()

        @Serializable
        data object Resource : AdvancedDestination()

        @Serializable
        data object Admin : AdvancedDestination()
    }
}