// This class yanked from:
// http://oldfashionedsoftware.com/2009/07/06/scala-boggles-the-mind/
package boggle
import scala.collection.mutable.HashMap
 
class LetterTree {
    private val nodes: HashMap[Char,LetterTree] = new HashMap[Char,LetterTree]
    var terminal: Boolean = false
    def addWord(word: String): Unit = addWord(word.toList)
    def addWord(word: List[Char]): Unit = word match {
        case Nil          => terminal = true
        case head :: tail => nodes.getOrElseUpdate(head, new LetterTree).addWord(tail)
    }
    def getSubTree(letter: Char): Option[LetterTree] =
        if (nodes.contains(letter)) Some(nodes(letter)) else None
}

