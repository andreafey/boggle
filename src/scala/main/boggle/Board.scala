package boggle
import scala.util.Random

class Board {
  val boardsize = 4                               //> boardsize  : Int = 4
  val rand = new Random()                         //> rand  : scala.util.Random = scala.util.Random@71971d92
  def int2Char(x:Int):Char = {
  	(x+65).toChar
  }                                               //> int2Char: (x: Int)Char
  val grid = createBoard()     //> res2: scala.collection.immutable.IndexedSeq[scala.collection.immutable.Index

		  def createBoard():IndexedSeq[IndexedSeq[Char]] = {
				  for {
					  x:Int <- Range(0,boardsize)
				  } yield
				  for {
					  y:Int <- Range(0,boardsize)
				  } yield int2Char(rand.nextInt(26))  
  }

  override def toString():String = {
    grid.foldLeft("")((s:String,row:IndexedSeq[Char]) => s + printRow(row))
  }
  def printRow(row:IndexedSeq[Char]):String = {
    row.foldLeft("")((s:String,c:Char) => s + c) + "\n"
  }
}