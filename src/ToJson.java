import java.lang.reflect.*;
import java.util.Map;
import java.util.Set;


public class ToJson {

    private int result;
    private String error;
    private Map<String, Set<RemoteFile>> keywords;

    public static class RemoteFile {
        private boolean isDirectory;
        private String name;
        private String filePath;
        private long size = -1;
    }

    public static void main(String[] args) throws Exception {

            Class<ToJson> toJsonClass = ToJson.class;
            try {
                Field result = toJsonClass.getDeclaredField("result");
                System.out.println("{" + "\"" + result.getName() + "\":" + "\"" + result.getType() + "\"");
                Field keywords = toJsonClass.getDeclaredField("keywords");
                System.out.println(keywords.getName() + "\":" + "[{" + "\"" + keywords.getGenericType() + "\"");
                System.out.println("[{");
                for (Class<?> class1 : ToJson.class.getDeclaredClasses()) {
                    for (Field field1 : class1.getDeclaredFields()) {
                        System.out.println("\"" + field1.getName() + "\":" + "\"" + field1.getType() + "\"");
                    }
                }
                System.out.println("]}");
                System.out.println("]}");
                Field error = toJsonClass.getDeclaredField("error");
                System.out.println("\"" + error.getName() + "\":" + "\"" + error.getType() + "\"" + "}");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }



























