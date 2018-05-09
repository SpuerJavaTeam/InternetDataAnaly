package dataOperator;
/*
 *访问最多的网站
 *@author gh
 *@create 2018-05-08 14:41
 */

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBConfiguration;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.db.DBInputFormat;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WebMostVisited {


    public static class table implements DBWritable, Writable {
        protected String field1;
        protected String field2;
        protected String field3;
        protected String field4;
        protected String field5;

        @Override
        public void readFields(DataInput in) {

        }

        @Override
        public void readFields(ResultSet resultSet) {

        }

        @Override
        public void write(DataOutput out) {

        }

        @Override
        public void write(PreparedStatement statement) {

        }
    }

    public static class SQLMapper
            extends Mapper<LongWritable, Text, Text, Text> {
        @Override
        protected void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            super.map(key, value, context);
        }
    }

    public static class SQLReducer extends Reducer<Text, Text, Text, IntWritable> {
        @Override
        protected void reduce(Text key, Iterable<Text> values, Context context)
                throws IOException, InterruptedException {
            super.reduce(key, values, context);
        }
    }

    public static void main(String[] args) throws IOException {
        Configuration configuration = new Configuration();
        configuration.set("arg","arg");
        DBConfiguration.configureDB(
                configuration,
                "com.mysql.jdbc.Driver",
                "jdbc:mysql://118.89.44.152:3306/javabean",
                "javabean",
                "@password"
        );
        Job job = Job.getInstance(configuration, "WebMostVisited");
        job.setJarByClass(WebMostVisited.class);
        job.setMapperClass(SQLMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        job.setReducerClass(SQLReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        String[] inFields = {};
        job.getJobState()
//        DBInputFormat.setInput(
//                job,
//
//        );
    }

}
