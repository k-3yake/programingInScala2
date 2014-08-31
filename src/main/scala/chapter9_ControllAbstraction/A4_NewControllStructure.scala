package chapter9_ControllAbstraction

import java.io.PrintWriter
import java.io.File

/**
  * Created by katsuki on 2014/08/16.
  */
object A4_NewControllStructure {
   def once(op: Double => Double, x: Double) = op(x)
   def twice(op: Double => Double, x: Double) = op(op(x))
   def addOne(x: Double) = x + 1

   def withPrintWriter (file: File,op: PrintWriter => Unit){
     val writer = new PrintWriter(file)
     try{
       op(writer)
     } finally{
       writer.close()
     }
   }

   def withPrintWriterCurried(file: File)(op: PrintWriter => Unit): Unit ={
     val writer = new PrintWriter(file)
     try{
       op(writer)
     } finally{
       writer.close()
     }
   }

   def main(args: Array[String]) {
     println(once(_ + 1, 5))
     println(twice(_ + 1, 5))
     val op1 = addOne _
     println(once(addOne,5))

     withPrintWriter(new File("date.txt"),writer => writer.println(new java.util.Date))

     withPrintWriterCurried(new File("date.txt")){
       writer => writer.println(new java.util.Date)
     }
   }
 }
