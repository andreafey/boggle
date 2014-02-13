package boggle
import scala.util.Random

object testwksheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
 // val f = 12
  def times2(x:Int):Int = {
  	x*2
  }                                               //> times2: (x: Int)Int
//  times2(f)
  
  //new SillyFirstClass().foo
  //println("grab var"+SillyFirstClass.foo)
  
  def printch(x:Char) = {
  	println(x)
  }                                               //> printch: (x: Char)Unit
    val seq:IndexedSeq[Char] = IndexedSeq('A','R','T')
                                                  //> seq  : IndexedSeq[Char] = Vector(A, R, T)
    
    seq.foldLeft("")((s:String,c:Char) => s + c)  //> res0: String = ART
 RunBoggle.main(Array[String]())                  //> aardvark: true
                                                  //| boolean: false
  
  
}