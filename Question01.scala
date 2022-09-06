object Main {
    val ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ !,"
    val KEY = 4

    def shift(direction: Int, index: Int, key: Int, asize: Int) = {
        var temp = (index + direction * key) % asize
        if(temp < 0) temp = temp + asize
        temp 
    }
    
    def Encrypt(c: Char, key: Int, a: String) = a(shift(1, a.indexOf(c.toUpper), 4, a.size))

    def Decrypt(c: Char, key: Int, a: String) = a(shift(-1, a.indexOf(c.toUpper), 4, a.size))

    def cipher(algo: (Char, Int, String) => Char, s: String, key: Int, a: String) = s.map(algo(_, key, a))

    def main(args: Array[String]) = {
        val text = "Hello, World!"

        val ct = cipher(Encrypt, text, KEY, ALPHABET)
        println("\nCIPER TEXT : " + ct + "\n")

        val pt = cipher(Decrypt, ct, KEY, ALPHABET)
        println("ORIJINAL TEXT : " + pt)
        
    }
}
