package dataOperator;
/*
 *访问最多的网站
 *@author gh
 *@create 2018-05-08 14:41
 */

import Setting.Database;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBConfiguration;
import org.apache.hadoop.mapred.lib.db.DBOutputFormat;
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
import java.util.Iterator;

public class WebMostVisited {

    public static class DataTable implements DBWritable, Writable {
        protected String sno;
        protected String name;
        protected String gender;
        protected String url;
        protected String date;

        @Override
        public void readFields(DataInput in) throws IOException {
            this.sno = Text.readString(in);
            this.name = Text.readString(in);
            this.gender = Text.readString(in);
            this.url = Text.readString(in);
            this.date = Text.readString(in);
        }

        @Override
        public void readFields(ResultSet resultSet) throws SQLException {
            this.sno = resultSet.getString(1);
            this.name = resultSet.getString(2);
            this.gender = resultSet.getString(3);
            this.url = resultSet.getString(4);
            this.date = resultSet.getString(5);
        }

        @Override
        public void write(DataOutput out) throws IOException {
            Text.writeString(out,this.sno);
            Text.writeString(out,this.name);
            Text.writeString(out,this.gender);
            Text.writeString(out,this.url);
            Text.writeString(out,this.date);
        }

        @Override
        public void write(PreparedStatement statement) throws SQLException {
            statement.setString(1,this.sno);
            statement.setString(2,this.name);
            statement.setString(3,this.gender);
            statement.setString(4,this.url);
            statement.setString(5,this.date);
        }
    }

    public static class SQLMapper
            extends Mapper<LongWritable, DataTable, Text, IntWritable> {
        @Override
        protected void map(LongWritable key, DataTable value, Context context)
                throws IOException, InterruptedException {
            context.write(new Text(value.url), new IntWritable(1));
        }
    }

    public static class SQLReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
        @Override
        protected void reduce(Text key, Iterable<IntWritable> values, Context context)
                throws IOException, InterruptedException {
            int sum = 0;
            Iterator<IntWritable> iterator = values.iterator();
            while (iterator.hasNext()){
                sum+=iterator.next().get();
            }
            context.write(key, new IntWritable(sum));
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration configuration = new Configuration();
        configuration.set("arg","arg");
        DBConfiguration.configureDB(
                configuration,
                Database.MySQLDriver,
                Database.DBurl,
                Database.username,
                Database.password
        );
        Job job = Job.getInstance(configuration, "WebMostVisited");
        job.setJarByClass(WebMostVisited.class);
        job.setMapperClass(SQLMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        job.setCombinerClass(SQLReducer.class);
        job.setReducerClass(SQLReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        job.setInputFormatClass(DBInputFormat.class);
        job.setOutputFormatClass(DBOutputFormat.class);
        DBInputFormat.setInput(
                job,
                DataTable.class,
                "select user.sno, user. name, user.gender, internetdata.url, internetdate.date " +
                        "from user, internetdata " +
                        "where user.uid=internetdata.uid",
                ""
        );
        DBOutputFormat.setOutput(
                job,
                "output",
                "key","vaule"
        );
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

}
