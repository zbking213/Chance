package com.chance.proxy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

public class ProxyUtils {

    /**
     * String context
     * file .java文件
     * class .class文件
     *有了class之后可以new
     * @param targetInterface  目标对象的接口
     */

    public static Object newInstance(Class targetInterface){
        /**
         *定义一个
         */
        Method methods[] = targetInterface.getDeclaredMethods();
        String line = "\n";
        String tab  = "\t";
        String interfaceName = targetInterface.getSimpleName();
        System.out.println(interfaceName+"interfaceName");
        String context = "";
        System.out.println(context+"context");
        String packageContext = "package com.chance.zbking;"+line;
        System.out.println(packageContext+"packageContext");
        String importContext = "import "+targetInterface.getName()+";"+line;
        System.out.println(importContext+"importContext");
        String clazzFirstLineContext = "public class $Proxy implements "+interfaceName +" {"+line;
        System.out.println(clazzFirstLineContext+"clazzFirstLineContext");
        String filedContext =tab+"private "+interfaceName+" dao;";
        System.out.println(filedContext+"fileContext");
        String constructorContext =tab+ "public $Proxy("+interfaceName+" dao){+" +line
              + tab+tab+ "this.dao=dao;"
        +line+tab+"}"+line;
        System.out.println(constructorContext+"constructorContext");

        String methodContext = "";
        for (Method method : methods) {
            String returnTypeName = method.getReturnType().getSimpleName();
            System.out.println(returnTypeName+"returnTypeName");
            String methodName = method.getName();
            System.out.println(methodName+"methodName");
            Object args[] = method.getParameterTypes();
            System.out.println(args+"args");
            String argsContext = "";
            String paramsContext ="";
            int flag = 0;
            for (Object arg : args) {

                String simpleName = arg.getClass().getSimpleName();
                argsContext+=simpleName+" p"+flag+",";
                paramsContext+="p"+flag+",";
                flag++;
                }
            if (argsContext.length()>0){
                argsContext=argsContext.substring(0,argsContext.lastIndexOf(",")-1);
                paramsContext = paramsContext.substring(0,paramsContext.lastIndexOf(",")-1);
            }
            methodContext+="public "+returnTypeName+" "+methodName+"("+ argsContext+")"+" "+"{"+line
                   +tab+tab +"System.out.println(\"log\");"+line
                    +tab+tab+"dao."+methodName+"("+paramsContext+");"+line
                    +tab+"}";

        }
        context=packageContext+importContext+clazzFirstLineContext+filedContext+constructorContext+methodContext+"}";
        File file = new File("D:\\com\\chance\\$Proxy.java");
        if (!file.exists()){
            try {
                file.createNewFile();
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(context);
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
