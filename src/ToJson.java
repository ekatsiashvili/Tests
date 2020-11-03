
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

        Object Json = Class.forName("ToJson").newInstance();
        Class<?> cls = Json.getClass();
        Field[] fields = cls.getDeclaredFields();
           for (Field field : fields) {
            Class<?> fld = field.getType();

            if (fld.isPrimitive()) {
                System.out.println("{\"" + field.getName() + "\":" + "\"" + fld.getName() + "\",");

            }

            if (fld.isInterface()) {
                System.out.println("\"" + field.getName() + "\":" + "\"" + field.getGenericType() + "\"");

                for (Class<?> class1 : ToJson.class.getDeclaredClasses()) {
                    for (Field field1 : class1.getDeclaredFields()) {

                        System.out.println("\"" + field1.getName() + "\":" + "\"" + field1.getType() + "\",");

                    }
                    Field error = toJsonClass.getDeclaredField("error");
                    System.out.println("\"" + error.getName() + "\":" + "\"" + error.getType() + "\"" + "}");
                }
            }
        }
    }
}

































