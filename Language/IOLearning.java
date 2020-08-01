import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;

/**
 * IOLearning
 */
public class IOLearning {
    public static void main(String[] args) {
        testDemo6();
    }

    // 字节输出流
    public static void testDemo1() throws IOException {
        File f1 = new File("Language" + File.separator + "testFiles" + File.separator + "IOtest.txt");
        FileOutputStream fStream = new FileOutputStream(f1, false);// 第二个参数表示append是否追加
        fStream.write(100);
        fStream.write('\n');
        byte[] b = { 49, 48, 48 };
        fStream.write(b);// 如果写入的第一个字节是正数，查询ASCII；如果是负数，查询系统码表
        fStream.write('\n');
        fStream.write(b, 1, 2);// 写b数组从index 1开始的两个字节
        fStream.write('\n');
        fStream.write("hello world!".getBytes());// 写字符串，使用getbytes
        fStream.close();
    }

    // 字节输入流
    public static void testDemo2() throws IOException {
        File f1 = new File("Language" + File.separator + "testFiles" + File.separator + "IOtest.txt");
        FileInputStream fStream = new FileInputStream(f1);
        for (int i = 0; i < f1.length(); ++i) {
            System.out.print((char)fStream.read());
        }
        int temp = 0;
        while ((temp = fStream.read()) != -1) {
            System.out.print((char)temp);
        }
        System.out.println();
        fStream.close();
    }

    // 字节输入流，一次读取多个字节
    public static void testDemo3() throws IOException {
        File f1 = new File("Language" + File.separator + "testFiles" + File.separator + "IOtest.txt");
        FileInputStream fStream = new FileInputStream(f1);
        byte[] bytes = new byte[30];
        int len = fStream.read(bytes);
        System.out.println(len);// len表示一次读取的有效字节数
        System.out.println(new String(bytes));// 读取的字节存储在bytes数组中
        fStream.close();
    }

    // 文件复制，字节输入/输出流应用
    public static void copyFile() throws IOException {
        File f1 = new File("Language" + File.separator + "testFiles" + File.separator + "IOtest.txt");
        File f2 = new File("Language" + File.separator + "testFiles" + File.separator + "IOtest副本.txt");
        f2.createNewFile();
        int len = (int)f1.length();
        byte[] bytes = new byte[len];
        FileInputStream fStream1 = new FileInputStream(f1);
        FileOutputStream fStream2 = new FileOutputStream(f2);
        fStream1.read(bytes);
        fStream1.close();
        fStream2.write(bytes);
        fStream2.close();
    }

    // 字符输入流
    public static void testDemo4() throws IOException {
        File f1 = new File("Language" + File.separator + "testFiles" + File.separator + "IOtest.txt");
        FileReader fReader = new FileReader(f1);
        int len = 0;
        while ((len = fReader.read()) != -1) {
            System.out.print((char)len);
        }
        System.out.println();
        fReader.close();
        fReader = new FileReader(f1);
        char[] chars = new char[(int)f1.length()];
        fReader.read(chars);
        System.out.println(new String(chars));
        fReader.close();
    }

    // 字符输出流
    public static void testDemo5() throws IOException {
        File f1 = new File("Language" + File.separator + "testFiles" + File.separator + "IOtest.txt");
        FileWriter fWriter = new FileWriter(f1, true);
        String s = "甲乙丙丁";
        fWriter.write(s);// 把数据写到内存缓冲区
        fWriter.flush();// 刷新缓冲区字符到文件，流可以继续使用
        fWriter.close();// 刷新缓冲区字符到文件，流被关闭
    }
    
    // 异常处理
    public static void testDemo6() {
        File f1 = new File("Language" + File.separator + "testFiles错" + File.separator + "IOtest.txt");
        try(
            FileInputStream fStream = new FileInputStream(f1);// jdk7新特性，定义在try()中的流自动关闭
        ) {
            int temp = 0;
            while ((temp = fStream.read()) != -1) {
                System.out.print((char)temp);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

class FileLearning {
    String pathSeparator = File.pathSeparator;// 路径分隔符，windows：; linux：:
    String separator = File.separator;// 文件名称分割符，windows：\ linux：/

    public static void main(String[] args) {
        File f1 = new File("Language" + File.separator + "testFiles" + File.separator + "IOtest.txt");
        File f2 = new File("Language" + File.separator + "testFiles");
        String absolutPath = f1.getAbsolutePath();// 获取绝对路径
        String path = f1.getPath();// 获取构造方法中传递的路径
        long l = f1.length();// 获取文件大小以字节为单位，若文件不存在则返回0
        String name = f1.getName();// 获取文件名称
        System.out.println(absolutPath + "    " + path + "    " + name + "    " + l);
        boolean exist = f1.exists();// 判断路径是否存在
        boolean isDir = f1.isDirectory();// 判断路径是否为一个目录
        boolean isFile = f1.isFile();// 判断路径是否为一个文件
        System.out.println("exist:" + exist + "  isDir：" + isDir + "   isfile:" + isFile);
        f1.delete();// 删除路径文件/文件夹
        f2.mkdir();// 创建单级文件夹
        f2.mkdirs();// 创建多级文件夹
        try {
            f1.createNewFile();
        } catch (IOException e) {
            System.out.println("path is not exist");
        } // 创建文件的路径和名称为构造方法的参数，当且仅当文件不存在时创建文件（不能创建文件夹），路径必须存在
        String[] list = f2.list();// 如果遍历的目录为空或者不是一个文件夹则抛出空指针异常
        File[] files = f2.listFiles();
        for (String string : list) {
            System.out.println(string);
        }
        for (File file : files) {
            System.out.println(file);
        }
    }
}

// 缓冲流
class BufferStreamTest {
    public static void main(String[] args) {
        try {
            testDemo4();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // 缓冲字节输入流
    public static void testDemo1() throws IOException {
        File f1 = new File("Language" + File.separator + "testFiles" + File.separator + "IOtest.txt");
        FileInputStream fStream = new FileInputStream(f1);
        BufferedInputStream bStream = new BufferedInputStream(fStream, 50);// 其中有个buf字节数组作为缓冲区，50为缓冲区大小
        byte[] bytes = new byte[3];
        int len = 0;// 记录有效读取字节数
        while ((len = bStream.read(bytes)) != -1) {// 特有方法：读取一行返回String，读到末尾返回null
            System.out.println(new String(bytes, 0, len));
        }
        bStream.close();// 关闭缓冲流自动关闭字节流
    }

    // 缓冲字节输出流
    public static void testDemo2() throws IOException {
        File f1 = new File("Language" + File.separator + "testFiles" + File.separator + "IOtest.txt");
        FileOutputStream fStream = new FileOutputStream(f1);
        BufferedOutputStream bStream = new BufferedOutputStream(fStream, 50);// 其中有个buf字节数组作为缓冲区，50为缓冲区大小
        bStream.write("abcdefg".getBytes());
        bStream.close();// 关闭缓冲流自动关闭字节流
    }

    // 缓冲字符输出流
    public static void testDemo3() throws IOException {
        File f1 = new File("Language" + File.separator + "testFiles" + File.separator + "IOtest.txt");
        FileWriter fWriter = new FileWriter(f1, true);
        BufferedWriter bWriter = new BufferedWriter(fWriter);
        bWriter.newLine();// 特有方法：行分割符，换行
        bWriter.write("甲乙丙丁");
        bWriter.close();// 刷新，隐含了一次flush操作
    }

    // 缓冲字符输入流
    public static void testDemo4() throws IOException {
        File f1 = new File("Language" + File.separator + "testFiles" + File.separator + "IOtest.txt");
        BufferedReader bReader = new BufferedReader(new FileReader(f1));
        String line;
        while ((line = bReader.readLine()) != null) {
            System.out.println(line);
        }
        bReader.close();
    }
}

// 转换流InputStreamReader和OutputStreamWriter
class TransStream {
    public static void main(String[] args) {
        try {
            testDemo1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 字符编码：字符（信息）与二进制字节之间的对应规则
     * ASCII字符集（ASCII编码）、GBK字符集（GBK编码）、Unicode字符集（UTF8、UTF16、UTF32编码）
     * IDE默认编码UTF8，读取GBK编码文件导致乱码
     */
    public static void testDemo1() throws IOException {
        BufferedReader bReader = new BufferedReader(
            new FileReader("Language" + File.separator + "testFiles" + File.separator + "IOtest.txt", Charset.forName("GBK"))
        );// 指定编码格式gbk，实际调用了super类InputStreamReader传入了编码参数。
        String line;
        while ((line = bReader.readLine()) != null) {
            System.out.println(line);
        }
        bReader.close();
    }
}

// 序列化流和反序列化流
class SerializeStream {
    public static void main(String[] args) {
        try {
            testDemo2();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // 序列化流：ObjectOutputStream
    public static void testDemo1() throws IOException {
        File f1 = new File("Language" + File.separator + "testFiles" + File.separator + "IOtest.txt");
        ObjectOutputStream oStream = new ObjectOutputStream(new FileOutputStream(f1));
        oStream.writeObject(new Persons("mile", 23));// 序列化对象必须实现java.io.Serializable接口才可以进行序列化
        oStream.close();
    }

    // 反序列化；ObjectInputStream
    public static void testDemo2() throws Exception {
        File f1 = new File("Language" + File.separator + "testFiles" + File.separator + "IOtest.txt");
        ObjectInputStream oStream = new ObjectInputStream(new FileInputStream(f1));
        Object ob = oStream.readObject();
        System.out.println(ob);
        oStream.close();
    }
}
/**
 * 测试类
 */
@SuppressWarnings("all")
class Persons implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    public Persons(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public Persons() {
    }

    private String name;
    private transient int age;// transient修饰的无法被序列化
}