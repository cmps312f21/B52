package com.cmps312.bankingapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.cmps312.bankingapp.repository.BankRepository

//hold all the data of the screens
class BankingViewModel(appContext: Application) : AndroidViewModel(appContext) {
    val bankRepository = BankRepository(appContext)

    //improvements
    val accounts by lazy { bankRepository.getAccounts() }
    val beneficiaries by lazy { bankRepository.getBeneficiaries() }

    val transfers = bankRepository.getTransfers()

}