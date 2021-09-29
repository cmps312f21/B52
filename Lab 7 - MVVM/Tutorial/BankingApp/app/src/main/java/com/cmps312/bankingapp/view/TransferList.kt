package com.cmps312.bankingapp.view

import androidx.activity.ComponentActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cmps312.bankingapp.model.Transfer
import com.cmps312.bankingapp.viewmodel.BankingViewModel

@Composable
fun TransferList() {
    val bankingViewModel =
        viewModel<BankingViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)
    LazyColumn {
        items(bankingViewModel.transfers) { transfer ->
            TransferCard(transfer, onTransferSerlected = {
                bankingViewModel.selectedTransfer = transfer
            })
        }
    }

}

@Composable
fun TransferCard(transfer: Transfer, onTransferSerlected: () -> Unit) {
    Row(modifier = Modifier.clickable { onTransferSerlected() }) {
        transfer.beneficiaryName?.let { Text(text = it) }
    }
}