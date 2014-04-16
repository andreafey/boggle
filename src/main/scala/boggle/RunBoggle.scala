package boggle
import scala.io.Source
import phonebook.PrefixTrie

object RunBoggle {
    def main(args: Array[String]) {
	val mygrid = List(
        List('f', 'e', 'u', 'c'),
        List('z', 'a', 'd', 'r'),
        List('i', 'b', 's', 'o'),
        List('w', 'g', 'w', 't')) 
	val evilgrid = List(
        List('s', 'e', 'r', 's'),
        List('p', 'a', 't', 'g'),
        List('l', 'i', 'n', 'e'),
        List('s', 'e', 'r', 's')) 
        val board = new Board(mygrid)
        val dict = new PrefixTrie[String]()
        println("creating dictionary ...")
        for (line <- Source.fromFile("src/main/resources/dict2.txt").getLines())
            dict.put(line.toLowerCase(), line)
      findAndPrint(board, dict)
      val evilboard = new Board(evilgrid)
	  findAndPrint(evilboard, dict)
    }

    /**
     * Convert a list of grid coordinates into a word
     */
    def wordFromGrid(b:Board, l:List[(Int, Int)]):String = 
       l.foldLeft("")((s:String, t:(Int, Int)) => s + b.grid(t._1)(t._2))
    

   /**
    * Lookup a word in a LetterTree dictionary
    */
    def lookup(s:String, dict:PrefixTrie[String]):Boolean = dict.find(s.toList) match {
        case None => false
        case _ => true
    }

/*
    def isWordInGrid(b:Board, s:String):Boolean = {
      
    }
    def isValidWord(s:String, dict:LetterTree):Boolean = {
      
    }
 */   

    /**
     * Find all dictionary words in a Boggle board
     */
    def findWords(b:Board, dict:PrefixTrie[String]):List[String] = 
	  findWordsHelper(b, dict, List(), List(), b.coords)

    /**
     * Recursion helper function to findWords
     */
    private def findWordsHelper(b:Board, dict:PrefixTrie[String], found:List[String], usedCoords:List[(Int,Int)], letters:List[(Int, Int)]):List[String] = letters match {
        case Nil => found
        case l :: ls => {
            val sub:Option[PrefixTrie[String]] = dict.find(List(b.grid(l._1)(l._2)))
            (sub match {
                case None => List()
                case Some(subdict) => {
                    val adj = adjacentCoords(b, l, usedCoords)
                    subdict.item match {
                        case None => findWordsHelper(b, subdict, List(), usedCoords ++ List(l), adj)
                        case _ => findWordsHelper(b, subdict, List(wordFromGrid(b, usedCoords ++ List(l))), usedCoords ++ List(l), adj)
                    }                        
                }
            }) ++ findWordsHelper(b, dict, found, usedCoords, ls)
        }
    }
    
    /**
     * Checks whether a coordinate (tuple) is in a list of coordinates
     */
    def isInList(item:(Int,Int), l:List[(Int,Int)]):Boolean = l match {
    	case Nil => false
    	case x :: xs => if (item == x) true else isInList(item,xs)
    }

    /**
     * Finds coordinates adjacent to a board square which have not already been used in a word's prefix
     */
    def adjacentCoords(b:Board, coord:(Int,Int), usedCoords:List[(Int, Int)]):List[(Int, Int)] = {
      (for {
        x <- (coord._1-1 until coord._1+2) if x >=0 && x < b.boardsize
        y <- (coord._2-1 until coord._2+2) if y >=0 && y < b.boardsize
        if (! ((x,y) == coord) && ! isInList((x,y), usedCoords))
      } yield (x, y)).toList
    }
   /**
    * Find all words in a dictionary and print them to the console
    */
   def findAndPrint(board: boggle.Board, dict: PrefixTrie[String]): Unit = {
      println("finding words ...")
      val words:List[String] = findWords(board, dict)
//      println("words found:")
//      for ( w:String <- words) 
//          println(w)
      println(words.size+" words found")
      println()
      println("board:")
      println(board)
    }
    
}

