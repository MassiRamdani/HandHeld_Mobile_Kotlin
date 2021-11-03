package fr.rmdcoding.handheld_mobile_kotlin.Enum

import fr.rmdcoding.handheld_mobile_kotlin.R

enum class PaymentMode(val mode: Int) {
    mode1(R.string.carte),
    mode2(R.string.cheque),
    mode3(R.string.espece),
    mode4(R.string.versement),
    mode5(R.string.virement)


}
