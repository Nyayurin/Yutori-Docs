package cn.nyayurin.yutori.document.componments.document

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import cn.nyayurin.yutori.document.DocumentDestination

@Composable
fun Resource(destination: DocumentDestination.ResourceDestination) {
    when (destination) {
        DocumentDestination.ResourceDestination.Channel -> Channel()
        DocumentDestination.ResourceDestination.Guild -> Guild()
        DocumentDestination.ResourceDestination.GuildMember -> GuildMember()
        DocumentDestination.ResourceDestination.GuildRole -> GuildRole()
        DocumentDestination.ResourceDestination.Interaction -> Interaction()
        DocumentDestination.ResourceDestination.Login -> Login()
        DocumentDestination.ResourceDestination.Message -> Message()
        DocumentDestination.ResourceDestination.Reaction -> Reaction()
        DocumentDestination.ResourceDestination.User -> User()
    }
}

@Composable
private fun Channel() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
    }
}

@Composable
private fun Guild() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
    }
}

@Composable
private fun GuildMember() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
    }
}

@Composable
private fun GuildRole() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
    }
}

@Composable
private fun Interaction() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
    }
}

@Composable
private fun Login() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
    }
}

@Composable
private fun Message() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
    }
}

@Composable
private fun Reaction() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
    }
}

@Composable
private fun User() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
    }
}
