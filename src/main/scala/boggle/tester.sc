package boggle
import scala.io.Source

object tester {
	val mygrid = List(
        List('f', 'e', 'u', 'c'),
        List('z', 'a', 'd', 'r'),
        List('i', 'b', 's', 'o'),
        List('w', 'g', 'w', 't'))                 //> mygrid  : List[List[Char]] = List(List(f, e, u, c), List(z, a, d, r), List(i
                                                  //| , b, s, o), List(w, g, w, t))
        val board = new Board(mygrid)             //> board  : boggle.Board = feuc
                                                  //| zadr
                                                  //| ibso
                                                  //| wgwt
                                                  //| 
 val dict = new LetterTree()                      //> dict  : boggle.LetterTree = boggle.LetterTree@4a1c5fd5/
for (line <- Source.fromFile("/Users/andrea/workspace-scala/boggle/src/main/resources/dictionary.txt").getLines())
  dict.addWord(line.toLowerCase() + '$')

//RunBoggle.findAndPrintWords(board, dictionary)
}