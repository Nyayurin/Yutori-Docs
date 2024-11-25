package cn.nyayurin.yutori.document.componments.document

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import cn.nyayurin.yutori.document.DocumentDestination

@Composable
fun Resource(
    destination: DocumentDestination.ResourceDestination,
    padding: Dp,
) {
    when (destination) {
        DocumentDestination.ResourceDestination.Channel -> Channel(padding)
        DocumentDestination.ResourceDestination.Guild -> Guild(padding)
        DocumentDestination.ResourceDestination.GuildMember -> GuildMember(padding)
        DocumentDestination.ResourceDestination.GuildRole -> GuildRole(padding)
        DocumentDestination.ResourceDestination.Interaction -> Interaction(padding)
        DocumentDestination.ResourceDestination.Login -> Login(padding)
        DocumentDestination.ResourceDestination.Message -> Message(padding)
        DocumentDestination.ResourceDestination.Reaction -> Reaction(padding)
        DocumentDestination.ResourceDestination.User -> User(padding)
    }
}

@Composable
private fun Channel(padding: Dp) {
    Text(
        text = "Coming soon...",
        modifier = Modifier.padding(vertical = padding),
        style = MaterialTheme.typography.headlineLarge,
    )
}

@Composable
private fun Guild(padding: Dp) {
    Text(
        text = "Coming soon...",
        modifier = Modifier.padding(vertical = padding),
        style = MaterialTheme.typography.headlineLarge,
    )
}

@Composable
private fun GuildMember(padding: Dp) {
    Text(
        text = "Coming soon...",
        modifier = Modifier.padding(vertical = padding),
        style = MaterialTheme.typography.headlineLarge,
    )
}

@Composable
private fun GuildRole(padding: Dp) {
    Text(
        text = "Coming soon...",
        modifier = Modifier.padding(vertical = padding),
        style = MaterialTheme.typography.headlineLarge,
    )
}

@Composable
private fun Interaction(padding: Dp) {
    Text(
        text = "Coming soon...",
        modifier = Modifier.padding(vertical = padding),
        style = MaterialTheme.typography.headlineLarge,
    )
}

@Composable
private fun Login(padding: Dp) {
    Text(
        text = "Coming soon...",
        modifier = Modifier.padding(vertical = padding),
        style = MaterialTheme.typography.headlineLarge,
    )
}

@Composable
private fun Message(padding: Dp) {
    Text(
        text = "Coming soon...",
        modifier = Modifier.padding(vertical = padding),
        style = MaterialTheme.typography.headlineLarge,
    )
}

@Composable
private fun Reaction(padding: Dp) {
    Text(
        text = "Coming soon...",
        modifier = Modifier.padding(vertical = padding),
        style = MaterialTheme.typography.headlineLarge,
    )
}

@Composable
private fun User(padding: Dp) {
    Text(
        text = "Coming soon...",
        modifier = Modifier.padding(vertical = padding),
        style = MaterialTheme.typography.headlineLarge,
    )
}