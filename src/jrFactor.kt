/**
 * Created by akyun on 6.07.2017.
 */
package tr.gen.ak.yunus

import java.io.*
fun main(args: Array<String>) {
    println("""
   _     ______ ___  _____ _____ ___________
  (_)    |  ___/ _ \/  __ \_   _|  _  | ___ \
   _ _ __| |_ / /_\ \ /  \/ | | | | | | |_/ /
  | | '__|  _||  _  | |     | | | | | |    /
  | | |_ | |  | | | | \__/\ | | \ \_/ / |\ \
  | |_(_)\_|  \_| |_/\____/ \_/  \___/\_| \_|
 _/ |
|__/

""")
    println("Girilen sayı çarpanlarına ayrılır. Çıkış için 0 girin.")
    println("Girilebilecek en büyük sayı: "+ Long.MAX_VALUE)

    var num: Long
    while(true) {
        try {
            if (args.size == 0) {
                print("Sayi girin: ")
                num = readLine()!!.toLong()

            } else {
                num = args[0].toLong()
            }
        } catch (e: NumberFormatException) {
            num = 0
        }
        if (num<2) {
            println("Uygulama kapandı")
            break
        }
        var factors: String = "";
        val sn = with(factors) {
            (kotlin.system.measureTimeMillis {
                factors = jrFactor(num)
            } * 0.001).toString()
        }
        println("$num = $factors")
        println("$sn saniyede bulundu.")
    }
}
fun jrFactor(Number:Long):String {
    val primeFile = File("milyonasal.txt")
    val input = primeFile.bufferedReader()
    var str: String? = ""
    var i:Long
    while(true) {
        str=input.readLine()
        if(str==null) break
        i = str.toLong()
        if (i*i > Number) break
        if (Number % i == 0L) return "$i x " + jrFactor(Number/i)
    }
    return Number.toString()
}
