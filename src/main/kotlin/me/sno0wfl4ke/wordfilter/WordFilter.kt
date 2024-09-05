package me.sno0wfl4ke.wordfilter

import com.opencsv.CSVReader
import java.io.InputStreamReader
import java.lang.IllegalArgumentException

fun main() {
    val wordFilter = WordFilter()
    wordFilter.run()
}

class WordFilter {

    private var loaded = false

    private val hashSet: HashSet<String> = HashSet()

    private fun findWord(word: String): Boolean {
        return hashSet.contains(word)
    }

    fun loadWords(filePath: String) {
        if (loaded) {
            throw IllegalArgumentException("[wordfilter] Already loaded all entries!")
        }

        val inputStream = this::class.java.getResourceAsStream("/$filePath")
            ?: throw IllegalArgumentException("Resource not found: /$filePath")

        val reader = CSVReader(InputStreamReader(inputStream))
        val lines = reader.readAll()

        lines.forEach { line -> hashSet.addAll(listOf(line[0])) }

        loaded = true
    }

    fun searchWord(word: String): Boolean {
        if (!loaded)
            throw IllegalArgumentException("[wordfilter] No entries loaded!")
        return findWord(word)
    }

    fun analyseString(input: String): String {
        var censoredString = input
        val strArray = input.lowercase().split(" ").toTypedArray()
        var badWordCounter = 0
        var wordCount = 0

        var wordFound = false

        strArray.forEach { word ->
            wordFound = searchWord(removePunctuation(word))
            if (wordFound) {
                badWordCounter += 1
                censoredString = censoredString.replace(word, censorWord(word))
            }

            wordCount += 1
        }
        return censoredString
    }

    private val regexWord = Regex("[a-zA-Z0-9]", RegexOption.IGNORE_CASE)
    private val regexPunctuation = Regex("[=?!.,;:]", RegexOption.IGNORE_CASE)

    fun censorWord(word: String): String {
        return word.replace(regexWord, "*")
    }

    fun removePunctuation(sentence: String): String {
        return sentence.replace(regexPunctuation, "")
    }

    // Testing
    fun run() {
        //loadWords("full-word-list.csv")
        //println(analyseString("Man, I was just minding my own damn business when my cat decided to knock over my coffee, spilled all over the keyboard! What a freaking mess, now my day’s all jacked up. Guess it’s just one of those hellish days, huh?"))
    }


}

