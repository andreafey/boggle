package boggle

import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.Assertions._
import boggle._
import phonebook.PrefixTrie
import org.scalatest.junit.JUnitRunner
import scala.io.Source

@RunWith(classOf[JUnitRunner])
class TestRunBoggle extends FlatSpec with Matchers with ShouldMatchers {
  "findWords" should "full suite of words should be found in the board" in {
    val mygrid = List(
        List('f', 'e', 'u', 'c'),
        List('z', 'a', 'd', 'r'),
        List('i', 'b', 's', 'o'),
        List('w', 'g', 'w', 't'))
    val board = new Board(mygrid)
    val dict = new PrefixTrie[String]()
    println("creating dictionary ...")
    for (line <- Source.fromFile("src/main/resources/dictionary.txt").getLines())
        dict.put(line, line)
    val found = RunBoggle.findWords(board, dict)
    println(dict.item)
    assert(isInList("fast", found) == true)
    assert(isInList("blue", found) == false)
    assert(found.size > 140)
    println(board)
  }
  "isInList" should "find coord (tuple) in coord list" in {
    val coords = List((0,1),(0,2))
    assert(RunBoggle.isInList((0,1), coords) == true)
    assert(RunBoggle.isInList((1,1), coords) == false)
  }
  "adjacentCoords" should "find all adjacent coordinates if none are used already" in {
    val mygrid = List(
        List('f', 'e', 'u', 'c'),
        List('z', 'a', 'd', 'r'),
        List('i', 'b', 's', 'o'),
        List('w', 'g', 'w', 't'))
    val board = new Board(mygrid)
    val adj = RunBoggle.adjacentCoords(board, (0,0), List())
    assert(adj.size == 3)
    assert(RunBoggle.isInList((0,0), adj) == false)
    assert(RunBoggle.isInList((0,1), adj) == true)
    
    val adj2 = RunBoggle.adjacentCoords(board, (1,1), List())
    assert(adj2.size == 8)
  }
  "adjacentCoords" should "exclude coordinates which have been used already" in {
    val mygrid = List(
        List('f', 'e', 'u', 'c'),
        List('z', 'a', 'd', 'r'),
        List('i', 'b', 's', 'o'),
        List('w', 'g', 'w', 't'))
    val board = new Board(mygrid)
    val adj = RunBoggle.adjacentCoords(board, (1,1), List((0,1),(1,2)))
    assert(adj.size == 6)
    assert(RunBoggle.isInList((0,1), adj) == false)
    assert(RunBoggle.isInList((2,2), adj) == true)
    
  }
  def isInList(item:String, l:List[String]):Boolean = l match {
    	case Nil => false
    	case x :: xs => if (item == x) true else isInList(item,xs)
  }
}
