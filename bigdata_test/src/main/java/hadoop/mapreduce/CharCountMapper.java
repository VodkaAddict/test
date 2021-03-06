package hadoop.mapreduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author Kled
 * @date 2021/6/18 3:21 下午
 * LongWritable, Text, Text, IntWritable => KeyIn, ValueIn, KeyOut, ValueOut => 行偏移量，行数据，字符，计数
 */
public class CharCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String line = value.toString();
        for (char c : line.toCharArray()) {
            try {
                context.write(new Text(String.valueOf(c)), new IntWritable(1));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
