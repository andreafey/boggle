package boggle
import scala.io.Source

object RunBoggle {
    def main(args: Array[String]) {
        val board = new Board()
        val dict = new LetterTree()
        println("creating dictionary ...")
        for (line <- Source.fromFile("/Users/rule146/Dropbox/boggle/src/main/resources/dictionary.txt").getLines())
            dict.addWord(line + '$')
//        println("aardvark: " + lookup("aardvark", dict))
//        println("boolean: " + lookup("boolean", dict))
        println("finding words ...")
        val words:List[String] = findWords(board, dict)
        println("words found:")
        for ( w:String <- words) 
            println(w)
        println()
        println("board:")
        println(board)
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

/*
    def isWordInGrid(b:Board, s:String):Boolean = {
      
    }
    def isValidWord(s:String, dict:LetterTree):Boolean = {
      
    }
 */   

    def findWords(b:Board, dict:LetterTree):List[String] = {
      val letters = for {
		x:Int <- Range(0,b.boardsize)
		y:Int <- Range(0,b.boardsize)
	  } yield (x,y) 
	  val all = for {
	    (x,y) <- letters
	  } yield (x,y) 
      findWordsHelper(b, dict, List(), List(), all.toList)
    }

    def findWordsHelper(b:Board, dict:LetterTree, found:List[String], usedCoords:List[(Int,Int)], letters:List[(Int, Int)]):List[String] = letters match {
        case Nil => found
        case l :: ls => {
            val sub = dict.getSubTree(b.grid(l._1)(l._2))
            sub match {
                case None => List()
                case Some(subdict) => {
                    val adj = adjacentCoords(b, l, usedCoords)
                    subdict.getSubTree('$') match {
                        case None => findWordsHelper(b, subdict, found, usedCoords ++ List(l), adj)
                        case _ => findWordsHelper(b, subdict, wordFromGrid(b, usedCoords ++ List(l)) :: found, usedCoords ++ List(l), adj)
                    }
                        
                }
            }
        }
    }
    
    def isInList(item:(Int,Int), l:List[(Int,Int)]):Boolean = l match {
    	case Nil => false
    	case x :: xs => if (item == x) true else isInList(item,xs)
    }

    def adjacentCoords(b:Board, coord:(Int,Int), usedCoords:List[(Int, Int)]):List[(Int, Int)] = {
      (for {
        x <- (coord._1-1 until coord._1+1) if x >=0 && x < b.boardsize
        y <- (coord._2-1 until coord._2+1) if y >=0 && y < b.boardsize
        if (isInList((x,y), usedCoords))
      } yield (x, y)).toList
    }
    
}

