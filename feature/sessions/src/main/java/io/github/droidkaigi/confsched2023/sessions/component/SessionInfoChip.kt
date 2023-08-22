package io.github.droidkaigi.confsched2023.sessions.component

import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.ChipBorder
import androidx.compose.material3.ChipColors
import androidx.compose.material3.ChipElevation
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun SessionInfoChip(
    label: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = SuggestionChipDefaults.shape,
    colors: ChipColors = SuggestionChipDefaults.suggestionChipColors(),
    icon: @Composable (() -> Unit)? = null,
    border: ChipBorder? = SuggestionChipDefaults.suggestionChipBorder(),
    elevation: ChipElevation? = SuggestionChipDefaults.suggestionChipElevation(),
) {
    SuggestionChip(
        onClick = { /* Do nothing */ },
        label = label,
        enabled = enabled,
        shape = shape,
        colors = colors,
        icon = icon,
        elevation = elevation,
        border = border,
        modifier = modifier,
        interactionSource = NoRippleInteractionSource(),
    )
}

private class NoRippleInteractionSource : MutableInteractionSource {
    override val interactions: Flow<Interaction> = emptyFlow()
    override suspend fun emit(interaction: Interaction) {}
    override fun tryEmit(interaction: Interaction) = true
}
