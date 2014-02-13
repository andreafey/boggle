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
          val dict = new LetterTree()             //> dict  : boggle.LetterTree = boggle.LetterTree@2083fc73
        println("creating dictionary ...")        //> creating dictionary ...
        for (line <- Source.fromFile("/Users/andrea/workspace-scala/boggle/src/main/resources/dictionary.txt").getLines())
            dict.addWord(line.toLowerCase() + '$')
  
     RunBoggle.findWords(board,dict)              //> res0: List[String] = List()
   5 until 10                                     //> res1: scala.collection.immutable.Range = Range(5, 6, 7, 8, 9)
   
   val used = List((0,0))                         //> used  : List[(Int, Int)] = List((0,0))
   val foo =(used.head._1 - 1 until used.head._1 + 2)
                                                  //> foo  : scala.collection.immutable.Range = Range(-1, 0, 1)
   RunBoggle.isInList((0,0), used)                //> res2: Boolean = true
   RunBoggle.isInList((0,1), used)                //> res3: Boolean = false
  
   val adj = List((0,1), (1,1), (1,0))            //> adj  : List[(Int, Int)] = List((0,1), (1,1), (1,0))
   
   RunBoggle.adjacentCoords(board,(0,0),List((0,0)))
                                                  //> res4: List[(Int, Int)] = List((0,1), (1,0), (1,1))
   
   
}