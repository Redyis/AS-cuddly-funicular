package com.redyis.as_cuddly_funicular.presentation.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.redyis.as_cuddly_funicular.presentation.viewmodel.InstallState

@Composable
fun InstallButton(
    installState: InstallState,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val buttonText = when (installState) {
        is InstallState.NotInstalled -> "Установить"
        is InstallState.Installing -> "Отменить (${installState.progress}%)"
        is InstallState.Installed -> "Установлено"
    }
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(vertical = 12.dp),
        enabled = installState !is InstallState.Installed,
        modifier = modifier,
    ) {
        Text(text = buttonText)
    }
}