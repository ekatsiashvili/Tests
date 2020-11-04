import java.lang.reflect.*;
import java.util.*;


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


        Field f1 = cls.getDeclaredField("result");
        Integer value1 = (Integer) f1.get(Json);
        f1.set(Json, 1);

        Field f2 = cls.getDeclaredField("error");
        String value2 = (String) f2.get(Json);
        f2.set(Json, "string");

        Field f3 = cls.getDeclaredField("keywords");
        f3.setAccessible(true);
        Map value3 = (Map) f3.get(Json);
        Map<String,  Set<RemoteFile>> m = new HashMap<String,  Set<RemoteFile>>();
        Set<RemoteFile> remoteFileHashSet = new HashSet<RemoteFile>();

        m.put("string", remoteFileHashSet);
        //m.put(f3.getName(),f3.set(Json, remoteFileHashSet);

        Object Json1 = Class.forName("ToJson$RemoteFile").newInstance();

        Class<?> cl = Json1.getClass();

                Field fl1 =  Json1.getClass().getDeclaredField("isDirectory");

                Boolean val1 = (Boolean) fl1.get(Json1);
                fl1.set(Json1, true);

                Field fl2 = Json1.getClass().getDeclaredField("name");

                String val2 = (String) fl2.get(Json1);
                fl2.set(Json1, "string");

                Field fl3 = Json1.getClass().getDeclaredField("filePath");

                String val3 = (String) fl3.get(Json1);
                fl3.set(Json1, "string");

                Field fl4 = Json1.getClass().getDeclaredField("size");
                fl4.setAccessible(true);
                Long val4 = (Long) fl4.get(Json1);
                fl4.set(Json1, -1);

        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            Class<?> fld = field.getType();

            if (fld.isPrimitive()) {
                System.out.println("{\"" + field.getName() + "\":" + "\"" + field.get(Json) + "\",");

            }

            if (fld.isInterface()) {
                System.out.println("\"" + field.getName() + "\":" + "\"" + fld.getSimpleName()+ "\"");

                for (Class<?> class1 : ToJson.class.getDeclaredClasses()) {
                    for (Field field1 : class1.getDeclaredFields()) {
                        System.out.println("\"" + field1.getName() + "\":" + "\"" + field1.get(Json1) + "\",");
                    }
                    Field error = toJsonClass.getDeclaredField("error");
                    System.out.println("\"" + error.getName() + "\":" + "\"" + error.get(Json) + "\"" + "}");


                }
            }
        }
    }
}









































