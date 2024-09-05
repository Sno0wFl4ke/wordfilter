/*package me.sno0wfl4ke.me.sno0wfl4ke.wordfilter.utils

/*
    * This class represents a TrieNode data structure
    * It is used to store characters and check if a word exists in the Trie
 */

class TrieNode {
    val children: HashMap<Char, TrieNode> = HashMap()
    var content: String = ""
    var isWord: Boolean = false
}

/*
    * This class represents a Trie data structure
    * It is used to store words and check if a word exists in the Trie
    * It also provides a method to check if any word in the Trie starts with a given prefix
    * Runtime complexity of all operations is O(n), where n is the length of the word
 */

/*
class Trie {
    private val root: TrieNode = TrieNode()

    // Insert a word into the Trie
    fun insertNode(word: String) {
        var node = root
        for (char in word) {
            node = node.children.getOrPut(char) { TrieNode() }
        }
        node.isWord = true
        node.content = word
    }

    // Search for a word in the Trie
    fun searchNode(word: String): Boolean {
        var node = root
        for (char in word) {
            node = node.children[char] ?: return false
        }
        return node.isWord
    }

    // Check if any word in the Trie starts with the given prefix
    fun startsWith(prefix: String): Boolean {
        var node = root
        for (char in prefix) {
            node = node.children[char] ?: return false
        }
        return true
    }
}
 */