import java.io.{FileNotFoundException, IOException, IOError}
import scala.collection.mutable.ArrayBuffer
import scala.io.Source
import scala.collection._

object ReadLogs{
  /* process log files */
  val bufferedSource = Source.fromFile("C:\\Users\\wmurphy\\Desktop\\debug.log")
  val logs = ArrayBuffer[String]()
  var i: Int = 0
  try {
    for (line <- bufferedSource.getLines) {
      logs.insert(i, line)
      i += 1
    }
  } catch {
      case e: FileNotFoundException => println("File not found.")
      case e: IOException => println("IO exception raised.")
      case e: IOError => println("IO error thrown.")
  }finally {
    bufferedSource.close
  }
  logs.foreach(println)
}



