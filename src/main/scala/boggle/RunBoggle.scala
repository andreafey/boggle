package boggle
import scala.io.Source

object RunBoggle {
    def main(args: Array[String]) {
        val board = new Board()
        val dict = new LetterTree()
        for (line <- Source.fromFile("smalldict.txt").getLines())
            dict.addWord(line + '$')
        println("aardvark: " + lookup("aardvark", dict))
        println("boolean: " + lookup("boolean", dict))
    }

    def traverse(b:Board, l:List[(Int, Int)]):String = {
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
    
}

