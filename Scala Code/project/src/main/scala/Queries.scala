import java.io. {
File,
PrintWriter
}
import java.nio.file. {
Files,
Path
}

import net.liftweb.json.JsonAST.JValue
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext
import net.liftweb.json._
import net.liftweb.json.JsonDSL._
import org.apache.commons.io.FileUtils

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * Created by shanmuk on 5/13/2016.
  */
object Queries {
  def runQuery() {

    System.setProperty("hadoop.home.dir", "C:\\Users\\shanmuk\\Desktop\\PB\\phase 2\\Utils\\Utils")
    // initialise spark context
    val conf = new SparkConf().setAppName("CountSpark").setMaster("local[2]").set("spark.executor.memory", "8g")
    val sc = new SparkContext(conf)

    //val textFile = sc.textFile("C:\\Users\\shanmuk\\Desktop\\PB\\project\\phase 2\\Tweets.Json")
    val sqlContext = new SQLContext(sc)
    val tweetsfile = sqlContext.read.json("C:\\Users\\shanmuk\\Desktop\\PB\\phase 2\\tweet.Json")
    tweetsfile.registerTempTable("tweetstable")

    //val query1 = sqlContext.sql("select count(user.name) as AtoB from tweetstable where user.name like 'A%' OR user.name like 'B%' OR user.name like 'C%' OR user.name like 'D%' OR user.name like 'E%'");
    //val query1 = sqlContext.sql("select count(user.name) as FtoJ from tweetstable where user.name like 'F%' OR user.name like 'G%' OR user.name like 'H%' OR user.name like 'I%' OR user.name like 'J%'");
    // val query1 = sqlContext.sql("select count(user.name) as KtoO from tweetstable where user.name like 'K%' OR user.name like 'L%' OR user.name like 'M%' OR user.name like 'N%' OR user.name like 'O%'");
    // val query1 = sqlContext.sql("select count(user.name) as PtoT from tweetstable where user.name like 'P%' OR user.name like 'Q%' OR user.name like 'R%' OR user.name like 'S%' OR user.name like 'T%'");
    //val query1 = sqlContext.sql("select count(user.name) as UtoZ from tweetstable where user.name like 'U%' OR user.name like 'V%' OR user.name like 'W%' OR user.name like 'X%' OR user.name like 'Y%' OR user.name like 'Z%'");

    //     val query2 = sqlContext.sql("select lang,count(user.followers_count) as followers from tweetstable group by lang order by followers desc");

//    val list3 = List("screen_name", "followers_count", "favourites_count", "friends_count")
//    val query3 = sqlContext.sql(
//      "select user.screen_name, user.followers_count, user.favourites_count, user.friends_count " +
//        "from tweetstable " +
//        "order by  user.followers_count desc " +
//        "limit 3")
//    if (new java.io.File("filesave").exists) {
//      FileUtils.deleteDirectory(new File("filesave"));
//      // new java.io.File("filesave").delete()
//    }
//    query3.rdd.map(x => {
//      var js = JObject(List())
//      for (ind < -0 until x.size) {
//        js = js~(list3(ind), x.get(ind).toString)
//      }
//      compactRender(js)
//    }).saveAsTextFile("filesave")
    //

    //val query4 = sqlContext.sql("select count(user.name) as morecount from tweetstable where user.statuses_count>10000 and user.verified=false");
    //val query4 = sqlContext.sql("select count(user.name) as lesscount from tweetstable where user.statuses_count<10000 and user.verified=true");

    //val query5 = sqlContext.sql("select count(user.name) as kohli from tweetstable where text like '%kohli%' ");
    //    val query5 = sqlContext.sql("select count(user.name) as dhoni from tweetstable where text like '%dhoni%' ");
    //    val query5 = sqlContext.sql("select count(user.name) as ashwin from tweetstable where text like '%ashwin%' ");

    //val query6 = sqlContext.sql("select count(user.created_at) as one from tweetstable where user.created_at like '%2006%' or user.created_at like '%2007%' or user.created_at like '%2008%'");
    //val query6 = sqlContext.sql("select count(user.created_at) as two from tweetstable where user.created_at like '%2009%' or user.created_at like '%2010%' or user.created_at like '%2011%'");
    //val query6 = sqlContext.sql("select count(user.created_at) as three from tweetstable where user.created_at like '%2012%' or user.created_at like '%2013%' or user.created_at like '%2014%'");
    //val query6 = sqlContext.sql("select count(user.created_at) as four from tweetstable where user.created_at like '%2015%' or user.created_at like '%2016%'");

    //val query7 = sqlContext.sql("select count(user.verified) as verified from tweetstable where user.verified =TRUE");
    //val query7 = sqlContext.sql("select count(user.verified) as notverified from tweetstable where user.verified =FALSE");

    //    val query8 = sqlContext.sql("select user.time_zone , count(user.time_zone) from tweetstable group by user.time_zone ");
    //    query8.show()
    //
    //val query9 = sqlContext.sql("select user.location,count(*) as total_count from tweetstable where user.location!='null' group by user.location order by total_count desc ")
    //    query2.show()
    //    var cn=0
    //    var str=""
    //    var str1=""
    //    var stri=new StringBuffer()
    val insertDocumentApp: InsertDocumentApp = new InsertDocumentApp
    insertDocumentApp.insertQueries(",hel", "hello,hello")
    //    //var flag=0;
    //    val writer = new PrintWriter(new File("output.txt"))
    //    query2.foreach(r => writer.write(r(0)+"" ))
    //    writer.close()
    //   query2.foreach(x=>{
    //     if(cn<5){
    //       insertDocumentApp.insertQueries(x(0)+",hel","hello,hello")
    //       cn=cn+1
    //     }
    //   }
    //
    //   )
    //    /*query2.foreach(x=>
    //      if(cn<10){
    //        if(str1=="")
    //          str1=x(1)+""
    //        else
    //          str1=str1+","+x(1)
    //        cn=cn+1
    //      }
    //    )*/



    //      val counts = textFile.flatMap(line => line.split(" "))
    //      .map(word => (word, 1))
    //    .reduceByKey(_ + _)
    //counts.saveAsTextFile("C:\\Users\\shanmuk\\Desktop\\PB\\project\\phase 2\\TweetsWordCount2")

    //java code inserted for uploading counts
    //println(" Hello"+ stri.toString+"nhjmsjdfnj"+str1)




  }
}