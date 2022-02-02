package com.example.kotlindemo.LocalScoping

import android.net.wifi.p2p.WifiP2pDevice
import java.util.*


val viewModel = ViewModel()



fun refreshViewModelJavaStyle(response: ResponsePojo, device: WifiP2pDevice){
    viewModel.name = response.name
    viewModel.address = response.address
    viewModel.age = getAge(response.dob)
    viewModel.isWifiConnected = getStatus(device.status)
}

fun refreshViewModelKotlinStyle(response: ResponsePojo, device: WifiP2pDevice){
    with(viewModel) {
        name = response.name
        address = response.address
        age = getAge(response.dob)
        isWifiConnected = getStatus(device.status)
    }
}












class ResponsePojo(val name:String?, val address:String?, val dob:Date)
class ViewModel{
    var name:String? = null
    var address:String? = null
    var age:Int? = null
    var isWifiConnected:String?=null
}
fun getAge(dob: Date): Int? {
    return 0
}
fun getStatus(status: Int): String {
    return ""
}
