import org.scalatest._
import org.scalatest.Assertions._
import scala.io.Source
import boggle.LetterTree
import boggle.RunBoggle
import boggle.Board

class TestRunBoggle extends FlatSpec with Matchers {
  
  "eg" should "Full suite of words should be found in the board" in {
    val mygrid = List(
        List('f', 'e', 'u', 'c'),
        List('z', 'a', 'd', 'r'),
        List('i', 'b', 's', 'o'),
        List('w', 'g', 'w', 't'))
    val board = new Board(mygrid)
    val dict = new LetterTree()
    println("creating dictionary ...")
    for (line <- Source.fromFile("/Users/andrea/workspace-scala/boggle/src/main/resources/dictionary.txt").getLines())
        dict.addWord(line + '$')
    val found = RunBoggle.findWords(board, dict)
    assert(isInList("fast", found) == true)
    assert(isInList("blue", found) == false)
    println(board)
  }
    def isInList(item:String, l:List[String]):Boolean = l match {
    	case Nil => false
    	case x :: xs => if (item == x) true else isInList(item,xs)
    }

}