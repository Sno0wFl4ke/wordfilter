package me.sno0wfl4ke.wordfilter.utils

class HashFilter {

    private val hashSet: HashSet<String> = HashSet()

    fun insertAllWords(words: List<String>) {
        // Runtime complexity of this operation is O(n), where n is the number of words
        hashSet.addAll(words)
    }

    // Runtime complexity of this operation is O(1)
    fun findWord(word: String): Boolean {
        return hashSet.contains(word)
    }


}