package cn.vxnm.component.jackson.sample;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

/**
 * 演示的数据来自于 classpath:demonstration.json
 */
public class ParseJsonSample {

    /**
     * ObjectMapper 是一个线程安全的类，可以在类当中进行实例，但要注意的是，不要轻易去改变它已经定好的配置
     * 否在，一旦有一个线程改了配置则会影响到其它正在使用 ObjectMapper 读取数据的线程。
     *
     * 线程安全是否意味着在高并发的场景下会有锁的开销？
     */
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 在 classpath:demonstration.json 文件中，拿到第一层的 _id 属性数据
     *
     * @throws FileNotFoundException 不处理
     */
    public void readId() throws FileNotFoundException {
        // 利用 Spring 框架来解析文件，可能会抛出异常，但这里主要演示 ObjectMapper 用法
        File file = ResourceUtils.getFile("classpath:demonstration.json");

        try {
            // 从文件当中读取数据进来
            JsonNode jsonNode = objectMapper.readTree(file);

            // 根据名称拿到数据
            String id = jsonNode.get("_id").asText();

            System.out.println(id);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在 classpath:demonstration.json 文件中，拿到 fields 当中的 name 属性数据
     *
     * @throws FileNotFoundException 不处理
     */
    public void readFieldName() throws FileNotFoundException {
        // 利用 Spring 框架来解析文件，可能会抛出异常，但这里主要演示 ObjectMapper 用法
        File file = ResourceUtils.getFile("classpath:demonstration.json");

        try {
            // 从文件当中读取数据进来
            JsonNode jsonNode = objectMapper.readTree(file);

            // 根据名称拿到数据
            String id = jsonNode.at("/fields/name").asText();

            System.out.println(id);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在 classpath:demonstration.json 文件中，遍历 tags 当中所有数据
     *
     * @throws FileNotFoundException 不处理
     */
    public void readArray() throws FileNotFoundException {
        // 利用 Spring 框架来解析文件，可能会抛出异常，但这里主要演示 ObjectMapper 用法
        File file = ResourceUtils.getFile("classpath:demonstration.json");

        try {
            // 从文件当中读取数据进来
            JsonNode jsonNode = objectMapper.readTree(file);

            // 根据名称拿到数据
            JsonNode tagsNode = jsonNode.get("tags");

            if (tagsNode.isArray()) {
                // 这里不需要判读 tagsNode.isEmpty() ，因为当数组为空的时候，也不会报空指针的问题
                for (JsonNode tag : tagsNode) {
                    System.out.println(tag.asText());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在 classpath:demonstration.json 文件中，找到 tags 当中的第二个元素
     *
     * @throws FileNotFoundException 不处理
     */
    public void findInArrayByIndex() throws FileNotFoundException {
        // 利用 Spring 框架来解析文件，可能会抛出异常，但这里主要演示 ObjectMapper 用法
        File file = ResourceUtils.getFile("classpath:demonstration.json");

        try {
            // 从文件当中读取数据进来
            JsonNode jsonNode = objectMapper.readTree(file);

            // 根据名称拿到数据
            JsonNode tagsNode = jsonNode.get("tags");

            if (tagsNode.isArray()) {
                // 这里不需要判读 tagsNode.isEmpty() ，因为当数组为空的时候，也不会报空指针的问题
                Iterator<JsonNode> tagsIterator = tagsNode.iterator();
                // 用 for 循环计数来迭代
                for (int i = 0; tagsIterator.hasNext(); i++) {
                    JsonNode tag = tagsIterator.next();
                    if (i == 1) {
                        System.out.println(tag);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        ParseJsonSample parseJsonSample = new ParseJsonSample();
        parseJsonSample.readId();
        parseJsonSample.readFieldName();
        parseJsonSample.readArray();
        parseJsonSample.findInArrayByIndex();
    }

}
