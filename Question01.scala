object Main {
    
    val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    def Encrypt(c: Char, key: Int, a: String) = a((a.indexOf(c.toUpper) + key) % a.size)
    def Decrypt(c: Char, key: Int, a: String) = a((a.indexOf(c.toUpper) - key) % a.size)

    def cipher(algo: (Char, Int, String) => Char, s: String, key: Int, a: String) = s.map(algo(_, key, a))

    def main(args: Array[String]) = {

        val ct1 = cipher(Encrypt, "dhananga", 1, alphabet)
        println(ct1)
        val pt1 = cipher(Decrypt, ct1, 1, alphabet)
        println(pt1)

        val ct2 = cipher(Encrypt, "DeEpanJaNA", 5, alphabet)
        println(ct2)
        val pt2 = cipher(Decrypt, ct2, 5, alphabet)
        println(pt2) 
    }
}