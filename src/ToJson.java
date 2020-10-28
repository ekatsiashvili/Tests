import java.beans.beancontext.BeanContextChild;
import java.lang.reflect.*;
import java.util.Arrays;
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

        Object Json = Class.forName("ToJson").newInstance();

        Class<?> cls = Json.getClass();
        Field[] fields = cls.getDeclaredFields();
        AccessibleObject.setAccessible(fields, true);
        for (Field field : fields) {
            Class<?> fld = field.getType();

            if (fld.isPrimitive()) {
                System.out.println("{\"" + field.getName() + "\":" + "\"" + fld.getName() + "\",");

            }
            if (fld.isArray()) {
                System.out.println("\"" + field.getName() + "\":" + "\"" + fld.getName() + "\":" + Arrays.deepToString(new Object[]{"\"" + field.getName() + "\":" + "\"" + fld.getName() + "\","}));

            }
            if (fld.isInstance(args)) {

                System.out.println("\"" + field.getName() + "\":" + "\"" + fld.getName() + "\"}");
                return;
            }

        }

    }

}





















