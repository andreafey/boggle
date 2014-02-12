package boggle
import scala.io.Source

object RunBoggle {
    def main(args: Array[String]) {
        val board = new Board()
        val dict = new LetterTree()
        for (line <- Source.fromFile("/Users/andrea/workspace-scala/boggle/src/main/resources/dictionary.txt").getLines())
            dict.addWord(line + '$')
        println("aardvark: " + lookup("aardvark", dict))
        println("boolean: " + lookup("boolean", dict))
    }

    def wordFromGrid(b:Board, l:List[(Int, Int)]):String = {
       l.foldLeft("")((s:String, t:(Int, Int)) => s + b.grid(t._1)(t._2))
    }

    def lookup(s:String, lt:LetterTree):Boolean = s.toList match {
        case Nil => lt.getSubTree('$') match { 
                        case None => false
                        case _ => true
                    }
        case c::cs => lt.getSubTree(c) match {
                        case None => false
                        case Some(sub) => lookup(cs.mkString, sub)
                    }
    }
    
    def isWordInGrid(b:Board, s:String):Boolean = {
      
    }
    def isValidWord(s:String, dict:LetterTree):Boolean = {
      
    }
    
    
    def findWords(b:Board, dict:LetterTree):List[String] = {
      val letters = for {
		x:Int <- Range(0,b.boardsize)
		y:Int <- Range(0,b.boardsize)
	  } yield (x,y) 
	  val all = for {
	    (x,y) <- letters
	  } yield findWordsHelper(b, dict, List(), List((x,y)))
	  all.flatten
    }
    def findWords((Int,Int), b:Board, dict:LetterTree, found:List[String]):List[String] {
      
    }
    def findWordsHelper(b:Board, dict:LetterTree, found:List[String], usedCoords:List[(Int,Int)]):List[String] = {
      
    }
    
    def isInList(item:(Int,Int), l:List[(Int,Int)]):Boolean = l match {
    	case Nil => false
    	case x :: xs => if (item == x) true else isInList(item,xs)
    }
    def adjacentCoords(b:Board, coord:(Int,Int), usedCoords:List[(Int, Int)]):List[(Int, Int)] = {
      for {
        x:Int <- Range(coord._1-1, coord._1+1) if x >=0 && x < b.boardsize
        y:Int <- Range(coord._2-1, coord._2+1) if y >=0 && y < b.boardsize
      } yield (x, y) if isInList((x,y), usedCoords)
    }
    
}

