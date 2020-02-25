import org.apache.spark.sql.SparkSession
import spark.implicits._


val spark = SparkSession
  .builder()
  .appName("Spark SQL basic example")
  .config("spark.some.config.option", "some-value")
  .getOrCreate()

####################################################################

val emp = Seq((1,"Smith",-1,"2018","10","M",3000),
    (2,"Rose",1,"2010","20","M",4000),
    (3,"Williams",1,"2010","10","M",1000),
    (4,"Jones",2,"2005","10","F",2000),
    (5,"Brown",2,"2010","40","",-1),
      (6,"Brown",2,"2010","50","",-1)
  )
  
 ###########################################################
 
 val dept = Seq(("Finance",10),
    ("Marketing",20),
    ("Sales",30),
    ("IT",40)
  )
  
  ######################################################
  
  val deptColumns = Seq("dept_name","dept_id")
#######################################################
val deptDF = dept.toDF(deptColumns:_*)

###################################################


deptDF.show(false)
################################################

empDF.join(deptDF,empDF("emp_dept_id") ===  deptDF("dept_id"),"inner")
    .show(false)
    
#####################################################################
 empDF.join(deptDF,empDF("emp_dept_id") ===  deptDF("dept_id"),"outer")
    .show(false)
#################################################################

 empDF.join(deptDF,empDF("emp_dept_id") ===  deptDF("dept_id"),"outer")
    .show(false)
    
####################################################################

empDF.join(deptDF,empDF("emp_dept_id") ===  deptDF("dept_id"),"full")
    .show(false)
########################################################################

empDF.join(deptDF,empDF("emp_dept_id") ===  deptDF("dept_id"),"fullouter")
    .show(false)
##########################################################################

empDF.join(deptDF,empDF("emp_dept_id") ===  deptDF("dept_id"),"left")
    .show(false)
##############################################################################


