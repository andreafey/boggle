package boggle
import scala.util.Random

object Board {
  // TODO develop weighted sensible board
  def createBoard(boardsize: Int):List[List[Char]] = {
    val rand = new Random() 
	  (for {
		  x:Int <- Range(0,boardsize)
	  } yield (for {
		  y:Int <- Range(0,boardsize)
	  } yield int2Char(rand.nextInt(26))).toList).toList
  }
  def int2Char(x:Int):Char = {
  	(x+65).toChar.toLower
  } 
}

class Board(val grid:List[List[Char]]) {
  def boardsize = grid.size
  override def toString():String = {
    grid.foldLeft("")((s:String,row:List[Char]) => s + printRow(row))
  }
  def printRow(row:List[Char]):String = {
    row.foldLeft("")((s:String,c:Char) => s + c) + "\n"
  }
}